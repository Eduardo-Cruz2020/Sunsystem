package Datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Dominio.Cliente;

/**
 * 
 * Implementacion de DAOCliente que se conecta con una base de datos relacional
 * 
 * @author Eduardo
 *
 */
public class DAOClienteBD implements DAOCliente {
	
	/**
	 * Este metodo permite agregar una materia Prima Cliente
	 * 
	 * @param Cliente el Cliente a agregar
	 * @return true si se creo exitosamente, false sino
	 */
	public boolean crea(Cliente cliente) {
		
		try {
			// Crea la instruccion
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
					
			// Ejecuta la instruccion
			statement.execute("INSERT INTO Cliente VALUES (DEFAULT,'"+cliente.getNombre()+"','"+cliente.getCorreo()+"','"+cliente.getTelefono()+"')",Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = statement.getGeneratedKeys(); // Recupera la llave
			if (rs != null && rs.next()) {
			    int llave = rs.getInt(1);
			    cliente.setId(llave); // Asigna la llave al Cliente
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
	public Cliente recupera(String nombre) {
		Cliente cliente = null;
		
		try{
			
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT * FROM Cliente WHERE nombre = '"+nombre+"'");
			
			if(rs.next())
			{
				cliente = new Cliente();
				cliente.setNombre(rs.getString("nombre"));
				// Nota el campo asociado al nodo padre no se asigna aqui
				cliente.setCorreo(rs.getString("correo"));
				cliente.setTelefono(Integer.parseInt(rs.getString("Telefono")));
				cliente.setId(Integer.parseInt(rs.getString("id")));
			}
			
			return cliente;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Retira un material de la Cliente
	 * 
	 * @param Cliente el cliente a retirar
	 * @return true si se retiro exitosamente, false sino
	 */
	public boolean borra(Cliente cliente) {
		try{			
			
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();

			// Recibe los resutados
			statement.execute("DELETE FROM Cliente WHERE Nombre = '"+cliente.getNombre()+"'");

			
			return true;

		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Regresa la lista de todos los Clientes
	 * 
	 * @return un ArrayList con todos los Clientes de la libreria
	 */
	public ArrayList<Cliente> recuperaTodos() {

		ArrayList <Cliente> clientes = new ArrayList<Cliente>();
		
		
		try{
			
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT * FROM Cliente");

			
			while(rs.next())
			{
				Cliente cliente = new Cliente();
				cliente.setNombre(rs.getString("nombre"));
				cliente.setCorreo(rs.getString("correo"));
				cliente.setTelefono(Integer.parseInt(rs.getString("Telefono")));
				clientes.add(cliente);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return clientes;

	}	
	
	/**
	 * 
	 */
	public boolean actualiza(Cliente cliente) {
		// FALTA IMPLEMENTARLO
		return true;
	}

	@Override
	public void borra(int id) {
		// TODO Auto-generated method stub
		
	}

}
