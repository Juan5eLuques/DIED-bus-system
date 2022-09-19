package DTO;

import java.util.Objects;

public class DTOCamino {    
    private int idOrigen;
	private int idDestino;
	private double distancia;
	private double duracion;
	private boolean activa;
	
	public int getIdOrigen() {
		return idOrigen;
	}
	public void setIdOrigen(int idParada) {
		this.idOrigen = idParada;
	}
	public int getIdDestino() {
		return idDestino;
	}
	public void setIdDestino(int idParada) {
		this.idDestino = idParada;
	}
	public double getDistancia() {
		return distancia;
	}
	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}
	public double getDuracion() {
		return duracion;
	}
	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}

    	public boolean isActiva() {
		return activa;
	}
	public void setActiva(boolean activa) {
		this.activa = activa;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idDestino, idOrigen);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DTOCamino other = (DTOCamino) obj;
		return idDestino == other.idDestino && idOrigen == other.idOrigen;
	}
	
	
}