package system.gestores;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import DTO.DTOAutobus;
import DTO.DTOCamino;
import system.clases.DAO.AutobusDAO;

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
		if (AutobusDAO.existeNroAutobus(datosAutobus)) {
			JOptionPane.showMessageDialog(null, "El n�mero de la linea ya existe en la base de datos", null, JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			AutobusDAO.setearDatosAutobus(datosAutobus);
			AutobusDAO.crearIDTrayecto(datosAutobus.getId());
			AutobusDAO.guardarTrayecto(datosAutobus.getId(), trayecto);
			if (trayecto.isEmpty()) System.out.println("Trayecto vacio");
			JOptionPane.showMessageDialog(null, "Linea registrada !", "Exito", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public static void eliminarAutobus(int idLinea) {
		AutobusDAO.eliminarTrayecto(idLinea);
		AutobusDAO.eliminarIDTrayecto(idLinea);
		AutobusDAO.eliminarAutobus(idLinea);
		
	}

	public static ArrayList<String> obtenerNombresDeLineas	(){
		return AutobusDAO.obtenerNombresDeLineas();
	}

	public static DTOAutobus obtenerDatosAutobus (int nroLinea){
		return AutobusDAO.obtenerDatosAutobus(nroLinea);
	}
	
	public static ArrayList<Integer> lineasQueContienenParada(int idParada){
		return null;
	}
	
	
}