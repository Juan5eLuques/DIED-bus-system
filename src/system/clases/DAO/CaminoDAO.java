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
			st.setInt(idLinea);
			ResultSet rs = st.executeQuery();
			ResutlSet rs2;
			idTrayecto = rs.getInt("id");

			con.prepareStatement ("SELECT * FROM APLICACION_BUS.CAMINOTRAYECTO where idTrayecto=? ORDER BY orden DESC");
			st.setInt(idTrayecto);
			rs = st.executeQuery();
			Camino unCamino = new Camino();
			while (rs.next){
				con.prepareStatement ("SELECT * FROM APLICACION_BUS.CAMINO WHERE idOrigen=? AND idDestino =?");
				st.setInt(1,rs.getInt("idOrigen"));
				st.setInt(2,rs.getInt("idDestino"));
				rs2 = st.executeQuery();
				unCamino.setInicio(rs2.getInt("idOrigen"));
				unCamino.setFin(rs2.getInt("idDestino"));
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
