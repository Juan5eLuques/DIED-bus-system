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
import GUI.Componentes.LblText;
import GUI.Componentes.TextFieldNumbers;
import GUI.Componentes.UbicacionParada;
import enums.EnumColor;
import system.gestores.GestorCamino;
import system.gestores.GestorGUI;
import system.gestores.GestorParada;

public class JPEditarCamino extends JPanel {
	
	Map <Integer, BotonNodo> nodosCiudad = new HashMap<Integer, BotonNodo>();
	ArrayList<DTOParada> listaParadas;
	ArrayList<DTOCamino> listaCaminos;
	ArrayList<DTOCamino> listaPosiblesCaminos;
	DTOParada paradaSeleccionada = new DTOParada();
	DTOCamino caminoSeleccionado = new DTOCamino();
	JLabel lblDistancia = new JLabel("Distancia");
	JLabel lblDuracion = new JLabel("Duración");
	TextFieldNumbers textFieldDistancia = new TextFieldNumbers();
	TextFieldNumbers textFieldDuracion = new TextFieldNumbers();
	BotonIcono botonGuardar = new BotonIcono("iconGuardar.png");
	BotonIcono botonEdit = new BotonIcono("iconEdit.png");
	BotonIcono btnCheck = new BotonIcono("iconCheck.png");
	
	public JPEditarCamino(JPanel panelManipular, JLabel lblTitulo) {
		
		Font fontLbl = new Font("Century Gothic", Font.BOLD, 15);
		
		listaParadas = GestorParada.obtenerTodas();
		listaCaminos = GestorCamino.obtenerCaminos();
		listaPosiblesCaminos = new ArrayList<DTOCamino>();
		
		for (DTOParada parada: listaParadas){
			BotonNodo nuevaParada = new BotonNodo(parada, null);
			listenerPosibles(nuevaParada);
			this.add(nuevaParada);
			nodosCiudad.put(parada.getNroParada(),nuevaParada);
			}
		
		btnCheck.setBounds(85, 35, 70, 70);
		btnCheck.setVisible(true);
		btnCheck.setEnabled(false);
		
		lblDistancia.setBounds(60,200,150,30);
		lblDistancia.setForeground(Color.white);
		lblDistancia.setFont(fontLbl);
		lblDistancia.setVisible(false);
		lblDuracion.setFont(fontLbl);
		lblDuracion.setBounds(60,300,150,30);
		lblDuracion.setForeground(Color.white);
		lblDuracion.setVisible(false);
		
		textFieldDistancia.setBounds(15,230,150,30);
		textFieldDuracion.setBounds(15,330,150,30);
		
		textFieldDistancia.setVisible(false);
		textFieldDuracion.setVisible(false);
		
		botonEdit.setEnabled(false);
		botonEdit.setVisible(true);
		botonEdit.setBounds(-10,470,100,100);
		
		this.add(botonEdit);
		this.add(btnCheck);
	
		this.add(lblDistancia);
		this.add(lblDuracion);
		this.add(textFieldDistancia);
		this.add(textFieldDuracion);
		
		BotonAtras boton = new BotonAtras(true);
		this.add(boton);
		this.setLayout(null);
		this.setBackground(new Color(32, 83, 117));
		
		botonGuardar.setBounds(87,472, 100, 100);
		botonGuardar.setEnabled(false);
		this.add(botonGuardar);
		
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelManipular.setVisible(true);
				deshabilitar();
				lblTitulo.setText("SISTEMA AUTOBUS");
			}
		});
		
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lblDistancia.setVisible(true);
				lblDuracion.setVisible(true);
				textFieldDistancia.setVisible(true);
				textFieldDuracion.setVisible(true);
				textFieldDistancia.setEnabled(false);
				textFieldDuracion.setEnabled(false);
				
				caminoSeleccionado.setIdOrigen(paradaSeleccionada.getNroParada());
				
				for (int i=0;i<listaParadas.size();i++) {
					BotonNodo btn = nodosCiudad.get(listaParadas.get(i).getNroParada());
					btn.limpiarActions();
					for(DTOCamino camino : listaPosiblesCaminos) {
						if (camino.getIdDestino()==btn.infoParada().getNroParada()) {
							listenerEditar(btn);
						}
					}
				}
				
			}
		});
		
		botonEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonGuardar.setEnabled(true);
				textFieldDuracion.setEnabled(true);
				textFieldDistancia.setEnabled(true);
			}
		});
		
		botonGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Camino modificado con exito", null, JOptionPane.INFORMATION_MESSAGE);
				caminoSeleccionado.setDuracion(Double.parseDouble(textFieldDuracion.getText()));
				caminoSeleccionado.setDistancia(Double.parseDouble(textFieldDistancia.getText()));
					GestorCamino.actualizarDatosCamino(caminoSeleccionado);
					resetPanel();
				}
			
		});
		
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
		
		}
		
		for(DTOCamino camino : listaPosiblesCaminos) {
			
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
			
			}
		
			if(caminoSeleccionado.getIdDestino()!=0) {
				
			DTOParada IDOrigen = new DTOParada();
			DTOParada IDDestino = new DTOParada();
			DTOParada origen,destino;
			
			IDOrigen.setNroParada(caminoSeleccionado.getIdOrigen());
			IDDestino.setNroParada(caminoSeleccionado.getIdDestino());
			
			int posO = listaParadas.indexOf(IDOrigen);
			int posD = listaParadas.indexOf(IDDestino);
			
			origen = listaParadas.get(posO);
			destino = listaParadas.get(posD);
			
			UbicacionParada U_Origen = new UbicacionParada(origen);
			UbicacionParada U_Destino = new UbicacionParada(destino);
			
			GestorGUI.dibujarCamino(g, U_Origen.getX(), U_Origen.getY(), U_Destino.getX(), U_Destino.getY(), Color.red);
			}
		}
	
public void listenerPosibles(BotonNodo parada) {
		
		MouseListener setearActionDestino = new MouseListener() {
		
			@Override
			public void mouseClicked(MouseEvent e) {
				if(paradaSeleccionada.getNroParada()!=0) {
					nodosCiudad.get(paradaSeleccionada.getNroParada()).setColor(EnumColor.BLACK);
				}
				nodosCiudad.get(parada.infoParada().getNroParada()).setColor(EnumColor.GREEN);
				listaPosiblesCaminos = GestorCamino.caminosQueInicianEnParada(parada.infoParada().getNroParada());
				paradaSeleccionada = parada.infoParada();
				if (!listaPosiblesCaminos.isEmpty()) btnCheck.setEnabled(true);
				else btnCheck.setEnabled(false);
				revalidate();
				repaint();
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
	
	public JPEditarCamino getPanel() {
		return this;
	}
	
	public void listenerEditar(BotonNodo parada) {
		
		MouseListener setearActionDestino = new MouseListener() {
		
			@Override
			public void mouseClicked(MouseEvent e) {
				botonEdit.setEnabled(true);
				
				caminoSeleccionado.setIdDestino(parada.infoParada().getNroParada());
				
				DTOCamino nuevoCamino = GestorCamino.obtenerCamino(caminoSeleccionado.getIdOrigen(),caminoSeleccionado.getIdDestino());
				
				caminoSeleccionado.setDistancia(nuevoCamino.getDistancia());
				caminoSeleccionado.setDuracion(nuevoCamino.getDuracion());
				
				if (nuevoCamino!=null) {
					
				textFieldDistancia.setText(nuevoCamino.getDistancia()+"");
				textFieldDuracion.setText(nuevoCamino.getDuracion()+"");
				}
				
				revalidate();
				repaint();
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
	
	public void resetPanel() {
		textFieldDistancia.setText("");
		textFieldDuracion.setText("");
		lblDistancia.setVisible(false);
		lblDuracion.setVisible(false);
		textFieldDistancia.setVisible(false);
		textFieldDuracion.setVisible(false);
		textFieldDistancia.setEnabled(false);
		textFieldDuracion.setEnabled(false);
		nodosCiudad.get(paradaSeleccionada.getNroParada()).resetColor();
		for(int i = 0 ; i<listaParadas.size();i++) {
			nodosCiudad.get(listaParadas.get(i).getNroParada());
			listenerPosibles(nodosCiudad.get(listaParadas.get(i).getNroParada()));
		}
		caminoSeleccionado = new DTOCamino();
		paradaSeleccionada = new DTOParada();
		listaPosiblesCaminos = new ArrayList<DTOCamino>();
		botonEdit.setEnabled(false);
		botonGuardar.setEnabled(false);
		revalidate();
		repaint();
		
	}
}
