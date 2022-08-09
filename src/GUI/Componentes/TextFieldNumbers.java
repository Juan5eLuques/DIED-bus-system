package GUI.Componentes;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

public class TextFieldNumbers extends JTextField {

	public TextFieldNumbers() {
		this.setBackground(new Color(17, 43, 60));
		this.setFont(new Font("Ebrima", Font.BOLD, 25));
		this.setForeground(Color.white);
		this.setBorder(null);
		
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(c <'0' || c > '9') e.consume();
			}
			});
		
	}
}
