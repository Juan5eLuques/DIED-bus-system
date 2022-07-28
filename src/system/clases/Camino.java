package system.clases;

public class Camino {
	
	private Parada inicio;
	private Parada fin;
	private double distancia;
	private double duracion;
	private boolean activa;
	
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
	
	public Camino() {};
	
	public Camino(Parada  i, Parada f) {
		this.setInicio(i);
		this.setFin(f);
	}
	
	public Camino(Parada i, Parada  f, double distancia,double duracion, boolean activa) {
		this.setInicio(i);
		this.setFin(f);
		this.setDistancia(distancia);
		this.setDuracion(duracion);
		this.activa = activa;
	}
	public boolean isActiva() {
		return activa;
	}
	public void setActiva(boolean activa) {
		this.activa = activa;
	}
	
	public String toString() {
		return "Inicio: " + this.inicio.toString()+"\n"+ "Final: " + this.fin.toString() + "\n" + "Distancia: " + this.distancia + " - Duracion: " + this.duracion + " - Activa: " + this.activa + "\n\n";
	}
	
}
