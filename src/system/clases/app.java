package system.clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import system.gestores.GestorDB;

public class app {

	public static void main(String[] args) {
		
		/*Parada parada1 = new Parada(1,20,"Parada esquina 1",false);
		Parada parada2 = new Parada(2,40,"Parada esquina 2",false);
		Parada parada3 = new Parada(3,20,"Parada esquina 3",false);
		Parada parada4 = new Parada(4,70,"Parada esquina 4",false);
		Parada parada5 = new Parada(5,230,"Parada esquina 5",false);
		Parada parada6 = new Parada(6,440,"Parada esquina 6",false);
		Parada parada7 = new Parada(7,210,"Parada esquina 7",false);
		Parada parada8 = new Parada(8,403,"Parada esquina 8",false);
		Parada parada9 = new Parada(9,244,"Parada esquina 9",false);
		Parada parada10 = new Parada(10,410,"Parada esquina 10",false);
		Parada parada11 = new Parada(11,205,"Parada esquina 11",false);
		Parada parada12 = new Parada(12,409,"Parada esquina 12",false);
		Parada parada13 = new Parada(13,234,"Parada esquina 13",false);
		Parada parada14 = new Parada(14,556,"Parada esquina 14",false);
		Parada parada15 = new Parada(15,234,"Parada esquina 15",false);
		Parada parada16 = new Parada(16,1223,"Parada esquina 16",false);
		Parada parada17 = new Parada(17,555,"Parada esquina 17",false);
		Parada parada18 = new Parada(18,142,"Parada esquina 18",false);
		Parada parada19 = new Parada(19,122,"Parada esquina 19",false);
		Parada parada20 = new Parada(20,405,"Parada esquina 20",false);
		
		Camino camino1 = new Camino(parada1,parada2,30,10);
		Camino camino2 = new Camino(parada3,parada4,20,10);
		Camino camino3 = new Camino(parada5,parada6,50,30);
		Camino camino4 = new Camino(parada7,parada8,10,6);
		Camino camino5 = new Camino(parada9,parada10,5,15);
		Camino camino6 = new Camino(parada11,parada12,24,12);
		Camino camino7 = new Camino(parada13,parada14,34,25);
		Camino camino8 = new Camino(parada15,parada16,12,14);
		
		List <Camino> trayectoAutobus = new ArrayList <Camino> ();
		trayectoAutobus.add(camino1);
		trayectoAutobus.add(camino2);
		trayectoAutobus.add(camino3);
		trayectoAutobus.add(camino4);
		trayectoAutobus.add(camino5);
		trayectoAutobus.add(camino6);
		trayectoAutobus.add(camino7);
		trayectoAutobus.add(camino8);
		
		AutobusEconomico eco = new AutobusEconomico("Linea 1","Verde",30,null);
		
		eco.trayectoColectivo(trayectoAutobus);
		
		for (int i=0;i<42;i++) {
			eco.agregarPasajero();
		}
		
		Ciudad ciudad = new Ciudad();
		
		ciudad.addParada(parada1);
		ciudad.addParada(parada2);
		ciudad.addParada(parada3);
		ciudad.addParada(parada4);
		ciudad.addParada(parada5);
		ciudad.addParada(parada6);
		ciudad.addParada(parada7);
		ciudad.addParada(parada8);
		ciudad.addParada(parada9);
		ciudad.addParada(parada10);
		ciudad.addParada(parada11);
		ciudad.addParada(parada12);
		ciudad.addParada(parada13);
		ciudad.addParada(parada14);
		ciudad.addParada(parada15);
		ciudad.addParada(parada16);
		ciudad.addParada(parada17);
		ciudad.addParada(parada18);
		ciudad.addParada(parada19);
		ciudad.addParada(parada20);
		
		ciudad.recorrerCiudad();
		
		eco.mostrarTrayecto();	
		*/
	
		
		try {
			GestorDB gdb = GestorDB.getInstance();
			Connection con = gdb.crearConexion();
			JOptionPane.showMessageDialog(null, "Base de datos conectada.", "Conexión establecida", JOptionPane.INFORMATION_MESSAGE);
			con.close();
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "No Hay Conexión con la Base de Datos.", "Error", JOptionPane.WARNING_MESSAGE);
			//e.printStackTrace();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No Hay Conexión con la Base de Datos.", "Error", JOptionPane.WARNING_MESSAGE);
			//e.printStackTrace();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No Hay Conexión con la Base de Datos.", "Error", JOptionPane.WARNING_MESSAGE);
			//e.printStackTrace();
		}

}
}