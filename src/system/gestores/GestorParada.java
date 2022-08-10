package system.gestores;

import java.util.ArrayList;

import DTO.DTOCamino;
import DTO.DTOParada;
import system.clases.DAO.CaminoDAO;
import system.clases.DAO.ParadaDAO;
import system.clases.Parada;

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
		ParadaDAO.agregarParada(nuevaParada);
	}

	public static void eliminarParada (int idParada){
		if (ParadaDAO.paradaExiste(idParada)){
			ArrayList<DTOCamino> listaCaminos = CaminoDAO.obtenerCaminosQueIncluyenParada(idParada);
			if (listaCaminos.isEmpty()){
				ParadaDAO.eliminarParada(idParada);
			}
			else{
				//MSG::Hay caminos que incluyen la parada. Se eliminaran. Seguro ? 
				GestorCamino.eliminarCaminos(listaCaminos);
			}
		}
		else {
			//MSG::No existe una parada con este id
		}
	}
	
	public static void actualizarParada(int nroParada, String calle, int nroCalle, boolean estado) {
		ParadaDAO.actualizarParada(nroParada, calle, nroCalle, estado);
	}
	
	public static Parada obtenerParada(int idParada) {
		return ParadaDAO.obtenerParada(idParada);
	}
	
	public static ArrayList <DTOParada> obtenerTodos(){
		return ParadaDAO.obtenerParadas();
	}
	public static ArrayList <Parada> obtenerTodasLasParadas(){
		ArrayList<DTOParada> listaDTO = ParadaDAO.obtenerParadas();
		ArrayList<Parada> listaParadas = new ArrayList<Parada>();
		for (DTOParada paradaDTO : listaDTO) {
			listaParadas.add(ParadaDAO.transformarDTOParadaAParada(paradaDTO));
		}
		return listaParadas;
	}

}
