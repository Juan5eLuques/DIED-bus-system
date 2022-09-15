package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DTO.DTOAutobus;
import DTO.DTOCamino;
import DTO.DTOParada;
import system.clases.Parada;
import system.gestores.GestorCamino;
import system.gestores.GestorGUI;
import system.gestores.GestorParada;

import javax.swing.JTable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

public class GUIAltaTrayecto extends JFrame {

	private static JPanel contentPane;
	private static JPanel panelDeControl;
	private static JPanel panelGrafo;
	private static JTextField TFNroParada;
	private static ArrayList<Parada> listaParadas = new ArrayList<Parada>();
	private static ArrayList<DTOCamino> listaCaminos = new ArrayList<DTOCamino>();
	private static ArrayList<DTOCamino> listaCaminosPosibles = new ArrayList<DTOCamino>();
	private static JButton btnAgregarParada;
	private static JButton btnGuardar;
	private static JComboBox comboListaPosibles;
	private static ArrayList<Parada> paradasPosibles = new ArrayList<Parada>();
	private final static int CX = 200; //Corrimiento en X
	private final static int CY = 5; //Corrimiento en Y
	private final static int TPA = 8; //Tama�o punto anterior
	private final static int TPN = 12; //Tama�o punto nuevo

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIAltaTrayecto frame = new GUIAltaTrayecto(null);
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
	public GUIAltaTrayecto(DTOAutobus DatosLinea) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 0, 900, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(32, 83, 117));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		
		
		///PANEL SUPERIOR////
		GridBagLayout gbl_panelDeControl = new GridBagLayout();
		gbl_panelDeControl.columnWidths = new int[]{149, 0, 0, 0, 0, 0, 24, 158, 0, 0, 0, 0, 0, 0, 0, 0, 235, 0};
		gbl_panelDeControl.rowHeights = new int[]{20, 0};
		gbl_panelDeControl.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelDeControl.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		JPanel panelDeControl = new JPanel();
		panelDeControl.setBackground(new Color(32, 83, 117));
		panelDeControl.setLayout(gbl_panelDeControl);
		panelDeControl.setBackground(SystemColor.activeCaption);
		contentPane.add(panelDeControl, BorderLayout.NORTH);
		
	
		
		JLabel lblTitulo = new JLabel("CREAR TRAYECTO");
		lblTitulo.setForeground(Color.white);
		lblTitulo.setFont(new Font("Ebrima", Font.BOLD, 30));
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.gridwidth = 3;
		gbc_lblTitulo.anchor = GridBagConstraints.NORTH;
		gbc_lblTitulo.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblTitulo.insets = new Insets(0, 0, 0, 5);
		gbc_lblTitulo.gridx = 0;
		gbc_lblTitulo.gridy = 0;
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(10, 15, 50, 20);
		panelDeControl.add(lblTitulo, gbc_lblTitulo);
		
		////PANEL CUERPO////
		
		JPanel panelGrafo = new JPanel();
		panelGrafo.setBackground(new Color(32, 83, 117));
		contentPane.add(panelGrafo, BorderLayout.CENTER);
		
		//HASTA ACA HACE LA BASE
		
		TFNroParada = new JTextField();
		GridBagConstraints gbc_TFNroParada = new GridBagConstraints();
		gbc_TFNroParada.gridwidth = 5;
		gbc_TFNroParada.insets = new Insets(0, 0, 0, 5);
		gbc_TFNroParada.gridx = 3;
		gbc_TFNroParada.gridy = 0;
		
		TFNroParada.setColumns(10);
		panelDeControl.add(TFNroParada, gbc_TFNroParada);
		
		comboListaPosibles = new JComboBox();
		GridBagConstraints gbc_comboListaPosibles = new GridBagConstraints();
		gbc_comboListaPosibles.ipadx = 10;
		gbc_comboListaPosibles.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboListaPosibles.gridwidth = 3;
		gbc_comboListaPosibles.insets = new Insets(0, 0, 0, 5);
		gbc_comboListaPosibles.gridx = 3;
		gbc_comboListaPosibles.gridy = 0;
		comboListaPosibles.setVisible(false);
		panelDeControl.add(comboListaPosibles, gbc_comboListaPosibles);
		
		
		ActionListener actionAgregar = e ->{
			Parada nuevaParada;
			if (listaParadas.isEmpty()){
			nuevaParada = GestorParada.obtenerParada(Integer.parseInt(TFNroParada.getText()));
			listaParadas.add(nuevaParada);
				btnAgregarParada.setText("Agregar parada");
				TFNroParada.setVisible(false);
				comboListaPosibles.setVisible(true);			
			}
			else {
				int index = comboListaPosibles.getSelectedIndex();
				nuevaParada = GestorParada.obtenerParada(paradasPosibles.get(index).getNroParada());
				listaParadas.add(nuevaParada);
				for (DTOCamino unCamino:listaCaminosPosibles) {
					if (unCamino.getIdDestino() == nuevaParada.getNroParada()) {
						listaCaminos.add(unCamino);
					}
				}
			}
			listaCaminosPosibles = GestorCamino.caminosQueInicianEnParada(nuevaParada.getNroParada());
			paradasPosibles.clear();
			for (DTOCamino unCamino:listaCaminosPosibles) {
				paradasPosibles.add(GestorParada.obtenerParada(unCamino.getIdDestino()));
			}
			ArrayList <Integer> idPosibles = (ArrayList<Integer>) paradasPosibles.stream().map(Parada::getNroParada).collect(Collectors.toList());
			comboListaPosibles.setModel(new DefaultComboBoxModel(idPosibles.toArray()));
			dibujarParadasPosibles(nuevaParada, paradasPosibles, panelGrafo);
			dibujarParadas(listaParadas, panelGrafo);	
		};
		
				
				btnAgregarParada = new JButton("Iniciar trayecto");
				btnAgregarParada.addActionListener (actionAgregar);
				btnAgregarParada.setBounds(128, 38, 89, 23);
				GridBagConstraints gbc_btnAgregarParada = new GridBagConstraints();
				gbc_btnAgregarParada.insets = new Insets(0, 0, 0, 5);
				gbc_btnAgregarParada.gridwidth = 1;
				gbc_btnAgregarParada.gridx = 8;
				gbc_btnAgregarParada.gridy = 0;
				gbc_btnAgregarParada.fill = GridBagConstraints.BOTH;
				panelDeControl.add(btnAgregarParada, gbc_btnAgregarParada);
				
				
				ActionListener actionGuardar = e ->{
					GestorGUI.GUIAltaLinea(DatosLinea, listaCaminos);
				};
		
		btnGuardar = new JButton("Guardar trayecto");
		btnGuardar.addActionListener(actionGuardar);
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardar.gridx = 11;
		gbc_btnGuardar.gridy = 0;
		panelDeControl.add(btnGuardar, gbc_btnGuardar);
		
		
	}
	

		
		private static void dibujarParadas(ArrayList<Parada> listaParadas, JPanel panel) {
			ArrayList <Integer> posActual; 
			ArrayList <Integer> posAnterior = null;
			Graphics g = panel.getGraphics();
			 int contador= 1;
			for(Parada unaParada:listaParadas) {
				posActual = ubicacion(unaParada);
				
				if (contador==listaParadas.size()) {
					g.fillOval(CX+posActual.get(0)-((TPN-TPA)/2), CY+posActual.get(1)-((TPN-TPA)/2), TPN, TPN);
				}
				else {
					g.fillOval(CX+posActual.get(0), CY+posActual.get(1), TPA, TPA);
				}				
				if (posAnterior != null){
					g.drawLine(CX+posAnterior.get(0)+TPA/2, CY+posAnterior.get(1)+TPA/2, CX+posActual.get(0)+TPA/2, CY +posActual.get(1)+TPA/2);
				}
				
				posAnterior = posActual;
				contador ++;
			}
		}
		
		private static void dibujarParadasPosibles(Parada paradaActual, ArrayList<Parada> paradasPosibles, JPanel panel) {
			panel.setBackground(new Color(32, 83, 117));
			ArrayList <Integer> posActual; 
			ArrayList <Integer> posPosible;
			Graphics g = panel.getGraphics();
			g.setColor(new Color(70, 130, 180));
			g.fillRect(CX, CY, 800, 800);
			posActual = ubicacion(paradaActual);
			for(Parada unaParada:paradasPosibles) {
				posPosible = ubicacion(unaParada);
					g.setColor(Color.RED);
					g.fillOval(CX+posPosible.get(0)-((TPN-TPA)/2), CY+posPosible.get(1)-((TPN-TPA)/2), TPN, TPN);
				
					g.drawLine(CX+posActual.get(0)+TPA/2, CY+posActual.get(1)+TPA/2, CX+posPosible.get(0)+TPA/2, CY +posPosible.get(1)+TPA/2);
				
			}
		}
		
		//Devuelve la posicion de la calle, en formato X,Y
		private static ArrayList<Integer> ubicacion(Parada parada) {
			
			ArrayList<Integer> retorno = new ArrayList<Integer>();
			int calle = Integer.parseInt(parada.getCalle().substring(6));
			if (calle%2==0) { //Si es vertical
				retorno.add(((calle/2)+1)*50);
				retorno.add(50*(((parada.getNroCalle()-50)/200))+75);
				
			}
			else { //Si es horizontal
				retorno.add(50*(((parada.getNroCalle()-50)/200))+75);
				retorno.add((calle+1)*25);
			}
			return retorno;
		}
}
