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
		BD bd = new BD();
		Tag s = null;
		final ArrayList<Object[]> select = bd.select(
				"tag", "id_tag=" + id, "id_tag", "nombre", "url");
		final Object[] o = select.get(0);
		s = new Tag((int) o[0], (String) o[1], (String) o[2]);
		bd.close();
		return s;
	}

	public static boolean actualizar(Integer id, String nombre, String url, Integer id0, Integer id1) throws SinBaseDatosException {
		BD bd = new BD();
		boolean s = false;
		try {
			s = bd.update("update tag set nombre=?, url=?, id_sensor=?, id_protocolo=? where id_tag=?", nombre, url, id0, id1, id);
		} catch (CodigoRepetidoException ex) {
			Logger.getLogger(TagDAL.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			bd.close();
		}
		return s;
	}

	public static Integer guardar(String nombre, String url, Integer id, Integer id0) throws CodigoRepetidoException, SinBaseDatosException {
		Integer s = null;
		BD bd = new BD();
		boolean b = bd.update("insert into tag "
				+ "(nombre,url, id_sensor, id_protocolo) values (?,?,?,?)",
				nombre, url, id, id0);
		if (b) {
			try {
				s = bd.lastId();
			} catch (SQLException ex) {
				Logger.getLogger(TagDAL.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return s;
	}

	public static boolean delete(Integer id) throws SinBaseDatosException {
		boolean s = false;
		BD bd = new BD();
		try {
			s = bd.update("delete from tag where id_tag=?", id);
		} catch (CodigoRepetidoException ex) {
			//no aplica
		}
		return s;
	}

}
