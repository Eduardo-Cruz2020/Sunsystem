package Datos;

import java.util.ArrayList;

import Dominio.Empleado;

/**
 * DAO Para la entidad empleado
 * 
 * @author Eduardo
 *
 */
public interface DAOEmpleado {
	
	/**
	 * Este metodo permite agregar un empleado a la libreria
	 * 
	 * @param empleado el empleado a agregar
	 * @return true si se creo exitosamente, false sino
	 */
	public boolean crea(Empleado empleado);
	
	/**
	 * Este metodo busca un empleado a partir de su nombre
	 * 
	 * @param nombre el nombre del empleado a buscar
	 * @return una referencia al empleado o null si no se encontro
	 */
	public Empleado recupera(String nombre);
	
	/**
	 * Actualiza empleado
	 * 
	 * @param empleado
	 * @return true si se actualizo correctamente, false si no
	 */
	public boolean actualiza(Empleado empleado);

	/**
	 * Retira un empleado de la libreria
	 * 
	 * @param empleado el empleado a retirar
	 * @return true si se retiro exitosamente, false sino
	 */
	public boolean borra(Empleado empleado);
	
	/**
	 * Regresa la lista de todos los empleados
	 * 
	 * @return un ArrayList con todos los empleados de la libreria
	 */
	public ArrayList<Empleado> recuperaTodos();


}
