package Presentacion;

import java.util.ArrayList;

import Dominio.Ramal;
import Negocio.ServicioRamal;


public class ControlRegistroRamales {
	//la ventana principal de la HU-23
	private VentanaRegistroRamales ventana = null;
	private VentanaEliminarRamal ventana1;
	private VentanaAgregarRamal ventana2;
	ArrayList <Ramal> Ramales;
	// servicio en la capa de presentacion
	private ServicioRamal servicio;
	
	public ControlRegistroRamales(ServicioRamal servicioRamal) {
		this.servicio = servicioRamal;
	}

	public void inicia() {
		//Aqui inicia la HU-23 el sistema muestra la ventana RegistroRamales
		Ramales = servicio.obtenerInformacionRamales();
		ventana = new VentanaRegistroRamales(this);
		ventana.setVisible(true);
		
	}
	public void MuestraVentanaEliminarRamal() {
		ventana1 = new VentanaEliminarRamal(this);
		ventana1.setVisible(true);
	}
	public void MuestraVentanaAgregarRamal() {
		ventana2 = new VentanaAgregarRamal(this);
		ventana2.setVisible(true);
	}
	
	public void AgregaNuevo() {
		
	}

	public void eliminaProducto() {
		
	}

	public void AgregaNuevo(String nombre, String correo, String direccion, int id) {
		// 3.- El usuario introduce los datos del ramal

				// Verifica primero que los datos no esten vacios
				if(nombre.equals("") || correo.equals("") || direccion.equals("") || id==0) {
					ventana.muestraMensaje("Faltan llenar uno o más campos!");	
				} else {
					
					System.out.println("Agregando ramal: "+nombre);
					
					// 4.- El sistema valida y muestra un mensaje de exito
					if(servicio.generaRegistro(nombre,correo,direccion,id)) {
			        
						ventana.muestraMensaje("Se agregó el ramal exitosamente");
					} else {
						
						// Flujo alternativo en 3, si no se puede agregar, muestra un mensaje de error
						ventana.muestraMensaje( "Un ramal con ese nombre ya existe o no se pudo agregar");
			
					}
					
					// 5. El sistema cierra la ventana y regresa a la ventana principal
					ventana.cierra();

				}
	}

	public void eliminaRamal(int id) {
			// el usuario introduce el ID del ramal a borrar
			if(servicio.EliminaRamal(id)) {
				ventana.muestraMensaje("El ramal se eliminó satisfactoriamente");
			}else {
				ventana.muestraMensaje("Error en eliminar el ramal");
			}
			
	}

}
