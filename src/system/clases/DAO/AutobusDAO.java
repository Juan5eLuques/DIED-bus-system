package system.clases.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import system.clases.Autobus;
import system.clases.AutobusEconomico;
import system.clases.AutobusSuperior;
import system.clases.Camino;
import system.gestores.GestorDB;

public class AutobusDAO {
	
	public ArrayList<Integer> obtenerCantidadDeLineas(){
		GestorDB gdb = GestorDB.getInstance();
		Connection con = gdb.conec;
		ArrayList<Integer> idColectivos = new ArrayList<Integer>();
		try {
			PreparedStatement st = con.prepareStatement("SELECT id FROM aplicacion_bus.LINEA");
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				idColectivos.add(rs.getInt("id"));
			}
			con.close();
			rs.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return idColectivos;
	}
	
	
	
	public Autobus obtenerAutobus (int id){
	
    	GestorDB gdb = GestorDB.getInstance();
		Connection con = gdb.conec;
		try {
			PreparedStatement st = con.prepareStatement("SELECT * FROM aplicacion_bus.LINEA WHERE id=?");
            st.setInt(1,id);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				
		            if(rs.getString("tipo") == "Economico"){
		                AutobusEconomico auto = new AutobusEconomico();
		                auto.setId(rs.getInt("id"));
		                auto.setColor(rs.getString("color"));
		                auto.setNombre(rs.getString("nombre"));
		                auto.setCapacidadMaxima(rs.getInt("asientos"));
		                auto.setPasajerosParados(rs.getInt("parados"));;
		                auto.setRecorridoLinea(new CaminoDAO().obtenerCaminosDeUnaLinea(id));
		                rs.close();
		    			con.close();
		                return auto;
		            }
		            else{
		                AutobusSuperior auto = new AutobusSuperior();
		                auto.setId(rs.getInt("id"));
		                auto.setColor(rs.getString("color"));
		                auto.setNombre(rs.getString("nombre"));
		                auto.setCapacidadMaxima(rs.getInt("asientos"));
		                auto.setAireAcondicionado(rs.getBoolean("aire"));
		                auto.setWifi(rs.getBoolean("wifi"));
		                auto.setRecorridoLinea(new CaminoDAO().obtenerCaminosDeUnaLinea(id));
		                rs.close();
		    			con.close();
		    			return auto;
		            }
				}
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
    }

	private int crearTrayecto(int idAutobus){
		int id= 0; 
		GestorDB gdb = GestorDB.getInstance();
		Connection con = gdb.conec;
		try{
			PreparedStatement st = con.prepareStatement("INSERT INTO APLICACION_BUS.TRAYECTO (idLinea) values (?);");
			st.setInt(1,idAutobus);
			//id = st.executeUpdate(Statement.RETURN_GENERATED_KEYS);	
		}
		catch (SQLException e) {
			e.printStackTrace();
		}	
		return id;
	}
	private void guardarTrayecto(int idAutobus, ArrayList<Camino> listaCaminos){
		int idTrayecto = crearTrayecto (idAutobus);
		CaminoDAO.guardarTrayecto(listaCaminos, idTrayecto);
	}
	
	public static void main (String argc[]) {
		AutobusDAO prueba = new AutobusDAO();
		System.out.println(prueba.obtenerCantidadDeLineas());
	}
	
}
 