package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DTO.DTOCamino;
import system.clases.Parada;
import system.clases.DAO.CaminoDAO;
import system.gestores.GestorAutobus;
import system.gestores.GestorParada;

import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JTree;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.ScrollPane;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class GUIMostrarTrayecto extends JFrame {

	
	private final static int CX = 100; //Corrimiento en X
	private final static int CY = 100; //Corrimiento en Y
	private final static int TPA = 8; //Tama�o punto anterior
	private final static int TPN = 12; //Tama�o punto nuevo
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIMostrarTrayecto frame = new GUIMostrarTrayecto();
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
	
	public GUIMostrarTrayecto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JPanel Grafo = new JPanel();
		Grafo.setBackground(new Color(70, 130, 180));
		contentPane.add(Grafo, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{149, 0, 0, 0, 0, 24, 158, 0, 0, 0, 0, 0, 0, 235, 0};
		gbl_panel.rowHeights = new int[]{20, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblTitleTrayecto = new JLabel("Trayectos");
		lblTitleTrayecto.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleTrayecto.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 22));
		GridBagConstraints gbc_lblTitleTrayecto = new GridBagConstraints();
		gbc_lblTitleTrayecto.anchor = GridBagConstraints.NORTH;
		gbc_lblTitleTrayecto.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblTitleTrayecto.insets = new Insets(0, 0, 0, 5);
		gbc_lblTitleTrayecto.gridx = 0;
		gbc_lblTitleTrayecto.gridy = 0;
		panel.add(lblTitleTrayecto, gbc_lblTitleTrayecto);
		panel.setBackground(getForeground());
		JComboBox btnListaLineas = new JComboBox();
		GridBagConstraints gbc_ListaLineas = new GridBagConstraints();
		gbc_ListaLineas.insets = new Insets(0, 0, 0, 5);
		gbc_ListaLineas.fill = GridBagConstraints.BOTH;
		gbc_ListaLineas.gridx = 6;
		gbc_ListaLineas.gridy = 0;
		panel.add(btnListaLineas, gbc_ListaLineas);
		
		String listaIDLineas[] = new String[GestorAutobus.obtenerNombresDeLineas().size()];
		GestorAutobus.obtenerNombresDeLineas().toArray(listaIDLineas);
		
		
		btnListaLineas.setBackground(Color.WHITE);
		btnListaLineas.setForeground(Color.BLACK);
		btnListaLineas.setToolTipText("");
		btnListaLineas.setModel(new DefaultComboBoxModel(listaIDLineas));
		btnListaLineas.setSelectedIndex(1);
		
		
		JButton btnMostrarTrayecto = new JButton("Mostrar");
		GridBagConstraints gbc_btnMostrarTrayecto = new GridBagConstraints();
		gbc_btnMostrarTrayecto.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnMostrarTrayecto.gridx = 13;
		gbc_btnMostrarTrayecto.gridy = 0;
		panel.add(btnMostrarTrayecto, gbc_btnMostrarTrayecto);
		btnMostrarTrayecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				ArrayList<Parada> listaParadas = new ArrayList<Parada>();
				int autobus = btnListaLineas.getSelectedIndex();
				ArrayList<DTOCamino> camino = CaminoDAO.obtenerCaminosDeUnaLinea(autobus+1);
				for(DTOCamino unCamino : camino ) {
					listaParadas.add(GestorParada.obtenerParada(unCamino.getIdOrigen()));
				}
				dibujarParadas(listaParadas, Grafo);
				
			}
		});
		
	}
	//
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
	
	private static ArrayList<Integer> obtenerLineas(){
	
		
		
		return null;
	}

}
