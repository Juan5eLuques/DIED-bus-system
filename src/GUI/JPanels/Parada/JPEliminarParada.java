package GUI.JPanels.Parada;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import DTO.DTOParada;
import GUI.Componentes.BotonAtras;
import GUI.Componentes.BotonIcono;
import GUI.Componentes.LblText;
import GUI.Componentes.TextFieldNumbers;
import GUI.Componentes.TextFieldText;
import system.clases.Parada;
import system.clases.DAO.CaminoDAO;
import system.gestores.GestorParada;

public class JPEliminarParada extends JPanel{
	
public JPEliminarParada(JPanel panelManipular, JLabel lblTitulo){
		
		BotonAtras boton = new BotonAtras(true);
		BotonIcono botonSearch = new BotonIcono("iconSearch.png");
		this.add(boton);
		this.setLayout(null);
		this.setBackground(new Color(32, 83, 117));
		TextFieldNumbers TFNroParada = new TextFieldNumbers();
		TextFieldText TFCalle = new TextFieldText();
		TextFieldNumbers TFNroCalle = new TextFieldNumbers();
		
		TFNroParada.setBounds(400, 190, 300, 40);
		botonSearch.setBounds(700, 185, 50, 50);
		TFCalle.setBounds(400, 250, 300, 40);
		TFNroCalle.setBounds(400, 310, 300, 40);
		TFCalle.setEnabled(false);
		TFNroCalle.setEnabled(false);
		
		
		LblText lblNroParada = new LblText("Numero de parada: ");
		lblNroParada.setBounds(100, 190, 300, 40);
		
		LblText lblCalle = new LblText("Calle: ");
		lblCalle.setBounds(100, 250, 300, 40);
		
		LblText lblNumero = new LblText("Numero de calle: ");
		lblNumero.setBounds(100, 310, 300, 40);
		
		BotonIcono botonDelete = new BotonIcono("iconDelete.png");
		botonDelete.setBounds(620,400, 100, 100);
		botonDelete.setEnabled(false);
		
		this.add(botonSearch);
		this.add(botonDelete);
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
		
		botonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (TFNroParada.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Debe completar el campo de busqueda", "Error", JOptionPane.WARNING_MESSAGE);
				}
				else {
				Parada paradaBuscada = GestorParada.obtenerParada(Integer.parseInt(TFNroParada.getText()));
				if (paradaBuscada.getNroParada() == -1) {
					JOptionPane.showMessageDialog(null, "Parada no encontrada", "Error", JOptionPane.WARNING_MESSAGE);
				}
				else {
					TFNroCalle.setText(Integer.toString(paradaBuscada.getNroCalle()));
					TFCalle.setText(paradaBuscada.getCalle());
					botonDelete.setEnabled(true);
					}
				}
			}
		});
		
		botonDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CaminoDAO.eliminarCaminosConParada(Integer.parseInt(TFNroParada.getText()));
				GestorParada.eliminarParada(Integer.parseInt(TFNroParada.getText()));
				JOptionPane.showMessageDialog(null, "Parada eliminada", "Succes", JOptionPane.INFORMATION_MESSAGE);
				TFNroCalle.setText("");
				TFCalle.setText("");
				TFNroParada.setText("");
				botonDelete.setEnabled(false);
			}
		});
		
		
	}
	
	public void deshabilitar() {
		this.setVisible(false);
		}
}
