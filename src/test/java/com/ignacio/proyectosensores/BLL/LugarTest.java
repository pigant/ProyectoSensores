package com.ignacio.proyectosensores.BLL;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.ignacio.proyectosensores.BLL.Lugar;
import com.ignacio.proyectosensores.DAL.BD;
import com.ignacio.proyectosensores.DAL.SinBaseDatosException;
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
public class LugarTest {

	public LugarTest() {
	}

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
	public void crud_lugar() throws SinBaseDatosException {
		boolean t;
		Lugar l = new Lugar("planeta test");
		t = l.save();
		assertTrue("No se guardo un lugar", t);
		l.setNombre("proeta test");
		t = l.save();
		assertTrue("No se actualizo un lugar", t);
		//obtiene
		Lugar l2 = Lugar.find(l.getId());
		assertTrue("No se obtubo el 'lugar' de la base de datos", l2.equals(l));
		t = l.delete();
		assertTrue("No se elimino un lugar", t);
	}
}
