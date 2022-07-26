package system.clases.DAO;

import java.util.List;

import system.clases.AutobusEconomico;
import system.clases.Camino;
import system.interfaces.AutobusEconomicoInterface;

public class AutobusEconomicoDAO extends AutobusEconomico implements AutobusEconomicoInterface{
	
	public void agregarPasajero() {
		if (this.pasajeros < this.capacidadMaxima) pasajeros ++;
		else {
			if ((this.pasajeros + this.getPasajerosParados())< this.capacidadMaxima*1.4) setPasajerosParados(getPasajerosParados() + 1);
				else {
				System.out.println("El colectivo alcanzo su capacidad maxima");
				}
		}
	}

	public void AutobusEconomico (String nombre, String color, int capacidadMaxima,List<Camino> recorrido) {
		this.nombre = nombre;
		this.color = color;
		this.capacidadMaxima = capacidadMaxima;
		this.recorridoLinea = recorrido;
	}

}
