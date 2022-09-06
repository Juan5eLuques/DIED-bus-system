package GUI.JPanels.Menu;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import DTO.DTOCamino;
import GUI.Componentes.BotonAtras;
import GUI.Componentes.BotonMenu;
import GUI.JPanels.Trayecto.JPMostrarTrayecto;
import system.clases.DAO.CaminoDAO;

public class JPMenuTrayecto extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JPMenuTrayecto(JPanel panelManipular, JPanel panelContent, JLabel lblTitulo) {
		
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
		
		
		btnVerTrayecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPMostrarTrayecto panelVerTrayectos= new JPMostrarTrayecto(getPanel(), lblTitulo);
				panelContent.add(panelVerTrayectos);
				desabilitarMenu();
				lblTitulo.setText("VER TRAYECTOS");
				panelVerTrayectos.setVisible(true);
//				JPUnTrayecto JP = new JPUnTrayecto(panelManipular, lblTitulo,trayecto, panelContent);
//				panelContent.add(JP);
//				desabilitarMenu();
//				lblTitulo.setText("VER TRAYECTOS");
//				JP.setVisible(true);
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