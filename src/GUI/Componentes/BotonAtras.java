package GUI.Componentes;

import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BotonAtras extends JButton {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String userDirectory = System.getProperty("user.dir");
	
	public BotonAtras( boolean visible) {

		this.setIcon(new ImageIcon(userDirectory+"\\iconos\\iconBack.png"));
		this.setBounds(10, 35, 70, 70);
		this.setBackground(null);
		this.setBorderPainted(false);
		this.setFocusPainted(false);
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.setVisible(true);
		this.setEnabled(visible);
		this.setContentAreaFilled(false);
		
	}
	
}