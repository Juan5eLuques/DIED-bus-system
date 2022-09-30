package GUI.JPanels.Menu;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import GUI.Componentes.BotonAtras;
import GUI.Componentes.BotonMenu;
import GUI.JPanels.Camino.JPCrearCamino;
import GUI.JPanels.Camino.JPEliminarCamino;
import GUI.JPanels.Camino.JPVerCaminos;
import GUI.JPanels.Linea.JPVerLineas;

public class JPMenuCamino extends JPanel{
	
	public JPMenuCamino(JPanel panelManipular,JPanel panelContent, JLabel lblTitulo) {
		
		panelManipular.setVisible(false);
		BotonAtras boton = new BotonAtras(true);
		this.add(boton);
		this.setBackground(new Color(32, 83, 117));
		this.setLayout(null);
		BotonMenu btnVerCaminos = new BotonMenu("Ver caminos");
		BotonMenu btnCrearCamino = new BotonMenu("Crear camino");
		BotonMenu btnEditarCamino = new BotonMenu("Editar camino");
		BotonMenu btnEliminarCamino = new BotonMenu("Eliminar camino");
		this.add(btnVerCaminos);
		this.add(btnCrearCamino);
		this.add(btnEditarCamino);
		this.add(btnEliminarCamino);
		
		agregarBoton(130, this,btnVerCaminos);
		agregarBoton(190, this,btnCrearCamino);
		agregarBoton(250, this,btnEditarCamino);
		agregarBoton(310, this,btnEliminarCamino);
		
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelManipular.setVisible(true);
				desabilitarMenu();
			}
		});
		
		btnVerCaminos.addActionListener(new ActionListener ( ) {
			public void actionPerformed(ActionEvent e) {
				JPVerCaminos panelVerCaminos = new JPVerCaminos(getPanel(), lblTitulo);
				panelContent.add(panelVerCaminos);
				desabilitarMenu();
				lblTitulo.setText("VER CAMINOS");
				panelVerCaminos.setVisible(true);
			}
		});
		
		btnCrearCamino.addActionListener(new ActionListener ( ) {
			public void actionPerformed(ActionEvent e) {
				JPCrearCamino panelCrearCamino = new JPCrearCamino(getPanel(), lblTitulo);
				panelContent.add(panelCrearCamino);
				desabilitarMenu();
				lblTitulo.setText("CREAR CAMINO");
				panelCrearCamino.setVisible(true);
			}
		});
		
		btnEliminarCamino.addActionListener(new ActionListener ( ) {
			public void actionPerformed(ActionEvent e) {
				JPEliminarCamino panelEliminarCamino = new JPEliminarCamino(getPanel(), lblTitulo);
				panelContent.add(panelEliminarCamino);
				desabilitarMenu();
				lblTitulo.setText("ELIMINAR CAMINO");
				panelEliminarCamino.setVisible(true);
			}
		});
		
		
	}
	
	public JPanel getPanel() {
		return this;
	}
	
	public void agregarBoton(int ubicacionInicialEnY, JPanel panel, BotonMenu boton) {
		boton.setBounds(10, ubicacionInicialEnY, 854, 40);
		panel.add(boton);
	}
	
	public void desabilitarMenu() {
		this.setVisible(false);
	}

}

