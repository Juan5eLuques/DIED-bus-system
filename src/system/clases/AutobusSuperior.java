package system.clases;


public class AutobusSuperior extends Autobus{
	
	private boolean aireAcondicionado;
	private boolean wifi;
	private static double porcentajePorServicio = 5;
	
	public boolean isAireAcondicionado() {
		return aireAcondicionado;
	}

	public boolean isWifi() {
		return wifi;
	}
	public static double getPorcentajePorServicio() {
		return porcentajePorServicio;
	}
	
	public void agregarPasajero() {
		if (this.getCapacidadMaxima() < this.getPasajeros()) this.setPasajeros(asientos++);
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
				+ nombre + ", color=" + color + ", capacidadMaxima=" + capacidadMaxima + ", pasajeros=" + asientos
				+ ", recorridoLinea=" + recorridoLinea + "]";
	}

	@Override
	public double porcentajeExtra() {
		double ret = porcentajePorServicio;
		if(wifi) ret +=5;
		if(aireAcondicionado) ret += 5;
		return ret;
	}

	
	
}
