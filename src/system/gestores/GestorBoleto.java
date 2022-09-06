package system.gestores;

import java.util.ArrayList;

import DTO.DTOAutobus;
import DTO.DTOCamino;
import DTO.DTOParada;
import system.clases.Autobus;
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
	
	//Devuelve en "ae" y "as" la lista de los autobuces que pasan por la parada "parada"
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
			i++;
		}
		
		return ret;
	}
	
	public static ArrayList<DTOCamino> caminoRecortadoInicio (int parada,ArrayList<DTOCamino> unTrayecto){
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
	
	public static ArrayList<DTOCamino> caminoRecortadoFin (int parada,ArrayList<DTOCamino> unTrayecto){
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
	
	public static void calcularCaminosPosibles(int paradaInicio, int paradaFin, ArrayList<AutobusEconomico> ae, ArrayList<AutobusSuperior> as, 
			ArrayList<ArrayList<DTOCamino>> listaCaminos, ArrayList<DTOAutobus> listaAutobuses, ArrayList<Double> listaDistancia, ArrayList<Double> listaCosto, ArrayList<Double> listaDuracion){
		listaAutobuses.clear();
		listaCaminos.clear();
		listaDistancia.clear();
		listaCosto.clear();
		listaDuracion.clear();
		double unaDistancia;
		double unCosto;
		double unTiempo;
		DTOAutobus unAuto;
		
		for (AutobusEconomico unAutobus:ae) {
			ArrayList<DTOCamino> unTrayecto = new ArrayList<DTOCamino>();
			unTrayecto = caminoRecortadoInicio(paradaInicio, unAutobus.getRecorridoLinea());
			unTrayecto = caminoRecortadoFin (paradaFin, unTrayecto);
			
			if (!unTrayecto.isEmpty()) {
				unAuto = AutobusEconomicoDAO.transformarADTO(unAutobus);
				listaAutobuses.add(unAuto);
				listaCaminos.add(unTrayecto);
				unaDistancia = calcularDistanciaRecorrida(unTrayecto);
				listaDistancia.add(unaDistancia);
				listaCosto.add(calcularCostoPasaje(unAuto,unaDistancia));
				listaDuracion.add(calcularDuracion(unTrayecto));
			}
		}
		
		for (AutobusSuperior unAutobus:as) {
			ArrayList<DTOCamino> unTrayecto = new ArrayList<DTOCamino>();
			unTrayecto = caminoRecortadoInicio(paradaInicio, unAutobus.getRecorridoLinea());
			unTrayecto = caminoRecortadoFin (paradaFin, unTrayecto);
			
			if (!unTrayecto.isEmpty()) {
				unAuto = AutobusSuperiorDAO.transformarADTO(unAutobus);
				listaAutobuses.add(unAuto);
				listaCaminos.add(unTrayecto);
				unaDistancia = calcularDistanciaRecorrida(unTrayecto);
				listaDistancia.add(unaDistancia);
				listaCosto.add(calcularCostoPasaje(unAuto,unaDistancia));
				listaDuracion.add(calcularDuracion(unTrayecto));
			}
		}
		
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
	
	//Devuelve el valor del pasaje
	public static double calcularCostoPasaje(DTOAutobus unAutobus, double distancia) {
		double valor=distancia * Autobus.getMontoPorKM();
		double modificador = Autobus.getPorcentajePorServicio();
		if (unAutobus.isAire()) {
			modificador += 5;
		}
		if (unAutobus.isWifi()) {
			modificador += 5;
		}
		return valor*(1+modificador/100);
	}
	
	//Devuelve la distancia total recorrida en un trayecto
	public static double calcularDistanciaRecorrida(ArrayList<DTOCamino> unTrayecto) {
		double distancia=0;
		for (DTOCamino unCamino:unTrayecto) {
			distancia+= unCamino.getDistancia();
		}
		return distancia;
	}
	
	//Devuelve la duracion total de un trayecto
	public static double calcularDuracion(ArrayList<DTOCamino> unTrayecto) {
		double duracion=0;
		for (DTOCamino unCamino:unTrayecto) {
			duracion+= unCamino.getDuracion();
		}
		return duracion;
	}
	
	//devuelve una lista de paradas que pasan por un camino
	public static void agregarParadasPosible (ArrayList<Parada> posibles, ArrayList<DTOCamino> unTrayecto) {
		for (DTOCamino unCamino:unTrayecto) {
			posibles.add(GestorParada.obtenerParada(unCamino.getIdDestino()));
		}
	}
}
