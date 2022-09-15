package system.gestores;

import java.util.ArrayList;

import DTO.DTOAutobus;
import DTO.DTOCamino;
import DTO.DTOParada;
import system.clases.DAO.ParadaDAO;
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

}