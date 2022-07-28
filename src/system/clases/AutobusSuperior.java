package system.clases;


public class AutobusSuperior extends Autobus{
	
	private boolean aireAcondicionado;
	private boolean wifi;
	
	
	public boolean isAireAcondicionado() {
		return aireAcondicionado;
	}

	public boolean isWifi() {
		return wifi;
	}
	
	public void agregarPasajero() {
		if (this.getCapacidadMaxima() < this.getPasajeros()) this.setPasajeros(pasajeros++);
			else {
				System.out.println("El colectivo alcanzo su capacidad maxima");
			}
	
		}

	public void setAireAcondicionado(boolean aireAcondicionado) {
		this.aireAcondicionado = aireAcondicionado;
	}

	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}

	@Override
	public String toString() {
		return "AutobusSuperior [aireAcondicionado=" + aireAcondicionado + ", wifi=" + wifi + ", id=" + id + ", nombre="
				+ nombre + ", color=" + color + ", capacidadMaxima=" + capacidadMaxima + ", pasajeros=" + pasajeros
				+ ", recorridoLinea=" + recorridoLinea + "]";
	}
	
	
	
}
