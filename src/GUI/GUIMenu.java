package GUI;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GUI.Componentes.BotonAtras;
import GUI.Componentes.BotonMenu;
import GUI.JPanels.Menu.JPMenuIncidencias;
import GUI.JPanels.Menu.JPMenuLineas;
import GUI.JPanels.Menu.JPMenuParada;
import GUI.JPanels.Menu.JPMenuTrayecto;


public class GUIMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelLayout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIMenu frame = new GUIMenu();
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUIMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 0, 900, 700);
		panelLayout = new JPanel();
		panelLayout.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelLayout);
		panelLayout.setLayout(new BorderLayout(0, 0));
		
		JPanel panelSuperior = new JPanel();
		panelLayout.add(panelSuperior, BorderLayout.NORTH);
		panelSuperior.setBackground(new Color(17, 43, 60));
		
		JLabel lblTitulo = new JLabel("SISTEMA AUTOBUS");
		lblTitulo.setIconTextGap(15);
		lblTitulo.setForeground(Color.white);
		String dir = System.getProperty("user.dir");
		lblTitulo.setIcon(new ImageIcon(dir +"\\iconos\\iconBus.png"));
		lblTitulo.setFont(new Font("Ebrima", Font.BOLD, 38));
		panelSuperior.add(lblTitulo);
		JPanel panelCentral = new JPanel();
		panelCentral.setBackground(new Color(32, 83, 117));
		panelCentral.setLayout(null);
		panelLayout.add(panelCentral, BorderLayout.CENTER);
		
		
		BotonAtras boton = new BotonAtras(false);
		
		panelCentral.add(boton);
		
		BotonMenu btnTrayectos = new BotonMenu("Trayectos");
		
		BotonMenu btnLineas = new BotonMenu("Lineas");
		
		BotonMenu btnParadas = new BotonMenu("Paradas");
		
		BotonMenu btnIncidencias = new BotonMenu("Incidencias");
		
		agregarBoton(130, panelCentral,btnTrayectos);
		agregarBoton(190, panelCentral,btnLineas);
		agregarBoton(250, panelCentral,btnParadas);
		agregarBoton(310, panelCentral,btnIncidencias);
		
		
		btnTrayectos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
			JPMenuTrayecto menuParada = new JPMenuTrayecto(panelCentral);
			panelCentral.setVisible(false);
			panelLayout.add(menuParada, BorderLayout.CENTER);
			menuParada.setVisible(true);
			}
		});
		
		btnLineas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			JPMenuLineas menuParada = new JPMenuLineas(panelCentral, panelLayout,lblTitulo);
			panelLayout.add(menuParada, BorderLayout.CENTER);
			menuParada.setVisible(true);
			}
		});
		
		btnParadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			JPMenuParada menuParada = new JPMenuParada(panelCentral, panelLayout,lblTitulo);
			panelLayout.add(menuParada, BorderLayout.CENTER);
			menuParada.setVisible(true);
			}
		});
		
		btnIncidencias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			JPMenuIncidencias menuParada = new JPMenuIncidencias(panelCentral);
			panelLayout.add(menuParada, BorderLayout.CENTER);
			menuParada.setVisible(true);
			}
		});
		
	}
	
	
	public void agregarBoton(int ubicacionInicialEnY, JPanel panel, BotonMenu boton) {
		boton.setBounds(10, ubicacionInicialEnY, 854, 40);
		panel.add(boton);
	}
	
}
