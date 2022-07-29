package system.clases.DAO;

import system.clases.Parada;
import system.gestores.GestorDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DTO.DTOParada;

public class ParadaDAO {
	
	private Connection conn;
	
	public static void agregarParada(DTOParada nuevaParada) {
		
		GestorDB gdb = GestorDB.getInstance();
		Connection con = gdb.conec;
		try {
			PreparedStatement st = con.prepareStatement("INSERT INTO aplicacion_bus.parada VALUES (?, ?, ?, ?)");
			st.setInt(1,nuevaParada.getNroParada());
			st.setBoolean(2, nuevaParada.isIncidencia());
			st.setString(3, nuevaParada.getCalle());
			st.setInt(4, nuevaParada.getNroCalle());
			st.executeUpdate();
			st.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		con.close();
	}
	
	public static boolean paradaExiste(int nroParada) {
		boolean ret= true;
		Parada existe = new ParadaDAO().obtenerParada(nroParada);
		if (existe != null){
			ret = false;
		}
		return ret;
	}
	
	public ArrayList<Parada> obtenerParadas(){
		
		ArrayList<Parada> lista = new ArrayList<Parada>();
		
		GestorDB gdb = GestorDB.getInstance();
		Connection con = gdb.conec;
		try {
			PreparedStatement st = con.prepareStatement("SELECT * FROM aplicacion_bus.parada VALUES");
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Parada parada = new Parada(rs.getInt("id"),rs.getInt("numero"),rs.getString("calle"),rs.getBoolean("activa"));
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
	
	public void eliminarParada(int idParada) {
		GestorDB gdb = GestorDB.getInstance();
		Connection con = gdb.conec;
		try {
			PreparedStatement st = con.prepareStatement("DELETE FROM aplicacion_bus.parada WHERE id=" + idParada);
			if(st.execute()!=true) {
				JOptionPane.showMessageDialog(null, "Ocurrion un error, la <Parada> no existe.", "Error", JOptionPane.WARNING_MESSAGE);
				st.close();
				con.close();
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Parada obtenerParada(int nroParada) {
		GestorDB gdb = GestorDB.getInstance();
		Connection con = gdb.conec;
		try {
			PreparedStatement st = con.prepareStatement("SELECT id, activa, calle, numero FROM aplicacion_bus.parada WHERE id=" + nroParada);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				Parada parada = new Parada(rs.getInt("id"),rs.getInt("numero"),rs.getString("calle"),rs.getBoolean("activa"));
				return parada;
			}
			rs.close();
			con.close();
		}
		catch (Exception e ) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] argc) { 
		
		//ObtenerParadas
		
		/*ParadaDAO prueba = new ParadaDAO();
		ArrayList<Parada> list;
		list = prueba.obtenerParadas();
		System.out.println(list);*/
		
		
		//Eliminar una parada por ID
		
		ParadaDAO prueba = new ParadaDAO();
		Parada nuevaParada = prueba.obtenerParada(3);
		System.out.println(nuevaParada);
		
	}
	
}
