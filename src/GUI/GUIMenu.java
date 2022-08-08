package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GUI.GUIMenu.BotonMenu;
import GUI.GUIMenu.GUIMenuParadas;

public class GUIMenu extends JFrame {

	private JPanel panelLayout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIMenu frame = new GUIMenu();
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
		lblTitulo.setIcon(new ImageIcon("C:\\Users\\diosc\\Downloads\\icons8-autob\u00FAs-50.png"));
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
		
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
			}
		});
		
		btnTrayectos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
			GUIMenuParadas menuParada = new GUIMenuParadas(panelCentral);
			panelLayout.add(menuParada, BorderLayout.CENTER);
			menuParada.setVisible(true);
			}
		});
		
		btnLineas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			GUIMenuParadas menuParada = new GUIMenuParadas(panelCentral);
			panelLayout.add(menuParada, BorderLayout.CENTER);
			menuParada.setVisible(true);
			}
		});
		
		btnParadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			GUIMenuParadas menuParada = new GUIMenuParadas(panelCentral);
			panelLayout.add(menuParada, BorderLayout.CENTER);
			menuParada.setVisible(true);
			}
		});
		
		btnIncidencias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			GUIMenuIncidencias menuParada = new GUIMenuIncidencias(panelCentral);
			panelLayout.add(menuParada, BorderLayout.CENTER);
			menuParada.setVisible(true);
			}
		});
		
	}
	
	
	public void agregarBoton(int ubicacionInicialEnY, JPanel panel, BotonMenu boton) {
		boton.setBounds(10, ubicacionInicialEnY, 854, 40);
		panel.add(boton);
	}
	
	
	public class BotonAtras extends JButton {
		
		public BotonAtras( boolean visible) {
			
			this.setIcon(new ImageIcon("C:\\Users\\diosc\\Downloads\\icons8-atr\u00E1s-64.png"));
			this.setBounds(10, 35, 70, 70);
			this.setBackground(null);
			this.setBorderPainted(false);
			this.setFocusPainted(false);
			this.setCursor(new Cursor(Cursor.HAND_CURSOR));
			this.setVisible(true);
			this.setEnabled(visible);
		}
		
	}
	
	
	public class BotonMenu extends JButton {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public BotonMenu(String titulo) {
		
		this.setFont(new Font("Century Gothic", Font.BOLD, 25));
		this.setText(titulo);
		this.setBorderPainted(false);
		this.setFocusPainted(false);
		this.setForeground(new Color(17, 43, 60));
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		}
	}
	
	public class GUIMenuParadas extends JPanel {
		
		public GUIMenuParadas(JPanel panelManipular) {
			
			panelManipular.setVisible(false);
			BotonAtras boton = new BotonAtras(true);
			this.add(boton);
			this.setBackground(new Color(32, 83, 117));
			this.setLayout(null);
			BotonMenu btnverParadas = new BotonMenu("Ver Paradas");
			BotonMenu btnbuscarParadas = new BotonMenu("Buscar Paradas");
			agregarBoton(130, this,btnverParadas);
			agregarBoton(190, this,btnbuscarParadas);
			
			boton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelManipular.setVisible(true);
				}
			});
		}
	}
	
	public class GUIMenuIncidencias extends JPanel {
		
		public GUIMenuIncidencias(JPanel panelManipular) {
			
			panelManipular.setVisible(false);
			BotonAtras boton = new BotonAtras(true);
			this.add(boton);
			this.setBackground(new Color(32, 83, 117));
			this.setLayout(null);
			BotonMenu btnVerIncidencias = new BotonMenu("Ver Incidencias");
			BotonMenu btnRegistrarIncidencias = new BotonMenu("Registrar Incidencia");
			BotonMenu btnEliminarIncidencia = new BotonMenu("Eliminar Incidencia");
			agregarBoton(130, this,btnVerIncidencias);
			agregarBoton(190, this,btnRegistrarIncidencias);
			agregarBoton(250, this,btnEliminarIncidencia);
			
			boton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelManipular.setVisible(true);
				}
			});
		}
	}
	
}
