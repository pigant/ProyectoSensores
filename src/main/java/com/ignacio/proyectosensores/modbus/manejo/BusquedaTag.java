/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ignacio.proyectosensores.modbus.manejo;

import com.ignacio.proyectosensores.BLL.Tag;
import com.ignacio.proyectosensores.DAL.SinBaseDatosException;
import com.ignacio.proyectosensores.modbus.Guardar;
import com.ignacio.proyectosensores.modbus.TagModbus;
import com.ignacio.proyectosensores.modbus.Tareas;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ignacio
 */
public final class BusquedaTag {

	List<TagModbus> ts;
	Map<String, Tareas> tareas = new HashMap<>();
	private static BusquedaTag instancia;

	private BusquedaTag() {
		try {
			ts = new ArrayList<>();
			buscar();
		} catch (SinBaseDatosException ex) {
			Logger.getLogger(BusquedaTag.class.getName()).log(
					Level.SEVERE, null, ex);
		}
	}

	public static BusquedaTag getInstance(){
		if (instancia == null){
			instancia = new BusquedaTag();
		}
		return instancia;
	}

	public void addTag(Tag t){
		agregar(t);
	}

	public void buscar() throws SinBaseDatosException {
		List<Tag> tags = Tag.findAllWithDependency();
		for (Tag t : tags) {
			agregar(t);
		}
	}

	private void agregar(Tag t) {
		TagModbus tm = new TagModbus(t);
		String[] dir = filtrarDireccion(t.getUrl());
		Tareas ta;
		ta = tareas.get(dir[0]);
		if (ta == null) {
			ta = new Tareas();
			tareas.put(dir[0], ta);
		}
		tm.setTareas(ta);
		tm.setDireccion(dir[1]);
		ts.add(tm);
	}

	/**
	 * El primer elemento es la IP, el segundo la direccion logica a la que se
	 * quiere acceder
	 *
	 * @param direccion
	 * @return
	 */
	public String[] filtrarDireccion(String direccion) {
		Pattern p = Pattern.compile(".*//(\\d+.\\d+.\\d+.\\d+)/(\\d+)");
		Matcher m = p.matcher(direccion);
		m.find();
		return new String[]{m.group(1), m.group(2)};
	}

	int simulados[] = new int[10];

	public void simulador() {
		Tareas tarea = tareas.get("10.0.0.16");
		int valor;
		for (int i = 0; i < 10; i++) {
			valor = (int) Math.round(Math.random() * 3);
			if (Math.random() > 0.5) {
				valor = -valor;
			}
			simulados[i] = Math.min(100, simulados[i]+valor);
			simulados[i] = Math.max(0, simulados[i]+valor);
			valor = simulados[i];
			tarea.addPedido(new Guardar(i,
					valor)
			);
		}
	}

	public void atender() {
		Arrays.fill(simulados, 50);
		while (true) {
			//Avanzar en el tiempo
			for (TagModbus t : ts) {
				t.decrementar();
			}
			simulador();
			Iterator i = tareas.entrySet().iterator();
			while (i.hasNext()) {
				Map.Entry<String, Tareas> m = (Map.Entry) i.next();
				Tareas t = m.getValue();
				t.operar();
			}
			//esperar
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
				Logger.getLogger(BusquedaTag.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

}
