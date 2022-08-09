package GUI.JPanels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import GUI.Componentes.BotonAtras;
import GUI.Componentes.BotonMenu;

public class JPMenuParada extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JPMenuParada(JPanel panelManipular,JPanel panelContent, JLabel lblTitulo) {
		
		panelManipular.setVisible(false);
		BotonAtras boton = new BotonAtras(true);
		this.add(boton);
		this.setBackground(new Color(32, 83, 117));
		this.setLayout(null);
		BotonMenu btnAgregarParada = new BotonMenu("Agregar Parada");
		BotonMenu btnverParadas = new BotonMenu("Ver Paradas");
		BotonMenu btnbuscarParadas = new BotonMenu("Buscar Paradas");
		BotonMenu btnEliminarParadas = new BotonMenu("Eliminar Paradas");
		
		agregarBoton(130, this,btnverParadas);
		agregarBoton(190, this,btnAgregarParada);
		agregarBoton(250, this,btnbuscarParadas);
		agregarBoton(310, this,btnEliminarParadas);
		
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelManipular.setVisible(true);
				desabilitarMenu();
			}
		});
		
		btnAgregarParada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desabilitarMenu();
				lblTitulo.setText("AGREGAR PARADA");
				JPAgregarParada panelAgregarParada = new JPAgregarParada(getPanel(), lblTitulo);
				panelContent.add(panelAgregarParada);
				panelAgregarParada.setVisible(true);
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