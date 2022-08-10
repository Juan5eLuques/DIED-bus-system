package GUI.Componentes;



import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class LblText extends JLabel {
	public LblText (String titulo) {
		this.setForeground(Color.white);
		this.setFont(new Font("Ebrima", Font.BOLD, 25));
		this.setText(titulo);
		this.setBorder(null);
	}
	
	public LblText (String titulo, Font unaFuente) {
		this.setForeground(Color.white);
		this.setFont(unaFuente);
		this.setText(titulo);
		this.setBorder(null);
	}
}
