package GUI.JPanels.Linea;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import DTO.DTOAutobus;
import GUI.Componentes.BotonAtras;
import GUI.Componentes.BotonIcono;
import GUI.Componentes.LblText;
import GUI.Componentes.TextFieldNumbers;
import GUI.Componentes.TextFieldText;

import system.clases.DAO.AutobusDAO;
import system.clases.DAO.CaminoDAO;
import system.clases.DAO.ParadaDAO;
import system.gestores.GestorAutobus;

public class JPEliminarLinea extends JPanel{
	
public JPEliminarLinea(JPanel panelManipular, JLabel lblTitulo){
		
		BotonAtras boton = new BotonAtras(true);
		BotonIcono botonSearch = new BotonIcono("iconSearch.png");
		this.add(boton);
		this.setLayout(null);
		this.setBackground(new Color(32, 83, 117));
		TextFieldNumbers TFNroLinea = new TextFieldNumbers();
		TextFieldText TFNombre= new TextFieldText();
		TextFieldText TFColor = new TextFieldText();
		
		TFNroLinea.setBounds(400, 190, 300, 40);
		botonSearch.setBounds(700, 185, 50, 50);
		TFNombre.setBounds(400, 250, 300, 40);
		TFColor.setBounds(400, 310, 300, 40);
		TFNombre.setEnabled(false);
		TFColor.setEnabled(false);
		
		
		LblText lblNroLinea = new LblText("Numero de linea: ");
		lblNroLinea.setBounds(100, 190, 300, 40);
		
		LblText lblNombre = new LblText("Nombre: ");
		lblNombre.setBounds(100, 250, 300, 40);
		
		LblText lblColor = new LblText("Color: ");
		lblColor.setBounds(100, 310, 300, 40);
		
		BotonIcono botonDelete = new BotonIcono("iconDelete.png");
		botonDelete.setBounds(620,400, 100, 100);
		botonDelete.setEnabled(false);
		
		this.add(botonSearch);
		this.add(botonDelete);
		this.add(TFNroLinea);
		this.add(TFNombre);
		this.add(TFColor);
		this.add(lblNroLinea);
		this.add(lblNombre);
		this.add(lblColor);
		
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
				
				if (TFNroLinea.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Debe completar el campo de busqueda", "Error", JOptionPane.WARNING_MESSAGE);
				}
				else {
					DTOAutobus autobusBuscado = AutobusDAO.obtenerDatosAutobus(Integer.parseInt(TFNroLinea.getText()));
					if(autobusBuscado != null) {
						TFNombre.setText(autobusBuscado.getNombre());
						TFColor.setText(autobusBuscado.getColor());
						botonDelete.setEnabled(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "No se encontro la linea", "Error", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		
		botonDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestorAutobus.eliminarAutobus(Integer.parseInt(TFNroLinea.getText()));
				JOptionPane.showMessageDialog(null, "Linea eliminada", "Succes", JOptionPane.INFORMATION_MESSAGE);
				TFColor.setText("");
				TFNombre.setText("");
				TFNroLinea.setText("");
				botonDelete.setEnabled(false);
			}
		});
		
		
	}
	
	public void deshabilitar() {
		this.setVisible(false);
		}
}
