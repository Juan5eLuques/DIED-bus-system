package GUI.Componentes;

import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Carga extends JLabel{
	
	private final String userDirectory = System.getProperty("user.dir");
	
	public Carga(String path){
		this.setIcon(new ImageIcon(userDirectory+"\\iconos\\"+path));
		this.setSize(100,100);
		this.setBackground(null);
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
}	
