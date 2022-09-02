package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DTO.DTOParada;
import GUI.Componentes.BotonMenu;
import GUI.Componentes.LblText;

public class GUIInfoNodo extends JFrame {
	
	private JPanel panelLayout;
	
	public GUIInfoNodo(DTOParada paradaInfo){
		
		panelLayout = new JPanel();
		panelLayout.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelLayout);
		panelLayout.setLayout(new BorderLayout(0, 0));
		
		JPanel panelSuperior = new JPanel();
		panelLayout.add(panelSuperior, BorderLayout.NORTH);
		panelSuperior.setBackground(new Color(17, 43, 60));
		
		this.setBounds(100,30,300,350);
		this.setVisible(true);
		JPanel content = new JPanel();
		this.add(content);
		content.setLayout(null);
		content.setBackground(new Color(32, 83, 117));
		LblText titulo = new LblText("Parada "+paradaInfo.getNroParada());
		titulo.setBounds(30, 30, 50, 30);
		titulo.setBackground(null);
		panelSuperior.add(titulo);
		LblText calle = new LblText("Calle: "+ paradaInfo.getCalle());
		LblText estado;
		if (paradaInfo.isActiva()) {
			estado = new LblText("Estado: ACTIVA");
		}
		else {
			estado = new LblText("Estado:  NO ACTIVA");
		}
		BotonMenu verIncidencias = new BotonMenu("VER INCIDENCIAS", new Font("Ebrima", Font.BOLD, 20));
		
		calle.setBounds(40,20,300,70);
		estado.setBounds(40,80,300,70);
		verIncidencias.setBounds(30,200,210,40);
		
		content.add(calle);
		content.add(estado);
		content.add(verIncidencias);
	}
}
