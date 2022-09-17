package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import DTO.DTOAutobus;
import DTO.DTOParada;
import GUI.Componentes.BotonMenu;
import GUI.Componentes.LblText;
import system.clases.InformacionCamino;

public class GUIInfoTrayecto extends JFrame {
	
	private JPanel panelLayout;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public GUIInfoTrayecto(InformacionCamino infoCamino, String index) {
		
		this.setBounds(500,100,300,400);
		this.setResizable(false);
		
		Font fuenteAtributos = new Font("Ebrima", Font.BOLD,20);
		
		JPanel panelSuperior = new JPanel();
		getContentPane().add(panelSuperior, BorderLayout.NORTH);
		panelSuperior.setBackground(new Color(17, 43, 60));
		
		LblText lblTitulo = new LblText("Recorrido " + index, new Font("Segou UI Black",Font.ITALIC,35));
		panelSuperior.add(lblTitulo);
		lblTitulo.setForeground(Color.white);
		
		JPanel panelContent = new JPanel();
		getContentPane().add(panelContent, BorderLayout.CENTER);
		panelContent.setLayout(null);
	
		
		LblText lblAutobus = new LblText("Linea: " + infoCamino.getAutobus().getNombre());
		LblText lblInicio= new LblText("Punto inicial: " +infoCamino.getParadaInicial()+"");
		LblText lblFinal= new LblText("Punto final: " +infoCamino.getParadaFinal()+"");
		LblText lblCosto = new LblText("Costo: ");
		LblText lblDuracion= new LblText("Duracion: " +infoCamino.getDuracion()+"");
		LblText lblDistancia = new LblText("Distancia: " +infoCamino.getDistancia()+"");
		LblText lblPrice = new LblText("$"+infoCamino.getCosto(),new Font("Ebrima", Font.BOLD,70));
		
		lblAutobus.setBounds(50,15,250,30);
		lblInicio.setBounds(50,50,250,30);
		lblFinal.setBounds(50,85,250,30);
		lblDuracion.setBounds(50,120,250,30);
		lblDistancia.setBounds(50,155,250,30);
		lblPrice.setBounds(10,205,250,70);
		
		panelContent.add(lblDistancia);
		panelContent.add(lblAutobus);
		panelContent.add(lblInicio);
		panelContent.add(lblFinal);
		panelContent.add(lblCosto);
		panelContent.add(lblDuracion);
		panelContent.add(lblPrice);
		
		panelContent.setBackground(new Color(32, 83, 117));
}
	
	public static void main (String[] args) {
		InformacionCamino camino = new InformacionCamino();
		camino.setAutobus(new DTOAutobus());
		camino.setCosto(300);
		camino.setDistancia(10);
		camino.setDuracion(4);
		camino.setParadaInicial(1);
		camino.setParadaFinal(10);
		
		GUIInfoTrayecto tr = new GUIInfoTrayecto(camino,1+"");
		tr.setVisible(true);
		
	}
	}