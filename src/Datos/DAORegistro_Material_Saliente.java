package Datos;

import java.util.ArrayList;


import Dominio.Registro_Material_Saliente;

/**
 * DAO Para la entidad Registro_Material_Saliente
 * 
 * @author Eduardo
 *
 */


public interface DAORegistro_Material_Saliente {
	/**
	 * Este metodo permite agregar un registro
	 * 
	 * @param registro el registro a agregar
	 * @return true si se creo exitosamente, false sino
	 */
	boolean crea(Registro_Material_Saliente registro);
	/**
	 * Retira un registro
	 * 
	 * @param registro el registro a retirar
	 * @return true si se retiro exitosamente, false sino
	 */

	boolean borra(Registro_Material_Saliente registro);
	/**
	 * Actualiza registro
	 * 
	 * @param registro
	 * @return true si se actualizo correctamente, false si no
	 */
	public
	ArrayList<Registro_Material_Saliente> recuperaTodos();

}
