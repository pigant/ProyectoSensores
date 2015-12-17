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
		List<Object[]> ob = ObjectDAL.findRaw(
				"select fecha, valor, id_tag "
				+ "from historial "
				+ "where id_tag=" + idTag
				+ "order by fecha ASC "
				+ "limit 1000");
		List<Historial> a = new ArrayList<>(ob.size());
		for (Object[] o : ob) {
			a.add(new Historial(
					(Timestamp) o[0],
					(BigDecimal) o[1],
					TagDAL.find((int) o[2])
			));
		}
		return a;
	}

	public static Integer guardar(Object... parametros)
			throws SinBaseDatosException, CodigoRepetidoException {
		return ObjectDAL.guardar(
				"insert into historial (fecha, valor, id_tag) "
				+ "values (?,?,?)", parametros);
	}

}
