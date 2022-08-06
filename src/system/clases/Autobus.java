package system.clases;

import java.util.List;

import DTO.DTOCamino;

public abstract class Autobus {
	protected static double montoPorKM = 1;
	protected static double porcentajePorServicio = 2;
	protected int id;
	protected String nombre;
	protected String color;
	protected int capacidadMaxima;
	protected int asientos;
	protected double precioBoleto;
	protected List<DTOCamino> recorridoLinea;	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getCapacidadMaxima() {
		return capacidadMaxima;
	}
	public void setCapacidadMaxima(int capacidadMaxima) {
		this.capacidadMaxima = capacidadMaxima;
	}
	public int getPasajeros() {
		return asientos;
	}
	public void setPasajeros(int pasajeros) {
		this.asientos = pasajeros;
	}
	public List<DTOCamino> getRecorridoLinea() {
		return recorridoLinea;
	}
	public void setRecorridoLinea(List<DTOCamino> recorridoLinea) {
		this.recorridoLinea = recorridoLinea;
	}
	
	public void trayectoColectivo(List<DTOCamino> unCamino) {
		recorridoLinea = unCamino;
	};

	public void mostrarTrayecto() {
		System.out.println("Recorrido " + this.nombre +"\n");
		for (DTOCamino camino : recorridoLinea) {
			System.out.println(camino);
		}
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
		public double getPrecioBoleto() {
		return precioBoleto;
	}

	public abstract double porcentajeExtra ();

	public void setPrecioBoleto() {
		double distancia = recorridoLinea.stream()
		.map(unCamino -> unCamino.getDistancia())
		.reduce(0.0,(acum, unaDist) -> acum + unaDist);

		precioBoleto = distancia * (1+(porcentajeExtra()/100));
	}
	@Override
	public String toString() {
		return "Autobus [id=" + id + ", nombre=" + nombre + ", color=" + color + ", capacidadMaxima=" + capacidadMaxima
				+ ", pasajeros=" + asientos + ", recorridoLinea=" + recorridoLinea + "]";
	}
	
}


