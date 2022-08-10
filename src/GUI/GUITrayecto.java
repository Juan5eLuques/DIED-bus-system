package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DTO.DTOCamino;
import GUI.Componentes.BotonAtras;
import GUI.Componentes.LblText;
import GUI.Componentes.TextFieldNumbers;
import GUI.Componentes.TextFieldText;
import system.clases.Parada;
import system.gestores.GestorCamino;
import system.gestores.GestorParada;

import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class GUITrayecto extends JFrame {

	private final static int CX = 200; //Corrimiento en X
	private final static int CY = 5; //Corrimiento en Y
	private final static int TPA = 8; //Tamaño punto anterior
	private final static int TPN = 12; //Tamaño punto nuevo
	private JPanel contentPane;
	private static ArrayList<Parada> listaParadas = new ArrayList<Parada>();
	private static ArrayList<DTOCamino> listaCaminos = new ArrayList<DTOCamino>();
	private static ArrayList<DTOCamino> listaCaminosPosibles = new ArrayList<DTOCamino>();
	private static ArrayList<Parada> paradasPosibles = new ArrayList<Parada>();
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUITrayecto frame = new GUITrayecto();
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
	public GUITrayecto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 0, 900, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelSuperior = new JPanel();
		contentPane.add(panelSuperior, BorderLayout.NORTH);
		
		JLabel lblTitulo = new JLabel("Recorrido de linea");
		panelSuperior.add(lblTitulo);
		lblTitulo.setForeground(Color.white);
		lblTitulo.setFont(new Font("Ebrima", Font.BOLD, 38));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panelContent = new JPanel();
		panel.add(panelContent, BorderLayout.CENTER);
		panelContent.setLayout(null);
		
		panelSuperior.setBackground(new Color(17, 43, 60));
		panelContent.setBackground(new Color(32, 83, 117));
		
		String dir = System.getProperty("user.dir");
		lblTitulo.setIcon(new ImageIcon(dir +"\\iconos\\iconCaminoFrame.png"));
		
		TextFieldNumbers TFNroParada = new TextFieldNumbers();
		TFNroParada.setBounds(140,30,150,30);
		
		JButton btnGuardar = new JButton();
		JButton btnSiguiente = new JButton();
		btnSiguiente.setText("Agr parada");
		btnGuardar.setText("Guardar");
		btnSiguiente.setBounds(560,30,120,30);
		btnGuardar.setBounds(700,30,120,30);
	
		JComboBox paradaSiguiente = new JComboBox();
	
		LblText lblParadaIncial = new LblText("Parada inicial", new Font("Ebrima", Font.BOLD, 18));
		lblParadaIncial.setBounds(10,30,140,30);
		
		panelContent.add(TFNroParada);
		panelContent.add(lblParadaIncial);
		panelContent.add(btnSiguiente);
		panelContent.add(btnGuardar);
		
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Parada nuevaParada;
				if (listaParadas.isEmpty()){
				nuevaParada = GestorParada.obtenerParada(Integer.parseInt(TFNroParada.getText()));
				listaParadas.add(nuevaParada);
					btnSiguiente.setText("Agregar parada");
					TFNroParada.setVisible(false);
					paradaSiguiente.setVisible(true);			
				}
				else {
					int index = paradaSiguiente.getSelectedIndex();
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
				paradaSiguiente.setModel(new DefaultComboBoxModel(idPosibles.toArray()));
				dibujarParadasPosibles(nuevaParada, paradasPosibles, panelContent);
				dibujarParadas(listaParadas, panelContent);	
			}
		});
		
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
	
	private static void dibujarParadasPosibles(Parada paradaActual, ArrayList<Parada> paradasPosibles, JPanel panel) {
		panel.setBackground(new Color(70, 130, 180));
		ArrayList <Integer> posActual; 
		ArrayList <Integer> posPosible;
		Graphics g = panel.getGraphics();
		g.setColor(Color.white);
		g.fillRect(CX, CY, 800, 800);
		posActual = ubicacion(paradaActual);
		for(Parada unaParada:paradasPosibles) {
			posPosible = ubicacion(unaParada);
				g.setColor(Color.RED);
				g.fillOval(CX+posPosible.get(0)-((TPN-TPA)/2), CY+posPosible.get(1)-((TPN-TPA)/2), TPN, TPN);
			
				g.drawLine(CX+posActual.get(0)+TPA/2, CY+posActual.get(1)+TPA/2, CX+posPosible.get(0)+TPA/2, CY +posPosible.get(1)+TPA/2);
			
		}
	}
	
}
