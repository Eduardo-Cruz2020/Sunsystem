package Datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Dominio.Empleado;

/**
 * 
 * Implementacion de DAOEmpleado que se conecta con una base de datos relacional
 * 
 * @author Eduardo
 *
 */
public class DAOEmpleadoBD implements DAOEmpleado {
	
	/**
	 * Este metodo permite agregar una materia Prima Empleado
	 * 
	 * @param Empleado el Empleado a agregar
	 * @return true si se creo exitosamente, false sino
	 */
	public boolean crea(Empleado empleado) {
		
		try {
			// Crea la instruccion
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
					
			// Ejecuta la instruccion
			statement.execute("INSERT INTO Empleado VALUES (DEFAULT,'"+empleado.getNombre()+"','"+empleado.getSueldo()+"','"+empleado.getCargo()+"')",Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = statement.getGeneratedKeys(); // Recupera la llave
			if (rs != null && rs.next()) {
			    int llave = rs.getInt(1);
			    empleado.setNo_empleado(llave); // Asigna la llave al Empleado
			}
				
					
			return true;
		} catch (SQLException e) {
			
			// Cacha excepcion
			e.printStackTrace();
			return false;
		}

	}
	
	/**
	 * Este metodo busca un nombre
	 * 
	 * @param nombre el nombre a buscar
	 * @return una referencia al Nombre o null si no se encontro
	 */
	public Empleado recupera(String nombre) {
		Empleado empleado = null;
		
		try{
			
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT * FROM Empleado WHERE Nombre = '"+nombre+"'");
			
			if(rs.next())
			{
				empleado = new Empleado();
				empleado.setNombre(rs.getString("Nombre"));
				// Nota el campo asociado al nodo padre no se asigna aqui
				empleado.setCargo(rs.getString("Cargo"));
				empleado.setSueldo(Double.parseDouble(rs.getString("Sueldo")));
				empleado.setNo_empleado(Integer.parseInt(rs.getString("No_empleado")));
			}
			
			return empleado;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Retira un material de la Empleado
	 * 
	 * @param Empleado el empleado a retirar
	 * @return true si se retiro exitosamente, false sino
	 */
	public boolean borra(Empleado empleado) {
		try{			
			
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();

			// Recibe los resutados
			statement.execute("DELETE FROM Empleado WHERE No_empleado = '"+empleado.getNo_empleado()+"'");

			
			return true;

		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Regresa la lista de todos los Empleados
	 * 
	 * @return un ArrayList con todos los Empleados de la libreria
	 */
	public ArrayList<Empleado> recuperaTodos() {

		ArrayList <Empleado> empleados = new ArrayList<Empleado>();
		
		
		try{
			
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT * FROM Empleado");

			
			while(rs.next())
			{
				Empleado empleado = new Empleado();
				empleado.setNombre(rs.getString("Nombre"));
				empleado.setSueldo(Double.parseDouble(rs.getString("Sueldo")));
				empleado.setCargo(rs.getString("cargo"));
				empleado.setNo_empleado(Integer.parseInt(rs.getString("No_empleado")));
				empleados.add(empleado);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return empleados;

	}	
	
	/**
	 * 
	 */
	public boolean actualiza(Empleado empleado) {
		// FALTA IMPLEMENTARLO
		return true;
	}

}
