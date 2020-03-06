package Negocio;

import java.util.ArrayList;

import Dominio.Ramal;


public interface ServicioRamal {
	ArrayList<Ramal> ramales();

	boolean generaRegistro(String nombre, String correo, String direccion, int id);

	ArrayList<Ramal> obtenerInformacionRamales();	
	boolean EliminaRamal(int id);
}