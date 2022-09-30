package GUI.JPanels.Trayecto;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

import DTO.DTOCamino;
import DTO.DTOParada;
import GUI.Componentes.BotonAtras;
import GUI.Componentes.BotonNodo;
import system.gestores.GestorCamino;
import system.gestores.GestorParada;

public class JPCrearCamino extends JPanel{
	
	Map <Integer, BotonNodo> nodosCiudad = new HashMap<Integer, BotonNodo>();
	ArrayList<DTOParada> listaParadas;
	ArrayList<DTOCamino> listaCaminos;
	
	public JPCrearCamino() {
		BotonAtras boton = new BotonAtras(true);
		this.add(boton);
		this.setLayout(null);
		this.setBackground(new Color(32, 83, 117));
		
		listaParadas = GestorParada.obtenerTodas();
		listaCaminos = GestorCamino.obtenerCaminos();
		
		for (DTOParada parada: listaParadas){
			
			BotonNodo nuevaParada = new BotonNodo(parada, null);
			
			this.add(nuevaParada);
			nodosCiudad.put(parada.getNroParada(),nuevaParada);
		}
		
	}
}
		