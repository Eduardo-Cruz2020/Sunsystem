package Datos;

import java.util.ArrayList;

import Dominio.Materia_Prima;

/**
 * DAO Para la entidad materia_Prima
 * 
 * @author Eduardo
 *
 */
public interface DAOMateria_Prima {
	
	/**
	 * Este metodo permite agregar un materia_Prima a la libreria
	 * 
	 * @param materia_Prima el materia_Prima a agregar
	 * @return true si se creo exitosamente, false sino
	 */
	public boolean crea(Materia_Prima materia_Prima);
	
	/**
	 * Este metodo busca un materia_Prima a partir de su nombre
	 * 
	 * @param nombre el nombre del materia_Prima a buscar
	 * @return una referencia al materia_Prima o null si no se encontro
	 */
	public Materia_Prima recupera(String nombre);
	
	/**
	 * Actualiza materia_Prima
	 * 
	 * @param materia_Prima
	 * @return true si se actualizo correctamente, false si no
	 */
	public boolean actualiza(Materia_Prima materia_Prima);

	/**
	 * Retira un materia_Prima de la libreria
	 * 
	 * @param materia_Prima el materia_Prima a retirar
	 * @return true si se retiro exitosamente, false sino
	 */
	public boolean borra(Materia_Prima materia_Prima);
	
	/**
	 * Regresa la lista de todos los materia_Primas
	 * 
	 * @return un ArrayList con todos los materia_Primas de la libreria
	 */
	public ArrayList<Materia_Prima> recuperaTodos();


}
