package system.clases.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import system.clases.Camino;
import system.clases.Parada;
import system.gestores.GestorDB;

public class CaminoDAO {
	
	public Camino transformarACamino(ResultSet rs) throws SQLException {
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
	}
	
	
	public final ArrayList<Camino> obtenerCaminos(){
		ArrayList<Camino> listaCaminos = new ArrayList <Camino>();
		GestorDB gdb = GestorDB.getInstance();
		Connection con = gdb.conec;
		try {
			PreparedStatement st = con.prepareStatement("SELECT * FROM aplicacion_bus.camino");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Camino nuevoCamino = this.transformarACamino(rs);
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
			Camino unCamino = new Camino();
			while (rs.next()){
				con.prepareStatement ("SELECT * FROM APLICACION_BUS.CAMINO WHERE idOrigen=? AND idDestino =?");
				st.setInt(1,rs.getInt("idOrigen"));
				st.setInt(2,rs.getInt("idDestino"));
				rs2 = st.executeQuery();
				
				unCamino.setInicio(new ParadaDAO().obtenerParada(rs.getInt("idOrigen")));
				unCamino.setInicio(new ParadaDAO().obtenerParada(rs.getInt("idDestino")));
				unCamino.setActiva(rs2.getBoolean("activa"));
				unCamino.setDuracion(rs2.getDouble("duracion"));
				unCamino.setDistancia(rs2.getDouble("distancia"));
				listaCaminos.add(unCamino);
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
	
	
	public Camino obtenerUnCamino(Parada inicio, Parada fin ) {
		GestorDB gdb = GestorDB.getInstance();
		Connection con = gdb.conec;
		try {
			PreparedStatement st = con.prepareStatement("SELECT * FROM aplicacion_bus.camino WHERE idorigen=" + inicio.getNroParada() + "AND iddestino=" + fin.getNroParada());
			ResultSet rs = st.executeQuery();
			if (rs.next()){
				Camino nuevoCamino = this.transformarACamino(rs);
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

		public ArrayList<Camino> obtenerCaminosDesdeParada(Parada inicio) {
		ArrayList<Camino> listaCaminos = new ArrayList <Camino>();
		GestorDB gdb = GestorDB.getInstance();
		Connection con = gdb.conec;
		try {
			PreparedStatement st = con.prepareStatement("SELECT * FROM aplicacion_bus.camino WHERE idorigen=?");
			st.setInt(1,inicio.getNroParada());
			ResultSet rs = st.executeQuery();
			while (rs.next()){
				Camino nuevoCamino = this.transformarACamino(rs);

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

	
	public static void main(String[] argc) {
		
		//Devuelve todos los caminos
		
		/*CaminoDAO prueba = new CaminoDAO();
		ArrayList <Camino> lista = new ArrayList<Camino>();
		lista = prueba.obtenerCaminos();
		System.out.println(lista);*/
		
		CaminoDAO prueba = new CaminoDAO();
		Camino nuevoCamino = prueba.obtenerUnCamino(new ParadaDAO().obtenerParada(1), new ParadaDAO().obtenerParada(2));
		System.out.println(nuevoCamino);
		
	}
	
}
