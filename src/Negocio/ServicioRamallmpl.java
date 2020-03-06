package Negocio;

import java.util.ArrayList;
import java.util.Iterator;

import Datos.DAORamal;
import Dominio.Ramal;

public class ServicioRamallmpl implements ServicioRamal {
	private DAORamal DAOramal;
	Ramal ramal;
	ArrayList<Ramal> ramales ; 

	public ServicioRamallmpl(DAORamal daoramalManufacturado){
		// TODO Auto-generated constructor stub
		// creamos conexion al DAO
		DAOramal = daoramalManufacturado;
	}
	
	public ArrayList<Ramal> obtenerInformacionramales(){
		ramales = DAOramal.recuperaTodos();
		return ramales;
	}
	/*
	 * Si el ID que recibe este método no esta registrado, crea una
	 *  nueva instancia y llama al DAO para que la agregue a la base de datos.
	 */
	public boolean generaRegistro(String nombre, String correo, String direccion, int Id) {
		if(verificaID(Id)==true) {
		ramal = new Ramal(nombre,correo,direccion,Id);
		DAOramal.crea(ramal);
		return true;
		}
		return false;
	}
	/*
	 *  método que verifica que no haya dos ramales con el mismo id (regla de negocio)
	*/
	public boolean verificaID(int Id) {
		Iterator<Ramal> it = ramales.iterator();
		while(it.hasNext()){
		    ramal =it.next();
		    if(Id == ramal.getId()) //encontró una coincidencia
		    	return false;
		}
		return true;
	}
	public boolean EliminaRamal(int id) {
		Iterator<Ramal> it = ramales.iterator();
		while(it.hasNext()){
		    ramal = it.next();
		    if(id == ramal.getId()) //encontró una coincidencia
		    {
		    	DAOramal.borra(ramal);
		    	return true;		    	
		    }
		    
		}
		return false;
	}
	public boolean eliminaRegistro(Ramal ramal) {
		if (verificaID(ramal.getId())!=false) {
		return false;
		}
		DAOramal.borra(ramal);
		return true;
	}
	@Override
	public ArrayList<Ramal> ramales() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<Ramal> obtenerInformacionRamales() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
