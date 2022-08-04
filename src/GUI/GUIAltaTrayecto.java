package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DTO.DTOCamino;
import DTO.DTOParada;
import system.clases.Parada;
import system.clases.DAO.CaminoDAO;
import system.gestores.GestorCamino;
import system.gestores.GestorParada;

import javax.swing.JTable;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class GUIAltaTrayecto extends JFrame {

	private JPanel contentPane;
	private JTextField TFNroParada;
	private ArrayList<Parada> listaParadas = new ArrayList<Parada>();
	private final static int CX = 100; //Corrimiento en X
	private final static int CY = 100; //Corrimiento en Y
	private final static int TPA = 8; //Tamaño punto anterior
	private final static int TPN = 12; //Tamaño punto nuevo
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIAltaTrayecto frame = new GUIAltaTrayecto();
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
	public GUIAltaTrayecto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnAgregarParada = new JButton("Agregar Parada");
		btnAgregarParada.addActionListener (actionAgregar);
		btnAgregarParada.setBounds(128, 38, 89, 23);
		contentPane.add(btnAgregarParada);
		
		TFNroParada = new JTextField();
		TFNroParada.setBounds(10, 39, 86, 20);
		contentPane.add(TFNroParada);
		TFNroParada.setColumns(10);
		
		JLabel lblNroParada = new JLabel("NumeroParada");
		lblNroParada.setBounds(10, 14, 86, 14);
		contentPane.add(lblNroParada);
		
	}
		ActionListener actionAgregar = e ->{
		Parada nuevaParada = GestorParada.obtenerParada(Integer.parseInt(TFNroParada.getText()));
		listaParadas.add(nuevaParada);
		ArrayList <DTOCamino> caminosDesdeParada = GestorCamino.caminosQueInicianEnParada(nuevaParada.getNroParada());
		ArrayList <Parada> paradasPosibles = new ArrayList <Parada>();
		for (DTOCamino unCamino:caminosDesdeParada) {
			paradasPosibles.add(GestorParada.obtenerParada(unCamino.getIdDestino()));
		}
		
		dibujarParadasPosibles(nuevaParada, paradasPosibles, contentPane);
		dibujarParadas(listaParadas, contentPane);	
	};
		
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
			ArrayList <Integer> posActual; 
			ArrayList <Integer> posPosible;
			Graphics g = panel.getGraphics();
			g.clearRect(CX, CY, 800, 800);
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
