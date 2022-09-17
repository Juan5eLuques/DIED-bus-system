package system.clases.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.DTOIncidencia;
import system.clases.InformacionCamino;
import system.gestores.GestorDB;

public class InformacionBoletoDAO {
	
	public static void guardarBoleto(InformacionCamino unBoleto){
		GestorDB gdb = GestorDB.getInstance();
		Connection con = gdb.conec;
		try {
			PreparedStatement st = con.prepareStatement("INSERT INTO APLICACION_BUS.BOLETO "
					+ "(idLinea, paradaInicial, paradaFinal, duracion, distancia, costo) VALUES (?,?,?,?,?,?) ");

			st.setInt(1, unBoleto.getAutobus().getId());
			st.setInt(2, unBoleto.getParadaInicial());
			st.setInt(3, unBoleto.getParadaFinal());
			st.setDouble(4, unBoleto.getDuracion());
			st.setDouble(5, unBoleto.getDistancia());
			st.setDouble(6, unBoleto.getCosto());
			st.executeUpdate();
			st.close();
			con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
