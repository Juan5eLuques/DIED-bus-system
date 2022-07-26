package system.clases;

import java.util.List;

public class Autobus {

	public String nombre;
	public String color;
	public int capacidadMaxima;
	public int pasajeros;
	public List<Camino> recorridoLinea;	
	
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
		return pasajeros;
	}
	public void setPasajeros(int pasajeros) {
		this.pasajeros = pasajeros;
	}
	public List<Camino> getRecorridoLinea() {
		return recorridoLinea;
	}
	public void setRecorridoLinea(List<Camino> recorridoLinea) {
		this.recorridoLinea = recorridoLinea;
	}
	
}

