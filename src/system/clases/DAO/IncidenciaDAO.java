package system.clases.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.DTOAutobus;
import DTO.DTOIncidencia;
import system.gestores.GestorDB;

public class IncidenciaDAO {
	
	public static ArrayList<DTOIncidencia> obtenerTodas(){
		GestorDB gdb = GestorDB.getInstance();
		Connection con = gdb.conec;
		ArrayList<DTOIncidencia> incidencias = new ArrayList<DTOIncidencia>();
		try {
			PreparedStatement st = con.prepareStatement("SELECT * FROM aplicacion_bus.INCIDENCIAS");
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				DTOIncidencia incidencia = new DTOIncidencia();
				incidencia.setIdIncidencia(rs.getInt("id"));
				incidencia.setIdParada(rs.getInt("idParada"));
				incidencia.setFechaInicio(rs.getDate("inicio"));
				incidencia.setFechaFin(rs.getDate("fin"));
				incidencia.setDescripcion(rs.getString("descripcion"));
				incidencia.setEstadoActual(rs.getBoolean("resuelta"));
				incidencias.add(incidencia);
			}
				rs.close();
				con.close();
				return incidencias;
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		return incidencias;
	}

	public static ArrayList<DTOIncidencia> obtenerActivas(){
		ArrayList<DTOIncidencia> ret = obtenerTodas();
		return (ArrayList<DTOIncidencia>)ret.stream().filter(unaIncidencia -> unaIncidencia.isEstadoActual());
	}
	
	public static void registrarIncidencia(DTOIncidencia nueva) {
		GestorDB gdb = GestorDB.getInstance();
		Connection con = gdb.conec;
		try {
			
			Date fechaInicio = new Date(nueva.getFechaInicio().getTime());
			Date fechaFin = new Date(nueva.getFechaFin().getTime());
			
			PreparedStatement st = con.prepareStatement("INSERT INTO aplicacion_bus.INCIDENCIAS VALUES (?,?,?,?,?,?)");
			st.setInt(1, nueva.getIdIncidencia());
			st.setInt(2, nueva.getIdParada());
			st.setDate(3, fechaInicio);
			st.setDate(4, fechaFin);
			st.setString(5, nueva.getDescripcion());
			st.setBoolean(6, nueva.isEstadoActual());
			st.executeUpdate();
			st.close();
			con.close();
			}
		catch (SQLException e ) {
			e.printStackTrace();
		}
	}
	
}
