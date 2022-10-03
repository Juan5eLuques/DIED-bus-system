package GUI.JPanels.Incidencia;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DTO.DTOAutobus;
import DTO.DTOIncidencia;
import GUI.Componentes.BotonAtras;
import system.gestores.GestorAutobus;
import system.gestores.GestorIncidencia;

public class JPVerIncidencias extends JPanel {
	
	private ArrayList<DTOIncidencia> incidencias = GestorIncidencia.obtenerTodas();
	
	public JPVerIncidencias(JPanel panelManipular, JLabel lblTitulo) {
	
	lblTitulo.setText("VER INCIDENCIAS");
	
	BotonAtras boton = new BotonAtras(true);
	this.add(boton);
	this.setLayout(null);
	this.setBackground(new Color(32, 83, 117));
	
	String[] columnas = {"ID","ParadaAfectada","Inicio","Final","Descripcion","Resuelto"};
	
	JScrollPane scroll = new JScrollPane();
	scroll.setBounds(50,150,800,350);
	this.add(scroll);
	
	DefaultTableModel model = new DefaultTableModel();
	
	JTable tabla = new JTable();
	
	
	tabla.setOpaque(false);
	scroll.getViewport().setBackground(new Color(17, 43, 60));
	tabla.setModel(model);
	model.addColumn("IDIncidencia");
	model.addColumn("ParadaAfectada");
	model.addColumn("Inicio");
	model.addColumn("Final");
	model.addColumn("Descripcion");
	model.addColumn("Resuelto");
	
	
	
	for (DTOIncidencia unaIncidencia : incidencias) {
		Object[] matrizInfo = new Object[6];
		matrizInfo[0] = unaIncidencia.getIdIncidencia();
		matrizInfo[1] = unaIncidencia.getIdParada();
		matrizInfo[2] = unaIncidencia.getFechaInicio();
		matrizInfo[3] = unaIncidencia.getFechaFin();
		matrizInfo[4] = unaIncidencia.getDescripcion();
		matrizInfo[5] = unaIncidencia.isResuelta();
		
	
		
		model.addRow(matrizInfo);
	}

	tabla.setRowHeight(80);

	tabla.getColumnModel().getColumn(1).setPreferredWidth(100);
	tabla.getColumnModel().getColumn(2).setPreferredWidth(100);
	tabla.getColumnModel().getColumn(3).setPreferredWidth(100);
	tabla.getColumnModel().getColumn(4).setPreferredWidth(70);
	tabla.getColumnModel().getColumn(5).setPreferredWidth(70);
	tabla.setBackground(new Color(17, 43, 60));
	
	tabla.setEnabled(false);
	tabla.setForeground(Color.white);
	tabla.setBackground(new Color(17, 43, 60));
	tabla.setFont(new Font("Ebrima", Font.PLAIN, 15));
	tabla.getTableHeader().setBackground(new Color(17, 43, 60));
	tabla.getTableHeader().setFont(new Font("Ebrima", Font.BOLD, 20));
	tabla.getTableHeader().setForeground(Color.white);
	scroll.setViewportView(tabla);
	scroll.setBackground(new Color(17, 43, 60));
	tabla.getTableHeader().setReorderingAllowed(false);
	
	
	boton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			panelManipular.setVisible(true);
			deshabilitar();
			lblTitulo.setText("SISTEMA AUTOBUS");
		}
	});
	}
	
	public void deshabilitar() {
		this.setVisible(false);
		}
}
