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