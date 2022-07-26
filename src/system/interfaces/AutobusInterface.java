package system.interfaces;

import java.util.List;

import system.clases.Camino;

public interface AutobusInterface {
	
	public void trayectoColectivo(List<Camino> unCamino);
	public void mostrarTrayecto();
	
}
