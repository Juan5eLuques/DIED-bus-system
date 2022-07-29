package system.clases.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import system.clases.Autobus;
import system.clases.AutobusEconomico;
import system.clases.AutobusSuperior;
import system.gestores.GestorDB;

public class AutobusDAO {
	
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
	
	public static void main (String argc[]) {
		AutobusDAO prueba = new AutobusDAO();
		System.out.println(prueba.obtenerAutobus(3));
	}
	
}
