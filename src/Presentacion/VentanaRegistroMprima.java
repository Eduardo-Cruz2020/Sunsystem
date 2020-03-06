package Presentacion;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Rectangle;

import Presentacion.ControlRegistroMprima;

import javax.swing.JButton;

public class VentanaRegistroMprima extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JButton jButtonAgregarNuevo = null;

	private JButton jButtonEliminarProducto = null;
	
	private JTextArea jTextArea = null;
	private JLabel etiqueta = null;



	private ControlRegistroMprima control = null;
	/**
	 * This is the default constructor
	 */
	public VentanaRegistroMprima(ControlRegistroMprima control) {
		super();
		initialize();
		setLocationRelativeTo(null);
		this.control = control;
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(500, 500);
		this.setContentPane(getJContentPane());
		this.setTitle("Lista de materia prima");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jTextArea = new JTextArea();

			
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			
			etiqueta = new JLabel();
			etiqueta.setText("Lista de materia prima");
			etiqueta.setBounds(new Rectangle(150,-50,180,150));
			
			jContentPane.add(etiqueta,null);

			jContentPane.add(getJButtonAgregarNuevo(), null);
			jContentPane.add(getJButtonEliminarProducto(), null);
			jContentPane.add(getJTextArea(), null);

		}
		return jContentPane;
	}


	/**
	 * This method initializes jButtonAgregarNuevo	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonAgregarNuevo() {
		if (jButtonAgregarNuevo == null) {
			jButtonAgregarNuevo = new JButton();
			jButtonAgregarNuevo.setBounds(new Rectangle(100, 400, 150, 40));
			jButtonAgregarNuevo.setText("Agregar Nueva");
			jButtonAgregarNuevo.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					control.MuestraVentanaAgregarMprima();
				}
			});
		}
		return jButtonAgregarNuevo;
	}

	/**
	 * This method initializes jButtonEliminarProducto
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonEliminarProducto() {
		if (jButtonEliminarProducto == null) {
			jButtonEliminarProducto = new JButton();
			jButtonEliminarProducto.setBounds(new Rectangle(280, 400, 150, 40));
			jButtonEliminarProducto.setText("Eliminar Materia");
			jButtonEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					control.MuestraVentanaEliminarMprima();
				}
			});
		}
		return jButtonEliminarProducto;
	}
	
	private JTextArea getJTextArea() {
		
		jTextArea.setEditable(false);		
		jTextArea.setBounds(new Rectangle(50,50,370,320));
		return jTextArea;	
	}

	public void abre() {
		setVisible(true);
	}
	
	public void cierra() {
		setVisible(false);
	}

	
	public void muestraMensaje(String mensaje){
		JOptionPane.showMessageDialog(this, mensaje);
	}
}
