package Datos;

import java.util.ArrayList;

import Dominio.Ventas;

/**
 * DAO Para la entidad ventas
 * 
 * @author humbertocervantes
 *
 */
public interface DAOVentas {
	
	/**
	 * Este metodo permite agregar una venta
	 * 
	 * @param venta
	 * @return true si se creo exitosamente, false sino
	 */
	public boolean crea(Ventas ventas);
	
	/**
	 * Este metodo crea venta a partir de su nombre
	 * 
	 * @param nombre el nombre del venta a buscar
	 * @return una referencia al venta o null si no se encontro
	 */
	public Ventas recupera(int No_Ventas);
	
	/**
	 * Actualiza  Ventas
	 * 
	 * @param libro
	 * @return true si se actualizo correctamente, false si no
	 */
	public boolean actualiza(Ventas ventas);

	/**
	 * Retira un venta
	 * 
	 * @param venta de la venta  a retirar
	 * @return true si se retiro exitosamente, false sino
	 */
	public boolean borra(Ventas ventas);
	
	/**
	 * Regresa la lista de todas las ventas
	 * 
	 * @return un ArrayList con todos los libros de la libreria
	 */
	public ArrayList<Ventas> recuperaTodos();


}
