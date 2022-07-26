package system.interfaces;

import system.clases.Parada;

public interface CiudadInterface {
	public void addParada(int nroParada, int nroCalle, String nombre, boolean incidencia);
	public void conectarParadas(Parada parada1, Parada parada2, double duracion, double distancia);
	public void addParada(Parada parada);
	public void recorrerCiudad();
}
