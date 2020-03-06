package Presentacion;

import java.util.ArrayList;

import Dominio.Cliente;
import Negocio.ServicioCliente;

public class ControlRegistroC_Cliente {
	//la ventana principal de la HU-32
		private VentanaRegistroCliente ventana = null;
		private VentanaEliminarCliente ventana1;
		private VentanaAgregarCliente ventana2;
		ArrayList <Cliente> clientes;
		// servicio en la capa de presentacion
		private ServicioCliente servicio;
		
		public ControlRegistroC_Cliente(ServicioCliente servicioCliente) {
			this.servicio = servicioCliente;
		}

		public void inicia() {
			//aqui inicia la HU-32 el sistema muestra la ventana RegistroClientes
			clientes = servicio.obtenerInformacionClientes();
			ventana = new VentanaRegistroCliente(this);
			ventana.setVisible(true);
			
		}
		public void MuestraVentanaEliminarCliente() {
			
			ventana1 = new VentanaEliminarCliente(this);
			ventana1.setVisible(true);
		}
		public void MuestraVentanaAgregarCliente() {
			ventana2 = new VentanaAgregarCliente(this);
			ventana2.setVisible(true);
		}
		public void AgregaNuevo() {
			
		}

		public void eliminaProducto() {
			
		}

		public void AgregaNuevo(String nombre, String correo, String tipo, int id, Double precio) {
			// 3.- El usuario introduce los datos del producto munufacturado

					// Verifica primero que los datos no esten vacios
					if(nombre.equals("") || correo.equals("") || tipo.equals("")|| id==0 || precio==0 ) {
							ventana.muestraMensaje("Los campos no deben estar vacios");	
					} else {
						
						System.out.println("Agregando producto: "+nombre+" del tipo:"+tipo);
						
						// 4.- El sistema valida y muestra un mensaje de exito
						if(servicio.generaCliente(id, correo, nombre, tipo, precio)) {
				        
							ventana.muestraMensaje("Se agrego un cliente exitosamente");
						} else {
							
							// Flujo alternativo en 3, si no se puede agregar, muestra un mensaje de error
							ventana.muestraMensaje( "Un Cliente con ese nombre ya existe o  se pudo agregar");
				
						}
						
						// 5. El sistema cierra la ventana y regresa a la ventana principal
						ventana.cierra();

					}
		}

		public void eliminaProducto(Integer id) {
			
		}

}
