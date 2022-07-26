package system.clases.DAO;

import java.util.ArrayList;

import system.clases.Camino;
import system.clases.Parada;
import system.interfaces.CiudadInterface;
import system.clases.Ciudad;

public class CiudadDAO extends Ciudad implements CiudadInterface {
	public void Ciudad () {
		this.setCaminos(new ArrayList<Camino>());
		this.setParadas(new ArrayList<Parada>());
	}
	
	public void addParada(int nroParada, int nroCalle, String nombre, boolean incidencia) {
		Parada nuevaParada = new Parada(nroParada,nroCalle, nombre,incidencia);
		this.getParadas().add(nuevaParada);
	}
	
	public void conectarParadas(Parada parada1, Parada parada2, double duracion, double distancia) {
		Camino nuevoCamino = new Camino(parada1,parada2,duracion,distancia);
		this.getCaminos().add(nuevoCamino);
	}
	
	public void addParada(Parada parada) {
		 this.getParadas().add(parada);
	}
	
	public void recorrerCiudad() {
		for (Parada parada : this.getParadas()) {
			System.out.println(parada);
		}
	}
}
