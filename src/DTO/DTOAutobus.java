package DTO;

public class DTOAutobus {
	private int id;
	private String nombre;
	private String color;
	private String tipo;
	private int asientos;
	private boolean aire;
	private boolean wifi;
	private int pasajerosextra;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getAsientos() {
		return asientos;
	}
	public void setAsientos(int asientos) {
		this.asientos = asientos;
	}
	public boolean isAire() {
		return aire;
	}
	public void setAire(boolean aire) {
		this.aire = aire;
	}
	public boolean isWifi() {
		return wifi;
	}
	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}
	public int getPasajerosextra() {
		return pasajerosextra;
	}
	public void setPasajerosextra(int pasajerosextra) {
		this.pasajerosextra = pasajerosextra;
	}

}
