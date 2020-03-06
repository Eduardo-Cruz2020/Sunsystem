package Dominio;
/**
 * Entidad Materia_Prima
 * 
 * @author Eduardo
 *
 */

public class Materia_Prima {
	private int Id_Materia_Prima;
	private double Costo;
	private String Nombre;
	
	
	public Materia_Prima(int id, String nombre2, double Costo) {
		// TODO Auto-generated constructor stub
		Id_Materia_Prima=id;
		this.Costo=Costo;
		Nombre=nombre2;
	}
	public Materia_Prima() {
		// TODO Auto-generated constructor stub
	}
	public int getId_Materia_Prima() {
		return Id_Materia_Prima;
	}
	public void setId_Materia_Prima(int id_Materia_Prima) {
		Id_Materia_Prima = id_Materia_Prima;
	}
	public double getCosto() {
		return Costo;
	}
	public void setCosto(double costo) {
		Costo = costo;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

}
