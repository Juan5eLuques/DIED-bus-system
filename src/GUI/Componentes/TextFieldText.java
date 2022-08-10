package GUI.Componentes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JTextField;

public class TextFieldText extends JTextField{
	
	public TextFieldText() {
		this.setBackground(new Color(17, 43, 60));
		this.setFont(new Font("Ebrima", Font.BOLD, 25));
		this.setForeground(Color.white);
		this.setBorder(null);
		this.setCaretColor(Color.white);
	}
}