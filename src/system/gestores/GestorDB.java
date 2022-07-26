package system.gestores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GestorDB {


	private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
	private static final String USER = "postgres";
	private static final String PASS = "root";

	public static  Connection conec;



	private static GestorDB GDB ; // Patron Singleton -- Unica instancia tipo gestor creada.

	private GestorDB(){ // Patron Singleton -- Constructor privatizado para no permitir su uso.

		try {
			this.conec = this.crearConexion();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


	}

	public static GestorDB getInstance() { // Patron Singleton -- Devuelve la instancia, si no existe la crea
		if ( GDB == null) {
			GDB = new GestorDB();
		}

		try {
			if (conec.isClosed()) {
				try {
					conec = crearConexion();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return GDB;
	}

	public static Connection crearConexion() throws ClassNotFoundException, SQLException{

		Class.forName("org.postgresql.Driver");

		Connection conexion = DriverManager.getConnection(URL, USER, PASS);
		if (conexion != null){
			System.out.print("Conexion establecida...");
			return conexion;

		}
		return null;

	}

	public void cerrarConexion () {
		try {
			this.conec.close();
			System.out.println("conexion cerrada...");
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}


}
