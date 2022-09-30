package GUI.JPanels.Camino;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

import GUI.Componentes.BotonAtras;

public class JPEditarCamino extends JPanel {
	
	public JPEditarCamino(JPanel panelManipular, JLabel lblTitulo) {
		
		BotonAtras boton = new BotonAtras(true);
		this.add(boton);
		this.setLayout(null);
		this.setBackground(new Color(32, 83, 117));
		
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelManipular.setVisible(true);
				deshabilitar();
				lblTitulo.setText("SISTEMA AUTOBUS");
			}
		});
		
	}
	
	public void deshabilitar() {
		this.setVisible(false);
		}
	
	public JPEditarCamino getPanel() {
		return this;
	}
}
