package GUI.Componentes;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import DTO.DTOCamino;
import DTO.DTOParada;
import GUI.JPanels.Trayecto.JPGuardarTrayecto;

public class BotonNodoTrayecto extends JLabel {

	private DTOParada parada;
	private int posY;
	private int posX;
	
	public BotonNodoTrayecto(DTOParada parada, ArrayList<DTOParada> trayecto, JPGuardarTrayecto panelDibujo, ArrayList<DTOCamino> posibles) {
		
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
		
			}

			@Override
			public void mousePressed(MouseEvent e) {
				ArrayList<DTOCamino> posibles = panelDibujo.getListaPosibles();
				boolean encontrado = false;
				for (DTOCamino unCamino: posibles) {
					if (unCamino.getIdDestino() == parada.getNroParada()) {
						encontrado=true;
					}
				}
				if (encontrado == true) {
					
				DTOCamino nuevoCamino = new DTOCamino();
				nuevoCamino.setIdOrigen(trayecto.get(trayecto.size()-1).getNroParada());
				nuevoCamino.setIdDestino(parada.getNroParada());
				trayecto.add(parada);
				panelDibujo.setearCaminos(nuevoCamino);
				panelDibujo.revalidate();
				panelDibujo.repaint();
				}
				
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
	
	public void buscarParada (DTOCamino camino, Boolean encontrado) {
			if(camino.getIdDestino() == parada.getNroParada()) encontrado = true;
	}
	
	public DTOParada infoParada() {
		return this.parada;
	}

	public void addActionListener() {
		// TODO Auto-generated method stub
		
	}
}
