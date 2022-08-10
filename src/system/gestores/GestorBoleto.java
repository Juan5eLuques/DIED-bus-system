package system.gestores;

import java.util.ArrayList;

import DTO.DTOCamino;
import DTO.DTOParada;
import system.clases.AutobusEconomico;
import system.clases.AutobusSuperior;
import system.clases.Parada;
import system.clases.DAO.AutobusDAO;
import system.clases.DAO.AutobusEconomicoDAO;
import system.clases.DAO.AutobusSuperiorDAO;

public class GestorBoleto {
	
	//---------- Patron Singleton
	private static GestorBoleto GBoleto ; // Patron Singleton -- Unica instancia tipo gestor creada.

	private GestorBoleto(){ // Patron Singleton -- Constructor privatizado para no permitir su uso.
	}

	public static GestorBoleto getInstance() { // Patron Singleton -- Devuelve la instancia, si no existe la crea
		if ( GBoleto == null) {
			GBoleto = new GestorBoleto();
		}
		return GBoleto;
	}
	
	public static boolean cargarLineasQueContienenParada(int parada, ArrayList<AutobusEconomico> ae, ArrayList<AutobusSuperior> as) {
		boolean ret = false;
		ArrayList <Integer> IDParadas = new ArrayList<Integer>();
		ArrayList <String> tipo= new ArrayList<String>();
				AutobusDAO.lineasQueContienenParada(parada, IDParadas,tipo);
		ae.clear();
		as.clear();
		int i = 0;
		if (IDParadas.size()!= 0) {
			ret = true;
		}
		for (int id:IDParadas) {
			if (tipo.get(i).equals("Economico")) {
				ae.add(AutobusEconomicoDAO.obtenerAutobus(id));
			}
			if (tipo.get(i).equals("Superior")) {
				as.add(AutobusSuperiorDAO.obtenerAutobus(id));
			}
		}
		
		return ret;
	}
	
	public static ArrayList<DTOCamino> caminosRecortadoInicio (int parada,ArrayList<DTOCamino> unTrayecto){
		ArrayList<DTOCamino> caminoCortado = new ArrayList<DTOCamino>();
		boolean flag;
			flag = false;
			for (DTOCamino unC:unTrayecto) {
				if (unC.getIdOrigen() == parada) {
					flag = true;
				}
				if (flag) {
					caminoCortado.add(unC);
				}
			}
		return caminoCortado;
	}
	
	public static ArrayList<DTOCamino> caminosRecortadoFin (int parada,ArrayList<DTOCamino> unTrayecto){
		ArrayList<DTOCamino> caminoCortado = new ArrayList<DTOCamino>();
		boolean flag;
			flag = false;
			int i=0;
			while (!flag) {
				caminoCortado.add(unTrayecto.get(i));
				if (unTrayecto.get(i).getIdDestino() == parada) {
					flag = true;
				}
			}
			if(true) {
				caminoCortado.clear();
			}
			return caminoCortado;
			}
	
	public static void calcularCaminosPosibles(int paradaInicio, int paradaFinal, ArrayList<AutobusEconomico> ae, ArrayList<AutobusSuperior> as){
		
	}

	public static boolean contieneParada (int unaParada, ArrayList<DTOCamino> listaCaminos) {
		boolean ret = false;
		for (DTOCamino unCamino:listaCaminos) {
			if (unCamino.getIdDestino() == unaParada) {
				ret = true;
			}
		}
		return ret; 
	}
}
