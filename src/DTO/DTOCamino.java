package DTO;

public class DTOCamino {    
    private int idOrigen;
	private int idDestino;
	private double distancia;
	private double duracion;
	private boolean activa;
	
	public int getIdOrigen() {
		return inicio;
	}
	public void setIdOrigen(int idParada) {
		this.idOrigen = idParada;
	}
	public int getIdDestino() {
		return fin;
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
}