/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ignacio.proyectosensores.modbus;

import com.ignacio.proyectosensores.BLL.Historial;
import com.ignacio.proyectosensores.BLL.Tag;
import com.ignacio.proyectosensores.DAL.CodigoRepetidoException;
import com.ignacio.proyectosensores.DAL.SinBaseDatosException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ignacio
 */
public class TagModbus implements Observer {

	private final Tag tag;
	private String direccion;
	private Tareas tareas;
	int segundos;

	public TagModbus(Tag tag) {
		this.tag = tag;
	}

	public void reiniciar() {
		segundos = tag.getSegundos();
	}

	public void decrementar() {
		segundos--;
		if (segundos <= 0) {
			//Se alista a las tareas
			tareas.addPedido(new Leer(Integer.valueOf(direccion), this));
			reiniciar();
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		Historial h = new Historial(
				new Timestamp(System.currentTimeMillis()),
				BigDecimal.valueOf((int) arg1),
				tag);
		try {
			Integer b = h.save();
		} catch (SinBaseDatosException ex) {
			Logger.getLogger(TagModbus.class.getName()).log(
					Level.SEVERE, null, ex);
		} catch (CodigoRepetidoException ex) {
			Logger.getLogger(TagModbus.class.getName()).log(
					Level.SEVERE, null, ex);
		}
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getSegundos() {
		return segundos;
	}

	public void setSegundos(int segundos) {
		this.segundos = segundos;
	}

	public Tareas getTareas() {
		return tareas;
	}

	public void setTareas(Tareas tareas) {
		this.tareas = tareas;
	}
}
