package GUI.JPanels.Trayecto;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import DTO.DTOCamino;
import DTO.DTOParada;
import GUI.GUIInfoNodo;
import GUI.GUIInfoTrayecto;
import GUI.Componentes.BotonAtras;
import GUI.Componentes.BotonIcono;
import GUI.Componentes.BotonNodo;
import GUI.Componentes.UbicacionParada;
import enums.EnumColor;
import system.clases.AutobusEconomico;
import system.clases.AutobusSuperior;
import system.clases.InformacionCamino;
import system.clases.Parada;
import system.gestores.GestorBoleto;
import system.gestores.GestorCamino;
import system.gestores.GestorGUI;
import system.gestores.GestorParada;

public class JPBoletoCiudad extends JPanel {
	
	private int idPrimerParada;
	private int idUltimaParada;
	Font fontLbl = new Font("Century Gothic", Font.BOLD, 15);
	BotonIcono btnCheck = new BotonIcono("iconCheck.png");
	ArrayList<Integer> paradasPosibles = new ArrayList<Integer>();
	ArrayList<InformacionCamino> caminosPosibles = new ArrayList<InformacionCamino>();
	ArrayList<InformacionCamino> caminosPosiblesFiltrados = new ArrayList<InformacionCamino>();
	ArrayList<DTOParada> listaParadas;
	ArrayList<DTOCamino> listaCaminos;
	Map <Integer, BotonNodo> nodosCiudad = new HashMap<Integer, BotonNodo>();
	ArrayList<ArrayList<DTOCamino>> listaCaminosTrayectos = new ArrayList<ArrayList<DTOCamino>>();
	DTOParada nodoOrigen= new DTOParada();
	ArrayList<AutobusEconomico> ae = new ArrayList<AutobusEconomico>();
	ArrayList<AutobusSuperior> as = new ArrayList<AutobusSuperior>();
	JComboBox criterio = new JComboBox(new String[] {"Sin filtro","Más barato","Más rápido","Más corto"});
	JComboBox<String> trayectoDescripcion = new JComboBox<String>(new String[] {"Ver todos"});
	BotonIcono botonComprar = new BotonIcono("iconComprar.png");
	JLabel lblCriterio = new JLabel("Filtro de camino");
	JLabel lblDescripcion = new JLabel("Selecc. camino");
	JButton btnVerDescripcion = new JButton("Ver descripcion");
	InformacionCamino informacionDescripcion = new InformacionCamino();
	private int numTrayectoFiltrado;
	
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
		listaCaminos = GestorCamino.obtenerCaminos();
		
		botonComprar.setEnabled(false);
		botonComprar.setVisible(true);
		botonComprar.setBounds(30,470,100,100);
		
		this.add(botonComprar);
		
		criterio.setBounds(10,170,150,30);
		criterio.setAlignmentX(CENTER_ALIGNMENT);
		criterio.setVisible(false);
		criterio.setSelectedIndex(0);
		criterio.setFocusable(false);
		
		lblCriterio.setBounds(20,140,150,30);
		lblCriterio.setForeground(Color.white);
		lblCriterio.setFont(fontLbl);
		lblDescripcion.setFont(fontLbl);
		lblCriterio.setVisible(false);
		lblDescripcion.setBounds(20,240,150,30);
		trayectoDescripcion.setBounds(10,270,150,30);
		trayectoDescripcion.setSelectedIndex(0);
		trayectoDescripcion.setFocusable(false);
		lblDescripcion.setForeground(Color.white);
		lblDescripcion.setVisible(false);
		trayectoDescripcion.setVisible(false);
		btnVerDescripcion.setBounds(10,370,150,50);
		btnVerDescripcion.setVisible(false);
		btnVerDescripcion.setEnabled(false);
		btnVerDescripcion.setBackground(new Color(107, 227, 162));
		btnVerDescripcion.setFocusable(false);
		btnVerDescripcion.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		
		this.add(lblDescripcion);
		this.add(lblCriterio);
		this.add(criterio);
		this.add(btnVerDescripcion);
		this.add(trayectoDescripcion);
		
		
		((JLabel)criterio.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		((JLabel)trayectoDescripcion.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		
		btnVerDescripcion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (criterio.getSelectedIndex()==0) {
				GUIInfoTrayecto info = new GUIInfoTrayecto(informacionDescripcion, trayectoDescripcion.getSelectedIndex()+"");
				info.setResizable(false);
				info.setVisible(true);
				}
				else {
					GUIInfoTrayecto info = new GUIInfoTrayecto(informacionDescripcion, criterio.getSelectedItem().toString().substring(4));
					info.setResizable(false);
					info.setVisible(true);
				}
			}
		});
		
		
		botonComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnVerDescripcion.isEnabled()) {
					int result = JOptionPane.showConfirmDialog(getPanel(), "Desea comprar un boleto para la linea : " +informacionDescripcion.getAutobus().getNombre() + " ?");
					if (result == JOptionPane.YES_OPTION) {
						GestorBoleto.guardarBoleto(informacionDescripcion);
						JOptionPane.showMessageDialog(null,"Compra realizada con exito ! ");
					}
				}
			}
		});
		
		criterio.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (criterio.getSelectedIndex()!=0) {
				GestorBoleto.ordenarPorCriterio(criterio.getSelectedIndex(), caminosPosiblesFiltrados);
				trayectoDescripcion.setEnabled(false);
				btnVerDescripcion.setEnabled(true);
				informacionDescripcion = caminosPosiblesFiltrados.get(0);
				}
				else {
					if (trayectoDescripcion.getSelectedIndex()==0) btnVerDescripcion.setEnabled(false);
					trayectoDescripcion.setEnabled(true);
				}
				repaint();
				revalidate();
			}
				});
		
		
		trayectoDescripcion.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (trayectoDescripcion.getSelectedIndex()!=0) {
				numTrayectoFiltrado = trayectoDescripcion.getSelectedIndex()-1;
				btnVerDescripcion.setEnabled(true);
				}
				else {
					trayectoDescripcion.setEnabled(true);
					btnVerDescripcion.setEnabled(false);
				}
				repaint();
				revalidate();
			}
				});
		
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
		
		GestorGUI.dibujarCamino(g, U_Origen.getX(), U_Origen.getY(), U_Destino.getX(), U_Destino.getY(), Color.black);
		}
		
		g.setColor(Color.green);
		
		if (criterio.getSelectedIndex()==0 && trayectoDescripcion.getSelectedIndex()==0) {
			
		for(InformacionCamino unaInfo : caminosPosibles) {
			
			if(caminosPosibles.indexOf(unaInfo)==0) g.setColor(Color.green);
			if(caminosPosibles.indexOf(unaInfo)==1) g.setColor(Color.MAGENTA);
			if(caminosPosibles.indexOf(unaInfo)==2)  g.setColor(Color.YELLOW);
		
			
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
				
				GestorGUI.dibujarCamino(g, U_Origen.getX(), U_Origen.getY(), U_Destino.getX(), U_Destino.getY(), Color.green);
			
				}
			}
			
		}
		
		else {
		
			if (criterio.getSelectedIndex()!=0) {

				for (DTOCamino unCamino: caminosPosiblesFiltrados.get(0).getRecorrido()) {
			
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
			
				GestorGUI.dibujarCamino(g, U_Origen.getX(), U_Origen.getY(), U_Destino.getX(), U_Destino.getY(), Color.green);
				}
			}
			
			if (criterio.getSelectedIndex()==0 && trayectoDescripcion.getSelectedIndex()!=0) {
				
				for(InformacionCamino unaInfo : caminosPosibles) {
					
					if (caminosPosibles.indexOf(unaInfo)==numTrayectoFiltrado) {
					
					informacionDescripcion = unaInfo;
					
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
						
							GestorGUI.dibujarCamino(g, U_Origen.getX(), U_Origen.getY(), U_Destino.getX(), U_Destino.getY(), Color.green);
					
						
							}
						}
					}
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
			GestorBoleto.agregarParadasPosible(posibles, unTrayecto);
		}

	}
	
	public static void listaCombo (ArrayList<Integer>idParadas, int idInicial, ArrayList<AutobusEconomico> ae, ArrayList<AutobusSuperior> as) {
		idParadas.clear();
		ArrayList<ArrayList<DTOCamino>> caminosPosibles = new ArrayList<ArrayList<DTOCamino>>();
		ArrayList<Parada> paradasPosibles = new ArrayList<Parada> ();
		setearCaminosPosibles(idInicial,caminosPosibles,ae,as);
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
					lblCriterio.setVisible(true);
					lblDescripcion.setVisible(true);
					caminosPosiblesFiltrados= caminosPosibles;
					botonComprar.setEnabled(true);
					btnVerDescripcion.setVisible(true);
					trayectoDescripcion.setVisible(true);
					
					if (criterio.getSelectedIndex()==0) {
						trayectoDescripcion.removeAllItems();
						trayectoDescripcion.addItem("Ver todos");
						for (InformacionCamino camino : caminosPosibles) {
							int index = caminosPosibles.indexOf(camino)+1;
							trayectoDescripcion.addItem("Recorrido -> " + index);
						}
						revalidate();
						repaint();
					}
					revalidate();
					repaint();
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
	
	public JPBoletoCiudad getPanel() {
		return this;
	}
	
}
