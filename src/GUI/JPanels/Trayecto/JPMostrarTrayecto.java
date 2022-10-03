package GUI.JPanels.Trayecto;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import DTO.DTOCamino;
import DTO.DTOIncidencia;
import DTO.DTOParada;
import GUI.Componentes.BotonAtras;
import GUI.Componentes.BotonIcono;
import GUI.Componentes.BotonNodo;
import GUI.Componentes.UbicacionParada;
import enums.CriterioNodoCiudad;
import system.clases.DAO.AutobusDAO;
import system.gestores.GestorCamino;
import system.gestores.GestorGUI;
import system.gestores.GestorIncidencia;
import system.gestores.GestorParada;

public class JPMostrarTrayecto extends JPanel{
	
	ArrayList<DTOParada> listaParadas;
	ArrayList<DTOCamino> listaCaminos;
	ArrayList<String> lineasArray;
	ArrayList<DTOCamino> trayectoLinea = new ArrayList<DTOCamino>();
	ArrayList<DTOCamino> trayectoReemplazado = new ArrayList<DTOCamino> ();
	
	private static final long serialVersionUID = 1L;

	public JPMostrarTrayecto(JPanel panelManipular, JLabel lblTitulo) {
		
		lineasArray = AutobusDAO.obtenerNombresDeLineas();
		panelManipular.setVisible(false);
		BotonAtras boton = new BotonAtras(true);
		BotonIcono botonVerTrayecto = new BotonIcono("iconCaminoFrame.png");
		botonVerTrayecto.setBounds(60,300,50,50);
		JLabel lblHelper = new JLabel();
		lblHelper.setBounds(50,350,100,30);
		lblHelper.setForeground(Color.white);
		lblHelper.setText("Ver trayecto");
		JComboBox lineas = new JComboBox(lineasArray.toArray());
		lineas.setForeground(Color.black);
		lineas.setBounds(30,200,120,30);
		
		trayectoLinea = GestorCamino.trayectoLinea(lineas.getSelectedItem().toString());
		
		this.add(boton);
		this.setBackground(new Color(32, 83, 117));
		this.setLayout(null);
		this.add(lblHelper);
		
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelManipular.setVisible(true);
				desabilitarMenu();
			}
		});
		
		listaParadas = GestorParada.obtenerTodas();
		listaCaminos = GestorCamino.obtenerCaminos();
		for (DTOParada parada: listaParadas){
		BotonNodo nuevaParada = new BotonNodo(parada, CriterioNodoCiudad.INFO);
		this.add(nuevaParada);
		}
		
		this.add(lineas);
		this.add(botonVerTrayecto);	
		
		botonVerTrayecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			trayectoLinea = GestorCamino.trayectoLinea(lineas.getSelectedItem().toString());
			//Carga una lista de todas las incidencias activas
			ArrayList<DTOIncidencia> incidenciasActivas= GestorIncidencia.obtenerActivas();
			//Para cada incidencia, busca si forma parte del trayecto seleccionado
			//Si forma parte del trayecto, calcula un camino habilitado
			for (DTOIncidencia unaIncidencia : incidenciasActivas){
				if (GestorCamino.paradaPresente(trayectoLinea, unaIncidencia.getIdParada())){			
					ArrayList<ArrayList<DTOCamino>> caminosAuxiliares =  GestorCamino.caminoHabilitado(trayectoLinea, unaIncidencia.getIdParada());
					trayectoLinea = caminosAuxiliares.get(0);
					trayectoReemplazado = caminosAuxiliares.get(1);
				}
			}
			revalidate();
			repaint();
			}
			});
		
	}
	
	public void desabilitarMenu() {
		this.setVisible(false);
	}
	
	public JPanel getPanel() {
		return this;
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		
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
		//g.drawLine(U_Origen.getX(), U_Origen.getY(), U_Destino.getX(), U_Destino.getY());
		}
	
		
		for(DTOCamino camino : trayectoLinea) {
			
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
			
			GestorGUI.dibujarCamino(g, U_Origen.getX(), U_Origen.getY(), U_Destino.getX(), U_Destino.getY(), Color.green);
			//g.drawLine(U_Origen.getX(), U_Origen.getY(), U_Destino.getX(), U_Destino.getY());
			}
		
		
		for(DTOCamino camino : trayectoReemplazado) {
			
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
			
			GestorGUI.dibujarCamino(g, U_Origen.getX(), U_Origen.getY(), U_Destino.getX(), U_Destino.getY(), Color.red);
			//g.drawLine(U_Origen.getX(), U_Origen.getY(), U_Destino.getX(), U_Destino.getY());
			}
		
	}
	
}