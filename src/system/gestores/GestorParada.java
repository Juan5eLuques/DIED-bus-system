package system.gestores;

import java.util.ArrayList;

import DTO.DTOParada;
import system.clases.DAO.ParadaDAO;
import system.clases.Camino;

public class GestorParada {
	
	//---------- Patron Singleton
	private static GestorParada GParada ; // Patron Singleton -- Unica instancia tipo gestor creada.

	private GestorParada(){ // Patron Singleton -- Constructor privatizado para no permitir su uso.
	}

	public static GestorParada getInstance() { // Patron Singleton -- Devuelve la instancia, si no existe la crea
		if ( GParada == null) {
			GParada = new GestorParada();
		}
		return GParada;
		}
	
	public/*boolean*/static void agregarParada(DTOParada nuevaParada) {
		if (!ParadaDAO.paradaExiste(nuevaParada.getNroParada())) {
			System.out.println("Id actualmente en uso");
		}
		else {
		ParadaDAO.agregarParada(nuevaParada);
		}
	}

	public static void eliminarParada (int idParada){
		if (ParadaDAO.paradaExiste(idParada)){
			ArrayList<Camino> listaCaminos = CaminoDAO.obtenerCaminosQueIncluyenParada(idParada);
			if (listaCaminos.isEmpty()){
				ParadaDAO.eliminarParada(idParada);
			}
			else{
				//MSG::Hay caminos que incluyen la parada. Se eliminaran. Seguro ? 
				GestorCamino.eliminarListaCaminos(listaCaminos);
			}
		}
		else {
			//MSG::No existe una parada con este id
		}
	}

}
