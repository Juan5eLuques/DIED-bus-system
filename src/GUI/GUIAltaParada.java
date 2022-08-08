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
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUIAltaParada extends JFrame {

	private JPanel contentPane;
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
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		GridBagLayout gbl_panelDeControl = new GridBagLayout();
		gbl_panelDeControl.columnWidths = new int[]{149, 0, 0, 0, 0, 0, 24, 158, 0, 0, 0, 0, 0, 0, 0, 0, 235, 0};
		gbl_panelDeControl.rowHeights = new int[]{20, 0};
		gbl_panelDeControl.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelDeControl.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		
		
		//TEXTFIELDS
		TFNroParada = new JTextField();
		TFNroParada.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(c <'0' || c > '9') e.consume();
			}
		});
		TFNroParada.setColumns(10);
		
		TFCalle = new JTextField();
		TFCalle.setColumns(10);
		
		TFNumero = new JTextField();
		TFNumero.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(c <'0' || c > '9') e.consume();
			}
			});
		TFNumero.setColumns(10);
		
		
		//BOTONES
		JButton btnAgregar = new JButton("Agregar");
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
				JOptionPane.showMessageDialog(null, "Nueva parada registrada", "Exito", JOptionPane.OK_OPTION);
				}
			}
		};
		
		
		btnAgregar.addActionListener(actionAgregar);
		
		JButton btnBack = new JButton("Atras");
		
		JLabel lblNroParada = new JLabel("Numero de parada");
		
		JLabel lblCalle = new JLabel("Calle");
		
		JLabel lblNumero = new JLabel("Numero");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(TFNroParada, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNroParada)
						.addComponent(lblCalle)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(TFCalle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnAgregar))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnBack)
								.addComponent(lblNumero)
								.addComponent(TFNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(221, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(17)
					.addComponent(lblNroParada)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(TFNroParada, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCalle)
						.addComponent(lblNumero))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(TFCalle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(TFNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAgregar)
						.addComponent(btnBack))
					.addContainerGap(95, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
}

