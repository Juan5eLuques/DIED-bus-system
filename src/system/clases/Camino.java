package system.clases;

public class Camino {
	
	private Parada inicio;
	private Parada fin;
	private double distancia;
	private double duracion;
	
	public Parada getInicio() {
		return inicio;
	}
	public void setInicio(Parada inicio) {
		this.inicio = inicio;
	}
	public Parada getFin() {
		return fin;
	}
	public void setFin(Parada fin) {
		this.fin = fin;
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
	
	public Camino(Parada inicio, Parada fin, double distancia, double duracion) {
		super();
		this.inicio = inicio;
		this.fin = fin;
		this.distancia = distancia;
		this.duracion = duracion;
	}
	
	public Camino() {};
	
}
