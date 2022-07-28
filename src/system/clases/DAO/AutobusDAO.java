package system.clases.DAO;

public class AutobusDAO {
	public Autobus obtenerAutobus (int id){
	
    		GestorDB gdb = GestorDB.getInstance();
		Connection con = gdb.conec;
		try {
			PreparedStatement st = con.prepareStatement("SELECT * FROM aplicacion_bus.LINEA where id=?");
            st.setInt(1,id);
			ResultSet rs = st.executeQuery();
            if(rs.getString("tipo") == "Economico"){
                AutobusEconomico auto = new AutobusEconomico();
                auto.transformarA_Autobus(rs);

            }
            else{
                AutobusSuperior auto = new AutobusSuperior();
                auto.transformarA_Autobus(rs);

            }
			rs.close();
			con.close();
            auto.setRecorridoLinea(CaminoDAO.obtenerCaminosDeUnaLinea(id));
			return auto;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
    }
	
}
