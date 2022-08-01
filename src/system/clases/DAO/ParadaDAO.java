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
		boolean ret= true;
		Parada existe = new ParadaDAO().obtenerParada(nroParada);
		if (existe.getNroParada() != -1){
			ret = false;
		}
		return ret;
	}
	
	//Obtiene todas las paradas de la BD
	public ArrayList<Parada> obtenerParadas(){
		
		ArrayList<Parada> lista = new ArrayList<Parada>();
		
		GestorDB gdb = GestorDB.getInstance();
		Connection con = gdb.conec;
		try {
			PreparedStatement st = con.prepareStatement("SELECT * FROM APLICACION_BUS.PARADA");
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
	
	//Elimina una parada con id : idParada. 
	//Fixear comportamiento si no la puede eliminar (siempre tira el mensaje aun que si pueda eliminarla).
	public static void eliminarParada(int idParada) {
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
	
	public static void main(String[] argc) { 
		
		//ObtenerParadas
		
		ParadaDAO prueba = new ParadaDAO();
		ArrayList<Parada> list;
		list = prueba.obtenerParadas();
		System.out.println(list);
		
		
		//Eliminar una parada por ID
		
		/*ParadaDAO prueba = new ParadaDAO();
		Parada nuevaParada = prueba.obtenerParada(3);
		System.out.println(nuevaParada);*/
		
	}
	
}
