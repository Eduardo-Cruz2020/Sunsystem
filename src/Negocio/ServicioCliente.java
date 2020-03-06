package Negocio;

import java.util.ArrayList;

import Dominio.Cliente;

public interface ServicioCliente {
	ArrayList<Cliente> clientes();

	boolean generaCliente(int id, String correo, String nombre, String tipo, Double precio);

	ArrayList<Cliente> obtenerInformacionClientes();
	
}
