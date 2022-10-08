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
import system.gestores.GestorParada;

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
		
		JDfechaInicio.setDateFormatString("dd-MM-yyyy");
		JDFechaFin.setDateFormatString("dd-MM-yyyy");
		
		TFIDIncidencia.setBounds(410, 132, 300, 30);
		TFIdParada.setBounds(410, 182, 300, 30);
		JDfechaInicio.setBounds(410, 232, 300, 30);
		JDFechaFin.setBounds(410,282,300,30);
		TFDescripcion.setBounds(410,332,300,30);
		
		LblText lblIDIncidencia = new LblText("IDIncidencia : ", fuente);
		lblIDIncidencia.setBounds(190, 130, 300, 30);
		
		LblText lblIDParada = new LblText("IDParadaAfectada : ",fuente);
		lblIDParada.setBounds(158, 180, 300, 30);
	
		LblText lblIncio= new LblText("FechaInicio : ",fuente);
		lblIncio.setBounds(194, 230, 300, 30);
		
		LblText lblFinal = new LblText("FechaFin : ",fuente);
		lblFinal.setBounds(207, 280, 300, 30);
		
		LblText lblDescripcion = new LblText("Descripcion : ",fuente);
		lblDescripcion.setBounds(190, 330, 300, 30);
		
		
		BotonIcono botonGuardar = new BotonIcono("iconGuardar.png");
		botonGuardar.setBounds(680,470, 100, 100);
	
		this.add(botonGuardar);
		this.add(TFIDIncidencia);
		this.add(TFIdParada);
		this.add(JDfechaInicio);
		this.add(JDFechaFin);
		this.add(TFDescripcion);

		this.add(lblIDIncidencia);
		this.add(lblIDParada);
		this.add(lblIncio);
		this.add(lblFinal);
		this.add(lblDescripcion);
		 
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
					
					if (JDfechaInicio.getDate().before(JDFechaFin.getDate())) {
					
					DTOIncidencia nuevaIncidencia = new DTOIncidencia();
					
					nuevaIncidencia.setIdIncidencia(Integer.parseInt(TFIDIncidencia.getText()));
					nuevaIncidencia.setIdParada(Integer.parseInt(TFIdParada.getText()));
					nuevaIncidencia.setFechaInicio(JDfechaInicio.getDate());
					nuevaIncidencia.setFechaFin(JDFechaFin.getDate());
					nuevaIncidencia.setDescripcion(TFDescripcion.getText());
					nuevaIncidencia.setResuelta(false);			
					
					GestorIncidencia.registrarIncidencia(nuevaIncidencia);
					GestorParada.cambiarEstadoParada(nuevaIncidencia.getIdParada(), false);
					JOptionPane.showMessageDialog(null, "Incidencia registrada con éxito", null, JOptionPane.INFORMATION_MESSAGE);
					if ( nuevaIncidencia.getFechaFin().before(new Date(System.currentTimeMillis()))) GestorIncidencia.actualizarIncidencias();
					}
					else {
						JOptionPane.showMessageDialog(null, "La fecha incio debe ser anterior a la fecha fin", "Error", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		
	}

	public void deshabilitar() {
		this.setVisible(false);
		}
}
