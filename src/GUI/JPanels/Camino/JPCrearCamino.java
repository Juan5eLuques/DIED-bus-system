package GUI.JPanels.Camino;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import DTO.DTOCamino;
import DTO.DTOParada;
import GUI.Componentes.BotonAtras;
import GUI.Componentes.BotonIcono;
import GUI.Componentes.BotonNodo;
import GUI.Componentes.TextFieldNumbers;
import GUI.Componentes.UbicacionParada;
import system.gestores.GestorCamino;
import system.gestores.GestorGUI;
import system.gestores.GestorParada;


public class JPCrearCamino extends JPanel{
	
	Map <Integer, BotonNodo> nodosCiudad = new HashMap<Integer, BotonNodo>();
	ArrayList<DTOParada> listaParadas;
	ArrayList<DTOCamino> listaCaminos;
	DTOCamino nuevoCamino;
	boolean setOrigen = false;
	BotonIcono btnCheck = new BotonIcono("iconCheck.png");
	BotonIcono botonGuardar = new BotonIcono("iconGuardar.png");
	JLabel lblDistancia = new JLabel("Distancia");
	JLabel lblDuracion = new JLabel("Duración");
	TextFieldNumbers textFieldDistancia = new TextFieldNumbers();
	TextFieldNumbers textFieldDuracion = new TextFieldNumbers();
	
	public JPCrearCamino(JPanel panelManipular, JLabel lblTitulo) {
		
		Font fontLbl = new Font("Century Gothic", Font.BOLD, 15);
		
		nuevoCamino = new DTOCamino();
		
		lblTitulo.setText("CREAR CAMINO");
		this.setBackground(new Color(32, 83, 117));
		this.setLayout(null);
	
		listaParadas = GestorParada.obtenerTodas();
		listaCaminos = GestorCamino.obtenerCaminos();
		
		lblDistancia.setBounds(60,200,150,30);
		lblDistancia.setForeground(Color.white);
		lblDistancia.setFont(fontLbl);
		lblDistancia.setVisible(false);
		lblDuracion.setFont(fontLbl);
		lblDuracion.setBounds(60,300,150,30);
		lblDuracion.setForeground(Color.white);
		lblDuracion.setVisible(false);
		
		btnCheck.setBounds(85, 35, 70, 70);
		btnCheck.setVisible(true);
		btnCheck.setEnabled(false);
		
		botonGuardar.setBounds(45,470, 100, 100);
		botonGuardar.setEnabled(false);
		
		textFieldDistancia.setBounds(15,230,150,30);
		textFieldDuracion.setBounds(15,330,150,30);
		
		textFieldDistancia.setVisible(false);
		textFieldDuracion.setVisible(false);
		
		this.add(btnCheck);
		this.add(botonGuardar);
		this.add(lblDistancia);
		this.add(lblDuracion);
		this.add(textFieldDistancia);
		this.add(textFieldDuracion);
		
		for (DTOParada parada: listaParadas){
			
			BotonNodo nuevaParada = new BotonNodo(parada, null);
			listenerOrigen(nuevaParada, nuevoCamino);
			this.add(nuevaParada);
			nodosCiudad.put(parada.getNroParada(),nuevaParada);
		}
		
		BotonAtras boton = new BotonAtras(true);
		this.add(boton);
		this.setLayout(null);
		this.setBackground(new Color(32, 83, 117));
		
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelManipular.setVisible(true);
				deshabilitar();
				lblTitulo.setText("SISTEMA AUTOBUS");
			}
		});
		
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setOrigen = true;
			}
		});
		
		botonGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(listaCaminos.contains(nuevoCamino)) {
					 JOptionPane.showMessageDialog(null, "El camino ya existe",null, JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					lblDistancia.setVisible(false);
					lblDuracion.setVisible(false);
					textFieldDistancia.setVisible(false);
					textFieldDuracion.setVisible(false);
					nuevoCamino.setDistancia(Integer.parseInt(textFieldDistancia.getText()));
					nuevoCamino.setDuracion(Integer.parseInt(textFieldDuracion.getText()));
					GestorCamino.guardarCamino(nuevoCamino);
					JOptionPane.showMessageDialog(null, "Camino guardado con exito ! ",null, JOptionPane.INFORMATION_MESSAGE);
					listaParadas = GestorParada.obtenerTodas();
					listaCaminos = GestorCamino.obtenerCaminos();
					resetPanel();
				}
			}
		});
		
	}
	
	
	@Override
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
		
			}
		
			if (nuevoCamino.getIdDestino() != 0) {
				
				g.setColor(Color.green);
				
				DTOParada IDOrigen = new DTOParada();
				DTOParada IDDestino = new DTOParada();
				DTOParada origen,destino;
				
				IDOrigen.setNroParada(nuevoCamino.getIdOrigen());
				IDDestino.setNroParada(nuevoCamino.getIdDestino());
			
				int posO = listaParadas.indexOf(IDOrigen);
				int posD = listaParadas.indexOf(IDDestino);
				
				origen = listaParadas.get(posO);
				destino = listaParadas.get(posD);
				
				UbicacionParada U_Origen = new UbicacionParada(origen);
				UbicacionParada U_Destino = new UbicacionParada(destino);
				
				GestorGUI.dibujarCamino(g, U_Origen.getX(), U_Origen.getY(), U_Destino.getX(), U_Destino.getY(), Color.green);
			}
	}

	public void listenerOrigen(BotonNodo parada, DTOCamino nuevo) {
		
			MouseListener setearActionDestino = new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {
					if (setOrigen == false) {
						if (nuevo.getIdOrigen()!=0) {
							nodosCiudad.get(nuevo.getIdOrigen()).resetColor();
						}
					nuevo.setIdOrigen(parada.infoParada().getNroParada());
					parada.setBorder((BorderFactory.createLineBorder(Color.green)));
					btnCheck.setEnabled(true);
					}
					else {
						
						textFieldDistancia.setVisible(true);
						textFieldDuracion.setVisible(true);
						lblDistancia.setVisible(true);
						lblDuracion.setVisible(true);
						
						if (nuevo.getIdDestino()!=0) {
						nodosCiudad.get(nuevo.getIdDestino()).resetColor();
						}
						nuevo.setIdDestino(parada.infoParada().getNroParada());
						parada.setBorder((BorderFactory.createLineBorder(Color.green)));
						revalidate();
						repaint();
						botonGuardar.setEnabled(true);
					}
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
	
			};
			
			parada.addMouseListener(setearActionDestino);
			
	}

	
	
	public void deshabilitar() {
		this.setVisible(false);
		}
	
	public JPCrearCamino getPanel() {
		return this;
	}
	
	public void resetColorNodo() {
		if (nuevoCamino.getIdOrigen()!=0) {
			nodosCiudad.get(nuevoCamino.getIdOrigen()).resetColor();
			}
	}
	
	public void resetPanel() {
		nodosCiudad.get(nuevoCamino.getIdOrigen()).setBorder(BorderFactory.createLineBorder(Color.black));
		nodosCiudad.get(nuevoCamino.getIdDestino()).setBorder(BorderFactory.createLineBorder(Color.black));
		textFieldDistancia.setText("");
		textFieldDuracion.setText("");
		nuevoCamino.setIdDestino(0);
		nuevoCamino.setIdOrigen(0);
		this.setOrigen = false;
		botonGuardar.setEnabled(false);
		btnCheck.setEnabled(false);
		repaint();
		revalidate();
		
		
	}
	
}
