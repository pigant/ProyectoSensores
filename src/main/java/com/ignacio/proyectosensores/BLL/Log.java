/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ignacio.proyectosensores.BLL;

import com.ignacio.proyectosensores.DAL.LogDAL;
import com.ignacio.proyectosensores.DAL.SinBaseDatosException;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author ignacio
 */
public class Log {

	public static List<Log> findAllWithProblems(int idSensor) 
			throws SinBaseDatosException {
		return LogDAL.findAllWithProblems(idSensor);
	}

	public static void changeStatus(int idSensor) throws SinBaseDatosException {
		LogDAL.changeStatus(idSensor);
	}

	private int id;
	private String mensaje;
	Timestamp fecha;
	boolean activo;
	Sensor sensor;

	public Log() {
	}

	public Log(int id,
			String mensaje,
			Timestamp fecha,
			boolean activo){
		this.id = id;
		this.mensaje = mensaje;
		this.fecha = fecha;
		this.activo = activo;
	}

	public static List<Log> findAllOf(int idSensor) 
			throws SinBaseDatosException {
		return LogDAL.findAllOf(idSensor);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Sensor getSensor() {
		return sensor;
	}

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}
}
