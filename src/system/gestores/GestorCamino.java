package system.gestores;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

import DTO.DTOAutobus;
import DTO.DTOCamino;
import DTO.DTOParada;
import system.clases.DAO.ParadaDAO;
import system.clases.DAO.AutobusEconomicoDAO;
import system.clases.DAO.CaminoDAO;
import system.clases.Autobus;
import system.clases.Camino;

public class GestorCamino {

	//---------- Patron Singleton
	private static GestorCamino GCamino ;
	private static ArrayList<DTOCamino> arrayList; // Patron Singleton -- Unica instancia tipo gestor creada.

	private GestorCamino(){ // Patron Singleton -- Constructor privatizado para no permitir su uso.
	}

	public static GestorCamino getInstance() { // Patron Singleton -- Devuelve la instancia, si no existe la crea
		if ( GCamino == null) {
			GCamino = new GestorCamino();
		}
		return GCamino;
	}

	public static void eliminarCaminosConParada (int idParada){
		CaminoDAO.eliminarCaminosConParada(idParada);
	}

	public static void eliminarCaminos (ArrayList<DTOCamino> lista){

	}

	public static ArrayList<DTOCamino> caminosQueInicianEnParada (int idParada){
		return CaminoDAO.obtenerCaminosDesdeParada(idParada);
	}

	public static ArrayList<DTOCamino> trayectoLinea(int idLinea){
		try {
			return CaminoDAO.obtenerCaminosDeUnaLinea(idLinea);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static ArrayList<DTOCamino> trayectoLinea(String nombre){
		try {
			return CaminoDAO.obtenerCaminosDeUnaLinea(nombre);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static ArrayList<DTOCamino> obtenerCaminos() {
		return CaminoDAO.obtenerCaminos();
	}

	//Devuelve el trayecto que surge de recalcular el camino entre 2 puntos
	public static ArrayList<DTOCamino> recalcularCamino (DTOCamino caminoOrigen, DTOCamino caminoDestino){
		ArrayList<DTOCamino> ret = new ArrayList<DTOCamino>();
		Double menorDuracion = -1.0;
		ArrayList<ArrayList<DTOCamino>> caminosPosibles = caminosPosibles(caminoOrigen, caminoDestino);
		for (ArrayList<DTOCamino> unTrayecto : caminosPosibles){
			double duracionTrayecto = GestorBoleto.calcularDuracion(unTrayecto);
			if (menorDuracion == -1 || duracionTrayecto < menorDuracion){
				ret = unTrayecto;
				menorDuracion = duracionTrayecto;
			}
		}
		return ret; 
	}

	//Calcula de forma recursiva todos los caminos desde un camino hasta otro
	private static ArrayList<ArrayList<DTOCamino>> caminosPosibles(DTOCamino caminoOrigen, DTOCamino caminoDestino){
		ArrayList<ArrayList<DTOCamino>> ret = new ArrayList<>();
		ArrayList<DTOCamino> unCamino = new ArrayList<>();

		ArrayList<DTOCamino> conectados = CaminoDAO.obtenerCaminosDesdeParada(caminoOrigen.getIdOrigen());
		conectados = filtrarDeshabilitados(conectados);
		for (DTOCamino camino:conectados) {
			ArrayList<DTOCamino> caminoAux = (ArrayList)unCamino.clone();
			caminoAux.add(camino);
			caminosPosibles(camino,caminoDestino,caminoAux, ret);
		}	
		return ret;
	}

	private static void caminosPosibles(DTOCamino caminoOrigen, DTOCamino caminoDestino, ArrayList<DTOCamino> caminoPosible, ArrayList<ArrayList<DTOCamino>> ret) {

		if(caminoOrigen.getIdDestino() == caminoDestino.getIdDestino()) {
			ret.add(caminoPosible);
		}
		else if(caminoPosible.size() > 6){

		}
		else {
			ArrayList<DTOCamino> conectados = CaminoDAO.obtenerCaminosDesdeParada(caminoOrigen.getIdDestino());
			conectados = filtrarDeshabilitados(conectados);
			for (DTOCamino camino:conectados) {
				ArrayList<DTOCamino> caminoAux = (ArrayList)caminoPosible.clone();
				caminoAux.add(camino);
				caminosPosibles(camino,caminoDestino,caminoAux, ret);	
			}
		}
	}
	//Devuelve un camino que esquiva la incidencia, uniendo la primer parte habilitada, el desvio calculado y la segunda parte habilitada
	public static ArrayList<DTOCamino> caminoHabilitado (ArrayList<DTOCamino> trayectoRoto, int idParadaRota){
		ArrayList<DTOCamino> primerParte = new ArrayList<>(); //Guarda la primer parte habilitada
		ArrayList<DTOCamino> segundaParte = new ArrayList<>(); //Guarda la segunda parte habilitada
		ArrayList<DTOCamino> caminosInactivos = new ArrayList<>(); //Guarda los caminos que hay que reemplazar
		ArrayList<DTOCamino> ret = new ArrayList<>(); //Variable de retorno
		//Separa el camino en las dos partes habilitadas e identifica las paradas inactivas por la incidencia
		caminoSplit(trayectoRoto, primerParte, segundaParte, idParadaRota, caminosInactivos);

		ArrayList<DTOCamino> desvio = recalcularCamino(caminosInactivos.get(0), caminosInactivos.get(1));

		ret.addAll(primerParte);
		ret.addAll(desvio);
		ret.addAll(segundaParte);


		return ret;
	}

	//Dado el trayecto y la parada inactiva, devuelve las dos partes del camino activas e identifica los caminos inactivos
	public static void caminoSplit (ArrayList<DTOCamino> caminoCompleto, 
	ArrayList<DTOCamino> primerParte, ArrayList<DTOCamino> segundaParte, int idParadaRota,
	ArrayList<DTOCamino> caminosInactivos){
		primerParte.clear();
		segundaParte.clear();
		caminosInactivos.clear();
		boolean splitFlag = false;
		for (DTOCamino unCamino: caminoCompleto){
			if(unCamino.getIdOrigen() != idParadaRota || unCamino.getIdDestino() != idParadaRota){
				if(splitFlag){
					segundaParte.add(unCamino);
				}
				else{
					primerParte.add(unCamino);
				}
			}
			else{
				caminosInactivos.add(unCamino);
				splitFlag = true;
			}
		}
	}

	private static ArrayList<DTOCamino> filtrarDeshabilitados (ArrayList<DTOCamino> listaCaminos){
		return (ArrayList<DTOCamino>)listaCaminos.stream().
				filter(camino -> camino.isActiva()).
				collect(Collectors.toList());
	}

	public static boolean paradaPresente(ArrayList<DTOCamino> listaCaminos, int idParada) {
		boolean ret = false; 
		if (listaCaminos.get(0).getIdOrigen() == idParada) {
			ret = true;
		}
		else {
			for (DTOCamino unCamino:listaCaminos) {
				if (unCamino.getIdDestino() == idParada) {
					ret = true;
				}
			}
		}
		return ret; 
	}

	public static void main(String[] argc) {
		ArrayList<DTOCamino> trayecto= trayectoLinea(1);
		ArrayList<DTOCamino> recalculado = recalcularCamino(trayecto.get(5), trayecto.get(6));
		//		ArrayList<DTOCamino> aux = CaminoDAO.obtenerCaminosDesdeParada(81);
		//	    aux = filtrarDeshabilitados(aux);
		//		for (DTOCamino unCamino : aux) {
		//			System.out.println(unCamino.getIdOrigen()+"-> "+unCamino.getIdDestino());
		//		}
		//		System.out.println(aux.size());
	}	


}