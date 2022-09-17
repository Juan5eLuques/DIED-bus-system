package GUI.Componentes;

import DTO.DTOParada;

public class UbicacionParada {
	
	private int X;
	private int Y;
	
	public UbicacionParada(DTOParada parada){
		int calle = Integer.parseInt(parada.getCalle().substring(6));
		if (calle%2==0) {
			X = (calle*25)+200;
			Y = (((parada.getNroCalle()/10)*5)+30);
		}
		else {
			X = (((parada.getNroCalle()/10)*5)+175);
			Y =(calle*25)+30;
		}
		
	}

	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}
	
}
