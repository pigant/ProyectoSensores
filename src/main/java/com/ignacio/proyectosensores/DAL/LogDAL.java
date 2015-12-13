/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ignacio.proyectosensores.DAL;

import com.ignacio.proyectosensores.BLL.Log;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ignacio
 */
public class LogDAL {

	public static List<Log> findAllOf(int idSensor) throws SinBaseDatosException {
		ArrayList<Object[]> ob = ObjectDAL.findRaw("select id_log, mensaje, fecha, activo "
				+ "from log where id_sensor=" + idSensor);
		ArrayList<Log> ls = new ArrayList<>(ob.size());
		for (Object[] o : ob) {
			ls.add(new Log(
					(int)o[0],
					(String) o[1],
					(Timestamp) o[2],
					(boolean) o[3]));
		}
		return ls;
	}
	
}
