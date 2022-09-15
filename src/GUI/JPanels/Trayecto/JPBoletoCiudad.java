package GUI.JPanels.Trayecto;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import DTO.DTOCamino;
import DTO.DTOParada;
import GUI.Componentes.BotonAtras;
import GUI.Componentes.BotonIcono;
import GUI.Componentes.BotonNodo;
import GUI.Componentes.UbicacionParada;
import enums.EnumColor;
import system.clases.AutobusEconomico;
import system.clases.AutobusSuperior;
import system.clases.InformacionCamino;
import system.clases.Parada;
import system.clases.DAO.CaminoDAO;
import system.gestores.GestorBoleto;
import system.gestores.GestorParada;

public class JPBoletoCiudad extends JPanel {
	
	private int idPrimerParada;
	private int idUltimaParada;
	BotonIcono btnCheck = new BotonIcono("iconCheck.png");
	ArrayList<Integer> paradasPosibles = new ArrayList<Integer>();
	ArrayList<InformacionCamino> caminosPosibles = new ArrayList<InformacionCamino>();
	ArrayList<DTOParada> listaParadas;
	ArrayList<DTOCamino> listaCaminos;
	Map <Integer, BotonNodo> nodosCiudad = new HashMap<Integer, BotonNodo>();
	ArrayList<ArrayList<DTOCamino>> listaCaminosTrayectos = new ArrayList<ArrayList<DTOCamino>>();
	DTOParada nodoOrigen= new DTOParada();
	ArrayList<AutobusEconomico> ae = new ArrayList<AutobusEconomico>();
	ArrayList<AutobusSuperior> as = new ArrayList<AutobusSuperior>();
	JComboBox criterio = new JComboBox(new String[] {"Ver todos","M�s barato","M�s corto","M�s r�pido"});
	
	
	public JPBoletoCiudad (JPanel panelCentral,JPanel panelManipular, JLabel lblTitulo, BotonIcono botonBoleto){
		
		ArrayList<AutobusEconomico> ae = new ArrayList<AutobusEconomico>();
		ArrayList<AutobusSuperior> as = new ArrayList<AutobusSuperior>();
		
		lblTitulo.setText("COMPRAR BOLETO");
		this.setBackground(new Color(32, 83, 117));
		this.setLayout(null);
		panelCentral.setVisible(false);
		btnCheck.setBounds(85, 35, 70, 70);
		btnCheck.setVisible(true);
		btnCheck.setEnabled(false);
		listaParadas = GestorParada.obtenerTodas();
		listaCaminos = CaminoDAO.obtenerCaminos();
		criterio.setBounds(10,200,150,40);
		criterio.setAlignmentX(CENTER_ALIGNMENT);
		criterio.setVisible(false);
		
		this.add(criterio);
		
		
		for (DTOParada parada: listaParadas){
			
			BotonNodo nuevaParada = new BotonNodo(parada, null);
			
			listenerOrigen(nuevaParada);
			
			this.add(nuevaParada);
			nodosCiudad.put(parada.getNroParada(),nuevaParada);
		}
		
		BotonAtras botonAtras = new BotonAtras(true);
		this.add(botonAtras);
		this.add(btnCheck);
		
		botonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelManipular.setVisible(true);
				deshabilitar();
				lblTitulo.setText("SISTEMA AUTOBUS");
				panelCentral.setVisible(true);
				botonBoleto.setVisible(true);
			}
		});
		setearOrigen();
		
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i=0;i<listaParadas.size();i++) {
					BotonNodo btn = nodosCiudad.get(listaParadas.get(i).getNroParada());
					btn.limpiarActions();
					if (paradasPosibles.contains(btn.infoParada().getNroParada())) {
						listenerDestino(btn);
					}
				}
				
			}
		});
		
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if (!paradasPosibles.isEmpty()) {
			btnCheck.setEnabled(true);
		}
		else btnCheck.setEnabled(false);

		for (Integer paradaP : paradasPosibles) { 
			nodosCiudad.get(paradaP).setBorder((BorderFactory.createLineBorder(Color.RED)));
		}
		
		if (nodoOrigen.getNroParada() != 0) {
			nodosCiudad.get(nodoOrigen.getNroParada()).setColor(EnumColor.GREEN);
			}
		
		for(DTOCamino camino : listaCaminos) {
		
		g.setColor(Color.black);	
		
		DTOParada IDOrigen = new DTOParada();
		DTOParada IDDestino = new DTOParada();
		DTOParada origen,destino;
		
		IDOrigen.setNroParada(camino.getIdOrigen());
		IDDestino.setNroParada(camino.getIdDestino());
	
		int posO = listaParadas.indexOf(IDOrigen);
		int posD = listaParadas.indexOf(IDDestino);
		
		origen = listaParadas.get(posO);
		destino = listaParadas.get(posD);
		
		UbicacionParada U_Origen = new UbicacionParada(origen);
		UbicacionParada U_Destino = new UbicacionParada(destino);
		
		g.drawLine(U_Origen.getX(), U_Origen.getY(), U_Destino.getX(), U_Destino.getY());
		}
		
		g.setColor(Color.green);
		
		for(InformacionCamino unaInfo : caminosPosibles) {
			
			if(caminosPosibles.indexOf(unaInfo)==0) g.setColor(Color.GREEN);
			if(caminosPosibles.indexOf(unaInfo)==1) g.setColor(Color.MAGENTA);
			if(caminosPosibles.indexOf(unaInfo)==2) g.setColor(Color.yellow);
			
			for (DTOCamino unCamino: unaInfo.getRecorrido()) {
				
				DTOParada IDOrigen = new DTOParada();
				DTOParada IDDestino = new DTOParada();
				DTOParada origen,destino;
			
				IDOrigen.setNroParada(unCamino.getIdOrigen());
				IDDestino.setNroParada(unCamino.getIdDestino());
			
				int posO = listaParadas.indexOf(IDOrigen);
				int posD = listaParadas.indexOf(IDDestino);
				
				origen = listaParadas.get(posO);
				destino = listaParadas.get(posD);
				
				UbicacionParada U_Origen = new UbicacionParada(origen);
				UbicacionParada U_Destino = new UbicacionParada(destino);
				
				g.drawLine(U_Origen.getX(), U_Origen.getY(), U_Destino.getX(), U_Destino.getY());
			}
		}
		
	}
	

	public void deshabilitar() {
		this.setVisible(false);
	}
	
	private void setearOrigen() {
		idPrimerParada = nodoOrigen.getNroParada();
		if (nodoOrigen.getNroCalle()==0) {
			new Timer().schedule(new TimerTask() {
				 public void run() {
					 JOptionPane.showMessageDialog(null, "Seleccionar la parada de origen",null, JOptionPane.INFORMATION_MESSAGE);
				    }
			}, 300);
		}
	}
	
	public static void setearParadasPosibles(ArrayList<Parada> posibles, ArrayList<ArrayList<DTOCamino>> listaCaminos) {
		for (ArrayList<DTOCamino> unTrayecto:listaCaminos) {
			for (DTOCamino unCamino:unTrayecto) {
//				System.out.println("UnCamino"+unCamino.getIdOrigen()+"->"+unCamino.getIdDestino());
			}
			GestorBoleto.agregarParadasPosible(posibles, unTrayecto);
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
	
	public static void setearCaminosPosibles (int idParada, ArrayList<ArrayList<DTOCamino>> listaCaminos,ArrayList<AutobusEconomico> ae, ArrayList<AutobusSuperior> as) {
		for (AutobusEconomico unAutobus:ae) {
			listaCaminos.add(GestorBoleto.caminoRecortadoInicio(idParada, unAutobus.getRecorridoLinea()));
		}
		
		for (AutobusSuperior unAutobus:as) {
			listaCaminos.add(GestorBoleto.caminoRecortadoInicio(idParada, unAutobus.getRecorridoLinea()));
		}
	}
	
	public void setNodoOrigen(DTOParada parada) {
		nodoOrigen = parada;
	}
	
	public void listenerDestino(BotonNodo parada) {
		
		MouseListener setearActionDestino = new MouseListener() {
		
			@Override
			public void mouseClicked(MouseEvent e) {
				idUltimaParada=parada.infoParada().getNroParada();
				if (paradasPosibles.contains(idUltimaParada)) {
					GestorBoleto.calcularCaminosPosibles(nodoOrigen.getNroParada(), idUltimaParada, ae, as, caminosPosibles);
					GestorBoleto.ordenarPorCriterio(1, caminosPosibles);
					criterio.setVisible(true);
					revalidate();
					repaint();
					for (InformacionCamino caminos: caminosPosibles ) {
						System.out.println("Ruta: " + caminosPosibles.indexOf(caminos));
						System.out.println("Duracion: "+ caminos.getDuracion());
						System.out.println("Distancia: " + caminos.getDistancia());
						System.out.println("Costo: "+ caminos.getCosto());
						}
				};
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		};
		
		parada.addMouseListener(setearActionDestino);
	}
	
	public void listenerOrigen(BotonNodo parada) {
		
		MouseListener setearActionDestino = new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (nodoOrigen.getNroParada()!=0) {
					nodosCiudad.get(nodoOrigen.getNroParada()).resetColor();
					
					for (Integer paradaP : paradasPosibles) {
						nodosCiudad.get(paradaP).resetColor();
					}
					
				}
				
				setNodoOrigen(parada.infoParada());
				Parada unaParada;
				unaParada =  GestorParada.obtenerParada(parada.infoParada().getNroParada());
				if (unaParada.getNroParada() != -1) {
					idPrimerParada = unaParada.getNroParada();
					GestorBoleto.cargarLineasQueContienenParada(unaParada.getNroParada(),ae,as);
					listaCombo(paradasPosibles,unaParada.getNroParada(),ae,as);
					revalidate();
					repaint();
				}
				else {
					//MOSTRAR MENSAJE DE INGRESAR NUEVA PARADA
				}
				}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		};
		
		parada.addMouseListener(setearActionDestino);
	}
	
	public void resetearActions() {
		for (DTOParada parada : listaParadas) {
			nodosCiudad.get(parada).limpiarActions();
			listenerOrigen(nodosCiudad.get(parada));
		}
	}

	
	public JPBoletoCiudad getPanel() {
		return this;
	}
	
	public void setColor(int n) {
		Graphics g = this.getGraphics();
		if(n==0) g.setColor(Color.GREEN);
		if(n==1) g.setColor(Color.MAGENTA);
		if(n==2) g.setColor(Color.yellow);
		if(n==4) g.setColor(Color.yellow);
	}
	
}
