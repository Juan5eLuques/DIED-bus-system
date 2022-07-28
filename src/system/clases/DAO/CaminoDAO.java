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
