package system.start;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import GUI.GUIMenu;
import system.gestores.GestorDB;


public class App {
	
	public static void main( String[] args ){

		try {

			GestorDB gdb = GestorDB.getInstance();
			Connection con = gdb.crearConexion();
			JOptionPane.showMessageDialog(null, "Base de datos conectada.", "Conexión establecida", JOptionPane.INFORMATION_MESSAGE);
			GUIMenu.main(args);
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
