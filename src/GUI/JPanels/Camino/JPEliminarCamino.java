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

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DTO.DTOCamino;
import DTO.DTOParada;
import GUI.Componentes.BotonAtras;
import GUI.Componentes.BotonIcono;
import GUI.Componentes.BotonNodo;
import GUI.Componentes.UbicacionParada;
import enums.CriterioNodoCiudad;
import enums.EnumColor;
import system.clases.InformacionCamino;
import system.gestores.GestorBoleto;
import system.gestores.GestorCamino;
import system.gestores.GestorGUI;
import system.gestores.GestorParada;

public class JPEliminarCamino extends JPanel{
	/**
	 * 
	 */
	ArrayList<DTOParada> listaParadas;
	ArrayList<DTOCamino> listaCaminos;
	ArrayList<DTOCamino> listaPosiblesCaminos;
	DTOCamino caminoSeleccionado = new DTOCamino();
	Map <Integer, BotonNodo> nodosCiudad = new HashMap<Integer, BotonNodo>();
	BotonIcono btnCheck = new BotonIcono("iconCheck.png");
	BotonIcono botonDelete = new BotonIcono("iconDelete.png");
	DTOParada paradaSeleccionada = new DTOParada();
	
	private static final long serialVersionUID = 1L;

	public JPEliminarCamino(JPanel panelManipular, JLabel lblTitulo) {
		
			
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
		
		botonDelete.setEnabled(false);
		botonDelete.setVisible(true);
		botonDelete.setBounds(30,470,100,100);
		
		this.add(botonDelete);
		this.add(btnCheck);
		
		
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
				
				caminoSeleccionado.setIdOrigen(paradaSeleccionada.getNroParada());
				
				for (int i=0;i<listaParadas.size();i++) {
					BotonNodo btn = nodosCiudad.get(listaParadas.get(i).getNroParada());
					btn.limpiarActions();
					for(DTOCamino camino : listaPosiblesCaminos) {
						if (camino.getIdDestino()==btn.infoParada().getNroParada()) {
							listenerEliminar(btn);
						}
					}
				}
				
			}
		});
		
		botonDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestorCamino.eliminarCamino(caminoSeleccionado);
				JOptionPane.showMessageDialog(null, "Camino eliminado con exito", null, JOptionPane.INFORMATION_MESSAGE);
				listaCaminos = GestorCamino.obtenerCaminos();
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
	
public void listenerEliminar(BotonNodo parada) {
	
	MouseListener setearActionDestino = new MouseListener() {
	
		@Override
		public void mouseClicked(MouseEvent e) {
			botonDelete.setEnabled(true);
			caminoSeleccionado.setIdDestino(parada.infoParada().getNroParada());
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
			nodosCiudad.get(caminoSeleccionado.getIdOrigen()).resetColor();
			nodosCiudad.get(caminoSeleccionado.getIdDestino()).resetColor();
			listaPosiblesCaminos = new ArrayList<DTOCamino>();
			caminoSeleccionado.setIdOrigen(0);
			caminoSeleccionado.setIdDestino(0);
			btnCheck.setEnabled(false);
			botonDelete.setEnabled(false);
			for (int i=0;i<listaParadas.size();i++) {
				BotonNodo btn = nodosCiudad.get(listaParadas.get(i).getNroParada());
				btn.limpiarActions();
				listenerPosibles(btn);
			}
			repaint();
			revalidate();
		}
	

		public void deshabilitar() {
			this.setVisible(false);
			}
		
		public JPEliminarCamino getPanel() {
			return this;
		}
}
