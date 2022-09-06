package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import DTO.DTOCamino;
import DTO.DTOParada;
import GUI.Componentes.BotonIcono;
import GUI.JPanels.Linea.JPAgregarLinea;
import GUI.JPanels.Trayecto.JPGuardarTrayecto;
import system.clases.DAO.ParadaDAO;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class GUIGuardarTrayecto extends JFrame {
	
	private JPanel contentPane;

	public GUIGuardarTrayecto(JPAgregarLinea panel, BotonIcono botonManipular) {

		setBounds(200, 0, 900, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelSuperior = new JPanel();
		contentPane.add(panelSuperior, BorderLayout.NORTH);
		
		JLabel lblTitulo = new JLabel("Guardar trayecto");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		panelSuperior.add(lblTitulo);
		
		JPGuardarTrayecto contentPanel = new JPGuardarTrayecto(panel, botonManipular);
		contentPane.add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
	}

}
