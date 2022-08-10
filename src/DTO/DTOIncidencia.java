package DTO;

import java.util.Date;

public class DTOIncidencia {
	private int idIncidencia;
	private int idParada;
	private Date fechaInicio;
	private Date fechaFin;
	private String descripcion;
	private boolean estadoActual;
	
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public boolean isEstadoActual() {
		return estadoActual;
	}
	public void setEstadoActual(boolean estadoActual) {
		this.estadoActual = estadoActual;
	}
	public int getIdIncidencia() {
		return idIncidencia;
	}
	public void setIdIncidencia(int idIncidencia) {
		this.idIncidencia = idIncidencia;
	}
	public int getIdParada() {
		return idParada;
	}
	public void setIdParada(int idParada) {
		this.idParada = idParada;
	}
	
	
}
