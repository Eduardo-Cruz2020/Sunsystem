package Dominio;

public class Ramal {
	
	private String Direccion;
	private String Correo;
	private String Nombre_Ramal;
	private int Id;
	
	public Ramal(String nombre, String correo, String direccion, int id) {
		this.Nombre_Ramal = nombre;
		this.Correo = correo;
		this.Direccion = direccion;
		this.Id = id;
		
	}
	public Ramal() {
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public String getCorreo() {
		return Correo;
	}
	public void setCorreo(String correo) {
		Correo = correo;
	}
	public String getNombre_Ramal() {
		return Nombre_Ramal;
	}
	public void setNombre_Ramal(String nombre_Ramal) {
		Nombre_Ramal = nombre_Ramal;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}

}
