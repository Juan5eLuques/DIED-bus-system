package GUI.JPanels.Trayecto;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import DTO.DTOCamino;
import DTO.DTOParada;
import GUI.Componentes.BotonIcono;
import GUI.Componentes.BotonMenu;
import GUI.Componentes.BotonNodoTrayecto;
import GUI.Componentes.UbicacionParada;
import GUI.JPanels.Linea.JPAgregarLinea;
import system.gestores.GestorCamino;
import system.gestores.GestorGUI;
import system.gestores.GestorParada;

public class JPGuardarTrayecto extends JPanel {

	ArrayList<DTOParada> listaParadas;
	ArrayList<DTOCamino> listaCaminos;
	ArrayList<DTOCamino> trayectoLinea = new ArrayList<DTOCamino>();
	public ArrayList<DTOParada> listaParadasTrayecto = new ArrayList<DTOParada>();
	ArrayList<DTOCamino> listaPosibles = new ArrayList<DTOCamino>();
	
	private static final long serialVersionUID = 1L;

	public JPGuardarTrayecto(JPAgregarLinea panel, BotonIcono botonGuardarManipular) {
		
		this.setBackground(new Color(32, 83, 117));
		this.setLayout(null);
		
		listaParadas = GestorParada.obtenerTodas();
		listaCaminos = GestorCamino.obtenerCaminos();
		
		for (DTOParada parada: listaParadas){
		BotonNodoTrayecto nuevaParada = new BotonNodoTrayecto(parada,listaParadasTrayecto,this,listaPosibles);
		this.add(nuevaParada);
		}
		
		if (listaParadasTrayecto.size()==0) {
			new Timer().schedule(new TimerTask() {
				 public void run() {
					 elegirPuntoInicial();
				    }
			}, 300);
		}
		
		BotonIcono botonGuardar = new BotonIcono("iconGuardar.png");
		botonGuardar.setBounds(30,470,100,100);
		this.add(botonGuardar);
		
		JLabel lblGuardar = new JLabel("Guardar");
		JLabel lblDeshacer = new JLabel("Deshacer");
		
		lblGuardar.setBounds(55,560, 100,30);
		lblDeshacer.setBounds(55,155, 100,30);
		
		lblGuardar.setForeground(Color.white);
		lblDeshacer.setForeground(Color.white);
		
		BotonIcono botonDeshacer = new BotonIcono("iconDeshacer.png");
		botonDeshacer.setBounds(30,60,100,100);
		this.add(botonDeshacer);
		this.add(lblGuardar);
		this.add(lblDeshacer);
		
		
		botonGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonGuardarManipular.setEnabled(true);
				panel.setearTrayecto(trayectoLinea);
				JOptionPane.showMessageDialog(null, "Trayecto guardado", null, JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		botonDeshacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listaParadasTrayecto.size()>1) {
				listaParadasTrayecto.remove(listaParadasTrayecto.size()-1);
				trayectoLinea.remove(trayectoLinea.size()-1);
				revalidate();
				repaint();
				}
				else {
					elegirPuntoInicial();
				}
			}
		});
		
	}
	
	public void agregarBoton(int ubicacionInicialEnY, JPanel panel, BotonMenu boton) {
		boton.setBounds(10, ubicacionInicialEnY, 854, 40);
		panel.add(boton);
	}
	
	public void desabilitarMenu() {
		this.setVisible(false);
	}
	
	public JPanel getPanel() {
		return this;
	}

	public ArrayList<DTOCamino> getListaPosibles() {
		return listaPosibles;
	}

	public void setListaPosibles(ArrayList<DTOCamino> listaPosibles) {
		this.listaPosibles = listaPosibles;
	}

	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		g.setColor(Color.black);
		
		for(DTOCamino camino : listaCaminos) {
		
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
		
		
		for(DTOCamino camino : trayectoLinea) {
			
			
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
			
			GestorGUI.dibujarCamino(g, U_Origen.getX(), U_Origen.getY(), U_Destino.getX(), U_Destino.getY(), Color.green);
			}
		
			if (listaParadasTrayecto.size()!=0) {
			int lastIndex = listaParadasTrayecto.size()-1;
			listaPosibles = GestorCamino.caminosQueInicianEnParada(listaParadasTrayecto.get(lastIndex).getNroParada());

			for(DTOCamino camino : listaPosibles) {
			
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
					
					GestorGUI.dibujarCamino(g, U_Origen.getX(), U_Origen.getY(), U_Destino.getX(), U_Destino.getY(), Color.red);
					
				}
			}
	}
	
	private void elegirPuntoInicial() {
			int ans = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresar numero de parada de origen",JOptionPane.INFORMATION_MESSAGE));
			listaParadasTrayecto.add(GestorParada.obtenerDTOParada(ans));
			repaint();
	}
	
	public void setearCaminos(DTOCamino parada){
		trayectoLinea.add(parada);
	}
	
}
