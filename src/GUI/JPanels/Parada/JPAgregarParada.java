package GUI.JPanels.Parada;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DTO.DTOParada;
import GUI.Componentes.BotonAtras;
import GUI.Componentes.BotonIcono;
import GUI.Componentes.LblText;
import GUI.Componentes.TextFieldNumbers;
import GUI.Componentes.TextFieldText;
import system.gestores.GestorParada;

public class JPAgregarParada extends JPanel {
	
	
	
	public JPAgregarParada(JPanel panelManipular, JLabel lblTitulo){
		
		BotonAtras boton = new BotonAtras(true);
		this.add(boton);
		this.setLayout(null);
		this.setBackground(new Color(32, 83, 117));
		TextFieldNumbers TFNroParada = new TextFieldNumbers();
		TextFieldText TFCalle = new TextFieldText();
		TextFieldNumbers TFNroCalle = new TextFieldNumbers();
			
		TFNroParada.setBounds(400, 190, 300, 40);
		TFCalle.setBounds(400, 250, 300, 40);
		TFNroCalle.setBounds(400, 310, 300, 40);
		
		LblText lblNroParada = new LblText("Numero de parada: ");
		lblNroParada.setBounds(100, 190, 300, 40);
		
		LblText lblCalle = new LblText("Calle: ");
		lblCalle.setBounds(100, 250, 300, 40);
		
		LblText lblNumero = new LblText("Numero: ");
		lblNumero.setBounds(100, 310, 300, 40);
		
		BotonIcono botonGuardar = new BotonIcono("iconGuardar.png");
		botonGuardar.setBounds(620,400, 100, 100);
		
		this.add(botonGuardar);
		this.add(TFNroParada);
		this.add(TFCalle);
		this.add(TFNroCalle);
		this.add(lblNroParada);
		this.add(lblCalle);
		this.add(lblNumero);
		
		panelManipular.setVisible(false);
		
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelManipular.setVisible(true);
				deshabilitar();
				lblTitulo.setText("SISTEMA AUTOBUS");
			}
		});
		
		
		
		botonGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(TFNroParada.getText().length()==0 || TFNroCalle.getText().length()==0 || TFCalle.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Debe completar todos los campos", "Error", JOptionPane.WARNING_MESSAGE);
				}
				
				else {
				
				DTOParada nuevaParada = new DTOParada();
				nuevaParada.setNroParada(Integer.parseInt(TFNroParada.getText()));
				nuevaParada.setCalle(TFCalle.getText());
				nuevaParada.setNroCalle(Integer.parseInt(TFNroCalle.getText()));
				
				if(GestorParada.paradaExiste(nuevaParada.getNroParada())==true) {
				JOptionPane.showMessageDialog(null, "El n�mero de parada ingresado ya existe", "Error", JOptionPane.WARNING_MESSAGE);
				}
				else {
					GestorParada.agregarParada(nuevaParada); 
					JOptionPane.showMessageDialog(null, "Nueva parada registrada", "Exito", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
	}
	
	public void deshabilitar() {
		this.setVisible(false);
		}
}
