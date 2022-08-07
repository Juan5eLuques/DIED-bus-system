package system.gestores;

import java.awt.EventQueue;
import java.util.ArrayList;

import DTO.DTOAutobus;
import DTO.DTOCamino;
import GUI.GUIAltaLinea;
import GUI.GUIAltaTrayecto;

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
}
