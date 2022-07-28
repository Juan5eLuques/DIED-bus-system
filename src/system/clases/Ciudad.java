package system.clases;

import java.util.ArrayList;
import java.util.List;


public class Ciudad {
	
	private List<Camino> caminos;
	private List<Parada> paradas;
	public final double costoMunicpio;
	
	public List<Camino> getCaminos() {
		return caminos;
	}
	public void setCaminos(List<Camino> caminos) {
		this.caminos = caminos;
	}
	public List<Parada> getParadas() {
		return paradas;
	}
	public void setParadas(List<Parada> paradas) {
		this.paradas = paradas;
	}
	
	public Ciudad () {
		this.costoMunicpio = 0;
		this.setCaminos(new ArrayList<Camino>());
		this.setParadas(new ArrayList<Parada>());
	}
	
	public void addParada(int nroParada, int nroCalle, String nombre, boolean incidencia) {
		Parada nuevaParada = new Parada(nroParada,nroCalle, nombre,incidencia);
		this.getParadas().add(nuevaParada);
	}
	
	public void conectarParadas(Parada parada1, Parada parada2, double duracion, double distancia,boolean activa) {
		Camino nuevoCamino = new Camino(parada1,parada2,duracion,distancia,activa);
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
