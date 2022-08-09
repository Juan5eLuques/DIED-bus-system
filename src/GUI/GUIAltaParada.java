package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import DTO.DTOParada;
import system.clases.DAO.ParadaDAO;
import system.gestores.GestorParada;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUIAltaParada extends JFrame {

	private JPanel panelLayout;
	private JPanel panelSuperior;
	private JPanel panelCentral;
	private JTextField TFNroParada;
	private JTextField TFCalle;
	private JTextField TFNumero;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIAltaParada frame = new GUIAltaParada();
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
	public GUIAltaParada() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 0, 900, 700);
		panelLayout = new JPanel();
		panelLayout.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelLayout);
		panelLayout.setLayout(new BorderLayout(0, 0));
		
		JPanel panelSuperior = new JPanel();
		panelLayout.add(panelSuperior, BorderLayout.NORTH);
		panelSuperior.setBackground(new Color(17, 43, 60));
		
		JLabel lblTitulo = new JLabel("CREAR PARADA");
		lblTitulo.setIconTextGap(13);
		lblTitulo.setForeground(Color.white);
		lblTitulo.setFont(new Font("Ebrima", Font.BOLD, 30));
		String dir = System.getProperty("user.dir");
		
		JLabel lblIcono = new JLabel("");
		lblIcono.setHorizontalAlignment(SwingConstants.LEFT);
		panelSuperior.add(lblIcono);
		lblIcono.setIcon(new ImageIcon(dir +"\\iconos\\iconBus.png"));
		panelSuperior.add(lblTitulo);
		JPanel panelCentral = new JPanel();
		panelCentral.setBackground(new Color(32, 83, 117));
		panelCentral.setLayout(null);
		panelLayout.add(panelCentral, BorderLayout.CENTER);
		
		
		//TEXTFIELDS
		TFNroParada = new JTextField();
		TFNroParada.setBounds(30, 45, 86, 20);
		TFNroParada.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(c <'0' || c > '9') e.consume();
			}
		});
		TFNroParada.setColumns(10);
		
		TFCalle = new JTextField();
		TFCalle.setBounds(30, 90, 86, 20);
		TFCalle.setColumns(10);
		
		TFNumero = new JTextField();
		TFNumero.setBounds(30, 135, 86, 20);
		TFNumero.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(c <'0' || c > '9') e.consume();
			}
			});
		TFNumero.setColumns(10);
		
		
		//BOTONES
		JButton btnCrear = new JButton("Crear");
		btnCrear.setBounds(235,161,80,30);
		ActionListener actionAgregar = e ->{
			
			
			if(TFNroParada.getText().length()==0 || TFNumero.getText().length()==0 || TFCalle.getText().length()==0) {
				JOptionPane.showMessageDialog(null, "Los campos no pueden estar vacios", "Error", JOptionPane.WARNING_MESSAGE);
			}
			
			else {
			
			DTOParada nuevaParada = new DTOParada();
			nuevaParada.setNroParada(Integer.parseInt(TFNroParada.getText()));
			nuevaParada.setCalle(TFCalle.getText());
			nuevaParada.setNroCalle(Integer.parseInt(TFNumero.getText()));
			
			if(ParadaDAO.paradaExiste(nuevaParada.getNroParada())==true) {
			JOptionPane.showMessageDialog(null, "El número de parada ingresado ya existe", "Error", JOptionPane.WARNING_MESSAGE);
			}
			else {
				GestorParada.agregarParada(nuevaParada); 
				JOptionPane.showMessageDialog(null, "Nueva parada registrada", "Exito", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		};
		
		
		btnCrear.addActionListener(actionAgregar);
		
		JButton btnBack = new JButton("Atras");
		
		JLabel lblNroParada = new JLabel("Numero de parada");
		lblNroParada.setBounds(126, 47, 102, 14);
		
		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setBounds(126, 92, 102, 14);
		
		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setBounds(126, 137, 102, 14);
		
		panelCentral.add(btnBack);
		panelCentral.add(lblNroParada);
		panelCentral.add(TFNroParada);
		panelCentral.add(lblCalle);
		panelCentral.add(TFCalle);
		panelCentral.add(lblNumero);
		panelCentral.add(TFNumero);
		panelCentral.add(btnCrear);
		
	}
}

