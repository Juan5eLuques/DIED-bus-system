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
		BotonMenu btnVerParadas = new BotonMenu("Ver Paradas");
		BotonMenu btnbuscarParada = new BotonMenu("Buscar Parada");
		BotonMenu btnEliminarParada = new BotonMenu("Eliminar Paradas");
		
		agregarBoton(130, this,btnVerParadas);
		agregarBoton(190, this,btnAgregarParada);
		agregarBoton(250, this,btnbuscarParada);
		agregarBoton(310, this,btnEliminarParada);
		
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelManipular.setVisible(true);
				desabilitarMenu();
			}
		});
		
		btnAgregarParada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPAgregarParada panelAgregarParada = new JPAgregarParada(getPanel(), lblTitulo);
				panelContent.add(panelAgregarParada);
				desabilitarMenu();
				lblTitulo.setText("AGREGAR PARADA");
				panelAgregarParada.setVisible(true);
			}
		});
		
		
		btnVerParadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPVerParadas panelVer = new JPVerParadas(getPanel(), lblTitulo);
				panelContent.add(panelVer);
				desabilitarMenu();
				lblTitulo.setText("LISTADO PARADAS");
				panelVer.setVisible(true);
			}
		});
		
		btnEliminarParada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPEliminarParada panelEliminarParada = new JPEliminarParada(getPanel(), lblTitulo);
				panelContent.add(panelEliminarParada);
				desabilitarMenu();
				lblTitulo.setText("ELIMINAR PARADA");
				panelEliminarParada.setVisible(true);
			}
		});
		
		btnbuscarParada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPBuscarParada panelBuscar = new JPBuscarParada(getPanel(), lblTitulo);
				panelContent.add(panelBuscar);
				desabilitarMenu();
				lblTitulo.setText("BUSCAR PARADA");
				panelBuscar.setVisible(true);
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