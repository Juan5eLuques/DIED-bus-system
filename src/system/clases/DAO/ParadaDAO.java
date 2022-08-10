package system.clases.DAO;

import system.clases.Parada;
import system.gestores.GestorDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JOptionPane;

import DTO.DTOCamino;
import DTO.DTOParada;

public class ParadaDAO {
	
	private Connection conn;
	
	//agrega una nueva parada
	public static void agregarParada(DTOParada nuevaParada) {
		
		GestorDB gdb = GestorDB.getInstance();
		Connection con = gdb.conec;
		try {
			PreparedStatement st = con.prepareStatement("INSERT INTO aplicacion_bus.parada VALUES (?, ?, ?, ?)");
			st.setInt(1,nuevaParada.getNroParada());
			st.setBoolean(2, nuevaParada.isActiva());
			st.setString(3, nuevaParada.getCalle());
			st.setInt(4, nuevaParada.getNroCalle());
			st.executeUpdate();
			st.close();
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	//Chequea existencia de una parada
		public static boolean paradaExiste(int nroParada) {
			GestorDB gdb = GestorDB.getInstance();
			boolean existe = true;
			Connection con = gdb.conec;
			try {
				PreparedStatement st = con.prepareStatement("SELECT id FROM aplicacion_bus.parada WHERE id=?");
				st.setInt(1, nroParada);
				ResultSet rs = st.executeQuery();
				if(rs.next()) {
					return true;
				}		
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
		}
	
	
	//Obtiene todas las paradas de la BD
	public static ArrayList<DTOParada> obtenerParadas(){
		
		ArrayList<DTOParada> lista = new ArrayList<DTOParada>();
		
		GestorDB gdb = GestorDB.getInstance();
		Connection con = gdb.conec;
		try {
			PreparedStatement st = con.prepareStatement("SELECT * FROM APLICACION_BUS.PARADA");
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				DTOParada parada = new DTOParada();
				parada.setNroParada(rs.getInt("id"));
				parada.setCalle(rs.getString("calle"));
				parada.setActiva(rs.getBoolean("activa"));
				parada.setNroCalle(rs.getInt("numero"));
	
				lista.add(parada);
			}
			rs.close();
			con.close();
			return lista;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//Elimina una parada con id : idParada. 
	public static void eliminarParada(int idParada) {
		GestorDB gdb = GestorDB.getInstance();
		Connection con = gdb.conec;
		try {
			PreparedStatement st = con.prepareStatement("DELETE FROM aplicacion_bus.parada WHERE id=" + idParada);
			int eliminado=st.executeUpdate();
			if(!(eliminado>0)) {
				JOptionPane.showMessageDialog(null, "Ocurrion un error, la <Parada> no existe.", "Error", JOptionPane.WARNING_MESSAGE);
			}
			else {
				st = con.prepareStatement("SELECT * FROM aplicacion_bus.caminotrayecto");
			}
			st.close();
			con.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Devuelve la parada con id nroParada. Si no encuentra parada con ese numero, devuelve una con nroParada = -1
	public static Parada obtenerParada(int nroParada) {
		GestorDB gdb = GestorDB.getInstance();
		Connection con = gdb.conec;
		Parada paradaResult = new Parada();
		paradaResult.setNroParada(-1);
		try {
			PreparedStatement st = con.prepareStatement("SELECT id, activa, calle, numero FROM aplicacion_bus.parada WHERE id=" + nroParada);
			ResultSet rs = st.executeQuery();
				if (rs.next()) {
					paradaResult.setNroParada(rs.getInt("id"));
					paradaResult.setCalle(rs.getString("calle"));
					paradaResult.setNroCalle(rs.getInt("numero"));
					paradaResult.setIncidenciaEstado(rs.getBoolean("activa"));
				}

			rs.close();
			con.close();
		}
		catch (Exception e ) {
			e.printStackTrace();
		}
		return paradaResult;
	}
	
	public static boolean paradaPerteneceATrayecto(int nroParada) {
		GestorDB gdb = GestorDB.getInstance();
		Connection con = gdb.conec;
		Set<Integer> lineasQueIncluyenParada = new HashSet<Integer>();
		
		try {
			
			PreparedStatement st = con.prepareStatement("SELECT idTrayecto FROM aplicacion_bus.caminotrayecto WHERE idOrigen=? OR idDestino=?");
			st.setInt(1, nroParada);
			st.setInt(2, nroParada);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				lineasQueIncluyenParada.add(rs.getInt("idTrayecto"));
			}
			
			if (lineasQueIncluyenParada.size()==0) {
				rs.close();
				con.close();
				return false;
			}
			
			else {
				for(Integer nroLinea : lineasQueIncluyenParada) {
				reasignarParada(nroLinea,nroParada);
				}
				rs.close();
				con.close();
				return true;
			}
		}
	
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	public static void reasignarParada(int nroLinea,int nroParada) {
		Parada paradaEliminar = obtenerParada(nroParada);
		GestorDB gdb = GestorDB.getInstance();
		Connection con = gdb.conec;
		try {
			PreparedStatement st = con.prepareStatement("SELECT idOrigen FROM aplicacion_bus.caminotrayecto WHERE idTrayecto=? AND idDestino=?");
			st.setInt(1, nroLinea);
			st.setInt(2, nroParada);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				ArrayList<DTOCamino> listaCaminosDesdeOrigen=CaminoDAO.obtenerCaminosDesdeParada(rs.getInt("idOrigen"));
				for(DTOCamino camino: listaCaminosDesdeOrigen) {
					System.out.println("LINEA NUMERO: " + nroLinea + "\nCamino " + listaCaminosDesdeOrigen.indexOf(camino) + ": "+ camino.getIdOrigen() + " ---- " + camino.getIdDestino() +"\n");
				}
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void actualizarParada(int nroParada, String calle, int nroCalle, boolean valida ) {
		GestorDB gdb = GestorDB.getInstance();
		Connection con = gdb.conec;
		
		try {
			PreparedStatement st = con.prepareStatement("UPDATE aplicacion_bus.parada SET calle = ?, activa=?, numero = ? WHERE id = ?");
			st.setString(1, calle);
			st.setBoolean(2, valida);
			st.setInt(3,nroCalle);
			st.setInt(4,nroParada);
			st.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] argc) { 
		
		//ObtenerParadas
		
		ParadaDAO prueba = new ParadaDAO();
		ArrayList<Parada> list;
		/*list = prueba.obtenerParadas();
		System.out.println(list);*/
		
		
		//Eliminar una parada por ID
		
		//prueba.eliminarParada(210);
		prueba.paradaPerteneceATrayecto(95);
		/*ParadaDAO prueba = new ParadaDAO();
		Parada nuevaParada = prueba.obtenerParada(3);
		System.out.println(nuevaParada);*/
		
	}
	
}
