package Datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Dominio.Pedido;

public class DAOPedidoBD implements DAOPedido {

	/**
	 * 
	 * Implementacion de DAOPedido que se conecta con una base de datos relacional
	 * 
	 * @author Ximena
	 *
	 */
	public boolean crea(Pedido pedido) {
			
			try {
				// Crea la instruccion
				Statement statement = ManejadorBaseDatos.getConnection().createStatement();
						
				// Ejecuta la instruccion
				statement.execute("INSERT INTO Pedido VALUES (DEFAULT,"+pedido.getCantidad()+",'"+pedido.getProveedor()+"',"+pedido.getCosto_total()+",'"+pedido.getFecha()+"','"+pedido.getMateria_Prima()+"')",Statement.RETURN_GENERATED_KEYS);
				ResultSet rs = statement.getGeneratedKeys(); // Recupera la llave
				if (rs != null && rs.next()) {
				    int No_Pedido = rs.getInt(1);
				    pedido.setNo_Pedido(No_Pedido); // Asigna la llave al pedido
				}
					
						
				return true;
			} catch (SQLException e) {
				
				// Cacha excepcion
				e.printStackTrace();
				return false;
			}

		}
		

		/**
		 * Retira un pedido del registro
		 * 
		 * @param pedido el pedido a retirar
		 * @return true si se retiro exitosamente, false si no
		 */
		public boolean borra(Pedido pedido) {
			try{			
				
				Statement statement = ManejadorBaseDatos.getConnection().createStatement();

				// Recibe los resutados
				statement.execute("DELETE FROM Pedido WHERE No_Pedido = '"+pedido.getNo_Pedido()+"'");

				
				return true;

			}catch(SQLException e){
				e.printStackTrace();
				return false;
			}
		}

		/**
		 * Regresa la lista de todos los pedidos con el mismo mes
		 * 
		 * @return un ArrayList con todos los pedidos que coinciden en el mismo mes en el registro
		 */
		public ArrayList<Pedido> recuperaMes(String mes) {

			ArrayList <Pedido> pedidos = new ArrayList<Pedido>();
			
			
			try{
				
				Statement statement = ManejadorBaseDatos.getConnection().createStatement();

				// Recibe los resutados
				ResultSet rs = statement.executeQuery("SELECT WHERE Mes = mes");

				
				while(rs.next())
				{
					Pedido pedido = new Pedido();
					pedido.setMes(rs.getString("mes"));
					pedido.setNo_Pedido(Integer.parseInt(rs.getString("No.Pedido")));
					pedido.setCantidad(Integer.parseInt(rs.getString("Cantidad")));
					pedido.setProveedor(rs.getString("Proveedor"));
					pedido.setCosto_total(Double.parseDouble(rs.getString("Costo_Total")));
					pedido.setFecha(rs.getString("Fecha"));
					pedido.setMateria_Prima(rs.getString("Materia_Prima"));
					pedidos.add(pedido);
				}
				
			}catch(SQLException e){
				e.printStackTrace();
			}
			
			return pedidos;

		}


		@Override
		public Pedido recupera(String fecha) {
			// TODO Auto-generated method stub
			return null;
		}


		@Override
		public boolean actualiza(Pedido pedido) {
			// TODO Auto-generated method stub
			return false;
		}



		

	}


