/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.ignacio.proyectosensores.BLL.Protocolo;
import com.ignacio.proyectosensores.DAL.BD;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ignacio
 */
public class ProtocoloTest {

	@BeforeClass
	public static void setUpClass() throws SQLException {
		BD.setTesting();
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	// TODO add test methods here.
	// The methods must be annotated with annotation @Test. For example:
	//
	// @Test
	// public void hello() {}
	@Test
	public void CRUD_protocolo() {
		//creacion
		Protocolo t = new Protocolo("modbus test");
		boolean s = t.save();
		assertTrue("No se guardo 'protocolo'", s);
		//update
		t.setNombre("CAN test");
		s = t.save();
		assertTrue("No se actualizo 'protocolo'", s);
		//read
		Protocolo t2 = Protocolo.find(t.getId());
		assertTrue("No se obtubo correctamente el protocolo", t2.equals(t));
		//delete
		s = t.delete();
		assertTrue("No se elimino correctamente el 'protocolo'", s);
	}
}
