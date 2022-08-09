package GUI.JPanels;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import GUI.Componentes.BotonAtras;
import GUI.Componentes.BotonMenu;

public class JPMenuLineas extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JPMenuLineas(JPanel panelManipular) {
		
		panelManipular.setVisible(false);
		BotonAtras boton = new BotonAtras(true);
		this.add(boton);
		this.setBackground(new Color(32, 83, 117));
		this.setLayout(null);
		BotonMenu btnVerLineas = new BotonMenu("Ver Lineas");
		BotonMenu btnAgregarLineas = new BotonMenu("Agregar Linea");
		BotonMenu btnEliminarLinea = new BotonMenu("Eliminar Linea");
		agregarBoton(130, this,btnVerLineas);
		agregarBoton(190, this,btnAgregarLineas);
		agregarBoton(250, this,btnEliminarLinea);
		
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelManipular.setVisible(true);
				desabilitarMenu();
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
	
}