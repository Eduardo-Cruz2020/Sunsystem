package Datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Dominio.Ventas;

/**
 * 
 * Implementacion de DAOLibro que se conecta con una base de datos relacional
 * 
 * @author humbertocervantes
 *
 */
public class DAOVentasBD implements DAOVentas {
	
	/**
	 * Este metodo permite agregar un libro a la libreria
	 * 
	 * @param libro el libro a agregar
	 * @return true si se creo exitosamente, false sino
	 */
	public boolean crea(Ventas ventas) {
		
		try {
			// Crea la instruccion
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
					
			// Ejecuta la instruccion
			statement.execute("INSERT INTO Ventas VALUES (DEFAULT,'"+ventas.getNo_Ventas()+"','"+ventas.getCliente()+"','"+ventas.getCosto_Total()+"','"+ventas.getFecha()+"','"+ventas.getProducto_Manufacturado()+"')",Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = statement.getGeneratedKeys(); // Recupera la llave
			if (rs != null && rs.next()) {
			    int llave = rs.getInt(1);
			    ventas.setNo_Ventas(llave); // Asigna la llave al libor
			}
				
					
			return true;
		} catch (SQLException e) {
			
			// Cacha excepcion
			e.printStackTrace();
			return false;
		}

	}
	
	/**
	 * Este metodo busca un titulo
	 * 
	 * @param nombre el nombre del titulo a buscar
	 * @return una referencia al Titulo o null si no se encontro
	 */
	public Ventas recupera(int No_Ventas) {
		Ventas ventas = null;
		
		try{
			
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT * FROM Ventas WHERE No_ventas= '"+No_Ventas+"'");
			
			if(rs.next())
			{
				ventas = new Ventas();
				
				ventas.setNo_Ventas(Integer.parseInt(rs.getString("No_Ventas")));
				ventas.setCliente(rs.getString("Cliente"));
				ventas.setFecha(rs.getString("Fecha"));
				ventas.setProducto_Manufacturado(rs.getString("Producto_Manufacturado"));
				ventas.setCosto_Total(Integer.parseInt(rs.getString("Costo_Total")));
			}
			
			return ventas;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Retira un libro de la libreria
	 * 
	 * @param libro el libro a retirar
	 * @return true si se retiro exitosamente, false sino
	 */
	public boolean borra(Ventas ventas) {
		try{			
			
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();

			// Recibe los resutados
			statement.execute("DELETE FROM Ventas WHERE Venta = '"+ventas.getNo_Ventas()+"'");

			
			return true;

		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Regresa la lista de todos los libros
	 * 
	 * @return un ArrayList con todos los libros de la libreria
	 */
	public ArrayList<Ventas> recuperaTodos() {

		ArrayList <Ventas> ventas = new ArrayList<Ventas>();
		
		
		try{
			
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT * FROM Ventas");

			
			while(rs.next())
			{
				Ventas venta = new Ventas();
				venta.setNo_Ventas(Integer.parseInt(rs.getString("No_ventas")));
				venta.setFecha(rs.getString("Fecha"));

				ventas.add(venta);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return ventas;

	}	
	
	/**
	 * 
	 */
	public boolean actualiza(Ventas ventas) {
		// FALTA IMPLEMENTARLO
		return true;
	}

}
