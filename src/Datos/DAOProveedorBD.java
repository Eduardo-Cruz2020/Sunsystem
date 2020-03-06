package Datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Dominio.Proveedor;

/**
 * 
 * Implementacion de DAOProveedor que se conecta con una base de datos relacional
 * 
 * @author humbertocervantes
 *
 */
public class DAOProveedorBD implements DAOProveedor {
	
	/**
	 * Este metodo permite agregar una materia Prima Proveedor
	 * 
	 * @param Proveedor el Proveedor a agregar
	 * @return true si se creo exitosamente, false sino
	 */
	public boolean crea(Proveedor proveedor) {
		
		try {
			// Crea la instruccion
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
					
			// Ejecuta la instruccion
			statement.execute("INSERT INTO Proveedor VALUES (DEFAULT,'"+proveedor.getNombre()+"','"+proveedor.getCorreo()+"','"+proveedor.getTelefono()+"')",Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = statement.getGeneratedKeys(); // Recupera la llave
			if (rs != null && rs.next()) {
			    int llave = rs.getInt(1);
			    proveedor.setId(llave); // Asigna la llave al Proveedor
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
	public Proveedor recupera(String nombre) {
		Proveedor proveedor = null;
		
		try{
			
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT * FROM Proveedor WHERE nombre = '"+nombre+"'");
			
			if(rs.next())
			{
				proveedor = new Proveedor();
				proveedor.setNombre(rs.getString("Nombre"));
				proveedor.setCorreo(rs.getString("Correo"));
				proveedor.setTelefono(Integer.parseInt(rs.getString("Telefono")));
				proveedor.setId(Integer.parseInt(rs.getString("Id")));
			}
			
			return proveedor;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Retira un material de la Proveedor
	 * 
	 * @param Proveedor el proveedor a retirar
	 * @return true si se retiro exitosamente, false sino
	 */
	public boolean borra(Proveedor proveedor) {
		try{			
			
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();

			// Recibe los resutados
			statement.execute("DELETE FROM Proveedor WHERE Nombre = '"+proveedor.getNombre()+"'");

			
			return true;

		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Regresa la lista de todos los Proveedors
	 * 
	 * @return un ArrayList con todos los Proveedors de la libreria
	 */
	public ArrayList<Proveedor> recuperaTodos() {

		ArrayList <Proveedor> proveedores = new ArrayList<Proveedor>();
		
		
		try{
			
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT * FROM Proveedor");

			
			while(rs.next())
			{
				Proveedor proveedor = new Proveedor();
				proveedor.setNombre(rs.getString("Nombre"));
				proveedor.setCorreo(rs.getString("Correo"));
				proveedor.setTelefono(Integer.parseInt(rs.getString("Telefono")));
				proveedores.add(proveedor);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return proveedores;

	}	
	
	/**
	 * 
	 */
	public boolean actualiza(Proveedor proveedor) {
		// FALTA IMPLEMENTARLO
		return true;
	}

}
