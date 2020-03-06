package Dominio;
/**
 * Entidad Proveedor
 * 
 * @author Eduardo
 *
 */

public class Proveedor {
	private int Id;
	private String Nombre;
	private String Correo;
	private int Telefono;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}

	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getCorreo() {
		return Correo;
	}
	public void setCorreo(String correo) {
		Correo = correo;
	}
	public int getTelefono() {
		return Telefono;
	}
	public void setTelefono(int telefono) {
		Telefono = telefono;
	}

}
