package system.interfaces;

import system.clases.Parada;

public interface CaminoInterface {
	public void Camino();
	public void Camino(Parada  i, Parada f);
	public void Camino(Parada i, Parada f, double distancia, double duracion);
}
