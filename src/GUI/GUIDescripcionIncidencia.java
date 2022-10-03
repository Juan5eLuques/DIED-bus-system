package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import DTO.DTOIncidencia;
import GUI.Componentes.LblText;

public class GUIDescripcionIncidencia extends JFrame {
	public GUIDescripcionIncidencia(DTOIncidencia info) {
		
		this.setBounds(100,30,400,450);
		
		JPanel panelSuperior = new JPanel();
		getContentPane().add(panelSuperior, BorderLayout.NORTH);
		panelSuperior.setBackground(new Color(17, 43, 60));
		
		JPanel panelContent = new JPanel();
		getContentPane().add(panelContent, BorderLayout.CENTER);
		panelContent.setLayout(null);
		
		panelContent.setBackground(new Color(32, 83, 117));
		
		LblText lblTitulo = new LblText("Descripcion de incidencia");
		panelSuperior.add(lblTitulo);
		lblTitulo.setForeground(Color.white);
		

		JTextPane textPaneDescripcion = new JTextPane();
		
		
		textPaneDescripcion.setForeground(Color.white);
		textPaneDescripcion.setOpaque(false);
		textPaneDescripcion.setFont(new Font("Century Gothic", Font.BOLD, 18));
		textPaneDescripcion.setText(info.getDescripcion());
		textPaneDescripcion.setEditable(false);
		textPaneDescripcion.setBounds(14,30,360,450);
		
		panelContent.add(textPaneDescripcion);
		
	}
}
