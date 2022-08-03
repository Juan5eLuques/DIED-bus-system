package system.clases.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DTO.DTOParada;
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

	//Dado un resultset de un camino, lo transforma a objeto camino y lo devuelve
	/*public Camino transformarACamino(ResultSet rs) throws SQLException {
		try {
		Camino nuevoCamino = new Camino();
		Parada paradaInicio = new ParadaDAO().obtenerParada(rs.getInt("idOrigen"));
		Parada paradaFinal = new ParadaDAO().obtenerParada(rs.getInt("idDestino"));
		nuevoCamino.setInicio(paradaInicio);
		nuevoCamino.setFin(paradaFinal);
		nuevoCamino.setDistancia(rs.getDouble("distancia"));
		nuevoCamino.setDuracion(rs.getInt("duracion"));
		nuevoCamino.setActiva(rs.getBoolean("activa"));
		return nuevoCamino;
		}
		catch (SQLException e ) {
			e.printStackTrace();
		}
		return null;
	}*/

		//Dado un DTO de un camino, lo transforma a objeto camino y lo devuelve
		public static Camino transformarACamino(DTOCamino unCamino) throws SQLException {
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
	public final ArrayList<Camino> obtenerCaminos(){
		ArrayList<Camino> listaCaminos = new ArrayList <Camino>();
		GestorDB gdb = GestorDB.getInstance();
		Connection con = gdb.conec;
		try {
			PreparedStatement st = con.prepareStatement("SELECT * FROM aplicacion_bus.camino");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Camino nuevoCamino = this.transformarRsACamino(rs);
				
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
		public final ArrayList<Camino> obtenerCaminosDeUnaLinea(int idLinea){
		ArrayList<Camino> listaCaminos = new ArrayList <Camino>();
		GestorDB gdb = GestorDB.getInstance();
		Connection con = gdb.conec;
		try {
			PreparedStatement st = con.prepareStatement("SELECT * FROM APLICACION_BUS.TRAYECTO where idLinea=?");
			st.setInt(1, idLinea);
			ResultSet rs = st.executeQuery();
			ResultSet rs2;
			int idTrayecto = rs.getInt("id");

			con.prepareStatement ("SELECT * FROM APLICACION_BUS.CAMINOTRAYECTO where idTrayecto=? ORDER BY orden DESC");
			st.setInt(1,idTrayecto);
			rs = st.executeQuery();
			while (rs.next()){
				con.prepareStatement ("SELECT * FROM APLICACION_BUS.CAMINO WHERE idOrigen=? AND idDestino =?");
				st.setInt(1,rs.getInt("idOrigen"));
				st.setInt(2,rs.getInt("idDestino"));
				rs2 = st.executeQuery();
				
				listaCaminos.add(transformarRsACamino(rs2));
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
	public DTOCamino obtenerUnCamino(int idOrigen, int idDestino ) {
		GestorDB gdb = GestorDB.getInstance();
		Connection con = gdb.conec;
		try {
			PreparedStatement st = con.prepareStatement("SELECT * FROM aplicacion_bus.camino WHERE idorigen=? AND iddestino=?");
			st.setInt(1, idOrigen);
			st.setInt(2, idDestino);
			ResultSet rs = st.executeQuery();
			if (rs.next()){
				DTOCamino nuevoCamino = this.transformarADTOCamino(rs);
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
		public ArrayList<DTOCamino> obtenerCaminosDesdeParada(int idParada) {
		ArrayList<DTOCamino> listaCaminos = new ArrayList <DTOCamino>();
		GestorDB gdb = GestorDB.getInstance();
		Connection con = gdb.conec;
		try {
			PreparedStatement st = con.prepareStatement("SELECT * FROM aplicacion_bus.camino WHERE idorigen=?");
			st.setInt(1,idParada);
			ResultSet rs = st.executeQuery();
			while (rs.next()){
				DTOCamino nuevoCamino = this.transformarADTOCamino(rs);

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
			public ArrayList<DTOCamino> obtenerCaminosHastaParada(int idParada) {
		ArrayList<DTOCamino> listaCaminos = new ArrayList <DTOCamino>();
		GestorDB gdb = GestorDB.getInstance();
		Connection con = gdb.conec;
		try {
			PreparedStatement st = con.prepareStatement("SELECT * FROM aplicacion_bus.camino WHERE iddestino=?");
			st.setInt(1,idParada);
			ResultSet rs = st.executeQuery();
			while (rs.next()){
				DTOCamino nuevoCamino = this.transformarADTOCamino(rs);

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

		public ArrayList<DTOCamino> obtenerCaminosQueIncluyenParada(int idParada){
			ArrayList<DTOCamino> listaCaminos = new ArrayList<DTOCamino>();
			listaCaminos.addAll(obtenerCaminosDesdeParada(idParada));
			listaCaminos.addAll(obtenerCaminosHastaParada(idParada));
			return listaCaminos;
		}

		//Dada una lista de caminos ya existentes, los asocia a un trayecto con id idTrayecto, en orden ascendente
		public static void guardarTrayecto(ArrayList<Camino> listaCaminos, int idTrayecto){
			int orden = 1;
			GestorDB gdb = GestorDB.getInstance();
			Connection con = gdb.conec;
			for (Camino unCamino:listaCaminos){
				PreparedStatement st;
				try {
					st = con.prepareStatement("INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (?,?,?,?)");
					st.setInt(1, unCamino.getInicio().getNroParada());
					st.setInt(2, unCamino.getFin().getNroParada());
					st.setInt(3, idTrayecto);
					st.setInt(4, orden);
					st.executeUpdate();
					orden ++;
				} 
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
	public void eliminarCaminosConParada (int idParada){
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
		
		/*CaminoDAO prueba = new CaminoDAO();
		ArrayList <Camino> lista = new ArrayList<Camino>();
		lista = prueba.obtenerCaminos();
		System.out.println(lista);*/
		
		CaminoDAO prueba = new CaminoDAO();
		DTOCamino camino= prueba.obtenerUnCamino(1, 2);
		System.out.println(ParadaDAO.obtenerParada(camino.getIdOrigen()));
		System.out.println(ParadaDAO.obtenerParada(camino.getIdDestino()));
	}
	
}
