package com.ignacio.proyectosensores.DAL;

import com.ignacio.proyectosensores.BLL.Tag;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ignacio
 */
public class TagDAL {

	public static Tag find(int id) throws SinBaseDatosException {
		Object[] o = ObjectDAL.find("select id_tag, nombre, url, segundos, detalle "
			+ "from tag where id_tag=?", id);
		Tag s = new Tag((int) o[0], (String) o[1], (String) o[2], (int) o[3]);
		return s;
	}

	public static boolean actualizar(Integer id, String nombre, String url,
		int segundos, String detalle, Integer id0, Integer id1)
		throws SinBaseDatosException {
		//
		return ObjectDAL.actualizar("update tag set "
			+ "nombre=?, url=?, segundos=?, id_sensor=?, id_protocolo=?,"
			+ "detalle=? where id_tag=?", nombre, url, segundos,
			id0, id1, id, detalle);
	}

	public static Integer guardar(
		String nombre, String url, int segundos,
		String detalle, Integer id, Integer id0)
		throws CodigoRepetidoException, SinBaseDatosException {
		return ObjectDAL.guardar("insert into tag "
			+ "(nombre,url, segundos, detalle, id_sensor, id_protocolo) "
			+ "values (?,?,?,?,?,?)",
			nombre, url, segundos, detalle, id, id0);
	}

	public static boolean delete(Integer id) throws SinBaseDatosException {
		return ObjectDAL.delete("delete from tag where id_tag=?", id);
	}

}
