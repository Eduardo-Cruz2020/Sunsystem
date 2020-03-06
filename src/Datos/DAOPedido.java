package Datos;

import java.util.ArrayList;

import Dominio.Pedido;

/**
 * DAO Para la entidad Pedido
 * 
 * @author Ximena
 *
 */

public interface DAOPedido {

	/**
	 * Este metodo permite agregar un Pedido al Registro
	 * 
	 * @param pedido el pedido a agregar
	 * @return true si se creo exitosamente, false si no
	 */
	
	public boolean crea(Pedido pedido);
	
	/**
	 * Este metodo busca un libro a partir de su nombre
	 * 
	 * @param nombre el nombre del libro a buscar
	 * @return una referencia al libro o null si no se encontro
	 */
	
	public Pedido recupera(String fecha);
	
	/**
	 * Actualiza pedido
	 * 
	 * @param pedido
	 * @return true si se actualizo correctamente, false si no
	 */
	
	public boolean actualiza(Pedido pedido);
	
	/**
	 * Retira un pedido del registro
	 * 
	 * @param pedido el pedido a retirar
	 * @return true si se retiro exitosamente, false si no
	 */
	
	public boolean borra(Pedido pedido);
	
	/**
	 * Regresa la lista de todos los pedidos
	 * 
	 * @return un ArrayList con todos los pedidos del registro
	 */
	
	public ArrayList<Pedido> recuperaMes(String mes);
	
}
