package Dominio;
/**
 * Entidad Empleado
 * 
 * @author Eduardo
 *
 */

public class Empleado {
	 private int No_empleado;
	 private String Nombre;
	 private double Sueldo;
	 private String Cargo;
	 
	public int getNo_empleado() {
		return No_empleado;
	}
	public void setNo_empleado(int no_empleado) {
		No_empleado = no_empleado;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public double getSueldo() {
		return Sueldo;
	}
	public void setSueldo(double sueldo) {
		Sueldo = sueldo;
	}
	public String getCargo() {
		return Cargo;
	}
	public void setCargo(String cargo) {
		Cargo = cargo;
	}
	 

	

}
