package system.gestores;

import java.util.ArrayList;

import DTO.DTOAutobus;
import DTO.DTOCamino;
import system.clases.AutobusEconomico;
import system.clases.AutobusSuperior;
import system.clases.DAO.AutobusDAO;
import system.clases.DAO.AutobusEconomicoDAO;
import system.clases.DAO.AutobusSuperiorDAO;

public class GestorAutobus {
	
	//---------- Patron Singleton
	private static GestorAutobus GAutobus ; // Patron Singleton -- Unica instancia tipo gestor creada.

	private GestorAutobus(){ // Patron Singleton -- Constructor privatizado para no permitir su uso.
	}

	public static GestorAutobus getInstance() { // Patron Singleton -- Devuelve la instancia, si no existe la crea
		if ( GAutobus == null) {
			GAutobus = new GestorAutobus();
		}
		return GAutobus;
	}
	
	public static ArrayList<DTOAutobus> obtenerAutobuses() {
		return AutobusDAO.obtenerAutobuses();
		
	}
	
	public static void crearAutobus(DTOAutobus datosAutobus, ArrayList<DTOCamino> trayecto) {
		if (datosAutobus.getTipo().equals("Economico")) {
			AutobusEconomico nuevoAutobus = new AutobusEconomico();
			nuevoAutobus.setCapacidadMaxima(datosAutobus.getAsientos());
			nuevoAutobus.setColor(datosAutobus.getColor());
			nuevoAutobus.setNombre(datosAutobus.getNombre());
			nuevoAutobus.setPasajeros(0);
			nuevoAutobus.setPasajerosParados(datosAutobus.getPasajerosextra());
			nuevoAutobus.setRecorridoLinea(trayecto);
			AutobusEconomicoDAO autobusEconomicoDAO = new AutobusEconomicoDAO();
			autobusEconomicoDAO.agregarAutobus(nuevoAutobus);
		}
		if (datosAutobus.getTipo().equals("Superior")) {
			
			AutobusSuperior nuevoAutobus = new AutobusSuperior();
			nuevoAutobus.setCapacidadMaxima(datosAutobus.getAsientos());
			nuevoAutobus.setColor(datosAutobus.getColor());
			nuevoAutobus.setNombre(datosAutobus.getNombre());
			nuevoAutobus.setPasajeros(0);
			nuevoAutobus.setAireAcondicionado(datosAutobus.isAire());
			nuevoAutobus.setWifi(datosAutobus.isWifi());
			nuevoAutobus.setRecorridoLinea(trayecto);
			AutobusSuperiorDAO autobusSuperiorDAO = new AutobusSuperiorDAO();
			autobusSuperiorDAO.agregarAutobus(nuevoAutobus);
		}
	}
	
	public static void eliminarAutobus(int idLinea) {
		AutobusDAO.eliminarTrayecto(idLinea); 
		AutobusDAO.eliminarAutobus(idLinea);
	}
	
	public static ArrayList<Integer> lineasQueContienenParada(int idParada){
		return null;
	}
	
	
}