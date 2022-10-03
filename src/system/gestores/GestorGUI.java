package system.gestores;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;

import DTO.DTOAutobus;
import DTO.DTOCamino;
import GUI.GUIAltaLinea;
import GUI.GUIAltaTrayecto;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.Polygon;

public class GestorGUI {

	public static void GUIAltaTrayecto (DTOAutobus DatosLinea) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIAltaTrayecto frame = new GUIAltaTrayecto(DatosLinea);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void GUIAltaLinea (DTOAutobus DatosLinea, ArrayList<DTOCamino> listaCaminos) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIAltaLinea frame = new GUIAltaLinea(DatosLinea, listaCaminos);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void dibujarParada (){


	}

	public static void dibujarCamino(Graphics g, double x1, double y1, double x2, double y2, Color color ) {
		g.setColor(color);
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.drawLine((int)x1, (int)y1, (int)x2, (int)y2);
	
		double l = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2)); //largo de la linea
		
		double d = 17;//Punto inicial de la flecha para lineas inclinadas (distancia desde el final de la linea) 
		if (x1 == x2 || y1 == y2) { //Punto inicial de la flecha para lineas rectas (horizontales o verticales)
			d = 14;
		}
		
		double newX = ((x2 + (((x1 - x2) / (l) * d)))); // X donde empieza la flecha
		double newY = ((y2 + (((y1 - y2) / (l) * d)))); // Y donde empieza la flecha 
	
		double dx = x2 - x1; 
	    double dy = y2 - y1;
		double angulo = (Math.atan2(dy, dx)); //devuelve el angulo en rad
		AffineTransform at = new AffineTransform();
		at.translate(newX, newY);
		at.rotate(angulo);
		g2d.transform(at);
	
		Polygon flecha = new Polygon();
		flecha.addPoint(3, 0);
		flecha.addPoint(-3, 3);
		flecha.addPoint(-1, -0);
		flecha.addPoint(-3, -3);
		g2d.fill(flecha);
		g2d.drawPolygon(flecha);
		g.setColor(Color.black);
	}
}
