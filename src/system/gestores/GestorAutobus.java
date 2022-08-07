package system.gestores;

import java.util.ArrayList;

import DTO.DTOAutobus;
import DTO.DTOCamino;

public class GestorAutobus {
	
	//---------- Patron Singleton
	private static GestorAutobus GAutobus ; // Patron Singleton -- Unica instancia tipo gestor creada.

	private GestorAutobus(){ // Patron Singleton -- Constructor privatizado para no permitir su uso.
	}

	public static GestorAutobus getInstance() { // Patron Singleton -- Devuelve la instancia, si no existe la crea
		if ( GAutobus == null) {
			GAutobus = new GestorAutobus();
		}
		return GAutobus;
	}
	
	public static void crearAutobus(DTOAutobus datosAutobus, ArrayList<DTOCamino> trayecto) {
		//COMPLETAR
	}
}