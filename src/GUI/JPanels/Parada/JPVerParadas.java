package GUI.JPanels.Parada;

import java.awt.Color;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import DTO.DTOParada;
import GUI.Componentes.BotonAtras;
import system.clases.Parada;
import system.gestores.GestorParada;

public class JPVerParadas extends JPanel {
	
	
	private int cantColumnas = 4;
	
	private ArrayList<DTOParada> paradas = GestorParada.obtenerTodas();
	
	public JPVerParadas(JPanel panelManipular, JLabel lblTitulo) {
	
		lblTitulo.setText("VER PARADAS");
		
		BotonAtras boton = new BotonAtras(true);
		this.add(boton);
		this.setLayout(null);
		this.setBackground(new Color(32, 83, 117));
		
		String[] columnas = {"IDParada","Calle","Activa","NroCalle"};
		
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(150,110,600,420);
		this.add(scroll);
		
		DefaultTableModel model = new DefaultTableModel();
		JTable tabla = new JTable();
		tabla.setModel(model);
		model.addColumn("ID");
		model.addColumn("Calle");
		model.addColumn("Activa");
		model.addColumn("NroCalle");
		
		for (DTOParada unaParada : paradas) {
			Object[] matrizInfo = new Object[4];
			matrizInfo[0] = unaParada.getNroParada();
			matrizInfo[1] = unaParada.getCalle();
			matrizInfo[2] = unaParada.isActiva();
			matrizInfo[3] = unaParada.getNroCalle();
			
			model.addRow(matrizInfo);
		}
		tabla.setBackground(null);
		tabla.setRowHeight(20);
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
