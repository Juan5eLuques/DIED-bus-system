package system.clases.DAO;

import system.clases.Camino;
import system.clases.Parada;
import system.interfaces.ParadaInterface;

public class ParadaDAO extends Parada implements ParadaInterface{
	

public ParadaDAO(int nroParada, int nroCalle, String nombre, boolean incidenciaEstado) {
		super(nroParada, nroCalle, nombre, incidenciaEstado);
		// TODO Auto-generated constructor stub
	}

public void registrarIncidencia() {
	
}

public Camino buscarRuta (Parada otraParada) {
	return new Camino();
}

@Override
public String toString() {
	return "Parada [nroParada=" + this.getNroParada() + ", nroCalle=" + this.getNroCalle() + ", calle=" + this.getCalle() + ", incidencia="
			+ this.getIncidencia() + "]";
}

	
}
