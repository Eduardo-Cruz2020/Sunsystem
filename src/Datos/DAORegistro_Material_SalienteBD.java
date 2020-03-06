package Datos;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Dominio.Registro_Material_Saliente;
/**
 * 
 * Implementacion de DAORegistro_Material_SalienteBD que se conecta con una base de datos relacional
 * 
 * @author Eduardo
 *
 */

public class DAORegistro_Material_SalienteBD implements DAORegistro_Material_Saliente {
	
	/**
	 * Este metodo permite agregar un registro a la base de datos
	 * 
	 * @param registro el registro a agregar
	 * @return true si se creo exitosamente, false sino
	 */
	public boolean crea(Registro_Material_Saliente registro) {
		try {
			// Crea la instruccion
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
					
			// Ejecuta la instruccion
			ResultSet rs = statement.getGeneratedKeys(); // Recupera la llav
			statement.execute("INSERT INTO Registro_Material_Saliente VALUES (DEFAULT,"+registro.getId_Materia_Prima()+","+registro.getCantidad()+",'"+registro.getFecha()+"')",Statement.RETURN_GENERATED_KEYS);

			if (rs != null && rs.next()) {
			    int llave = rs.getInt(1);
			    registro.setId(llave); // Asigna la llave al registro
			}
			return true;
		} catch (SQLException e) {
			
			// Cacha excepcion
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * Retira un Registro 
	 * 
	 * @param Registro el Registro a retirar
	 * @return true si se retiro exitosamente, false sino
	 */
	public boolean borra(Registro_Material_Saliente registro) {
	try{			
				
				Statement statement = ManejadorBaseDatos.getConnection().createStatement();
	
				// Recibe los resutados
				statement.execute("DELETE FROM Registro_Material_Saliente WHERE Id = "+registro.getId()+"");
	
				
				return true;
	
			}catch(SQLException e){
				e.printStackTrace();
				return false;
			}
	}	
	/**
	 * Regresa la lista de todos los Registros de material saliente
	 * 
	 * @return un ArrayList con todos los registros 
	 */

	public ArrayList<Registro_Material_Saliente> recuperaTodos() {
	ArrayList <Registro_Material_Saliente> registros = new ArrayList<Registro_Material_Saliente>();
		
		
		try{
			
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT * FROM Registro_Material_Saliente");

			
			while(rs.next())
			{
				Registro_Material_Saliente registro = new Registro_Material_Saliente();
				registro.setId(Integer.parseInt(rs.getString("Id")));
				registro.setId_Materia_Prima(Integer.parseInt(rs.getString("Id_Materia_Prima")));
				registro.setCantidad(Integer.parseInt(rs.getString("Cantidad")));
				registro.setFecha(rs.getString("Fecha"));

				registros.add(registro);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return registros;
	}

}
