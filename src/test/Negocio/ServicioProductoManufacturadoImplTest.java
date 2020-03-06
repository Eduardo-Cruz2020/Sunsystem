package test.Negocio;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Datos.DAOProductoManofacturado;
import Dominio.Producto_Manufacturado;
import Negocio.ServicioProductoManufacturado;
import Negocio.ServicioProductoManufacturadoImpl;
import test.Datos.DAOProductoManufacturadoMock;


public class ServicioProductoManufacturadoImplTest {
	private ServicioProductoManufacturado servicio;

	@Before
	public void setUp() throws Exception {
		
		// El servicio depende de un DAOProductoManufacturado, creamos un Mock y lo conectamos
		DAOProductoManofacturado dao = new DAOProductoManufacturadoMock();
		servicio = new ServicioProductoManufacturadoImpl(dao);

		
		// Creamos un producto de prueba
		Producto_Manufacturado producto = new Producto_Manufacturado();
		producto.setId(5555);
		producto.setNombre("lamparita");
		producto.setDescripcion("es una loca lamparita xd");
		producto.setCosto(500.6);
		producto.setTipo("lampara");
		producto.setCantidad(0);

		
		dao.crea(producto);
	}
	

	@Test
	public void testObtenerInformacionProductos() {
		//recupera el ArrayList de manera correcta
		ArrayList<Producto_Manufacturado> resultado = servicio.obtenerInformacionProductos();
		assertNotNull("regreso null, pero debió regresar un arreglo de productos",resultado);
	}
	
	@Test
	public void testGeneraRegistro() {
		//Crea el un producto que no exixtia antes
		boolean resultado = servicio.generaRegistro(5656, "descripcion", 10, "nombre", "tipo", 60.5);
		assertTrue("regreso false, pero debió regresar true",resultado);
		//intenta crear un producto cuyo ID ya esta registrado
		resultado = servicio.generaRegistro(5555, "descripcion", 10, "nombre", "tipo", 45.90);
		assertFalse("regreso true,  pero debio regresar false", resultado);
	}

	@Test
	public void testRliminaRegistro() {
		//Crea el libro que no exixtia antes
		boolean resultado = servicio.eliminaRegistro(1113);
		assertTrue("regreso false, pero debió regresar true",resultado);
		//intenta eliminar un producto que no existe
		resultado = servicio.eliminaRegistro(5555);
		assertFalse("regreso true,  pero debio regresar false", resultado);
	}
	
	@Test
	public void testActualizaCantidad
	() {
		//Crea el libro que no exixtia antes
		boolean resultado = servicio.actualizaCantidad(5656,3);
		assertTrue("regreso false, pero debió regresar true",resultado);
		//intenta eliminar un producto que no existe
		resultado = servicio.actualizaCantidad(5555,3);
		assertFalse("regreso true,  pero debio regresar false", resultado);
	}
	
	
	
	@After
	public void tearDown() throws Exception {
	}


}
