package GUI.Componentes;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.TableModel;

public class JTablePersonalizado extends JTable {
	
	public JTablePersonalizado(String[] columnas, String[][] datos) {
		this.getColumnModel().setColumnMargin(20);
		this.setBounds(150,110,600,420);
	}
}
