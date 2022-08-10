package GUI.JPanels.Incidencia;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.toedter.calendar.JDateChooser;

import DTO.DTOIncidencia;
import GUI.Componentes.BotonAtras;
import GUI.Componentes.BotonIcono;
import GUI.Componentes.LblText;
import GUI.Componentes.TextFieldNumbers;
import GUI.Componentes.TextFieldText;
import system.gestores.GestorIncidencia;

public class JPRegistrarIncidencia extends JPanel {
	
	private Font fuente = new Font("Ebrima", Font.BOLD, 22);
	
	public JPRegistrarIncidencia(JPanel panelManipular, JLabel lblTitulo) {
		BotonAtras boton = new BotonAtras(true);
		this.add(boton);
		this.setLayout(null);
		this.setBackground(new Color(32, 83, 117));
		TextFieldNumbers TFIDIncidencia = new TextFieldNumbers();
		TextFieldNumbers TFIdParada= new TextFieldNumbers();
		JDateChooser JDfechaInicio = new JDateChooser();
		JDateChooser JDFechaFin = new JDateChooser();
		TextFieldText TFDescripcion = new TextFieldText();
		
		JDfechaInicio.setDateFormatString("yyyy/mm/dd");
		//TextFieldText TFResuleta = new TextFieldText();
		
		TFIDIncidencia.setBounds(410, 132, 300, 30);
		TFIdParada.setBounds(410, 182, 300, 30);
		JDfechaInicio.setBounds(410, 232, 300, 30);
		JDFechaFin.setBounds(410,282,300,30);
		TFDescripcion.setBounds(410,332,300,30);
		//TFResuleta.setBounds(400,322,300,30);
		
		LblText lblNroLinea = new LblText("IDIncidencia : ", fuente);
		lblNroLinea.setBounds(200, 130, 300, 30);
		
		LblText lblNombre = new LblText("IDParadaAfectada : ",fuente);
		lblNombre.setBounds(200, 180, 300, 30);
	
		LblText lblColor = new LblText("FechaInicio : ",fuente);
		lblColor.setBounds(200, 230, 300, 30);
		
		LblText lblTipo = new LblText("FechaFin : ",fuente);
		lblTipo.setBounds(200, 280, 300, 30);
		
		LblText lblPasajeros = new LblText("Descripcion : ",fuente);
		lblPasajeros.setBounds(200, 330, 300, 30);
		
		//LblText lblParados = new LblText("Resuelta: ",fuente);
		//lblParados.setBounds(200, 320, 300, 30);
		
	
		
		BotonIcono botonGuardar = new BotonIcono("iconGuardar.png");
		botonGuardar.setBounds(680,470, 100, 100);
	
		this.add(botonGuardar);
		this.add(TFIDIncidencia);
		this.add(TFIdParada);
		this.add(JDfechaInicio);
		this.add(JDFechaFin);
		this.add(TFDescripcion);
		//this.add(TFResuleta);

		this.add(lblNroLinea);
		this.add(lblNombre);
		this.add(lblColor);
		this.add(lblTipo);
		this.add(lblPasajeros);
		//this.add(lblParados);
		 
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelManipular.setVisible(true);
				deshabilitar();
				lblTitulo.setText("SISTEMA AUTOBUS");
			}
		});
		
		botonGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (TFIDIncidencia.getText().length()==0 || TFIdParada.getText().length()==0 || JDfechaInicio.getDate() == null|| JDFechaFin.getDate() == null || TFDescripcion.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Debe completar todos los campos", "Error", JOptionPane.WARNING_MESSAGE);
				}
				else {
					DTOIncidencia nuevaIncidencia = new DTOIncidencia();
					
					nuevaIncidencia.setIdIncidencia(Integer.parseInt(TFIDIncidencia.getText()));
					nuevaIncidencia.setIdParada(Integer.parseInt(TFIdParada.getText()));
					//nuevaIncidencia.setFechaInicio(JDfechaInicio.getDate());
					//nuevaIncidencia.setFechaFin(JDFechaFin.getDate());
					nuevaIncidencia.setDescripcion(TFDescripcion.getText());
					nuevaIncidencia.setEstadoActual(true);
					
					
					GestorIncidencia.registrarIncidencia(nuevaIncidencia);
					
				}
			}
		});
		
	}

	public void deshabilitar() {
		this.setVisible(false);
		}
}
