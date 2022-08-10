package system.clases.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.DTOAutobus;
import system.clases.AutobusEconomico;
import system.clases.AutobusSuperior;
import system.clases.Camino;
import system.gestores.GestorCamino;
import system.gestores.GestorDB;
import system.interfaces.AutobusInterfaceDAO;

public class AutobusSuperiorDAO implements AutobusInterfaceDAO <AutobusSuperior> {

	
	public final static AutobusSuperior transformarA_Autobus(ResultSet rs) throws SQLException{
		AutobusSuperior autobus = new AutobusSuperior();
		try {
			//MODELAR EXCEPTION PARA EL CASO EN QUE EL ID DEL COLECTIVO NO SEA SUPERIOR//
			autobus.setId(rs.getInt("id"));
			autobus.setNombre(rs.getString("nombre"));
			autobus.setColor(rs.getString("color"));
			autobus.setCapacidadMaxima(rs.getInt("asientos"));
			autobus.setAireAcondicionado(rs.getBoolean("aire"));
			autobus.setWifi(rs.getBoolean("wifi"));
			return autobus;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	
	public static AutobusSuperior obtenerAutobus(int idAutobus) {
		GestorDB gdb = GestorDB.getInstance();
		Connection con = gdb.conec;
		AutobusSuperior ret = new AutobusSuperior();
		try {
			PreparedStatement st = con.prepareStatement("SELECT * FROM aplicacion_bus.linea WHERE id="+idAutobus );
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				ret = transformarA_Autobus(rs);
				ret.setRecorridoLinea(GestorCamino.trayectoLinea(idAutobus));
			}
			rs.close();
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	@Override
	public ArrayList<AutobusSuperior> obtenerTodosDelTipo(String tipo) {
		ArrayList<AutobusSuperior> lista_Autobus = new ArrayList <AutobusSuperior>();
		GestorDB gdb = GestorDB.getInstance();
		Connection con = gdb.conec;
		try {
			PreparedStatement st = con.prepareStatement("SELECT * FROM aplicacion_bus.linea WHERE tipo=" +tipo);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				AutobusSuperior autobus = this.transformarA_Autobus(rs);
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

	public void agregarAutobus(AutobusSuperior nuevoAutobus) {
		GestorDB gdb = GestorDB.getInstance();
		Connection con = gdb.conec;
		try {
			PreparedStatement st = con.prepareStatement("INSERT INTO aplicacion_bus.linea (nombre, color, tipo, asientos, parados, wifi, aire) VALUES (?, ?, ?, ?, ?, ?, ?)");
			st.setString(1, nuevoAutobus.getNombre());
			st.setString(2, nuevoAutobus.getColor());
			st.setString(3, "Superior");
			st.setInt(4,nuevoAutobus.getPasajeros());
			st.setInt (5,0);
			st.setBoolean(6, nuevoAutobus.isWifi());
			st.setBoolean(7, nuevoAutobus.isAireAcondicionado());
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
	
	public static DTOAutobus transformarADTO (AutobusSuperior unAutobus) {
		DTOAutobus ret = new DTOAutobus();
		ret.setAire(unAutobus.isAireAcondicionado());
		ret.setWifi(unAutobus.isWifi());
		ret.setAsientos(unAutobus.getPasajeros());
		ret.setColor(unAutobus.getColor());
		ret.setId(unAutobus.getId());
		ret.setNombre(unAutobus.getNombre());
		ret.setPasajerosextra(0);
		ret.setTipo("Superior");
		return ret;
	}

	public static void main(String[] argc) {
		AutobusSuperiorDAO prueba = new AutobusSuperiorDAO();
		System.out.println(prueba.obtenerAutobus(3).toString());
	}

}