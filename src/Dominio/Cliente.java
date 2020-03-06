package Dominio;

public class Cliente {
	
	private String Nombre;
	private String Correo;
	private int Telefono;
	private String Tipo;
	private int id;
	
	public Cliente(int id, String tipo, String nombre, String correo, int telefono) {
		this.id = id;
		this.Nombre = nombre;
		this.Correo = correo;
		this.Telefono = telefono;
		this.Tipo = tipo;
		
	}
	public Cliente() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	
	

}
