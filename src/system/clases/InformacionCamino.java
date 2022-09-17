package system.clases;

import java.util.ArrayList;

import DTO.DTOAutobus;
import DTO.DTOCamino;

public class InformacionCamino {
	
	private DTOAutobus autobus;
	private int paradaInicial;
	private int paradaFinal;
	private double costo;
	private double duracion;
	private double distancia;
	private ArrayList<DTOCamino> recorrido;
	
	public int getParadaInicial() {
		return paradaInicial;
	}
	public void setParadaInicial(int paradaInicial) {
		this.paradaInicial = paradaInicial;
	}
	public int getParadaFinal() {
		return paradaFinal;
	}
	public void setParadaFinal(int paradaFinal) {
		this.paradaFinal = paradaFinal;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	public double getDuracion() {
		return duracion;
	}
	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}
	public double getDistancia() {
		return distancia;
	}
	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}
	public ArrayList<DTOCamino> getRecorrido() {
		return recorrido;
	}
	public void setRecorrido(ArrayList<DTOCamino> recorrido) {
		this.recorrido = recorrido;
	}
	public DTOAutobus getAutobus() {
		return autobus;
	}
	public void setAutobus(DTOAutobus autobus) {
		this.autobus = autobus;
	}
	
	public void mostrarRecorrido() {
		int i = 1;
		if (recorrido.get(0) != null) {
			System.out.println(i+". ->"+recorrido.get(0).getIdOrigen());
			i++;
		}
		for (DTOCamino unCamino:recorrido) {
			System.out.println(i+". ->"+unCamino.getIdDestino());
			i++;
		}
	}
	
}
