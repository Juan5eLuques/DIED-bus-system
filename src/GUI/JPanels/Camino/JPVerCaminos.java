package GUI.JPanels.Camino;

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

import DTO.DTOCamino;
import GUI.Componentes.BotonAtras;
import system.gestores.GestorCamino;

public class JPVerCaminos extends JPanel{
	

	String[] columnas = {"ParadaOrigen","ParadaDestino","Distancia","Duracion"};
	
	ArrayList<DTOCamino> caminos = GestorCamino.obtenerCaminos();
	
	public JPVerCaminos(JPanel panelManipular, JLabel lblTitulo) {

		
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(50,150,800,350);
		this.add(scroll);
		
		DefaultTableModel model = new DefaultTableModel();
		
		JTable tabla = new JTable();
		tabla.setModel(model);
		model.addColumn("ParadaOrigen");
		model.addColumn("ParadaDestino");
		model.addColumn("Distancia");
		model.addColumn("Duracion");
		
		for (DTOCamino unCamino : caminos) {
			Object[] matrizInfo = new Object[8];
			matrizInfo[0] = unCamino.getIdOrigen();
			matrizInfo[1] = unCamino.getIdDestino();
			matrizInfo[2] = unCamino.getDistancia();
			matrizInfo[3] = unCamino.getDuracion();
			
			model.addRow(matrizInfo);
		}
		
		tabla.setRowHeight(80);
		tabla.getColumnModel().getColumn(1).setPreferredWidth(100);
		tabla.getColumnModel().getColumn(2).setPreferredWidth(100);
		tabla.getColumnModel().getColumn(3).setPreferredWidth(100);
		
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
		
		tabla.setAutoCreateRowSorter(true);
		
		BotonAtras boton = new BotonAtras(true);
		this.add(boton);
		this.setLayout(null);
		this.setBackground(new Color(32, 83, 117));
		
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
	
	public JPVerCaminos getPanel() {
		return this;
	}
}
