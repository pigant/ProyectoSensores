/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ignacio.proyectosensores.DAL;

import com.ignacio.proyectosensores.BLL.Advertencia;
import java.util.List;

/**
 *
 * @author ignacio
 */
public class AdvertenciaDAL {

	public static Integer guardar(int minimo, int maximo, int idSensor) throws SinBaseDatosException, CodigoRepetidoException {
		Integer id = ObjectDAL.guardar(
				"insert into advertencia (min, max, id_sensor) "
				+ "values (?,?,?)", minimo, maximo, idSensor);
		return id;
	}

	public static Advertencia getBySensor(Integer id) throws SinBaseDatosException {
		List<Object[]> ob = ObjectDAL.findRaw("select id_advertencia, min, max "
				+ "from advertencia where id_sensor=" + id);
		Advertencia a = null;
		if (ob.size() > 0) {
			Object[] o = ob.get(0);
			a = new Advertencia((int) o[0], (int) o[1], (int) o[2], id);
		}
		return a;
	}

	public static boolean borrar(int idAdvertencia)
			throws SinBaseDatosException {
		return ObjectDAL.delete("delete from advertencia "
				+ "where id_advertencia=?", idAdvertencia);
	}

}
