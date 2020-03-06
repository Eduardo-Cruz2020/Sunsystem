package Presentacion;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Rectangle;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

public class VentanaAgregarRamal extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JLabel jLabel4 = null;

	private JTextField jTextFieldNombre = null;
	private JTextField jTextFieldCorreo = null;
	private JTextField jTextFieldDireccion = null;
	private JTextField jTextFieldId = null;
	

	private JButton jButtonAgregar = null;

	private JButton jButtonCancelar = null;

	private ControlRegistroRamales control = null;
	/**
	 * This is the default constructor
	 */
	public VentanaAgregarRamal(ControlRegistroRamales control) {
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
		this.setSize(300, 300);
		this.setContentPane(getJContentPane());
		this.setTitle("Agregar nuevo ramal");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(20, 70, 60, 15));
			jLabel1.setText("Nombre:");
			
			jLabel2 = new JLabel();
			jLabel2.setText("Correo:");
			jLabel2.setBounds(new Rectangle(20, 95, 60, 15));
			
			jLabel3 = new JLabel();
			jLabel3.setText("Direccion:");
			jLabel3.setBounds(new Rectangle(20, 120, 90, 15));
			
			jLabel4 = new JLabel();
			jLabel4.setText("Id:");
			jLabel4.setBounds(new Rectangle(20, 145, 60, 15));
			
			
			
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(50, 20, 250, 30));
			jLabel.setFont(new Font("Arial Black", Font.BOLD, 18));
			jLabel.setText("Agregar ramal");
			
			//jTextArea = new jTextArea();
			
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabel, null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(jLabel3, null);
			jContentPane.add(jLabel4, null);
			//jContentPane.add(jLabel5, null);
			
			jContentPane.add(getJTextFieldNombre(), null);
			jContentPane.add(getJTextFieldCorreo(), null);
			jContentPane.add(getJTextFieldDireccion(), null);
			jContentPane.add(getJTextFieldId(), null);
			//jContentPane.add(getJTextFieldPrecio(), null);
			jContentPane.add(jLabel2, null);
			
			jContentPane.add(getJButtonAgregar(), null);
			jContentPane.add(getJButtonCancelar(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jTextFieldNombre	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldNombre() {
		if (jTextFieldNombre == null) {
			jTextFieldNombre = new JTextField();
			jTextFieldNombre.setBounds(new Rectangle(120, 70, 137, 20));
		}
		return jTextFieldNombre;
	}

	/**
	 * This method initializes jTextFieldDireccion	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldDireccion() {
		if (jTextFieldDireccion == null) {
			jTextFieldDireccion = new JTextField();
			jTextFieldDireccion.setBounds(new Rectangle(120, 95, 138, 20));
		}
		return jTextFieldDireccion;
	}
	
	/**
	 * This method initializes jTextFieldCorreo	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldCorreo() {
		if (jTextFieldCorreo == null) {
			jTextFieldCorreo = new JTextField();
			jTextFieldCorreo.setBounds(new Rectangle(120, 120, 138, 20));
		}
		return jTextFieldCorreo;
	}
	
	/**
	 * This method initializes jTextFieldId	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldId() {
		if (jTextFieldId == null) {
			jTextFieldId = new JTextField();
			jTextFieldId.setBounds(new Rectangle(120, 145, 138, 20));
		}
		return jTextFieldId;
	}


	/**
	 * This method initializes jButtonAceptar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonAgregar() {
		if (jButtonAgregar == null) {
			jButtonAgregar = new JButton();
			jButtonAgregar.setBounds(new Rectangle(20, 200, 106, 31));
			jButtonAgregar.setText("Agregar");
			jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					String nombre = jTextFieldNombre.getText();
					String correo = jTextFieldDireccion.getText();
					String direccion = jTextFieldCorreo.getText();
					try {
					Integer id = Integer.parseInt(jTextFieldId.getText());
					control.AgregaNuevo(nombre,correo,direccion,id);
					}catch(java.lang.NumberFormatException exception) {
						JOptionPane.showMessageDialog(null, "ID no valido, inténtelo nuevamente", "Error", JOptionPane.ERROR_MESSAGE);
					}					
						//control.AgregaNuevo(nombre, correo, direccion, id);
					
				}
			});
		}
		return jButtonAgregar;
	}

	/**
	 * This method initializes jButtonCancelar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonCancelar() {
		if (jButtonCancelar == null) {
			jButtonCancelar = new JButton();
			jButtonCancelar.setBounds(new Rectangle(149, 200, 107, 31));
			jButtonCancelar.setText("Cancelar");
			jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					cierra();
				}
			});
		}
		return jButtonCancelar;
	}

	public void abre() {
		setVisible(true);
	}
	
	public void cierra() {
		this.dispose();
	}

	
	public void muestraMensaje(String mensaje){
		JOptionPane.showMessageDialog(this, mensaje);
	}
}
