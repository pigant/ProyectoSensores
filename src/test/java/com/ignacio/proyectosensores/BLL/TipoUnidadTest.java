package com.ignacio.proyectosensores.BLL;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.ignacio.proyectosensores.BLL.TipoUnidad;
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
public class TipoUnidadTest {

	public TipoUnidadTest() {
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
	public void CRUD_tipo_unidad() {
		//creacion
		TipoUnidad t = new TipoUnidad("celsius test");
		boolean s = t.save();
		assertTrue("No se guardo 'tipo_unidad'", s);
		//update
		t.setNombre("farenheit test");
		s = t.save();
		assertTrue("No se actualizo 'tipo_unidad'", s);
		//read
		TipoUnidad t2 = TipoUnidad.find(t.getId());
		assertTrue("No se obtubo correctamente la unidad", t2.equals(t));
		//delete
		s = t.delete();
		assertTrue("No se elimino correctamente la 'unidad'", s);
	}
}
