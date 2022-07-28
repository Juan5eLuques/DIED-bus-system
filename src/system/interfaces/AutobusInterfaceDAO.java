package system.interfaces;

import java.util.ArrayList;

import system.clases.Autobus;

public interface AutobusInterfaceDAO <A>{
	public A obtenerAutobus(int idAutobus);
	public void agregarAutobus(A nuevoAutobus);
	public ArrayList<A> obtenerTodosDelTipo(String tipo);
}
