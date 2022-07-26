package system.clases;

import java.util.List;


public class Ciudad {
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
	private List<Camino> caminos;
	private List<Parada> paradas;
	

}
