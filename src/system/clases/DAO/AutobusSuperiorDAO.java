package system.clases.DAO;

import system.clases.AutobusSuperior;
import system.interfaces.AutobusSuperiorInterface;

public class AutobusSuperiorDAO extends AutobusSuperior implements AutobusSuperiorInterface{
	
	public void agregarPasajero() {
		if (this.getCapacidadMaxima() < this.getPasajeros()) this.setPasajeros(pasajeros++);
			else {
				System.out.println("El colectivo alcanzo su capacidad maxima");
			}
	
		}
}