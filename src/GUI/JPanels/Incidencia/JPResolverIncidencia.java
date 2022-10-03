package GUI.JPanels.Incidencia;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import DTO.DTOAutobus;
import DTO.DTOIncidencia;
import GUI.GUIDescripcionIncidencia;
import GUI.Componentes.BotonAtras;
import GUI.Componentes.BotonIcono;
import GUI.Componentes.LblText;
import GUI.Componentes.TextFieldNumbers;
import GUI.Componentes.TextFieldText;
import system.gestores.GestorAutobus;
import system.gestores.GestorIncidencia;

public class JPResolverIncidencia extends JPanel{
	
	DTOIncidencia incidencia = new DTOIncidencia();
	
	public JPResolverIncidencia(JPanel panelManipular, JLabel lblTitulo) {
		
		BotonAtras boton = new BotonAtras(true);
		BotonIcono botonSearch = new BotonIcono("iconSearch.png");
		this.add(boton);
		this.setLayout(null);
		this.setBackground(new Color(32, 83, 117));
		TextFieldNumbers TFNroIDIncidencia = new TextFieldNumbers();
		TextFieldText TFParada = new TextFieldText();
		TextFieldText TFPeriodo = new TextFieldText();
		
		TFNroIDIncidencia.setBounds(370, 150, 350, 40);
		botonSearch.setBounds(740, 145, 50, 50);
		TFParada.setBounds(370, 210, 350, 40);
		TFPeriodo.setBounds(370, 270, 350, 40);
		TFParada.setEnabled(false);
		TFPeriodo.setEnabled(false);
		
		
		LblText lblIDIncidencia = new LblText("ID Incidencia: ");
		lblIDIncidencia.setBounds(175, 148, 300, 40);
		
		LblText lblParada = new LblText("Parada afectada: ");
		lblParada.setBounds(140, 208, 300, 40);
		
		LblText lblPeriodo = new LblText("Periodo: ");
		lblPeriodo.setBounds(232, 268, 300, 40);
		
		JButton btnDescripcion = new JButton("Ver descripcion");
		btnDescripcion.setBounds(370, 350, 350, 40);
		btnDescripcion.setVisible(false);
		
		BotonIcono btnCheck = new BotonIcono("iconCheckIncidencia.png");
		btnCheck.setBounds(620,450, 100, 100);
		btnCheck.setEnabled(false);
		
		this.add(botonSearch);
		this.add(btnCheck);
		this.add(TFNroIDIncidencia);
		this.add(TFParada);
		this.add(TFPeriodo);
		this.add(lblIDIncidencia);
		this.add(lblParada);
		this.add(lblPeriodo);
		this.add(btnDescripcion);
		
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
				
				if (TFNroIDIncidencia.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Debe completar el campo de busqueda", "Error", JOptionPane.WARNING_MESSAGE);
				}
				else {
					incidencia = GestorIncidencia.obtenerIncidencia(Integer.parseInt(TFNroIDIncidencia.getText()));
					if(incidencia.getIdIncidencia()!=-1) {
						TFPeriodo.setText(incidencia.getFechaInicio().toString()+" / "+ incidencia.getFechaFin().toString());
						TFParada.setText(incidencia.getIdParada()+"");
						TFNroIDIncidencia.setText(incidencia.getIdIncidencia()+"");
						btnDescripcion.setVisible(true);
						btnCheck.setEnabled(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "La IDIncidencia ingresada no existe", "Error", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestorIncidencia.solucionarIncidencia(Integer.parseInt(TFNroIDIncidencia.getText()));
				JOptionPane.showMessageDialog(null, "Incidencia resuleta ! ", "Succes", JOptionPane.INFORMATION_MESSAGE);
				TFPeriodo.setText("");
				TFParada.setText("");
				TFNroIDIncidencia.setText("");
				btnCheck.setEnabled(false);
			}
		});
		
		btnDescripcion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIDescripcionIncidencia frameDescripcion = new GUIDescripcionIncidencia(incidencia);
				frameDescripcion.setVisible(true);
			}
		});
	}
	
	public void deshabilitar() {
		this.setVisible(false);
		}
}
