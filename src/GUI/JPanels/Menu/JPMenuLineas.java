package GUI.JPanels.Menu;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import GUI.Componentes.BotonAtras;
import GUI.Componentes.BotonMenu;
import GUI.JPanels.Parada.JPAgregarParada;
import GUI.JPanels.Linea.JPAgregarLinea;
import GUI.JPanels.Linea.JPEliminarLinea;
import GUI.JPanels.Linea.JPVerLineas;

public class JPMenuLineas extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JPMenuLineas(JPanel panelManipular,JPanel panelContent, JLabel lblTitulo) {
		
		panelManipular.setVisible(false);
		BotonAtras boton = new BotonAtras(true);
		this.add(boton);
		this.setBackground(new Color(32, 83, 117));
		this.setLayout(null);
		BotonMenu btnVerLineas = new BotonMenu("Ver Lineas");
		BotonMenu btnAgregarLinea = new BotonMenu("Agregar Linea");
		BotonMenu btnEliminarLinea = new BotonMenu("Eliminar Linea");
		agregarBoton(130, this,btnVerLineas);
		agregarBoton(190, this,btnAgregarLinea);
		agregarBoton(250, this,btnEliminarLinea);
		
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelManipular.setVisible(true);
				desabilitarMenu();
			}
		});
		
		
		btnVerLineas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPVerLineas panelVerLineas = new JPVerLineas(getPanel(), lblTitulo);
				panelContent.add(panelVerLineas);
				desabilitarMenu();
				lblTitulo.setText("VER LINEAS");
				panelVerLineas.setVisible(true);
			}
		});
		
		btnAgregarLinea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPAgregarLinea panelAgregarLinea = new JPAgregarLinea(getPanel(), lblTitulo);
				panelContent.add(panelAgregarLinea);
				desabilitarMenu();
				lblTitulo.setText("AGREGAR LINEA");
				panelAgregarLinea.setVisible(true);
			}
		});
		
		btnEliminarLinea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPEliminarLinea panelEliminarLinea = new JPEliminarLinea(getPanel(), lblTitulo);
				panelContent.add(panelEliminarLinea);
				desabilitarMenu();
				lblTitulo.setText("ELIMINAR LINEA");
				panelEliminarLinea.setVisible(true);
			}
		});
		
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
	
}