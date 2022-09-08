package system.clases.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.DTOAutobus;
import DTO.DTOCamino;
import system.clases.Autobus;
import system.clases.AutobusEconomico;
import system.clases.AutobusSuperior;
import system.clases.Camino;
import system.clases.Parada;
import system.gestores.GestorDB;

public class AutobusDAO {
	
	
	public static Boolean existeNroAutobus(DTOAutobus autobus) {
		GestorDB gdb = GestorDB.getInstance();
		Connection con = gdb.conec;
		try {
			PreparedStatement st = con.prepareStatement("SELECT id FROM aplicacion_bus.LINEA where id=?");
			st.setInt(1, autobus.getId());
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				return true;
			}
			con.close();
			rs.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public static ArrayList<String> obtenerNombresDeLineas(){
		GestorDB gdb = GestorDB.getInstance();
		Connection con = gdb.conec;
		ArrayList<String> idColectivos = new ArrayList<String>();
		try {
			PreparedStatement st = con.prepareStatement("SELECT nombre FROM aplicacion_bus.LINEA");
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				idColectivos.add(rs.getString("nombre"));
			}
			con.close();
			rs.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return idColectivos;
	}
	
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
	
	public static int IDUltimaLinea() {
		
		GestorDB gdb = GestorDB.getInstance();
		Connection con = gdb.conec;
		int id= -2;
		try {
			PreparedStatement st = con.prepareStatement("SELECT id FROM aplicacion_bus.LINEA");
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				id = rs.getInt("id");
			}
			con.close();
			rs.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
	
	public static int siguienteIDTrayecto() {
		
		GestorDB gdb = GestorDB.getInstance();
		Connection con = gdb.conec;
		int id= -2;
		try {
			PreparedStatement st = con.prepareStatement("SELECT id FROM aplicacion_bus.TRAYECTO");
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				id = rs.getInt("id");
			}
			con.close();
			rs.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
	
	public static ArrayList<DTOAutobus> obtenerAutobuses(){
		GestorDB gdb = GestorDB.getInstance();
		Connection con = gdb.conec;
		ArrayList<DTOAutobus> autobuses = new ArrayList<DTOAutobus>();
		try {
			PreparedStatement st = con.prepareStatement("SELECT * FROM aplicacion_bus.LINEA");
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				DTOAutobus autobus = new DTOAutobus();
				autobus.setId(rs.getInt("id"));
				autobus.setNombre(rs.getString("nombre"));
				autobus.setColor(rs.getString("color"));
				autobus.setTipo(rs.getString("tipo"));
				autobus.setAsientos(rs.getInt("asientos"));
				autobus.setPasajerosextra(rs.getInt("parados"));
				autobus.setWifi(rs.getBoolean("wifi"));
				autobus.setAire(rs.getBoolean("aire"));
				
				autobuses.add(autobus);
			}
				rs.close();
				con.close();
				return autobuses;
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			return autobuses;
	}
	
	public static Autobus obtenerAutobus (int id){
	
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
	
	public static DTOAutobus obtenerDatosAutobus(int nroLinea) {
		GestorDB gdb = GestorDB.getInstance();
		Connection con = gdb.conec;
		try {
			PreparedStatement st = con.prepareStatement("SELECT * FROM aplicacion_bus.LINEA WHERE id=?");
            st.setInt(1,nroLinea);
			ResultSet rs = st.executeQuery();
			DTOAutobus auto = new DTOAutobus();
			if (rs.next()) {
		         auto.setId(rs.getInt("id"));
		         auto.setColor(rs.getString("color"));
		         auto.setNombre(rs.getString("nombre"));
		         auto.setAsientos(rs.getInt("asientos"));
		         auto.setAire(rs.getBoolean("aire"));
		         auto.setWifi(rs.getBoolean("wifi"));
		         rs.close();
		         con.close();
		         return auto;
		            }
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
				return null;
	}
	
	public static void setearDatosAutobus(DTOAutobus datos) {
		GestorDB gdb = GestorDB.getInstance();
		Connection con = gdb.conec;
		try {
			PreparedStatement st = con.prepareStatement("INSERT INTO aplicacion_bus.LINEA (id,nombre,color,tipo,asientos,parados,wifi,aire) VALUES (?,?,?,?,?,?,?,?)");
			st.setInt(1, datos.getId());
			st.setString(2,datos.getNombre());
			st.setString(3,datos.getColor());
			st.setString(4,datos.getTipo());
			st.setInt(5, datos.getAsientos());
			st.setInt(6, datos.getPasajerosextra());
			st.setBoolean(7, datos.isWifi());
			st.setBoolean(8, datos.isAire());
			st.executeUpdate();
			
			st.close();
			con.close();
		}
			catch (SQLException e) {
			e.printStackTrace();
			}
	}
	

	private static int obtenerIDTrayecto(int idAutobus){
		int id= 0;
		GestorDB gdb = GestorDB.getInstance();
		Connection con = gdb.conec;
		try{
			PreparedStatement st = con.prepareStatement("SELECT id FROM APLICACION_BUS.TRAYECTO where idLinea = ?");
			st.setInt(1,idAutobus);
			ResultSet rs =st.executeQuery();
			if(rs.next()) {
				return rs.getInt("id");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}	
		return id;
	}
	
	public static void guardarTrayecto(int idAutobus, ArrayList<DTOCamino> listaCaminos){
		int idTrayecto = obtenerIDTrayecto(idAutobus);
		System.out.println(idTrayecto);
		CaminoDAO.guardarTrayecto(listaCaminos, idTrayecto);
	}
	
	
	public static void crearIDTrayecto(int idAutobus) {
		GestorDB gdb = GestorDB.getInstance();
		Connection con = gdb.conec;
		try{
			PreparedStatement st = con.prepareStatement("INSERT INTO APLICACION_BUS.TRAYECTO (idLinea) values (?)");
			st.setInt(1,idAutobus);
			st.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void eliminarIDTrayecto(int nroLinea) {
		GestorDB gdb = GestorDB.getInstance();
		Connection con = gdb.conec;
		try{
			PreparedStatement st = con.prepareStatement("DELETE FROM aplicacion_bus.trayecto WHERE idlinea=?");
			st.setInt(1,nroLinea);
			st.execute();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	
	public static void eliminarTrayecto(int nroLinea) {
		GestorDB gdb = GestorDB.getInstance();
		Connection con = gdb.conec;
		try{
			PreparedStatement st = con.prepareStatement("DELETE FROM aplicacion_bus.caminotrayecto WHERE idtrayecto=?");
			st.setInt(1,nroLinea);
			st.execute();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	

	public static void eliminarAutobus(int nroLinea) {
		GestorDB gdb = GestorDB.getInstance();
		Connection con = gdb.conec;
		try{
			PreparedStatement st2 = con.prepareStatement("DELETE FROM aplicacion_bus.trayecto WHERE id=?");
			st2.setInt(1,nroLinea);
			PreparedStatement st = con.prepareStatement("DELETE FROM aplicacion_bus.linea WHERE id=?");
			st.setInt(1,nroLinea);
			st.execute();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	//Devuelve en "lineas" el id de los autobuces que pasan por la parada "idParada" y el tipo de cada uno en "tipo"
	public static void lineasQueContienenParada(int idParada, ArrayList <Integer> lineas, ArrayList<String> tipo) {
		GestorDB gdb = GestorDB.getInstance();
		Connection con = gdb.conec;
		try{
			PreparedStatement st = con.prepareStatement("Select linea.id, linea.tipo from aplicacion_bus.linea inner join aplicacion_bus.trayecto on linea.id =  trayecto.idlinea inner join aplicacion_bus.caminotrayecto on trayecto.id = caminotrayecto.idTrayecto where caminotrayecto.idOrigen = ?");
			st.setInt(1,idParada);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				lineas.add(rs.getInt("id"));
				tipo.add(rs.getString("tipo"));
			}
			con.close();
			rs.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	
	
	public static void main (String argc[]) {
		AutobusDAO prueba = new AutobusDAO();
		//System.out.println(prueba.lineasQueContienenParada(187)); 
	}
	
}
 