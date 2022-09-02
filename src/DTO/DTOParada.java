package DTO;

import java.util.Objects;

public class DTOParada {
	
	private int nroParada;
	private int nroCalle;
	private String calle;
	private boolean activa;
	private DTOIncidencia incidencia;
	
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
	
	public DTOIncidencia getIncidencia() {
		return incidencia;
	}
	public void setIncidencia(DTOIncidencia incidencia) {
		this.incidencia = incidencia;
	}
	@Override
	public int hashCode() {
		return Objects.hash(nroParada);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DTOParada other = (DTOParada) obj;
		return nroParada == other.nroParada;
	}
	
}
