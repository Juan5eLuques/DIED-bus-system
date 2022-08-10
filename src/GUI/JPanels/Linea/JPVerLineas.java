package GUI.JPanels.Linea;

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
import DTO.DTOParada;
import GUI.Componentes.BotonAtras;
import system.gestores.GestorAutobus;
import system.gestores.GestorParada;

public class JPVerLineas extends JPanel {
	
	private ArrayList<DTOAutobus> lineas = GestorAutobus.obtenerAutobuses();
	
	public JPVerLineas(JPanel panelManipular, JLabel lblTitulo) {
	
		lblTitulo.setText("Listado de lineas");
		
		BotonAtras boton = new BotonAtras(true);
		this.add(boton);
		this.setLayout(null);
		this.setBackground(new Color(32, 83, 117));
		
		String[] columnas = {"IDLinea","Nombre","Color","Tipo","Asientos","Parados","Wifi","AireAcondicionado"};
		
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(50,150,800,350);
		this.add(scroll);
		
		DefaultTableModel model = new DefaultTableModel();
		JTable tabla = new JTable();
		tabla.setModel(model);
		model.addColumn("IDLinea");
		model.addColumn("Nombre");
		model.addColumn("Color");
		model.addColumn("Tipo");
		model.addColumn("Asientos");
		model.addColumn("Parados");
		model.addColumn("Wifi");
		model.addColumn("Aire");
	
		
		for (DTOAutobus unaLinea : lineas) {
			Object[] matrizInfo = new Object[8];
			matrizInfo[0] = unaLinea.getId();
			matrizInfo[1] = unaLinea.getNombre();
			matrizInfo[2] = unaLinea.getColor();
			matrizInfo[3] = unaLinea.getTipo();
			matrizInfo[4] = unaLinea.getAsientos();
			matrizInfo[5] = unaLinea.getPasajerosextra();
			matrizInfo[6] = unaLinea.isWifi();
			matrizInfo[7] = unaLinea.isAire();
		
			
			model.addRow(matrizInfo);
		}

		tabla.setRowHeight(80);
		tabla.getColumnModel().getColumn(1).setPreferredWidth(100);
		tabla.getColumnModel().getColumn(2).setPreferredWidth(100);
		tabla.getColumnModel().getColumn(3).setPreferredWidth(100);
		tabla.getColumnModel().getColumn(4).setPreferredWidth(70);
		tabla.getColumnModel().getColumn(5).setPreferredWidth(70);
		tabla.getColumnModel().getColumn(6).setPreferredWidth(70);
		tabla.getColumnModel().getColumn(7).setPreferredWidth(70);
		
		
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

