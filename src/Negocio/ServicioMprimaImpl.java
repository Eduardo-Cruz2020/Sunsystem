package Negocio;

import java.util.ArrayList;
import java.util.Iterator;

import Datos.DAOMateria_Prima;
import Dominio.Materia_Prima;


public class ServicioMprimaImpl implements ServicioMprima {
	private DAOMateria_Prima DAOProducto;
	Materia_Prima producto;
	ArrayList<Materia_Prima> productos ; 

	public ServicioMprimaImpl(DAOMateria_Prima daoMprima) {
		// TODO Auto-generated constructor stub
		// creamos conexion al DAO
		DAOProducto = daoMprima;
	}
	@Override
	public ArrayList<Materia_Prima> obtenerproductos() {
		// TODO Auto-generated method stub
		productos = DAOProducto.recuperaTodos();
		return productos;
	}

	@Override
	public boolean generaRegistro(int id, String nombre, double costo) {
		// TODO Auto-generated method stub
		if(verificaID(id)==true) {
			producto = new Materia_Prima(id, nombre, costo);
			DAOProducto.crea(producto);
			return true;
		}
		return false;
	}

	private boolean verificaID(int id) {
		// TODO Auto-generated method stub
		Iterator<Materia_Prima> it = productos.iterator();
		while(it.hasNext()){
		    producto =it.next();
		    if(id == producto.getId()) //encontro una coincidencia
		    	return false;
		}
		return true;
	}
	@Override
	public ArrayList<Materia_Prima> obtenerInformacionProductos() {
		// TODO Auto-generated method stub
		productos = DAOProducto.recuperaTodos();
		return productos;
		
	}

}
