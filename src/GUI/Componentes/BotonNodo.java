package GUI.Componentes;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import DTO.DTOParada;
import GUI.GUIInfoNodo;
import GUI.GUIInfoNodo;
import system.clases.DAO.ParadaDAO;

public class BotonNodo extends JLabel {
	
	private DTOParada parada;
	private int posY;
	private int posX;
	
	public BotonNodo(DTOParada parada) {
		
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.parada=parada;
		this.setFont(new Font("Century Gothic", Font.BOLD, 10));
		this.setText(parada.getNroParada() + "");
		this.setVisible(true);
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.setBorder((BorderFactory.createLineBorder(Color.black)));
		this.setBorder(getBorder());
		this.setForeground(Color.black);
		this.setBackground(Color.white);
		this.setOpaque(true);
		int calle = Integer.parseInt(parada.getCalle().substring(6));
		if(calle%2==0) {
			this.setBounds((calle*25)+175,(((parada.getNroCalle()/10)*5)+30),20,20);
		}
		else {
			this.setBounds((((parada.getNroCalle()/10)*5)+150),(calle*25)+30,20,20);
		}
		
		this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				GUIInfoNodo info = new GUIInfoNodo(infoParada());
				info.setResizable(false);
				info.setVisible(true);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
	}
	
	public DTOParada infoParada() {
		return this.parada;
	}
	
}
