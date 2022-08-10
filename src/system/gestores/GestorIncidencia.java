package system.gestores;

import java.util.ArrayList;

import DTO.DTOIncidencia;
import system.clases.DAO.IncidenciaDAO;

public class GestorIncidencia {

	//---------- Patron Singleton
		private static GestorIncidencia GParada ; // Patron Singleton -- Unica instancia tipo gestor creada.

		private GestorIncidencia(){ // Patron Singleton -- Constructor privatizado para no permitir su uso.
		}

		public static GestorIncidencia getInstance() { // Patron Singleton -- Devuelve la instancia, si no existe la crea
			if ( GParada == null) {
				GParada = new GestorIncidencia();
			}
			return GParada;
			}
		
		public static ArrayList<DTOIncidencia> obtenerTodas(){
			return IncidenciaDAO.obtenerTodas();
		}
		
	}
