package Negocio;

import java.util.ArrayList;
import java.util.Iterator;

import Datos.DAOCliente;
import Dominio.Cliente;


public class ServicioClienteImple implements ServicioCliente{
	private DAOCliente DAOClientesillo;
	Cliente cliente;
	ArrayList<Cliente> clientes ; 

	public ServicioClienteImple(DAOCliente daoCliente) {
		// TODO Auto-generated constructor stub
		// creamos conexion al DAO
		DAOClientesillo = daoCliente;
	}
	
	public ArrayList<Cliente> obtenerInformacionClientes(){
		clientes = DAOClientesillo.recuperaTodos();
		return clientes;
	}
	/*
	 * Si el ID que recibe este m�todo no esta registrado, crea una
	 *  nueva instancia y llama al DAO para que la agregue a la base de datos.
	 */
	public boolean generaRegistro(int Id, String correo, String nombre, String tipo, int telefono ) {
		if(verificaID(Id)==true) {
		cliente = new Cliente (Id,tipo,nombre, correo,telefono);
		DAOClientesillo.crea(cliente);
		return true;
		}
		return false;
	}
	/*
	 *  m�todo que verifica que no haya dos productos con el mismo id (regla de negocio)
	*/
	public boolean verificaID(int Id) {
		Iterator<Cliente> it = clientes.iterator();
		while(it.hasNext()){
		    cliente =it.next();
		    if(Id == cliente.getId()) //encontro una coincidencia
		    	return false;
		}
		return true;
	}
 
	public boolean eliminaRegistro(int Id) {
		if (verificaID(Id)!=false) {
		return false;
		}
		DAOClientesillo.borra(Id);

		return true;
	}

	public ArrayList<Cliente> productos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Cliente> clientes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean generaCliente(int id, String correo, String nombre, String tipo, Double precio) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
