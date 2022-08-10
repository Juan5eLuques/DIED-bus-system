package DTO;

public class DTOParada {
	
	private int nroParada;
	private int nroCalle;
	private String calle;
	private boolean activa;
	
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
	public boolean isActiva() {
		return activa;
	}
	
	public void setActiva(boolean valor) {
		activa = valor;
	}
	
}
