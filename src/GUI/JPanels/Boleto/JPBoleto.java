package GUI.JPanels.Boleto;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import GUI.Componentes.BotonAtras;
import GUI.Componentes.BotonIcono;
import GUI.Componentes.LblText;
import GUI.Componentes.TextFieldNumbers;

public class JPBoleto extends JPanel {
	
	public JPBoleto(JPanel panelCentral,JPanel panelManipular, JLabel lblTitulo, BotonIcono botonBoleto) {
	
	panelCentral.setVisible(false);
	lblTitulo.setText("Compra de boleto");
		
	String[] opciones = new String[] {};
	
	BotonAtras boton = new BotonAtras(true);
	
	this.add(boton);
	this.setLayout(null);
	this.setBackground(new Color(32, 83, 117));
	TextFieldNumbers TFidParadaOrigen = new TextFieldNumbers();
	JComboBox JCidParadaDestino = new JComboBox(opciones);
	BotonIcono botonComprar = new BotonIcono("iconComprar.png");
	LblText lblCosto = new LblText("");
	lblCosto.setVisible(false);
	
	
	LblText lblParadaOrigen = new LblText("ParadaOrigen: ");
	lblParadaOrigen.setBounds(100, 200, 200, 40);
	LblText lblParadaDestino = new LblText("ParadaDestino: ");
	lblParadaDestino.setBounds(100, 250, 200, 40);
	
	botonComprar.setBounds(700,455,100,100);
	
	TFidParadaOrigen.setBounds(400,200,300,40);
	JCidParadaDestino.setBounds(400,250,300,40);
	
	this.add(JCidParadaDestino);
	this.add(TFidParadaOrigen);
	this.add(lblParadaDestino);
	this.add(lblParadaOrigen);
	this.add(botonComprar);
	
	boton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			panelManipular.setVisible(true);
			deshabilitar();
			lblTitulo.setText("SISTEMA AUTOBUS");
			panelCentral.setVisible(true);
			botonBoleto.setVisible(true);
		}
	});
	
	boton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			panelManipular.setVisible(true);
			deshabilitar();
			lblTitulo.setText("SISTEMA AUTOBUS");
			panelCentral.setVisible(true);
		}
	});
	
	}
	public void deshabilitar() {
		this.setVisible(false);
		}
}
