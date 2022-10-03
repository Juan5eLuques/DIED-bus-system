package GUI.JPanels.Menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import DTO.DTOCamino;
import DTO.DTOIncidencia;
import DTO.DTOParada;
import GUI.Componentes.BotonAtras;
import GUI.Componentes.BotonMenu;
import GUI.Componentes.BotonNodo;
import GUI.Componentes.UbicacionParada;
import enums.CriterioNodoCiudad;
import system.gestores.GestorParada;
import system.gestores.GestorCamino;
import system.gestores.GestorGUI;
import system.gestores.GestorIncidencia;

public class JPMostrarCiudad extends JPanel{
	
	ArrayList<DTOParada> listaParadas;
	ArrayList<DTOCamino> listaCaminos;
	ArrayList<DTOIncidencia> incidencias = GestorIncidencia.obtenerActivas();
	Map <Integer, BotonNodo> nodosCiudad = new HashMap<Integer, BotonNodo>();
	
	private static final long serialVersionUID = 1L;

	public JPMostrarCiudad(JPanel panelManipular, JPanel panelContent, JLabel lblTitulo) {
		
		
		JLabel referencia = new JLabel("");
		referencia.setBounds(15,545,20,20);
		referencia.setBorder(BorderFactory.createLineBorder(Color.red));
		
		JLabel descripcion = new JLabel("Incidencias");
		descripcion.setFont(new Font("Century Gothic", Font.BOLD, 15));
		descripcion.setForeground(Color.white);
		descripcion.setBounds(50,505,100,100);
		
		panelManipular.setVisible(false);
		BotonAtras boton = new BotonAtras(true);
		this.add(boton);
		this.setBackground(new Color(32, 83, 117));
		this.setLayout(null);
		this.add(referencia);
		this.add(descripcion);
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelManipular.setVisible(true);
				desabilitarMenu();
			}
		});
		
		listaParadas = GestorParada.obtenerTodas();
		listaCaminos = GestorCamino.obtenerCaminos();
		for (DTOParada parada: listaParadas) {
		BotonNodo nuevaParada = new BotonNodo(parada, CriterioNodoCiudad.INFO);
		nodosCiudad.put(parada.getNroParada(),nuevaParada);
		this.add(nuevaParada);
		}
		
		
	}
	
	public void agregarBoton(int ubicacionInicialEnY, JPanel panel, BotonMenu boton) {
		boton.setBounds(10, ubicacionInicialEnY, 854, 40);
		panel.add(boton);
	}
	
	public void desabilitarMenu() {
		this.setVisible(false);
	}
	
	public JPanel getPanel() {
		return this;
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.black);
		
		for(DTOCamino camino : listaCaminos) {	
		
		DTOParada IDOrigen = new DTOParada();
		DTOParada IDDestino = new DTOParada();
		DTOParada origen,destino;
		
		IDOrigen.setNroParada(camino.getIdOrigen());
		IDDestino.setNroParada(camino.getIdDestino());
	
		int posO = listaParadas.indexOf(IDOrigen);
		int posD = listaParadas.indexOf(IDDestino);
		
		origen = listaParadas.get(posO);
		destino = listaParadas.get(posD);
		
		UbicacionParada U_Origen = new UbicacionParada(origen);
		UbicacionParada U_Destino = new UbicacionParada(destino);
		GestorGUI.dibujarCamino(g, U_Origen.getX(), U_Origen.getY(), U_Destino.getX(), U_Destino.getY(), Color.black);
		
		}
		
		for(DTOIncidencia incidencia : incidencias) {
			nodosCiudad.get(incidencia.getIdParada()).setBorder(BorderFactory.createLineBorder(Color.red));
		}
		
	}
	
	
}
