package system.clases.DAO;

import java.util.List;

import system.clases.Autobus;
import system.clases.Camino;
import system.interfaces.AutobusInterface;

public class AutobusDAO extends Autobus implements AutobusInterface {
	public void trayectoColectivo(List<Camino> unCamino) {
		recorridoLinea = unCamino;
	};

	public void mostrarTrayecto() {
		System.out.println("Recorrido " + this.nombre +"\n");
		for (Camino camino : recorridoLinea) {
			System.out.println(camino);
		}
	}
}
