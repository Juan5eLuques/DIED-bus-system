package GUI.JPanels.Boleto;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import DTO.DTOCamino;
import GUI.Componentes.BotonAtras;
import GUI.Componentes.BotonIcono;
import GUI.Componentes.LblText;
import GUI.Componentes.TextFieldNumbers;
import system.clases.AutobusEconomico;
import system.clases.AutobusSuperior;
import system.clases.Parada;
import system.gestores.GestorAutobus;
import system.gestores.GestorBoleto;
import system.gestores.GestorParada;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class JPBoleto extends JPanel {
	
	public JPBoleto(JPanel panelCentral,JPanel panelManipular, JLabel lblTitulo, BotonIcono botonBoleto) {
	
	ArrayList<AutobusEconomico> ae = new ArrayList<AutobusEconomico>();
	ArrayList<AutobusSuperior> as = new ArrayList<AutobusSuperior>();
	ArrayList<ArrayList<DTOCamino>> listaCaminos = new ArrayList<ArrayList<DTOCamino>> ();
	ArrayList<Integer> paradasPosibles = new ArrayList<Integer>();
	BotonIcono btnBuscar = new BotonIcono("iconSearch.png");
	panelCentral.setVisible(false);
	lblTitulo.setText("Compra de boleto");
		
	String[] opciones = new String[] {};
	
	BotonAtras boton = new BotonAtras(true);
	JButton botonVerCaminos = new JButton();
	botonVerCaminos.setText("Ver Caminos");
	botonVerCaminos.setBounds(409, 95, 180, 30);
	botonVerCaminos.setVisible(false);
	
	this.add(boton);
	this.setLayout(null);
	this.setBackground(new Color(32, 83, 117));
	TextFieldNumbers TFidParadaOrigen = new TextFieldNumbers();
	JComboBox JCidParadaDestino = new JComboBox(opciones);
	BotonIcono botonComprar = new BotonIcono("iconComprar.png");
	botonComprar.setEnabled(false);
	btnBuscar.setBounds(409, 95, 40, 30);
	
	LblText lblCosto = new LblText("");
	lblCosto.setVisible(false);
	
	
	LblText lblParadaOrigen = new LblText("ParadaOrigen: ");
	lblParadaOrigen.setFont(new Font("Ebrima", Font.BOLD, 20));
	lblParadaOrigen.setText("Parada Origen: ");
	lblParadaOrigen.setBounds(40, 92, 200, 40);
	LblText lblParadaDestino = new LblText("ParadaDestino: ");
	lblParadaDestino.setVisible(false);
	lblParadaDestino.setText("Parada Destino: ");
	lblParadaDestino.setFont(new Font("Ebrima", Font.BOLD, 20));
	lblParadaDestino.setBounds(40, 92, 200, 40);
	
	botonComprar.setBounds(700,455,100,100);
	
	TFidParadaOrigen.setBounds(199,95,200,30);
	JCidParadaDestino.setBounds(199,95,200,30);
	JCidParadaDestino.setVisible(false);
	
	this.add(JCidParadaDestino);
	this.add(TFidParadaOrigen);
	this.add(lblParadaDestino);
	this.add(lblParadaOrigen);
	this.add(botonComprar);
	this.add(botonVerCaminos);
	
	ActionListener actionBuscar = e ->{
		Parada unaParada;
		unaParada =  GestorParada.obtenerParada(Integer.parseInt(TFidParadaOrigen.getText()));
		if (unaParada.getNroParada() != -1) {
			GestorBoleto.cargarLineasQueContienenParada(unaParada.getNroParada(),ae,as);
			listaCombo(paradasPosibles,unaParada.getNroParada(),ae,as);
			
			lblParadaOrigen.setVisible(false);
			TFidParadaOrigen.setVisible(false);
			
			JCidParadaDestino.setModel(new DefaultComboBoxModel(paradasPosibles.toArray()));
			JCidParadaDestino.setVisible(true);
			lblParadaDestino.setVisible(true);
			botonVerCaminos.setVisible(true);
			btnBuscar.setVisible(false);
			
		}
	};
	btnBuscar.addActionListener(actionBuscar);
	add(btnBuscar);
	
	boton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			panelManipular.setVisible(true);
			deshabilitar();
			lblTitulo.setText("SISTEMA AUTOBUS");
			panelCentral.setVisible(true);
			botonBoleto.setVisible(true);
		}
	});
	
	}

	public static void setearParadasPosibles(ArrayList<Parada> posibles, ArrayList<ArrayList<DTOCamino>> listaCaminos) {
		for (ArrayList<DTOCamino> unTrayecto:listaCaminos) {
			for (DTOCamino unCamino:unTrayecto) {
				System.out.println("UnCamino"+unCamino.getIdOrigen()+"->"+unCamino.getIdDestino());
			}
			GestorBoleto.agregarParadasPosible(posibles, unTrayecto);
		}

	}
	
	public static void setearCaminosPosibles (int idParada, ArrayList<ArrayList<DTOCamino>> listaCaminos,ArrayList<AutobusEconomico> ae, ArrayList<AutobusSuperior> as) {
		for (AutobusEconomico unAutobus:ae) {
			listaCaminos.add(GestorBoleto.caminoRecortadoInicio(idParada, unAutobus.getRecorridoLinea()));
		}
		
		for (AutobusSuperior unAutobus:as) {
			listaCaminos.add(GestorBoleto.caminoRecortadoInicio(idParada, unAutobus.getRecorridoLinea()));
		}
	}
	
	public static void listaCombo (ArrayList<Integer>idParadas, int idInicial, ArrayList<AutobusEconomico> ae, ArrayList<AutobusSuperior> as) {
		idParadas.clear();
		ArrayList<ArrayList<DTOCamino>> caminosPosibles = new ArrayList<ArrayList<DTOCamino>>();
		ArrayList<Parada> paradasPosibles = new ArrayList<Parada> ();
		setearCaminosPosibles(idInicial,caminosPosibles,ae,as);
		System.out.println("Cantidad de caminos posibles: "+ caminosPosibles.size());
		setearParadasPosibles(paradasPosibles,caminosPosibles);
		for (Parada unaParada:paradasPosibles) {
			idParadas.add(unaParada.getNroParada());
		}
	}
	public void deshabilitar() {
		this.setVisible(false);
		}
} 