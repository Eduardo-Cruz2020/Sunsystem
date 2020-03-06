package Datos;

import java.util.ArrayList;

import Dominio.Cliente;

/**
 * DAO Para la entidad cliente
 * 
 * @author Eduardo
 *
 */
public interface DAOCliente {
	
	/**
	 * Este metodo permite agregar un cliente a la libreria
	 * 
	 * @param cliente el cliente a agregar
	 * @return true si se creo exitosamente, false sino
	 */
	public boolean crea(Cliente cliente);
	
	/**
	 * Este metodo busca un cliente a partir de su nombre
	 * 
	 * @param nombre el nombre del cliente a buscar
	 * @return una referencia al cliente o null si no se encontro
	 */
	public Cliente recupera(String nombre);
	
	/**
	 * Actualiza cliente
	 * 
	 * @param cliente
	 * @return true si se actualizo correctamente, false si no
	 */
	public boolean actualiza(Cliente cliente);

	/**
	 * Retira un cliente de la libreria
	 * 
	 * @param cliente el cliente a retirar
	 * @return true si se retiro exitosamente, false sino
	 */
	public boolean borra(Cliente cliente);
	
	/**
	 * Regresa la lista de todos los clientes
	 * 
	 * @return un ArrayList con todos los clientes de la libreria
	 */
	public ArrayList<Cliente> recuperaTodos();

	public void borra(int id);


}
