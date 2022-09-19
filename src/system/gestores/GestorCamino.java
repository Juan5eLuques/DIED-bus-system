package system.gestores;

import java.util.ArrayList;

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
	private static GestorCamino GCamino ; // Patron Singleton -- Unica instancia tipo gestor creada.

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
	
	public static ArrayList<DTOCamino> recalcularCamino (DTOCamino caminoOrigen, DTOCamino caminoDestino){
		ArrayList<DTOCamino> ret = new ArrayList<>();
		return ret; 
		}
	
	private static ArrayList<ArrayList<DTOCamino>> caminosPosibles(DTOCamino caminoOrigen, DTOCamino caminoDestino){
		System.out.println("GestorCamino::Calculando posibles caminos desde "+caminoOrigen.getIdOrigen()+"->"+caminoOrigen.getIdDestino()+ " hasta "+ caminoDestino.getIdOrigen()+"->" +caminoDestino.getIdDestino());
		ArrayList<ArrayList<DTOCamino>> ret = new ArrayList<>();
		ArrayList<DTOCamino> unCamino = new ArrayList<>();
		int cantRecorrida = 1;
		unCamino.add(caminoOrigen);
		
		ArrayList<DTOCamino> conectados = CaminoDAO.obtenerCaminosDesdeParada(caminoOrigen.getIdDestino());
		for (DTOCamino camino:conectados) {
			System.out.println("GestorCamino:: posible siguiente:" + camino.getIdOrigen()+"->"+camino.getIdDestino()); //BORRAR
			ArrayList<DTOCamino> caminoAux = (ArrayList)unCamino.clone();
			caminoAux.add(camino);
			caminosPosibles(camino,caminoDestino,caminoAux, ret, cantRecorrida);
		}	
		return ret;
	}
	
	private static void caminosPosibles(DTOCamino caminoOrigen, DTOCamino caminoDestino, ArrayList<DTOCamino> caminoPosible, ArrayList<ArrayList<DTOCamino>> ret, int cantRecorrida) {
		System.out.println("Distancia recorrida: " + cantRecorrida);//BORRAR
		System.out.println("GestorCamino:: Analizo camino " +caminoOrigen.getIdOrigen()+"->"+caminoOrigen.getIdDestino());//BORRAR
		System.out.println("GestorCamino:: El camino destino es: " +caminoDestino.getIdOrigen()+"->"+caminoDestino.getIdDestino());//BORRAR

		if(caminoDestino.equals(caminoOrigen)) {
			ret.add(caminoPosible);
			System.out.println("GestorCamino:: Camino posbile!");//BORRAR
			System.out.println(caminoPosible.get(0).getIdOrigen());//BORRAR
			for (DTOCamino unCamino:caminoPosible) { //BORRAR
				System.out.println("->"+unCamino.getIdDestino()); //BORRAR
			}
		}
		else if(cantRecorrida >= 3){
			
		}
		else {
			ArrayList<DTOCamino> conectados = CaminoDAO.obtenerCaminosDesdeParada(caminoOrigen.getIdDestino());
			for (DTOCamino camino:conectados) {
				if (!caminoPosible.contains(camino)) {
					ArrayList<DTOCamino> caminoAux = (ArrayList)caminoPosible.clone();
					caminoAux.add(camino);
					caminosPosibles(camino,caminoDestino,caminoAux, ret, cantRecorrida ++);
				}	
			}
		}
	};
	
	public static void main(String[] argc) {
		ArrayList<DTOCamino> trayecto= trayectoLinea(1);
		ArrayList<ArrayList<DTOCamino>> posibles = caminosPosibles(trayecto.get(5), trayecto.get(6));
		
		System.out.println(posibles);
	}	
	

}