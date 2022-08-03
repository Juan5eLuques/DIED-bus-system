package system.gestores;

import java.util.ArrayList;

import DTO.DTOCamino;
import DTO.DTOParada;
import system.clases.DAO.ParadaDAO;
import system.clases.DAO.CaminoDAO;
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

        public static void eliminarCaminos (ArrayList<Camino> lista){
            
        }
}