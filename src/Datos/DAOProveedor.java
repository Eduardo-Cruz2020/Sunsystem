package Datos;

import java.util.ArrayList;

import Dominio.Proveedor;

/**
 * DAO Para la entidad proveedor
 * 
 * @author humbertocervantes
 *
 */
public interface DAOProveedor {
	
	/**
	 * Este metodo permite agregar un proveedor a la libreria
	 * 
	 * @param proveedor el proveedor a agregar
	 * @return true si se creo exitosamente, false sino
	 */
	public boolean crea(Proveedor proveedor);
	
	/**
	 * Este metodo busca un proveedor a partir de su nombre
	 * 
	 * @param nombre el nombre del proveedor a buscar
	 * @return una referencia al proveedor o null si no se encontro
	 */
	public Proveedor recupera(String nombre);
	
	/**
	 * Actualiza proveedor
	 * 
	 * @param proveedor
	 * @return true si se actualizo correctamente, false si no
	 */
	public boolean actualiza(Proveedor proveedor);

	/**
	 * Retira un proveedor de la libreria
	 * 
	 * @param proveedor el proveedor a retirar
	 * @return true si se retiro exitosamente, false sino
	 */
	public boolean borra(Proveedor proveedor);
	
	/**
	 * Regresa la lista de todos los proveedors
	 * 
	 * @return un ArrayList con todos los proveedors de la libreria
	 */
	public ArrayList<Proveedor> recuperaTodos();


}
