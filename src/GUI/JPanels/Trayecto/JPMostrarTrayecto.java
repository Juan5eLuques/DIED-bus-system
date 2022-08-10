package GUI.JPanels.Trayecto;

import java.awt.Graphics;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.stream.Collectors;

import DTO.DTOCamino;
import system.clases.Camino;
import system.clases.Parada;
import system.clases.DAO.CaminoDAO;
import system.gestores.GestorCamino;
import system.gestores.GestorParada;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPMostrarTrayecto extends JPanel{
	
	private final static int CX = 200; //Corrimiento en X
	private final static int CY = 5; //Corrimiento en Y
	private final static int TPA = 8; //Tamaño punto anterior
	private final static int TPN = 12; //Tamaño punto nuevo
	
	
	public JPMostrarTrayecto(JPanel panelManipular, JLabel lblTitulo) {
		
		ArrayList<Parada> paradas = GestorParada.obtenerTodasLasParadas();
		this.setLayout(null);
		dibujarCiudad(this);
		
	}
	
	
	private static void dibujarParadas(ArrayList<Parada> listaParadas, JPanel panel) {
		ArrayList <Integer> posActual; 
		ArrayList <Integer> posAnterior = null;
		
		Graphics g = panel.getGraphics();
		
		 int contador= 1;
		for(Parada unaParada:listaParadas) {
			posActual = ubicacion(unaParada);
			
			if (contador==listaParadas.size()) {
				dibujarUnaParada(g, posActual, TPN);
			}
			else {
				dibujarUnaParada(g, posActual, TPA);
			}				
			if (posAnterior != null){
				dibujarUnCamino (g, posAnterior, posActual);
			}
			
			posAnterior = posActual;
			contador ++;
		}
	}
	
	
	private static void dibujarCiudad(JPanel panel) {
		ArrayList<Parada> paradas = GestorParada.obtenerTodasLasParadas();
		ArrayList<DTOCamino> DTOCaminos = GestorCamino.obtenerCaminos();
		ArrayList <Camino> caminos= new ArrayList<Camino>();
		for (DTOCamino unDTOCamino:DTOCaminos) {
			caminos.add(CaminoDAO.transformarACamino(unDTOCamino));
		}
		Graphics g = panel.getGraphics();
		
		for (Parada unaParada:paradas) {
			ArrayList<Parada> paradasConectadas = 
			(ArrayList<Parada>) caminos.stream()
			.filter(unCamino -> unCamino.getInicio().getNroParada() == unaParada.getNroParada())
			.map(unCamino -> unCamino.getFin())
			.collect(Collectors.toList());
			
			ArrayList<Integer> posParada = ubicacion(unaParada);
			dibujarUnaParada(g,posParada,TPA);
			
			for (Parada unaParadaConectada:paradasConectadas) {
				ArrayList<Integer> posSiguiente = ubicacion(unaParadaConectada);
				dibujarUnCamino(g,posParada,posSiguiente);
			}
		}
	}
	
	private static ArrayList<Integer> ubicacion(Parada parada) {
		
		ArrayList<Integer> retorno = new ArrayList<Integer>();
		int calle = Integer.parseInt(parada.getCalle().substring(6));
		if (calle%2==0) { //Si es vertical
			retorno.add(((calle/2)+1)*50);
			retorno.add(50*(((parada.getNroCalle()-50)/200))+75);
			
		}
		else { //Si es horizontal
			retorno.add(50*(((parada.getNroCalle()-50)/200))+75);
			retorno.add((calle+1)*25);
		}
		return retorno;
	}
	
	private static void dibujarUnaParada (Graphics g, ArrayList<Integer> pos, int tam) {
		g.fillOval(CX+pos.get(0)-((TPN-tam)/2), CY+pos.get(1)-((TPN-tam)/2), tam, tam);
	}
	
	private static void dibujarUnCamino (Graphics g, ArrayList<Integer> posInicial, ArrayList<Integer> posFinal) {
		g.drawLine(CX+posInicial.get(0)+TPA/2, CY+posInicial.get(1)+TPA/2, CX+posFinal.get(0)+TPA/2, CY +posFinal.get(1)+TPA/2);
	}
}
