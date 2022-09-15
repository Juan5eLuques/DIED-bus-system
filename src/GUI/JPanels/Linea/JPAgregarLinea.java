package GUI.JPanels.Linea;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import DTO.DTOAutobus;
import DTO.DTOCamino;
import GUI.Componentes.BotonAtras;
import GUI.Componentes.BotonIcono;
import GUI.Componentes.LblText;
import GUI.Componentes.TextFieldNumbers;
import GUI.Componentes.TextFieldText;
import system.gestores.GestorAutobus;
import GUI.GUIGuardarTrayecto;

public class JPAgregarLinea extends JPanel implements KeyListener {
	
	TextFieldNumbers TFNroLinea = new TextFieldNumbers();
	TextFieldText TFNombre= new TextFieldText();
	TextFieldText TFColor = new TextFieldText();
	TextFieldNumbers TFPasajeros = new TextFieldNumbers();
	TextFieldNumbers TFParados = new TextFieldNumbers();
	JComboBox JCBTipo = new JComboBox(new String[] {"Economico", "Superior"});
	BotonIcono botonGuardar = new BotonIcono("iconGuardar.png");
	BotonIcono botonCamino = new BotonIcono("iconCamino.png");
	JCheckBox JCheckAire = new JCheckBox("Aire");
	JCheckBox JCheckWifi = new JCheckBox("Wifi");
	
	private ArrayList<DTOCamino> trayecto;
	
	private Font fuente = new Font("Ebrima", Font.BOLD, 20);
	
	public JPAgregarLinea(JPanel panelManipular, JLabel lblTitulo){
		
		trayecto = new ArrayList<DTOCamino>();
		
		BotonAtras boton = new BotonAtras(true);
		this.add(boton);
		this.setLayout(null);
		this.setBackground(new Color(32, 83, 117));
		
		JCheckAire.setBackground(null);
		JCheckWifi.setBackground(null);
		JCheckAire.setForeground(Color.white);
		JCheckWifi.setForeground(Color.white);
		
		
		TFNroLinea.setBounds(400, 122, 300, 30);
		TFNombre.setBounds(400, 162, 300, 30);
		TFColor.setBounds(400, 202, 300, 30);
		JCBTipo.setBounds(400, 242, 300, 30);
		TFPasajeros.setBounds(400,282,300,30);
		TFParados.setBounds(400,322,300,30);
		
		
		LblText lblNroLinea = new LblText("Numero de linea: ", fuente);
		lblNroLinea.setBounds(160, 120, 300, 30);
		
		LblText lblNombre = new LblText("Nombre: ",fuente);
		lblNombre.setBounds(200, 160, 300, 30);
	
		LblText lblColor = new LblText("Color: ",fuente);
		lblColor.setBounds(212, 200, 300, 30);
		
		LblText lblTipo = new LblText("Tipo: ",fuente);
		lblTipo.setBounds(215, 240, 300, 30);
		
		LblText lblPasajeros = new LblText("Asientos: ",fuente);
		lblPasajeros.setBounds(195, 280, 300, 30);
		
		LblText lblParados = new LblText("Parados: ",fuente);
		lblParados.setBounds(197, 320, 300, 30);
		
		LblText lblServicios = new LblText("Servicios: ",fuente);
		lblServicios.setBounds(191, 360, 300, 30);
		lblServicios.setVisible(false);
		
		JCheckWifi.setBounds(400,363,80,30);
		JCheckAire.setBounds(500,363,80,30);
		JCheckWifi.setVisible(false);
		JCheckAire.setVisible(false);
		botonGuardar.setBounds(680,470, 100, 100);
		botonGuardar.setEnabled(false);
		botonCamino.setEnabled(false);
		botonCamino.setBounds(530,470,100,100);
		
		this.add(botonCamino);
		this.add(botonGuardar);
		this.add(TFNroLinea);
		this.add(TFNombre);
		this.add(TFColor);
		this.add(JCBTipo);
		this.add(TFPasajeros);
		this.add(TFParados);
		this.add(JCheckAire);
		this.add(JCheckWifi);
		
		this.add(lblNroLinea);
		this.add(lblNombre);
		this.add(lblColor);
		this.add(lblTipo);
		this.add(lblPasajeros);
		this.add(lblParados);
		this.add(lblServicios);
		
		JCBTipo.setSelectedIndex(0);
		
		panelManipular.setVisible(false);
		
		TFNroLinea.addKeyListener(this);
		TFNombre.addKeyListener(this);
		TFColor.addKeyListener(this);
		TFParados.addKeyListener(this);
		TFPasajeros.addKeyListener(this);
		
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelManipular.setVisible(true);
				deshabilitar();
				lblTitulo.setText("SISTEMA AUTOBUS");
			}
		});
		
		JCBTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JCBTipo.getSelectedItem().toString() == "Superior") {
					JCheckWifi.setVisible(true);
					JCheckAire.setVisible(true);  
					lblServicios.setVisible(true);
					TFParados.setEnabled(false);
				}
				if(JCBTipo.getSelectedItem().toString() == "Economico") {
					JCheckWifi.setVisible(false);
					JCheckAire.setVisible(false);
					TFParados.setEnabled(true);
					lblServicios.setVisible(false);
				}
			}
		});
		
		botonGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(TFNroLinea.getText().length()==0 || TFNombre.getText().length()==0 || TFColor.getText().length()==0 || TFPasajeros.getText().length()==0 || JCBTipo.getSelectedItem() == null) {
					JOptionPane.showMessageDialog(null, "Debe completar todos los campos", "Error", JOptionPane.WARNING_MESSAGE);
				}
				else {
					DTOAutobus autobus = new DTOAutobus();
					autobus.setId(Integer.parseInt(TFNroLinea.getText()));
					autobus.setNombre(TFNombre.getText());
					autobus.setColor(TFColor.getText());
					autobus.setTipo(JCBTipo.getSelectedItem().toString());
					autobus.setAsientos(Integer.parseInt(TFPasajeros.getText()));
					if (JCBTipo.getSelectedItem().toString() == "Superior") {
						autobus.setAire(JCheckAire.isSelected());
						autobus.setWifi(JCheckWifi.isSelected());
					}
					else {
						autobus.setAire(false);
						autobus.setWifi(false);
						autobus.setPasajerosextra(Integer.parseInt(TFParados.getText()));
					}
					
					GestorAutobus.crearAutobus(autobus, trayecto);
					
				}
			}
		});
		
		
		botonCamino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIGuardarTrayecto nuevoTrayecto = new GUIGuardarTrayecto(getPanel(),botonGuardar);
				nuevoTrayecto.setVisible(true);
			}
		});
	}
	
	public void habilitarBotonCamino() {
		if (JCBTipo.getSelectedItem().toString() == "Economico") {
		if (!TFNroLinea.getText().isEmpty() && !TFNombre.getText().isEmpty() && !TFColor.getText().isEmpty() && !TFParados.getText().isEmpty()  && !TFPasajeros.getText().isEmpty()) {
			botonCamino.setEnabled(true);
			}
		else {
			botonCamino.setEnabled(false);
			}
		}
		
		if (JCBTipo.getSelectedItem().toString() == "Superior") {
			if (!TFNroLinea.getText().isEmpty() && !TFNombre.getText().isEmpty() && !TFColor.getText().isEmpty() && !TFPasajeros.getText().isEmpty()) {
				botonCamino.setEnabled(true);
				}
			else {
				botonCamino.setEnabled(false);
				}
		}
		
	}	
	
	public void setearTrayecto (ArrayList<DTOCamino> unTrayecto) {
		this.trayecto = unTrayecto;
	}
	
	public void deshabilitar() {
		this.setVisible(false);
		}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		habilitarBotonCamino();
		
	}
	
	public JPAgregarLinea getPanel() {
		return this;
	}
}
