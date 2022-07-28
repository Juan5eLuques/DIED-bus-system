package system.clases;

import java.util.List;

public class AutobusEconomico extends Autobus {

	private double pasajerosParados;

	public double getPasajerosParados() {
		return pasajerosParados;
	}

	public void setPasajerosParados(double pasajerosParados) {
		this.pasajerosParados = pasajerosParados;
	}
	
	public void agregarPasajero() {
		if (this.pasajeros < this.capacidadMaxima) pasajeros ++;
		else {
			if ((this.pasajeros + this.getPasajerosParados())< this.capacidadMaxima*1.4) setPasajerosParados(getPasajerosParados() + 1);
				else {
				System.out.println("El colectivo alcanzo su capacidad maxima");
				}
		}
	}

	public AutobusEconomico (int id, String nombre, String color, int capacidadMaxima,List<Camino> recorrido) {
		this.id = id;
		this.nombre = nombre;
		this.color = color;
		this.capacidadMaxima = capacidadMaxima;
		this.recorridoLinea = recorrido;
	}
	
	public AutobusEconomico() {}

	@Override
	public String toString() {
		return "AutobusEconomico [pasajerosParados=" + pasajerosParados + ", id=" + id + ", nombre=" + nombre
				+ ", color=" + color + ", capacidadMaxima=" + capacidadMaxima + ", pasajeros=" + pasajeros
				+ ", recorridoLinea=" + recorridoLinea + "]";
	}
	
	
}
