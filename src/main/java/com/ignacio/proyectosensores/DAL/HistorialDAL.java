/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ignacio.proyectosensores.DAL;

import com.ignacio.proyectosensores.BLL.Historial;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ignacio
 */
public class HistorialDAL {

	public static List<Historial> findLast1000(int idTag)
			throws SinBaseDatosException {
		ArrayList<Object[]> ob = ObjectDAL.findRaw(
				"select fecha, valor "
				+ "from historial "
				+ "where id_tag=" + idTag
				+ "order by fecha ASC "
				+ "limit 1000");
		ArrayList<Historial> a = new ArrayList<>(ob.size());
		for (Object[] o : ob) {
			a.add(new Historial((Timestamp) o[0], (BigDecimal) o[1]));
		}
		return a;
	}

}
