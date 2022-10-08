package system.gestores;

import java.util.ArrayList;

import DTO.DTOIncidencia;
import system.clases.DAO.IncidenciaDAO;
import system.clases.DAO.ParadaDAO;

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
		
		public static DTOIncidencia obtenerIncidencia(int idIncidencia) {
			return IncidenciaDAO.obtenerIncidencia(idIncidencia);
		}
		
		public static void registrarIncidencia(DTOIncidencia nueva) {
			IncidenciaDAO.registrarIncidencia(nueva);
//			GestorParada.cambiarEstadoParada(nueva.getIdParada(), !nueva.isResuelta());

			if (!nueva.isResuelta()){
				ParadaDAO.actualizarActiva(nueva.getIdParada(),false);
			}
		}

		public static ArrayList<DTOIncidencia> obtenerActivas(){
			return IncidenciaDAO.obtenerActivas();
		}
		
		public static void actualizarIncidencias() {
			IncidenciaDAO.verificarIncidencias();
		}
		
		public static boolean incidenciaExiste(int idIncidencia){
			return (IncidenciaDAO.obtenerIncidencia(idIncidencia).getIdParada() != -1);
		}
		
		public static void solucionarIncidencia(int idIncidencia) {
			IncidenciaDAO.cambiarEstado(idIncidencia, true);
		}
		
	}
