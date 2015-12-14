/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ignacio.proyectosensores.modbus.manejo;

import com.ignacio.proyectosensores.BLL.Tag;
import com.ignacio.proyectosensores.DAL.SinBaseDatosException;
import com.ignacio.proyectosensores.modbus.TagModbus;
import com.ignacio.proyectosensores.modbus.Tareas;
import java.util.ArrayList;
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

	public BusquedaTag() {
		try {
			ts = new ArrayList<>();
			buscar();
		} catch (SinBaseDatosException ex) {
			Logger.getLogger(BusquedaTag.class.getName()).log(
					Level.SEVERE, null, ex);
		}
	}

	

	public void buscar() throws SinBaseDatosException {
		List<Tag> tags = Tag.findAllWithDependency();
		for (Tag t : tags) {
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

	public void atender() {
		while (true) {
			//Avanzar en el tiempo
			for (TagModbus t : ts) {
				t.decrementar();
			}
			Iterator i = tareas.entrySet().iterator();
			while (i.hasNext()) {
				Map.Entry<String, Tareas> m = (Map.Entry) i.next();
				Tareas t = m.getValue();
				t.operar();
				i.remove();
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
