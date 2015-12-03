/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ignacio.proyectosensores.DAL;

import com.ignacio.proyectosensores.BLL.Protocolo;
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
public class ProtocoloDALTest {
	
	public ProtocoloDALTest() {
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

	/**
	 * Test of find method, of class ProtocoloDAL.
	 */
	@Test
	public void testFind() {
		System.out.println("find");
		int id = 0;
		Protocolo expResult = null;
		Protocolo result = ProtocoloDAL.find(id);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of guardar method, of class ProtocoloDAL.
	 */
	@Test
	public void testGuardar() {
		System.out.println("guardar");
		String nombre = "";
		Integer expResult = null;
		Integer result = ProtocoloDAL.guardar(nombre);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of actualizar method, of class ProtocoloDAL.
	 */
	@Test
	public void testActualizar() {
		System.out.println("actualizar");
		Integer id = null;
		String nombre = "";
		boolean expResult = false;
		boolean result = ProtocoloDAL.actualizar(id, nombre);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of delete method, of class ProtocoloDAL.
	 */
	@Test
	public void testDelete() {
		System.out.println("delete");
		Integer id = null;
		boolean expResult = false;
		boolean result = ProtocoloDAL.delete(id);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
}
