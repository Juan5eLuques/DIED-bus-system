package GUI.JPanels.Boleto;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
import system.clases.InformacionCamino;
import system.clases.Parada;
import system.gestores.GestorAutobus;
import system.gestores.GestorBoleto;
import system.gestores.GestorParada;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class JPBoleto extends JPanel {
	
	private int idPrimerParada;
	private int idUltimaParada;
	
	
	public JPBoleto(JPanel panelCentral,JPanel panelManipular, JLabel lblTitulo, BotonIcono botonBoleto) {	

		ArrayList<InformacionCamino> caminosPosibles = new ArrayList<InformacionCamino>();
		ArrayList<AutobusEconomico> ae = new ArrayList<AutobusEconomico>();
		ArrayList<AutobusSuperior> as = new ArrayList<AutobusSuperior>();
		ArrayList<ArrayList<DTOCamino>> listaCaminos = new ArrayList<ArrayList<DTOCamino>>();
		ArrayList<Integer> paradasPosibles = new ArrayList<Integer>();
		JButton btnBuscar = new JButton("Buscar");
		panelCentral.setVisible(false);
		lblTitulo.setText("Compra de boleto");
		String[] opciones = new String[] {};

		BotonAtras botonAtras = new BotonAtras(true);

		this.add(botonAtras);
		this.setLayout(null);
		this.setBackground(new Color(32, 83, 117));
		TextFieldNumbers TFidParadaOrigen = new TextFieldNumbers();
		JComboBox JCidParadaDestino = new JComboBox(opciones);
		BotonIcono botonComprar = new BotonIcono("iconComprar.png");
		botonComprar.setEnabled(false);
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



		//Accion que se realiza cuando se selecciona la parada final: Aca se deben mostrar los posibles caminos con sus tiempos distancias y costos
		ActionListener actionSeleccionarParadaFinal = e ->{
			idUltimaParada = (Integer)JCidParadaDestino.getSelectedItem();
			System.out.println("JPBOLETO::Calcular caminos desde "+idPrimerParada+" hasta "+idUltimaParada); //BORRAR
			
			GestorBoleto.calcularCaminosPosibles(idPrimerParada, idUltimaParada, ae, as, caminosPosibles);
			GestorBoleto.ordenarPorCriterio(1, caminosPosibles);
			System.out.println("JPBOLETO::IMPRIMIR INFORMACION DE CAMINOS POSIBLES: "); //BORRAR
			System.out.println("caminos posibles: "+caminosPosibles.size()); //BORRAR
//			for(InformacionCamino unCamino:caminosPosibles) {
//				System.out.println("Linea: "+ unCamino.getAutobus().getId());
//				System.out.println("Tipo: "+ unCamino.getAutobus().getTipo());
//				System.out.println("Distancia: "+ unCamino.getDistancia());
//				System.out.println("Duracion: "+ unCamino.getDuracion());
//				System.out.println("Costo: "+ unCamino.getCosto());
//				System.out.println("Recorrido: ");
//				unCamino.mostrarRecorrido();
//				}
			for (ArrayList<DTOCamino> unTrayecto:listaCaminos) {
				for (DTOCamino unCamino:unTrayecto) {
					System.out.println("UnCamino"+unCamino.getIdOrigen()+"->"+unCamino.getIdDestino());
				}
			}
		};

		//Accion que se realiza al seleccionar la parada inicial:  
		//si existe, carga las lineas que pasan por ella en ae y as,calcular las paradas posibles, 
		//mostrarlas en el combo, y cambiar la accion por la de seleccionar parada final
		//Para cambiar la accion primero hay que remover la actual, sino se ejecutan las dos
		ActionListener actionBuscarPrimerParada = e ->{
			Parada unaParada;
			unaParada =  GestorParada.obtenerParada(Integer.parseInt(TFidParadaOrigen.getText()));
			if (unaParada.getNroParada() != -1) {
				idPrimerParada = unaParada.getNroParada();
				GestorBoleto.cargarLineasQueContienenParada(unaParada.getNroParada(),ae,as);
				listaCombo(paradasPosibles,unaParada.getNroParada(),ae,as);

				lblParadaOrigen.setVisible(false);
				TFidParadaOrigen.setVisible(false);
				JCidParadaDestino.setModel(new DefaultComboBoxModel(paradasPosibles.toArray()));
				JCidParadaDestino.setVisible(true);
				lblParadaDestino.setVisible(true);
				btnBuscar.setBounds(409, 95, 180, 30);
				btnBuscar.setText("Ver caminos");
				btnBuscar.removeActionListener(btnBuscar.getActionListeners()[0]);
				btnBuscar.addActionListener(actionSeleccionarParadaFinal);
			}
			else {
				//MOSTRAR MENSAJE DE INGRESAR NUEVA PARADA
			}
		};

		btnBuscar.setBounds(409, 95, 89, 30);
		btnBuscar.addActionListener(actionBuscarPrimerParada);
		add(btnBuscar);

		botonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelManipular.setVisible(true);
				deshabilitar();
				lblTitulo.setText("SISTEMA AUTOBUS");
				panelCentral.setVisible(true);
				botonBoleto.setVisible(true);
			}
		});

		botonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelManipular.setVisible(true);
				deshabilitar();
				lblTitulo.setText("SISTEMA AUTOBUS");
				panelCentral.setVisible(true);
			}
		});
		
	}

	//devuelve la lista de todas las paradas de una lista de caminos
	public static void setearParadasPosibles(ArrayList<Parada> posibles, ArrayList<ArrayList<DTOCamino>> listaCaminos) {
		for (ArrayList<DTOCamino> unTrayecto:listaCaminos) {
			for (DTOCamino unCamino:unTrayecto) {
				System.out.println("UnCamino"+unCamino.getIdOrigen()+"->"+unCamino.getIdDestino());
			}
			GestorBoleto.agregarParadasPosible(posibles, unTrayecto);
		}

	}
	
	//Devuelve una version recortada de los caminos (Se recorta por el inicio, es decir, todas las paradas anteriores a "idParada")
	public static void setearCaminosPosibles (int idParada, ArrayList<ArrayList<DTOCamino>> listaCaminos,ArrayList<AutobusEconomico> ae, ArrayList<AutobusSuperior> as) {
		for (AutobusEconomico unAutobus:ae) {
			listaCaminos.add(GestorBoleto.caminoRecortadoInicio(idParada, unAutobus.getRecorridoLinea()));
		}
		
		for (AutobusSuperior unAutobus:as) {
			listaCaminos.add(GestorBoleto.caminoRecortadoInicio(idParada, unAutobus.getRecorridoLinea()));
		}
	}
	
	//A partir de la parada seleccionada como inicial, recorta los caminos que pasan por esta y los guarda en "caminosPosibles"
	//Con esta lista de caminos, devuelve una lista (int) de idParada posibles en "idParadas"
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