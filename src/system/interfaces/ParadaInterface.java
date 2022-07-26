package system.interfaces;

import system.clases.Camino;
import system.clases.Parada;

public interface ParadaInterface {
	
	public void registrarIncidencia();
	public Camino buscarRuta (Parada otraParada);
	
}
