package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import DTO.DTOParada;
import system.clases.Parada;
import system.clases.DAO.ParadaDAO;
import system.gestores.GestorParada;
import java.awt.event.ActionEvent;

public class GUIBusquedaParada extends JFrame {

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
					GUIBusquedaParada frame = new GUIBusquedaParada();
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
	public GUIBusquedaParada() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//TEXTFIELDS
		TFNroParada = new JTextField();
		TFNroParada.setBounds(15, 42, 86, 20);
		TFNroParada.setColumns(10);
		
		TFCalle = new JTextField();
		TFCalle.setEditable(false);
		TFCalle.setBounds(15, 100, 86, 20);
		TFCalle.setColumns(10);
		
		TFNumero = new JTextField();
		TFNumero.setEditable(false);
		TFNumero.setBounds(119, 100, 86, 20);
		TFNumero.setColumns(10);
		
		//BOTONES
		JButton btnEliminar = new JButton("Eliminar");
		ActionListener actionEliminar = e -> {
			CaminoDAO.eliminarCaminosConParada(Integer.parseInt(TFNroParada.getText()));
			ParadaDAO.eliminarParada(Integer.parseInt(TFNroParada.getText()));
		};
		btnEliminar.addActionListener(actionEliminar);
		btnEliminar.setEnabled(false);

		btnEliminar.setBounds(15, 138, 71, 23);		
		JButton btnBack = new JButton("Atras");
		btnBack.setBounds(119, 138, 59, 23);
		
		JLabel lblNroParada = new JLabel("Numero de parada");
		lblNroParada.setBounds(15, 22, 89, 14);
		
		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setBounds(15, 80, 23, 14);
		
		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setBounds(119, 80, 37, 14);
		contentPane.setLayout(null);
		
		JButton btnBuscar = new JButton("Buscar");

		ActionListener actionBuscar = e ->{
			System.out.println("Buscar parada nro: "+TFNroParada.getText()); //BORRAR
			Parada paradaBuscada = ParadaDAO.obtenerParada(Integer.parseInt(TFNroParada.getText()));
			if (paradaBuscada.getNroParada() == -1) {
				System.out.println("No se encontro la parada");
			}
			else {
				TFNumero.setText(Integer.toString(paradaBuscada.getNroCalle()));
				TFCalle.setText(paradaBuscada.getCalle());
				btnEliminar.setEnabled(true);
				}
		};
		btnBuscar.addActionListener(actionBuscar); 
		btnBuscar.setBounds(119, 41, 89, 23);
		contentPane.add(btnBuscar);
		
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
								.addComponent(btnEliminar))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnBack)
								.addComponent(lblNumero)
								.addComponent(TFNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(224, Short.MAX_VALUE))
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
						.addComponent(btnEliminar)
						.addComponent(btnBack))
					.addContainerGap(95, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		
	}

}
