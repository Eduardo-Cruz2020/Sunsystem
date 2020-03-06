package Presentacion;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Rectangle;


import javax.swing.JButton;

public class VentanaRegistroRamales extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JButton jButtonAgregarRamal = null;

	private JButton jButtonEliminarRamal = null;

	private JTextArea jTextArea = null;
	
	private JLabel etiqueta = null;
	private ControlRegistroRamales control = null;
	/**
	 * This is the default constructor
	 */
	public VentanaRegistroRamales(ControlRegistroRamales control) {
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
		this.setTitle("Registro Ramales");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			
			jTextArea = new JTextArea();
			//jTextArea.
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			etiqueta = new JLabel();
			etiqueta.setText("Lista de ramales existentes");
			etiqueta.setBounds(new Rectangle(150,-50,180,150));
			
			jContentPane.add(etiqueta,null);
			jContentPane.add(getJTextArea(), null);
			jContentPane.add(getJButtonAgregarRamal(), null);
			jContentPane.add(getJButtonEliminarRamal(), null);
		}
		return jContentPane;
	}


	/**
	 * This method initializes jButtonAgregarRamal	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JTextArea getJTextArea() {
		
		jTextArea.setEditable(false);		
		jTextArea.setBounds(new Rectangle(50,50,370,320));
		return jTextArea;	
	}
	private JButton getJButtonAgregarRamal() {
		if (jButtonAgregarRamal == null) {
			jButtonAgregarRamal = new JButton();
			jButtonAgregarRamal.setBounds(new Rectangle(100, 400, 100, 40));
			jButtonAgregarRamal.setText("Añadir");
			jButtonAgregarRamal.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					control.MuestraVentanaAgregarRamal();
				}
			});
		}
		return jButtonAgregarRamal;
	}

	/**
	 * This method initializes jButtonEliminarRamal
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonEliminarRamal() {
		if (jButtonEliminarRamal == null) {
			jButtonEliminarRamal = new JButton();
			jButtonEliminarRamal.setBounds(new Rectangle(280, 400, 100, 40));
			jButtonEliminarRamal.setText("Eliminar");
			jButtonEliminarRamal.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					control.MuestraVentanaEliminarRamal();
				}
			});
		}
		return jButtonEliminarRamal;
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
