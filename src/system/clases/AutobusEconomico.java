package system.clases;

import java.util.ArrayList;
import java.util.List;

import DTO.DTOCamino;

public class AutobusEconomico extends Autobus {

	private int pasajerosParados;
	private static double porcentajePorServicio = 20;

	public int getPasajerosParados() {
		return pasajerosParados;
	}

	public void setPasajerosParados(int pasajerosParados) {
		this.pasajerosParados = pasajerosParados;
	}

	public static double getPorcentajePorServicio() {
		// TODO Auto-generated method stub
		return porcentajePorServicio;
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

	public AutobusEconomico (int id, String nombre, String color, int capacidadMaxima,ArrayList<DTOCamino> recorrido, int parados) {
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

	@Override
	public double porcentajeExtra() {
		return porcentajePorServicio;
	}
	
	
}
