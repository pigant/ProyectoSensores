/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ignacio.proyectosensores.BLL;

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
public class SensorTest {

	public SensorTest() {
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

	/**
	 * Test of find method, of class Sensor.
	 */
	@Test
	public void CRUD_sensor() throws SinBaseDatosException, CodigoRepetidoException {
		//creaciones
		Lugar l = new Lugar("lugar presion test sensor");
		Maquina m = new Maquina("Maquina test sensor");
		TipoUnidad tu = new TipoUnidad("tipo unidad test sensor");
		TipoSensor ts = new TipoSensor("tipo sensor test sensor");
		Sensor s = new Sensor("Presion", "1*x",
			"Algo de texto para el relleno", true);
		//uniones
		m.setLugar(l);
		s.setMaquina(m);
		s.setTipoSensor(ts);
		s.setTipoUnidad(tu);
		//guardado
		l.save();
		m.save();
		tu.save();
		ts.save();
		boolean resultado = m.save();
		assertTrue("No se guardo el sensor", resultado);
		//Actualizacion
		s.setNombre("sensor update test");
		resultado = s.save();
		assertTrue("No se actualizo el sensor", resultado);
		//Read
		Sensor s2 = Sensor.find(s.getId());
		s2.setMaquina(m);
		s2.setTipoSensor(ts);
		s2.setTipoUnidad(tu);
		resultado = s2.equals(s);
		assertTrue("No se leyo correctamente el sensor", resultado);
		//Eliminado
		resultado = s.delete();
		m.delete();
		l.delete();
		tu.delete();
		ts.delete();
		assertTrue("No se borro el sensor", resultado);
	}

}
