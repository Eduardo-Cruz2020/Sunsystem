package test.Datos;

import java.util.ArrayList;

import Datos.DAOProductoManofacturado;
import Dominio.Producto_Manufacturado;
/**
 * Esta clase es un Mock (sustituto) para realizar pruebas unitarias
 * de modulos que dependen de DAOProducto Manufacturado
 * 
 * @author Eduardo Cruz
 *
 */
public class DAOProductoManufacturadoMock implements DAOProductoManofacturado {
	
	ArrayList <Producto_Manufacturado> productos= new ArrayList<Producto_Manufacturado>();
	Producto_Manufacturado produc= new Producto_Manufacturado(5858,"nombre","tipo", 69.0,"descripcion",5);	
	
	public boolean crea(Producto_Manufacturado producto) {
		// TODO Auto-generated method stub
		return productos.add(producto);
	}


	public boolean actualizaCantidad(int id, int cantidad) {
		Producto_Manufacturado producto = productos.get(0);
		producto.setCantidad(cantidad);
		
		
		return true;
	}


	public ArrayList<Producto_Manufacturado> recuperaTodos() {
		// TODO Auto-generated method stub
		return productos;
	}

	public boolean borra(int id) {
		// TODO Auto-generated method stub
		productos.remove(0);
		return true;

	}

}
