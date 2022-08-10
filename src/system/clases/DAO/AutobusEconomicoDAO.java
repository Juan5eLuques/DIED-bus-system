package system.clases.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import system.clases.AutobusEconomico;
import system.clases.Camino;
import system.gestores.GestorDB;
import system.interfaces.AutobusInterfaceDAO;

public class AutobusEconomicoDAO implements AutobusInterfaceDAO<AutobusEconomico>{
	
	private Connection conn;
	
	public final AutobusEconomico transformarA_Autobus(ResultSet rs) throws SQLException{
		AutobusEconomico autobus = new AutobusEconomico();
		try {
			//MODELAR EXCEPTION PARA EL CASO EN QUE EL ID DEL COLECTIVO NO SEA SUPERIOR//
			autobus.setId(rs.getInt("id"));
			autobus.setNombre(rs.getString("nombre"));
			autobus.setColor(rs.getString("color"));
			autobus.setCapacidadMaxima(rs.getInt("asientos"));
			autobus.setPasajerosParados(rs.getInt("parados"));
			return autobus;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	
	@Override
	public AutobusEconomico obtenerAutobus(int idAutobus) {
		GestorDB gdb = GestorDB.getInstance();
		Connection con = gdb.conec;
		try {
			PreparedStatement st = con.prepareStatement("SELECT * FROM aplicacion_bus.linea WHERE id="+idAutobus);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				return this.transformarA_Autobus(rs);
			}
			rs.close();
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public ArrayList<AutobusEconomico> obtenerTodosDelTipo(String tipo) {
		ArrayList<AutobusEconomico> lista_Autobus = new ArrayList <AutobusEconomico>();
		GestorDB gdb = GestorDB.getInstance();
		Connection con = gdb.conec;
		try {
			PreparedStatement st = con.prepareStatement("SELECT * FROM aplicacion_bus.linea WHERE tipo=" +tipo);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				AutobusEconomico autobus = this.transformarA_Autobus(rs);
				lista_Autobus.add(autobus);
			}
			rs.close();
			con.close();
			return lista_Autobus;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	

	public void agregarAutobus(AutobusEconomico nuevoAutobus) {
		GestorDB gdb = GestorDB.getInstance();
		Connection con = gdb.conec;
		try {
			PreparedStatement st = con.prepareStatement("INSERT INTO aplicacion_bus.linea (nombre, color, tipo, asientos, parados, wifi, aire) VALUES (?, ?, ?, ?, ?, ?, ?)");
			st.setString(1, nuevoAutobus.getNombre());
			st.setString(2, nuevoAutobus.getColor());
			st.setString(3, "Economico");
			st.setInt(4,nuevoAutobus.getPasajeros());
			st.setInt (5,nuevoAutobus.getPasajerosParados());
			st.setBoolean(6,false);
			st.setBoolean(7, false);
			st.executeUpdate();
			nuevoAutobus.setId(AutobusDAO.IDUltimaLinea());
			AutobusDAO.guardarTrayecto(nuevoAutobus.getId(),(ArrayList)nuevoAutobus.getRecorridoLinea());
			st.close();
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] argc) {
		AutobusEconomicoDAO prueba = new AutobusEconomicoDAO();
		System.out.println(prueba.obtenerAutobus(1).toString());
	}	
	
}
