package system.clases;

import java.util.List;

public class AutobusEconomico extends Autobus {

	private int pasajerosParados;

	public int getPasajerosParados() {
		return pasajerosParados;
	}

	public void setPasajerosParados(int pasajerosParados) {
		this.pasajerosParados = pasajerosParados;
	}
	
	public void agregarPasajero() {
		if (this.asientos < this.capacidadMaxima) asientos ++;
		else {
			if ((this.asientos + this.getPasajerosParados())< this.capacidadMaxima*1.4) setPasajerosParados(getPasajerosParados() + 1);
				else {
				System.out.println("El colectivo alcanzo su capacidad maxima");
				}
		}
	}

	public AutobusEconomico (int id, String nombre, String color, int capacidadMaxima,List<Camino> recorrido, int parados) {
		this.id = id;
		this.nombre = nombre;
		this.color = color;
		this.capacidadMaxima = capacidadMaxima;
		this.recorridoLinea = recorrido;
		this.pasajerosParados = parados;
	}
	
	public AutobusEconomico() {}

	@Override
	public String toString() {
		return "AutobusEconomico [pasajerosParados=" + pasajerosParados + ", id=" + id + ", nombre=" + nombre
				+ ", color=" + color + ", capacidadMaxima=" + capacidadMaxima + ", pasajeros=" + asientos
				+ ", recorridoLinea=" + recorridoLinea + "]";
	}
	
	
}
