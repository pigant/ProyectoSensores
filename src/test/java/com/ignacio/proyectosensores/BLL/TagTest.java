/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ignacio.proyectosensores.BLL;

import com.ignacio.proyectosensores.DAL.CodigoRepetidoException;
import com.ignacio.proyectosensores.DAL.SinBaseDatosException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author ignacio
 */
public class TagTest {
	
	public TagTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
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
	public void crud_tag() 
			throws SinBaseDatosException, 
			CodigoRepetidoException {
		//boolean t;
		//Tag l = new Tag("tag test", "4001", 2);
		//t = l.save();
		//assertTrue("No se guardo un tag", t);
		//l.setNombre("tag t test");
		//t = l.save();
		//assertTrue("No se actualizo un tag", t);
		////obtiene
		//Lugar l2 = Lugar.find(l.getId());
		//assertTrue("No se obtubo el 'tag' de la base de datos", l2.equals(l));
		//t = l.delete();
		//assertTrue("No se elimino un tag", t);
	}
}
