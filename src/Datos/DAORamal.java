package Datos;

import java.util.ArrayList;

import Dominio.Ramal;

/**
 * DAO Para la entidad ramal
 * 
 * @author humbertocervantes
 *
 */
public interface DAORamal {
	
	/**
	 * Este metodo permite agregar un ramal a la libreria
	 * 
	 * @param ramal el ramal a agregar
	 * @return true si se creo exitosamente, false sino
	 */
	public boolean crea(Ramal ramal);
	
	/**
	 * Este metodo busca un ramal a partir de su nombre
	 * 
	 * @param nombre el nombre del ramal a buscar
	 * @return una referencia al ramal o null si no se encontro
	 */
	public Ramal recupera(String nombre);
	
	/**
	 * Actualiza ramal
	 * 
	 * @param ramal
	 * @return true si se actualizo correctamente, false si no
	 */
	public boolean actualiza(Ramal ramal);

	/**
	 * Retira un ramal de la libreria
	 * 
	 * @param ramal el ramal a retirar
	 * @return true si se retiro exitosamente, false sino
	 */
	public boolean borra(Ramal ramal);
	
	/**
	 * Regresa la lista de todos los ramals
	 * 
	 * @return un ArrayList con todos los ramals de la libreria
	 */
	public ArrayList<Ramal> recuperaTodos();


}
