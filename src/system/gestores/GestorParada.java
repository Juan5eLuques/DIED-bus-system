package system.gestores;

import DTO.DTOParada;
import system.clases.DAO.ParadaDAO;

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

}
