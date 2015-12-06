package com.ignacio.proyectosensores.BLL;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.ignacio.proyectosensores.BLL.Lugar;
import com.ignacio.proyectosensores.BLL.Maquina;
import com.ignacio.proyectosensores.DAL.BD;
import com.ignacio.proyectosensores.DAL.CodigoRepetidoException;
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
public class MaquinaTest {

	public MaquinaTest() {
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
	public void CRUD_maquina() throws SinBaseDatosException, CodigoRepetidoException {
		Lugar l = new Lugar("lugar test");
		l.save();
		//Create
		Maquina m = new Maquina("cosa test");
		m.setLugar(l);
		boolean s = m.save();
		//Update
		assertTrue("No se guardo la maquina", s);
		m.setNombre("la cosa del test");
		s = m.save();
		assertTrue("No se actualizo la maquina", s);
		//READ
		Maquina m2 = Maquina.find(m.getId());
		m2.setLugar(l);
		assertTrue("No se obtuvo 'maquina'", m2.equals(m));
		//delete
		s = m.delete();
		assertTrue("No se borro la maquina", s);
		l.delete();
	}
}
