package GUI.Componentes;

import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BotonIcono extends JButton{
	
	private final String userDirectory = System.getProperty("user.dir");
	
	public BotonIcono(String path) {
		this.setIcon(new ImageIcon(userDirectory+"\\iconos\\"+path));
		this.setSize(100,100);
		this.setBackground(null);
		this.setBorderPainted(false);
		this.setFocusPainted(false);
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
}
