package system.gestores;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

import DTO.DTOAutobus;
import DTO.DTOCamino;
import DTO.DTOParada;
import system.clases.Autobus;
import system.clases.AutobusEconomico;
import system.clases.AutobusSuperior;
import system.clases.InformacionCamino;
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
				System.out.println("GESTORBOLETO::Siguiente parada __->" +unTrayecto.get(i).getIdDestino()); //BORRAR
				caminoCortado.add(unTrayecto.get(i));
				if (unTrayecto.get(i).getIdDestino() == parada) {
					flag = true;
				}
				i++;
			}
			if(!flag) {
				caminoCortado.clear();
			}
			return caminoCortado;
			}
	
	public static void calcularCaminosPosibles(int paradaInicio, int paradaFin, ArrayList<AutobusEconomico> ae, ArrayList<AutobusSuperior> as, 
			ArrayList<InformacionCamino> caminosPosibles){
		caminosPosibles.clear();
		double unaDistancia;
		DTOAutobus unAuto;
		
		
		System.out.println("GESTORBOLETO::Cantidad de autobuses economicos: "+ae.size()); //BORRAR
		for (AutobusEconomico unAutobus:ae) {
			ArrayList<DTOCamino> unTrayecto = new ArrayList<DTOCamino>();
			unTrayecto = caminoRecortadoInicio(paradaInicio, unAutobus.getRecorridoLinea());
			unTrayecto = caminoRecortadoFin (paradaFin, unTrayecto);
			
			if (!unTrayecto.isEmpty()) {
				InformacionCamino unCamino = new InformacionCamino();
				System.out.println("GESTORBOLETO::Hay un camino economico posible"); //BORRAR
				unAuto = AutobusEconomicoDAO.transformarADTO(unAutobus);
				unCamino.setAutobus(unAuto);
				System.out.println("GESTORBOLETO::ID LINEA ECONOMICA:" + unCamino.getAutobus().getId()); //BORRAR
				unCamino.setRecorrido(unTrayecto);
				unaDistancia = calcularDistanciaRecorrida(unTrayecto);
				unCamino.setDistancia(unaDistancia);
				unCamino.setCosto(calcularCostoPasaje(unAuto,unaDistancia));
				unCamino.setDuracion(calcularDuracion(unTrayecto));
				caminosPosibles.add(unCamino);
			}
		}
		System.out.println("GESTORBOLETO::Cantidad de autobuses superiores: "+as.size()); //BORRAR
		for (AutobusSuperior unAutobus:as) {
			ArrayList<DTOCamino> unTrayecto = new ArrayList<DTOCamino>();
			unTrayecto = caminoRecortadoInicio(paradaInicio, unAutobus.getRecorridoLinea());
			unTrayecto = caminoRecortadoFin (paradaFin, unTrayecto);
			
			if (!unTrayecto.isEmpty()) {
				InformacionCamino unCamino = new InformacionCamino();
				System.out.println("GESTORBOLETO::Hay un camino superior posible"); //BORRAR
				unAuto = AutobusSuperiorDAO.transformarADTO(unAutobus);
				unCamino.setAutobus(unAuto);
				unCamino.setRecorrido(unTrayecto);
				unaDistancia = calcularDistanciaRecorrida(unTrayecto);
				unCamino.setDistancia(unaDistancia);
				unCamino.setCosto(calcularCostoPasaje(unAuto,unaDistancia));
				unCamino.setDuracion(calcularDuracion(unTrayecto));
				caminosPosibles.add(unCamino);
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
		double modificador;
		if (unAutobus.getTipo()=="Economico") {
			modificador = AutobusEconomico.getPorcentajePorServicio();
		}
		else {
			modificador = AutobusSuperior.getPorcentajePorServicio();
		}
		System.out.println("GESTORBOLETO:: PORCENTAJE POR SERVICIO: "+modificador); //BORRAR
		if (unAutobus.isAire()) {
			modificador += 5;
		}
		if (unAutobus.isWifi()) {
			modificador += 5;
		}
		return valor*(1+modificador/100);
	}
	
	//Devuelve la distancia total EN KILOMETROS recorrida en un trayecto
	public static double calcularDistanciaRecorrida(ArrayList<DTOCamino> unTrayecto) {
		double distancia=0;
		for (DTOCamino unCamino:unTrayecto) {
			distancia+= unCamino.getDistancia();
		}
		return distancia/1000; //PARA PASAR A KM
	}
	
	//Devuelve la duracion total de un trayecto
	public static double calcularDuracion(ArrayList<DTOCamino> unTrayecto) {
		double duracion=0;
		for (DTOCamino unCamino:unTrayecto) {
			duracion+= unCamino.getDuracion();
		}
		return duracion;
	}
	
	public static void agregarParadasPosible (ArrayList<Parada> posibles, ArrayList<DTOCamino> unTrayecto) {
		for (DTOCamino unCamino:unTrayecto) {
			posibles.add(GestorParada.obtenerParada(unCamino.getIdDestino()));
		}
	}
	
	
	//Ordena la lista de caminos posibles por duracion, costo o distancia del viaje
	public static void ordenarPorCriterio(int criterio, ArrayList<InformacionCamino> caminosPosibles) {
		if (caminosPosibles.size() > 1) {
			caminosPosibles.sort(Comparator.comparingDouble(InformacionCamino::getCosto));
		}	
		
	}
}
