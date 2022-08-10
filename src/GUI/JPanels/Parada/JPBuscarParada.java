package GUI.JPanels.Parada;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import GUI.Componentes.BotonAtras;
import GUI.Componentes.BotonIcono;
import GUI.Componentes.LblText;
import GUI.Componentes.TextFieldNumbers;
import GUI.Componentes.TextFieldText;
import system.clases.Parada;
import system.clases.DAO.ParadaDAO;
import system.gestores.GestorParada;

public class JPBuscarParada extends JPanel{
	
	public JPBuscarParada(JPanel panelManipular, JLabel lblTitulo) {
		
		String[] opciones = new String[] {"Activa","No activa"};
		
		BotonAtras boton = new BotonAtras(true);
		BotonIcono botonSearch = new BotonIcono("iconSearch.png");
		BotonIcono botonEdit = new BotonIcono("iconEdit.png");
		
		this.add(boton);
		this.setLayout(null);
		this.setBackground(new Color(32, 83, 117));
		TextFieldNumbers TFNroParada = new TextFieldNumbers();
		TextFieldText TFCalle = new TextFieldText();
		TextFieldNumbers TFNroCalle = new TextFieldNumbers();
		JComboBox botonActiva = new JComboBox(opciones);
		botonActiva.setEnabled(false);
		botonActiva.setSelectedIndex(-1); 
		
		
		TFNroParada.setBounds(400, 130, 300, 40);
		TFCalle.setBounds(400, 190, 300, 40);
		TFNroCalle.setBounds(400, 250, 300, 40);
		botonActiva.setBounds(400, 310, 300, 40);
		TFCalle.setEnabled(false);
		TFNroCalle.setEnabled(false);
		botonEdit.setEnabled(false);
		botonSearch.setBounds(700, 125, 50, 50);
		botonEdit.setBounds(80,400, 100, 100);
		
		
		LblText lblNroParada = new LblText("Numero de parada: ");
		lblNroParada.setBounds(100, 130, 300, 40);
		
		LblText lblCalle = new LblText("Calle: ");
		lblCalle.setBounds(100, 190, 300, 40);
		
		LblText lblNumero = new LblText("Numero: ");
		lblNumero.setBounds(100, 250, 300, 40);
		
		LblText lblEstado = new LblText ("Estado: ");
		lblEstado.setBounds(100, 310, 300, 40);
		
		BotonIcono botonGuardar = new BotonIcono("iconGuardar.png");
		botonGuardar.setBounds(620,400, 100, 100);
		botonGuardar.setEnabled(false);
		
		this.add(botonSearch);
		this.add(TFNroParada);
		this.add(TFCalle);
		this.add(TFNroCalle);
		this.add(lblNroParada);
		this.add(lblCalle);
		this.add(lblNumero);
		this.add(botonEdit);
		this.add(botonGuardar);
		this.add(botonActiva);
		this.add(lblEstado);
		
		panelManipular.setVisible(false);
		
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelManipular.setVisible(true);
				deshabilitar();
				lblTitulo.setText("SISTEMA AUTOBUS");
			}
		});
		
		botonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (TFNroParada.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Debe completar el campo de busqueda", "Error", JOptionPane.WARNING_MESSAGE);
				}
				else {
				Parada paradaBuscada = ParadaDAO.obtenerParada(Integer.parseInt(TFNroParada.getText()));
				if (paradaBuscada.getNroParada() == -1) {
					JOptionPane.showMessageDialog(null, "Parada no encontrada", "Error", JOptionPane.WARNING_MESSAGE);
				}
				else {
					TFNroCalle.setText(Integer.toString(paradaBuscada.getNroCalle()));
					TFCalle.setText(paradaBuscada.getCalle());
					if(paradaBuscada.getActiva()) {
						botonActiva.setSelectedIndex(0);
					}
					else {
						botonActiva.setSelectedIndex(1);	
					}
					botonEdit.setEnabled(true);
					}
				}
			}
		});
		
		botonEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonGuardar.setEnabled(true);
				TFCalle.setEnabled(true);
				TFNroCalle.setEnabled(true);
				botonActiva.setEnabled(true);
			}
		});
		
		botonGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(TFNroParada.getText().length()==0 || TFNroCalle.getText().length()==0 || TFCalle.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Debe completar todos los campos", "Error", JOptionPane.WARNING_MESSAGE);
				}
				
				else {
				
				int nroParada =Integer.parseInt(TFNroParada.getText());
				String calle = TFCalle.getText();
				int nroCalle = (Integer.parseInt(TFNroCalle.getText()));
				String activa = botonActiva.getSelectedItem().toString();
				
				if (activa == "Activa") {
					GestorParada.actualizarParada(nroParada, calle, nroCalle, true);
				}
				else {
					GestorParada.actualizarParada(nroParada, calle, nroCalle, false);
				}
				
				JOptionPane.showMessageDialog(null, "Datos actualizados", "Succes", JOptionPane.INFORMATION_MESSAGE);
				
				
				
				
				TFCalle.setEnabled(false);
				TFNroCalle.setEnabled(false);
				botonActiva.setEnabled(false);
				botonGuardar.setEnabled(false);
				botonEdit.setEnabled(false);
				
				botonActiva.setSelectedIndex(-1); 
				TFCalle.setText("");
				TFNroCalle.setText("");
				TFNroParada.setText("");
				
				}
			}
		});
		
	}
	
	public void deshabilitar() {
		this.setVisible(false);
		}
	
}
