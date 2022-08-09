package GUI.JPanels;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import GUI.Componentes.BotonAtras;
import GUI.Componentes.BotonMenu;

public class JPMenuTrayecto extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JPMenuTrayecto(JPanel panelManipular) {
		
		panelManipular.setVisible(false);
		BotonAtras boton = new BotonAtras(true);
		this.add(boton);
		this.setBackground(new Color(32, 83, 117));
		this.setLayout(null);
		BotonMenu btnVerTrayecto = new BotonMenu("Ver Trayecto");
		BotonMenu btnVerTodosLosTrayectos = new BotonMenu("Ver Todos Los Trayectos");
		BotonMenu btnEliminarTrayecto = new BotonMenu("Eliminar Trayecto");
		agregarBoton(130, this,btnVerTrayecto);
		agregarBoton(190, this,btnVerTodosLosTrayectos);
		agregarBoton(250, this,btnEliminarTrayecto);
		
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