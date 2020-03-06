package Presentacion;



import javax.swing.JButton;

import java.awt.Rectangle;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaRegistroCliente  extends JFrame{
	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JButton jButtonAgregarCliente = null;

	private JButton jButtonEliminarCliente = null;
	
	private JTextArea jTextArea = null;
	private JLabel etiqueta = null;



	private ControlRegistroC_Cliente control = null;
	/**
	 * This is the default constructor
	 */
	public VentanaRegistroCliente(ControlRegistroC_Cliente control) {
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
		this.setTitle("Lista de Clientes Anotados");
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
			etiqueta.setText("Agenda de clientes");
			etiqueta.setBounds(new Rectangle(150,-50,180,150));
			
			jContentPane.add(etiqueta,null);

			jContentPane.add(getJButtonAgregarCliente(), null);
			jContentPane.add(getJButtonEliminarCliente(), null);
			jContentPane.add(getJTextArea(), null);

		}
		return jContentPane;
	}


	/**
	 * This method initializes jButtonAgregarNuevo	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonAgregarCliente() {
		if (jButtonAgregarCliente == null) {
			jButtonAgregarCliente = new JButton();
			jButtonAgregarCliente.setBounds(new Rectangle(100, 400, 100, 40));
			jButtonAgregarCliente.setText("Agregar Nuevo Cliente");
			jButtonAgregarCliente.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					control.MuestraVentanaAgregarCliente();
				}
			});
		}
		return jButtonAgregarCliente;
	}

	/**
	 * This method initializes jButtonEliminarProducto
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonEliminarCliente() {
		if (jButtonEliminarCliente == null) {
			jButtonEliminarCliente = new JButton();
			jButtonEliminarCliente.setBounds(new Rectangle(280, 400, 100, 40));
			jButtonEliminarCliente.setText("Eliminar Cliente");
			jButtonEliminarCliente.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					control.MuestraVentanaEliminarCliente();
				}
			});
		}
		return jButtonEliminarCliente;
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
