package GUI.JPanels;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import GUI.Componentes.BotonAtras;
import GUI.Componentes.BotonMenu;

public class JPMenuIncidencias extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JPMenuIncidencias(JPanel panelManipular) {
		
		panelManipular.setVisible(false);
		BotonAtras boton = new BotonAtras(true);
		this.add(boton);
		this.setBackground(new Color(32, 83, 117));
		this.setLayout(null);
		BotonMenu btnVerIncidencias = new BotonMenu("Ver Incidencias");
		BotonMenu btnRegistrarIncidencias = new BotonMenu("Registrar Incidencia");
		BotonMenu btnEliminarIncidencia = new BotonMenu("Eliminar Incidencia");
		agregarBoton(130, this,btnVerIncidencias);
		agregarBoton(190, this,btnRegistrarIncidencias);
		agregarBoton(250, this,btnEliminarIncidencia);
		
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