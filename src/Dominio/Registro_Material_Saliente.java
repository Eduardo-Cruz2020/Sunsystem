package Dominio;
/**
 * Entidad Registro_Material_Saliente
 * 
 * @author Eduardo
 *
 */
public class Registro_Material_Saliente {
	private int Id;
	private int Id_Materia_Prima;
	private int Cantidad;
	private String Fecha;
	
	public int getId_Materia_Prima() {
		return Id_Materia_Prima;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public void setId_Materia_Prima(int id_Materia_Prima) {
		Id_Materia_Prima = id_Materia_Prima;
	}
	public int getCantidad() {
		return Cantidad;
	}
	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}
	public String getFecha() {
		return Fecha;
	}
	public void setFecha(String fecha) {
		Fecha = fecha;
	}
	


}
