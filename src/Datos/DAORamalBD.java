package Datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Dominio.Ramal;

/**
 * 
 * Implementacion de DAORamal que se conecta con una base de datos relacional
 * 
 * @author humbertocervantes
 *
 */
public class DAORamalBD implements DAORamal {
	
	/**
	 * Este metodo permite agregar una materia Prima Ramal
	 * 
	 * @param Ramal el Ramal a agregar
	 * @return true si se creo exitosamente, false sino
	 */
	public boolean crea(Ramal ramal) {
		
		try {
			// Crea la instruccion
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
					
			// Ejecuta la instruccion
			statement.execute("INSERT INTO Ramal VALUES (DEFAULT,'"+ramal.getDireccion()+"','"+ramal.getNombre_Ramal()+"','"+ramal.getCorreo()+"')",Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = statement.getGeneratedKeys(); // Recupera la llave
			if (rs != null && rs.next()) {
			    int llave = rs.getInt(1);
			    ramal.setId(llave); // Asigna la llave al Ramal
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
	public Ramal recupera(String nombre) {
		Ramal ramal = null;
		
		try{
			
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT * FROM Ramal WHERE nombre = '"+nombre+"'");
			
			if(rs.next())
			{
				ramal = new Ramal();
				ramal.setNombre_Ramal(rs.getString("Nombre_Ramal"));
				// Nota el campo asociado al nodo padre no se asigna aqui
				ramal.setCorreo(rs.getString("Correo"));
				ramal.setDireccion(rs.getString("Direccion"));
				ramal.setId(Integer.parseInt(rs.getString("Id")));
			}
			
			return ramal;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Retira un material de la Ramal
	 * 
	 * @param Ramal el ramal a retirar
	 * @return true si se retiro exitosamente, false sino
	 */
	public boolean borra(Ramal ramal) {
		try{			
			
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();

			// Recibe los resutados
			statement.execute("DELETE FROM Ramal WHERE nombre = '"+ramal.getNombre_Ramal()+"'");

			
			return true;

		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Regresa la lista de todos los Ramals
	 * 
	 * @return un ArrayList con todos los Ramals de la libreria
	 */
	public ArrayList<Ramal> recuperaTodos() {

		ArrayList <Ramal> ramal = new ArrayList<Ramal>();
		
		
		try{
			
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT * FROM Ramal");

			
			while(rs.next())
			{
				Ramal ramal1 = new Ramal();
				ramal1.setId(Integer.parseInt(rs.getString("Id")));
				ramal1.setNombre_Ramal(rs.getString("Nombre_Ramal"));
				ramal1.setCorreo(rs.getString("Correo"));
				ramal1.setDireccion(rs.getString("Direccion"));
				ramal.add(ramal1);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return ramal;

	}	
	
	/**
	 * 
	 */
	public boolean actualiza(Ramal ramal) {
		// FALTA IMPLEMENTARLO
		return true;
	}

}
