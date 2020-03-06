package Dominio;

public class Pedido {
	private int No_Pedido;
	private int Cantidad;
	private  String Proveedor;
	private double Costo_total;
	private String fecha;
	private String Materia_Prima;
	private String Mes;
	
	
	public String getMes() {
		return Mes;
	}
	public void setMes(String mes) {
		Mes = mes;
	}
	public int getNo_Pedido() {
		return No_Pedido;
	}
	public void setNo_Pedido(int no_Pedido) {
		No_Pedido = no_Pedido;
	}
	public int getCantidad() {
		return Cantidad;
	}
	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}
	public String getProveedor() {
		return Proveedor;
	}
	public void setProveedor(String proveedor) {
		Proveedor = proveedor;
	}
	public double getCosto_total() {
		return Costo_total;
	}
	public void setCosto_total(double costo_total) {
		Costo_total = costo_total;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getMateria_Prima() {
		return Materia_Prima;
	}
	public void setMateria_Prima(String materia_Prima) {
		Materia_Prima = materia_Prima;
	}


}
