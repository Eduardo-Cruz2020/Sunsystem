package Presentacion;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Dominio.Producto_Manufacturado;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;

import Presentacion.ControlRegistroPmanufacturado;

import javax.swing.JButton;

public class VentanaRegistroProductoManufacturado extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JButton jButtonAgregarNuevo = null;

	private JButton jButtonEliminarProducto = null;
	
	ArrayList <Producto_Manufacturado> productos= new ArrayList<Producto_Manufacturado>();
	Producto_Manufacturado product=null;


	
	private JTextArea jTextArea = null;
	JScrollPane scroll=null;
	private JLabel etiqueta = null;



	private ControlRegistroPmanufacturado control = null;
	/**
	 * This is the default constructor
	 */
	public VentanaRegistroProductoManufacturado(ControlRegistroPmanufacturado control,ArrayList <Producto_Manufacturado> productos) {
		super();
		this.control = control;
		this.productos = productos;
		initialize();
		setLocationRelativeTo(null);
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(500, 500);
		this.setContentPane(getJContentPane());
		this.setTitle("Registro de productos manufacturados");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {

			
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			
			etiqueta = new JLabel();
			etiqueta.setText("Lista de productos:");
			etiqueta.setBounds(new Rectangle(150,-50,230,150));
			
			jContentPane.add(etiqueta,null);

			jContentPane.add(getJButtonAgregarNuevo(), null);
			jContentPane.add(getJButtonEliminarProducto(), null);
			jContentPane.add(getJTextArea(), null);
			jContentPane.add(scroll, null);

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
			jButtonAgregarNuevo.setBounds(new Rectangle(70, 400, 150, 40));
			jButtonAgregarNuevo.setText("Agregar Nuevo");
			jButtonAgregarNuevo.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					control.MuestraVentanaAgregarProductoManufacturado();
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
			jButtonEliminarProducto.setBounds(new Rectangle(250, 400, 150, 40));
			jButtonEliminarProducto.setText("Eliminar Producto");
			jButtonEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					control.MuestraVentanaEliminarProductoManufacturado();
				}
			});
		}
		return jButtonEliminarProducto;
	}
	
	private JTextArea getJTextArea() {
		jTextArea = new JTextArea(10,4);
		String List = "";

		jTextArea.setEditable(true);		
		jTextArea.setBounds(new Rectangle(50,50,370,320));
		  scroll=new JScrollPane(jTextArea);

		for (int i=0; i<productos.size();i++){
		    Producto_Manufacturado producto = productos.get(i);
		    List = List + "Nombre: " + producto.getNombre() + " , Costo: " + producto.getCosto()+ ", tipo: " + 
		    producto.getTipo()+"\nDescripci�n: "+ producto.getDescripcion()+"\n\n";
		    jTextArea.setText(List);
		}
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
