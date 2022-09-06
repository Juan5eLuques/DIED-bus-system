package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import DTO.DTOParada;
import GUI.Componentes.BotonMenu;
import GUI.Componentes.LblText;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class GUIInfoNodo extends JFrame {
	
	private JPanel panelLayout;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public GUIInfoNodo(DTOParada paradaInfo) {
		
		this.setBounds(100,30,300,350);
		
		String dir = System.getProperty("user.dir");
		
		JPanel panelSuperior = new JPanel();
		getContentPane().add(panelSuperior, BorderLayout.NORTH);
		panelSuperior.setBackground(new Color(17, 43, 60));
		
		LblText lblTitulo = new LblText("Parada "+paradaInfo.getNroParada());
		panelSuperior.add(lblTitulo);
		lblTitulo.setForeground(Color.white);
		
		JPanel panelContent = new JPanel();
		getContentPane().add(panelContent, BorderLayout.CENTER);
		panelContent.setLayout(null);
		
		LblText lvlCalle = new LblText("Calle: "+ paradaInfo.getCalle());
		lvlCalle.setHorizontalAlignment(SwingConstants.CENTER);
		lvlCalle.setBounds(0, 40, 284, 30);
		panelContent.add(lvlCalle);
		
		LblText lblEstado = new LblText("");
		if (paradaInfo.isActiva()) {
			lblEstado = new LblText("Estado: ACTIVA");
			lblEstado.setIcon(new ImageIcon(dir +"\\iconos\\iconVerified.png"));
		}
		else {
			lblEstado = new LblText("Estado:  NO ACTIVA");
			lblEstado.setIcon(new ImageIcon(dir +"\\iconos\\iconDenied.png"));
		}
		lblEstado.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstado.setBounds(0, 120, 284, 64);
		panelContent.add(lblEstado);
		
		BotonMenu verIncidencias = new BotonMenu("VER INCIDENCIAS", new Font("Ebrima", Font.BOLD, 20));
		
		panelContent.add(verIncidencias);
		verIncidencias.setBounds(10,200,264,40);
		panelContent.setBackground(new Color(32, 83, 117));
}
	}
