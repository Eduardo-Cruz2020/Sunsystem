package Datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Dominio.Materia_Prima;

/**
 * 
 * Implementacion de DAOMateria_Prima que se conecta con una base de datos relacional
 * 
 * @author humbertocervantes
 *
 */
public class DAOMateria_PrimaBD implements DAOMateria_Prima {
	
	/**
	 * Este metodo permite agregar una materia Prima Materia_Prima
	 * 
	 * @param Materia_Prima el Materia_Prima a agregar
	 * @return true si se creo exitosamente, false sino
	 */
	public boolean crea(Materia_Prima materia_Prima) {
		
		try {
			// Crea la instruccion
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
					
			// Ejecuta la instruccion
			statement.execute("INSERT INTO Materia_Prima VALUES (DEFAULT,'"+materia_Prima.getNombre()+"','"+materia_Prima.getCosto()+"')",Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = statement.getGeneratedKeys(); // Recupera la llave
			if (rs != null && rs.next()) {
			    int llave = rs.getInt(1);
			    materia_Prima.setId_Materia_Prima(llave); // Asigna la llave al Materia_Prima
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
	public Materia_Prima recupera(String nombre) {
		Materia_Prima materia= new Materia_Prima();
		
		try{
			
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT * FROM Materia_Prima WHERE Nombre = '"+nombre+"'");
			
			if(rs.next())
			{
				materia.setNombre(rs.getString("Nombre"));
				// Nota el campo asociado al nodo padre no se asigna aqui
				materia.setCosto(Double.parseDouble(rs.getString("Costo")));
				materia.setId_Materia_Prima(Integer.parseInt(rs.getString("id")));
			}
			
			return materia;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Retira un material de la Materia_Prima
	 * 
	 * @param Materia_Prima el materia_Prima a retirar
	 * @return true si se retiro exitosamente, false sino
	 */
	public boolean borra(Materia_Prima materia) {
		try{			
			
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();

			// Recibe los resutados
			statement.execute("DELETE FROM Materia_Prima WHERE nombre = '"+materia.getNombre()+"'");

			
			return true;

		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Regresa la lista de todos los Materia_Primas
	 * 
	 * @return un ArrayList con todos los Materia_Primas de la libreria
	 */
	public ArrayList<Materia_Prima> recuperaTodos() {

		ArrayList <Materia_Prima> materia_Prima = new ArrayList<Materia_Prima>();
		
		
		try{
			
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT * FROM Materia_Prima");

			
			while(rs.next())
			{
				Materia_Prima materia = new Materia_Prima();
				materia.setNombre(rs.getString("Nombre"));
				materia.setCosto(Double.parseDouble(rs.getString("Costo")));

				materia_Prima.add(materia);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return materia_Prima;

	}	
	
	/**
	 * 
	 */
	public boolean actualiza(Materia_Prima materia_Prima) {
		// FALTA IMPLEMENTARLO
		return true;
	}

}
