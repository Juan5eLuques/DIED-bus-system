package system.clases.DAO;

import system.clases.Camino;
import system.clases.Parada;
import system.interfaces.CaminoInterface;

public class CaminoDAO extends Camino implements CaminoInterface{
	
public void Camino() {}
	
	public void Camino(Parada  i, Parada f) {
		this.setInicio(i);
		this.setFin(f);
	}
	
	public void Camino(Parada i, Parada  f, double distancia,double duracion) {
		this.setInicio(i);
		this.setFin(f);
		this.setDistancia(distancia);
		this.setDuracion(duracion);
	}
	
}
