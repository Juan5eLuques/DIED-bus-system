package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import DTO.DTOAutobus;
import DTO.DTOCamino;
import system.gestores.GestorAutobus;
import system.gestores.GestorGUI;

import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class GUIAltaIncidencia extends JFrame {

	private JPanel contentPane;
	private JPanel panelDeControl;
	private JPanel panelGrafo;
	private JComboBox comboTipo;
	private JTextField TFNombreLinea;
	private JTextField TFColor;
	private JTextField TFCapacidad;
	JRadioButton rdbtnAire;
	JRadioButton rdbtnWifi;
	private JTextField TFPasajerosExtra;
	private JLabel lblPasajerosExtra;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIAltaLinea frame = new GUIAltaLinea(null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUIAltaIncidencia( DTOAutobus DatosLinea, ArrayList<DTOCamino> listaCaminos) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		GridBagLayout gbl_panelDeControl = new GridBagLayout();
		gbl_panelDeControl.columnWidths = new int[]{149, 0, 0, 0, 0, 0, 24, 158, 0, 0, 0, 0, 0, 0, 0, 0, 235, 0};
		gbl_panelDeControl.rowHeights = new int[]{20, 0};
		gbl_panelDeControl.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelDeControl.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		
		
		////PANEL SUPERIOR////
		JPanel panelDeControl = new JPanel();
		panelDeControl.setLayout(gbl_panelDeControl);
		panelDeControl.setBackground(SystemColor.activeCaption);
		contentPane.add(panelDeControl, BorderLayout.NORTH);
		
		JLabel lblTitulo = new JLabel("CREAR LINEA");
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.gridwidth = 3;
		gbc_lblTitulo.anchor = GridBagConstraints.NORTH;
		gbc_lblTitulo.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblTitulo.insets = new Insets(0, 0, 0, 5);
		gbc_lblTitulo.gridx = 0;
		gbc_lblTitulo.gridy = 0;
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 22));
		lblTitulo.setBounds(10, 14, 86, 14);
		panelDeControl.add(lblTitulo, gbc_lblTitulo);
		
		////PANEL CUERPO////
		JPanel panelGrafo = new JPanel();
		panelGrafo.setBackground(new Color(70, 130, 180));
		contentPane.add(panelGrafo, BorderLayout.CENTER);
		panelGrafo.setLayout(null);
		
		TFNombreLinea = new JTextField();
		TFNombreLinea.setBounds(30, 45, 86, 20);
		panelGrafo.add(TFNombreLinea);
		TFNombreLinea.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(126, 48, 46, 14);
		panelGrafo.add(lblNombre);
		
		TFColor = new JTextField();
		TFColor.setBounds(30, 76, 86, 20);
		panelGrafo.add(TFColor);
		TFColor.setColumns(10);
		
		JLabel lvlColor = new JLabel("Color");
		lvlColor.setBounds(126, 79, 46, 14);
		panelGrafo.add(lvlColor);
		
		TFCapacidad = new JTextField();
		TFCapacidad.setToolTipText("");
		TFCapacidad.setBounds(30, 107, 86, 20);
		panelGrafo.add(TFCapacidad);
		TFCapacidad.setColumns(10);
		
		JLabel lvlCapacidad = new JLabel("Capacidad");
		lvlCapacidad.setBounds(126, 110, 63, 14);
		panelGrafo.add(lvlCapacidad);
		
		ActionListener actionSeleccionar = e ->{
			actualizarSegunCombo();
		};
		
		comboTipo = new JComboBox();
		comboTipo.addActionListener(actionSeleccionar);
		comboTipo.setModel(new DefaultComboBoxModel(new String[] {"Tipo", "Superior", "Economico"}));
		comboTipo.setBounds(30, 138, 86, 22);
		panelGrafo.add(comboTipo);
		
		JLabel lblTipo = new JLabel("Tipo de servicio");
		lblTipo.setBounds(126, 142, 86, 14);
		panelGrafo.add(lblTipo);
		
		rdbtnAire = new JRadioButton("Aire Acondicionado");
		rdbtnAire.setBounds(30, 178, 124, 23);
		rdbtnAire.setVisible(false);
		panelGrafo.add(rdbtnAire);
		
		rdbtnWifi = new JRadioButton("Wifi");
		rdbtnWifi.setBounds(30, 204, 124, 23);
		rdbtnWifi.setVisible(false);
		panelGrafo.add(rdbtnWifi);
		
		ActionListener actionAgregarRecorrido = e ->{
			DTOAutobus datos = generarDatosLinea ();
			GestorGUI.GUIAltaTrayecto(datos);
			
		};
		
		JButton btnCargarRecorrido = new JButton("Cargar Recorrido");
		btnCargarRecorrido.addActionListener(actionAgregarRecorrido);
		btnCargarRecorrido.setBounds(433, 44, 115, 23);
		panelGrafo.add(btnCargarRecorrido);
		
		ActionListener actionCrearLinea = e ->{ // IMPORTANTE COMPLETAR
			GestorAutobus.crearAutobus(DatosLinea, listaCaminos);
			
		};
		
		JButton btnCrearLinea = new JButton("CrearLinea");
		btnCrearLinea.addActionListener(actionCrearLinea);
		btnCrearLinea.setBounds(719, 546, 89, 23);
		btnCrearLinea.setEnabled(false);
		panelGrafo.add(btnCrearLinea);
		
		TFPasajerosExtra = new JTextField();
		TFPasajerosExtra.setBounds(30, 179, 124, 20);
		TFPasajerosExtra.setVisible(false);
		panelGrafo.add(TFPasajerosExtra);
		
		TFPasajerosExtra.setColumns(10);
		
		lblPasajerosExtra = new JLabel("Porcentaje de pasajeros extra");
		lblPasajerosExtra.setBounds(166, 182, 155, 14);
		lblPasajerosExtra.setVisible(false);
		panelGrafo.add(lblPasajerosExtra);
		
		setearConDatos (DatosLinea);
		if (listaCaminos == null || listaCaminos.isEmpty()) {
			btnCrearLinea.setEnabled(false);
		}
		else {
			btnCrearLinea.setEnabled(true);
		}
	}
	
	private DTOAutobus generarDatosLinea () {
		DTOAutobus datos = new DTOAutobus();
		if (TFCapacidad.getText().equals("")) {
			datos.setAsientos(0);
		}
		else {
			datos.setAsientos(Integer.parseInt(TFCapacidad.getText()));
		}
		datos.setColor(TFColor.getText());
		datos.setId(123);
		datos.setNombre(TFNombreLinea.getText());
		
		if (comboTipo.getSelectedIndex() == 1) {
			datos.setTipo("Superior");
			datos.setAire(rdbtnAire.isSelected());
			datos.setWifi(rdbtnWifi.isSelected());
		}
		else if (comboTipo.getSelectedIndex() == 2){ 
			datos.setTipo("Economica");
			datos.setPasajerosextra(Integer.parseInt(TFPasajerosExtra.getText()));
		}
		else {
			datos.setTipo("Tipo");
		}
		
		
		return datos;
	}
	
	private void setearConDatos (DTOAutobus datos) {
		if (datos != null) {
			TFCapacidad.setText(Integer.toString(datos.getAsientos()));
			TFColor.setText(datos.getColor());
			TFNombreLinea.setText(datos.getNombre());
			if (datos.getTipo().equals("Economica")) {
				comboTipo.setSelectedIndex(2);
				TFPasajerosExtra.setText(Integer.toString(datos.getPasajerosextra()));
			}
			else if (datos.getTipo().equals("Superior")){
				comboTipo.setSelectedIndex(1);
				rdbtnWifi.setSelected(datos.isWifi());
				rdbtnAire.setSelected(datos.isAire());
				
			}
			else {
				comboTipo.setSelectedIndex(0);
			}
		}

	}
	private void actualizarSegunCombo() {
		if( comboTipo.getSelectedIndex()==1) {
			rdbtnAire.setVisible(true);
			rdbtnWifi.setVisible(true);
			TFPasajerosExtra.setVisible(false);
			lblPasajerosExtra.setVisible(false);
		}
		else if (comboTipo.getSelectedIndex()==2){
			rdbtnAire.setVisible(false);
			rdbtnWifi.setVisible(false);
			TFPasajerosExtra.setVisible(true);
			lblPasajerosExtra.setVisible(true);
		}
		else {
			TFPasajerosExtra.setVisible(false);
			lblPasajerosExtra.setVisible(false);
			TFPasajerosExtra.setVisible(false);
			lblPasajerosExtra.setVisible(false);
		}
	}
}
