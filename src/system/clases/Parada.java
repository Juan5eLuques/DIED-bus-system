package system.clases;

public class Parada {


	private int nroParada;
	private int nroCalle;
	private String calle;
	private boolean incidenciaEstado;
	
	
	public Parada(int nroParada, int nroCalle, String nombre, boolean incidenciaEstado) {
	this.nroParada = nroParada;
	this.nroCalle = nroCalle;
	this.calle = nombre;
	this.incidenciaEstado = incidenciaEstado;
	}


	public int getNroParada() {
		return nroParada;
	}


	public void setNroParada(int nroParada) {
		this.nroParada = nroParada;
	}


	public int getNroCalle() {
		return nroCalle;
	}


	public void setNroCalle(int nroCalle) {
		this.nroCalle = nroCalle;
	}


	public String getCalle() {
		return calle;
	}


	public void setCalle(String calle) {
		this.calle = calle;
	}


	public boolean isIncidenciaEstado() {
		return incidenciaEstado;
	}


	public void setIncidenciaEstado(boolean incidenciaEstado) {
		this.incidenciaEstado = incidenciaEstado;
	}

	public void registrarIncidencia() {
		
	}
	
	public Camino buscarRuta (Parada otraParada) {
		return new Camino();
	}
	
	@Override
	public String toString() {
		return "Parada [nroParada=" + this.getNroParada() + ", nroCalle=" + this.getNroCalle() + ", calle=" + this.getCalle() + ", incidencia="
				+ this.isIncidenciaEstado() + "]";
	}
	
	public Parada() {
		
	}
}

