package system.clases;

import java.util.Date;

public class Incidencia {
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
	
}
