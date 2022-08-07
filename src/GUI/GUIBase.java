package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class GUIBase extends JFrame {
	
	JPanel panelPrincipal;
	JPanel panelDeControl;
	JPanel panelCuerpo;
	
	public GUIBase(String tituloSeccion) {
		panelPrincipal = new JPanel();
		setVisible(true);
		setSize(900,700);
		setResizable(false);
		setTitle("BUS-SYSTEM");
		
		panelPrincipal.setBackground(new Color(70, 130, 180));
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelPrincipal.setLayout(new BorderLayout(0, 0));
		setContentPane(panelPrincipal);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		GridBagLayout gbl_panelDeControl = new GridBagLayout();
		gbl_panelDeControl.columnWidths = new int[]{149, 0, 0, 0, 0, 0, 24, 158, 0, 0, 0, 0, 0, 0, 0, 0, 235, 0};
		gbl_panelDeControl.rowHeights = new int[]{20, 0};
		gbl_panelDeControl.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelDeControl.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		
		panelDeControl = new JPanel();
		panelDeControl.setLayout(gbl_panelDeControl);
		panelDeControl.setBackground(SystemColor.activeCaption);
		panelPrincipal.add(panelDeControl, BorderLayout.NORTH);
		
		JLabel lblTitulo = new JLabel(tituloSeccion);
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.gridwidth = 3;
		gbc_lblTitulo.anchor = GridBagConstraints.NORTH;
		gbc_lblTitulo.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblTitulo.insets = new Insets(0, 0, 0, 5);
		gbc_lblTitulo.gridx = 0;
		gbc_lblTitulo.gridy = 0;
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 22));
		lblTitulo.setBounds(10, 14, 86, 14);
		panelDeControl.add(lblTitulo, gbc_lblTitulo);
		
		
		panelCuerpo = new JPanel();
		panelCuerpo.setBackground(new Color(70, 130, 180));
		panelPrincipal.add(panelCuerpo, BorderLayout.CENTER);
		
	}

	public JPanel getPanelPrincipal() {
		return panelPrincipal;
	}

	public void setPanelPrincipal(JPanel panelPrincipal) {
		this.panelPrincipal = panelPrincipal;
	}

	public JPanel getPanelDeControl() {
		return panelDeControl;
	}

	public void setPanelDeControl(JPanel panelDeControl) {
		this.panelDeControl = panelDeControl;
	}

	public JPanel getPanelCuerpo() {
		return panelCuerpo;
	}

	public void setPanelCuerpo(JPanel panelCuerpo) {
		this.panelCuerpo = panelCuerpo;
	}

}