package GUI.Componentes;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JButton;

public class BotonMenu extends JButton {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public BotonMenu(String titulo) {
	this.setFont(new Font("Century Gothic", Font.BOLD, 25));
	this.setText(titulo);
	this.setBorderPainted(false);
	this.setFocusPainted(false);
	this.setForeground(new Color(17, 43, 60));
	this.setCursor(new Cursor(Cursor.HAND_CURSOR));
	
	}
}