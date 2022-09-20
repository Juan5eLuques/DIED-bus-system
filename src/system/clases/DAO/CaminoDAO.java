package system.clases.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DTO.DTOCamino;
import system.clases.Camino;
import system.clases.Parada;
import system.gestores.GestorDB;

public class CaminoDAO {
	
	//Dado un resultset de un camino, lo transforma a objeto DTOCamino y lo devuelve
		public static DTOCamino transformarADTOCamino(ResultSet rs) throws SQLException {
		try {
		DTOCamino nuevoCamino = new DTOCamino();
		nuevoCamino.setIdOrigen(rs.getInt("idOrigen"));
		nuevoCamino.setIdDestino(rs.getInt("idDestino"));
		nuevoCamino.setDistancia(rs.getDouble("distancia"));
		nuevoCamino.setDuracion(rs.getInt("duracion"));
		nuevoCamino.setActiva(rs.getBoolean("activa"));
		return nuevoCamino;
		}
		catch (SQLException e ) {
			e.printStackTrace();
		}
		return null;
	}

		//Dado un DTO de un camino, lo transforma a objeto camino y lo devuelve
		public static Camino transformarACamino(DTOCamino unCamino) {
		Camino nuevoCamino = new Camino();
		Parada paradaInicio = new ParadaDAO().obtenerParada(unCamino.getIdOrigen());
		Parada paradaFinal = new ParadaDAO().obtenerParada(unCamino.getIdDestino());
		nuevoCamino.setInicio(paradaInicio);
		nuevoCamino.setFin(paradaFinal);
		nuevoCamino.setDistancia(unCamino.getDistancia());
		nuevoCamino.setDuracion(unCamino.getDuracion());
		nuevoCamino.setActiva(unCamino.isActiva());
		return nuevoCamino;
	}

	public static Camino transformarRsACamino(ResultSet rs) throws SQLException{
		DTOCamino unDTOCamino = transformarADTOCamino(rs);
		return transformarACamino(unDTOCamino);
	}
	
	//Obtiene todos los caminos de la DB
	public static final ArrayList<DTOCamino> obtenerCaminos(){
		ArrayList<DTOCamino> listaCaminos = new ArrayList <DTOCamino>();
		GestorDB gdb = GestorDB.getInstance();
		Connection con = gdb.conec;
		try {
			PreparedStatement st = con.prepareStatement("SELECT * FROM aplicacion_bus.camino");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				DTOCamino nuevoCamino = transformarADTOCamino(rs);
				
				listaCaminos.add(nuevoCamino);
			}
			rs.close();
			con.close();
			return listaCaminos;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
		//Obtiene el trayecto asociado a la linea con id idLinea.
		//Primero obtiene el id del trayecto asociado a la linea de la tabla TRAYECTO.
		//Segundo, obtiene la lista de caminos asociados al trayecto de la tabla CAMINOTRAYECTO.
		//Por ultimo, transforma cada camino a objeto y lo guarda en el arreglo de retorno.
	
		public final static ArrayList<DTOCamino> obtenerCaminosDeUnaLinea(int idLinea){
		ArrayList<DTOCamino> listaCaminos = new ArrayList <DTOCamino>();
		GestorDB gdb = GestorDB.getInstance();
		Connection con = gdb.conec;
		try {
			PreparedStatement st = con.prepareStatement("SELECT * FROM APLICACION_BUS.TRAYECTO where idLinea=?");
			st.setInt(1, idLinea);
			int idTrayecto=-1;
			ResultSet rs = st.executeQuery();
			ResultSet rs2;
			if(rs.next()) {
			idTrayecto = rs.getInt("id");
			}
			st=con.prepareStatement ("SELECT * FROM APLICACION_BUS.CAMINOTRAYECTO where idTrayecto=? ORDER BY orden ASC");
			st.setInt(1,idTrayecto);
			rs2 = st.executeQuery();
			while (rs2.next()){
				listaCaminos.add((obtenerUnCamino(rs2.getInt("idOrigen"),rs2.getInt("idDestino"))));
			}
			rs.close();
			con.close();
			return listaCaminos;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
		
		public final static ArrayList<DTOCamino> obtenerCaminosDeUnaLinea(String nombreLinea){
			ArrayList<DTOCamino> listaCaminos = new ArrayList <DTOCamino>();
			GestorDB gdb = GestorDB.getInstance();
			Connection con = gdb.conec;
			try {
				int idColectivo=-1;
				int idTrayecto=-1;
				PreparedStatement st1 = con.prepareStatement("SELECT id FROM APLICACION_BUS.LINEA where nombre=?");
				st1.setString(1, nombreLinea);
				ResultSet rs1 = st1.executeQuery();
				if (rs1.next()) {
					idColectivo = rs1.getInt("id");
				}
				PreparedStatement st = con.prepareStatement("SELECT * FROM APLICACION_BUS.TRAYECTO where idLinea=?");
				st.setInt(1, idColectivo);
				ResultSet rs = st.executeQuery();
				ResultSet rs2;
				if(rs.next()) {
				idTrayecto = rs.getInt("id");
				}
				st=con.prepareStatement ("SELECT * FROM APLICACION_BUS.CAMINOTRAYECTO where idTrayecto=? ORDER BY orden ASC");
				st.setInt(1,idTrayecto);
				rs2 = st.executeQuery();
				while (rs2.next()){
					listaCaminos.add((obtenerUnCamino(rs2.getInt("idOrigen"),rs2.getInt("idDestino"))));
				}
				rs.close();
				con.close();
				return listaCaminos;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
	
	//Si existe, devuelve en camino que tiene como origen y destino las paradas pasadas. Si no existe, retorna null
	public static DTOCamino obtenerUnCamino(int idOrigen, int idDestino ) {
		GestorDB gdb = GestorDB.getInstance();
		Connection con = gdb.conec;
		try {
			PreparedStatement st = con.prepareStatement("SELECT * FROM aplicacion_bus.camino WHERE idorigen=? AND iddestino=?");
			st.setInt(1, idOrigen);
			st.setInt(2, idDestino);
			ResultSet rs = st.executeQuery();
			if (rs.next()){
				DTOCamino nuevoCamino = transformarADTOCamino(rs);
				rs.close();
				con.close();
				return nuevoCamino;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
		//Devuelve un array de todos los caminos que tienen a la parada inicio como origen
		public static ArrayList<DTOCamino> obtenerCaminosDesdeParada(int idParada) {
		ArrayList<DTOCamino> listaCaminos = new ArrayList <DTOCamino>();
		GestorDB gdb = GestorDB.getInstance();
		Connection con = gdb.conec;
		try {
			PreparedStatement st = con.prepareStatement("SELECT * FROM aplicacion_bus.camino WHERE idorigen=?");
			st.setInt(1,idParada);
			ResultSet rs = st.executeQuery();
			while (rs.next()){
				DTOCamino nuevoCamino = transformarADTOCamino(rs);

				listaCaminos.add(nuevoCamino);
			}
				rs.close();
				con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return listaCaminos;
	}
		//Devuelve un array de todos los caminos que tienen a la parada fin como destino
			public static ArrayList<DTOCamino> obtenerCaminosHastaParada(int idParada) {
		ArrayList<DTOCamino> listaCaminos = new ArrayList <DTOCamino>();
		GestorDB gdb = GestorDB.getInstance();
		Connection con = gdb.conec;
		try {
			PreparedStatement st = con.prepareStatement("SELECT * FROM aplicacion_bus.camino WHERE iddestino=?");
			st.setInt(1,idParada);
			ResultSet rs = st.executeQuery();
			while (rs.next()){
				DTOCamino nuevoCamino = transformarADTOCamino(rs);

				listaCaminos.add(nuevoCamino);
			}
				rs.close();
				con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return listaCaminos;
	}

		public static ArrayList<DTOCamino> obtenerCaminosQueIncluyenParada(int idParada){
			ArrayList<DTOCamino> listaCaminos = new ArrayList<DTOCamino>();
			listaCaminos.addAll(obtenerCaminosDesdeParada(idParada));
			listaCaminos.addAll(obtenerCaminosHastaParada(idParada));
			return listaCaminos;
		}

		//Dada una lista de caminos ya existentes, los asocia a un trayecto con id idTrayecto, en orden ascendente
		public static void guardarTrayecto(ArrayList<DTOCamino> listaCaminos, int idTrayecto){
			int orden = 1;
			GestorDB gdb = GestorDB.getInstance();
			Connection con = gdb.conec;
			try {
				PreparedStatement st;
				st = con.prepareStatement("INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (?,?,?,?)");
				for (DTOCamino unCamino:listaCaminos){
					st.setInt(1, unCamino.getIdOrigen());
					st.setInt(2, unCamino.getIdDestino());
					st.setInt(3, idTrayecto);
					st.setInt(4, orden);
					st.executeUpdate();
					orden ++;
				}
				st.close();
			}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			public static void eliminarCamino(DTOCamino unCamino) {
		GestorDB gdb = GestorDB.getInstance();
		Connection con = gdb.conec;
		try {
			PreparedStatement st = con.prepareStatement("DELETE FROM aplicacion_bus.camino WHERE idorigen=? AND iddestino=?");
			st.setInt(1,unCamino.getIdOrigen());
			st.setInt(2,unCamino.getIdDestino());
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

	//Elimina una lista de caminos
	public static void eliminarListaCaminos(ArrayList<DTOCamino> listaCaminos){
		for (DTOCamino unCamino:listaCaminos){
			eliminarCamino(unCamino);
		}
	}

	//Elimina todos los caminos asociados a una parada
	public static void eliminarCaminosConParada (int idParada){
		ArrayList<DTOCamino> listaCaminos = null;
		try {
			listaCaminos = obtenerCaminosQueIncluyenParada(idParada);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		eliminarListaCaminos(listaCaminos);
	}
	
	
	
	public static void main(String[] argc) {
		
		//Devuelve todos los caminos
		
		CaminoDAO prueba = new CaminoDAO();
		/*ArrayList <Camino> lista = new ArrayList<Camino>();
		lista = prueba.obtenerCaminos();
		System.out.println(lista);*/
		
		/*CaminoDAO prueba = new CaminoDAO();
		for (DTOCamino camino : prueba.obtenerCaminosDeUnaLinea(1)) {
			System.out.println("IDOrigen: " + camino.getIdOrigen()+"\n" + "IDDestino: " + camino.getIdDestino()+"\n");
		}*/
		
		ArrayList<DTOCamino> caminosDesde = obtenerCaminosDesdeParada(95);
		
		for(DTOCamino camino : caminosDesde) {
			System.out.println("Camino " + caminosDesde.indexOf(camino) + ": " + camino.getIdOrigen() + camino.getIdDestino() );
		}
		
		
	
	}

	public static void actualizarActivo(int nroParada, boolean activa ) {
		GestorDB gdb = GestorDB.getInstance();
		Connection con = gdb.conec;
		
		ArrayList<DTOCamino>listaCaminos = obtenerCaminosQueIncluyenParada(nroParada);
		for (DTOCamino unCamino:listaCaminos){
			boolean estadoOrigen = ParadaDAO.obtenerEstadoParada(unCamino.getIdOrigen());
			boolean estadoDestino = ParadaDAO.obtenerEstadoParada(unCamino.getIdDestino());
			boolean estadoCaminoActual = estadoDestino && estadoOrigen;
			if (estadoCaminoActual != unCamino.isActiva()){
				try {
					PreparedStatement st = con.prepareStatement("UPDATE aplicacion_bus.camino SET activa=?, WHERE idorigen = ? and iddestino = ?");
					st.setBoolean(1, activa);
					st.setInt(2, unCamino.getIdOrigen());
					st.setInt(3, unCamino.getIdDestino());
					st.executeUpdate();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
