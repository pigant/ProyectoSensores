package com.ignacio.proyectosensores.DAL;

import com.ignacio.proyectosensores.BLL.Lugar;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ignacio
 */
public class LugarDAL {

	public static List<Lugar> findAll() throws SinBaseDatosException {
		List<Lugar> al = new ArrayList();
		List<Object[]> todos = ObjectDAL.findAll(
				"select id_lugar, nombre from lugar");
		for (Object[] parte : todos) {
			Lugar l = new Lugar(
					(int) parte[0],
					(String) parte[1]
			);
			al.add(l);
		}
		return al;
	}

	public static Integer guardar(String nombre) throws SinBaseDatosException, CodigoRepetidoException {
		return ObjectDAL.guardar(
				"insert into lugar (nombre) values (?)", nombre);
	}

	public static boolean delete(int id) throws SinBaseDatosException {
		return ObjectDAL.delete("delete from lugar where id_lugar=?", id);
	}

	public static boolean actualizar(Integer id, String nombre) throws SinBaseDatosException {
		return ObjectDAL.actualizar(
				"update lugar set nombre=? where id_lugar=?", nombre, id);
	}

	public static Lugar find(int codigo) throws SinBaseDatosException {
		Object[] parametros = ObjectDAL.find(
				"select id_lugar, nombre from lugar where id_lugar=?",
				codigo);
		Lugar l = null;
		if (parametros != null) {
			l = new Lugar(
					(int) parametros[0],
					(String) parametros[1]);
		}
		return l;
	}

	public static Lugar findByMaquina(Integer id) throws SinBaseDatosException {
		Lugar l = null;
		String q = "select l.id_lugar, l.nombre from lugar as l "
				+ "join maquina as m on l.id_lugar=m.id_lugar "
				+ "where m.id_maquina=" + id;
		BD bd = new BD();
		try {
			ResultSet r = bd.createStatement().executeQuery(q);
			if (r.next()) {
				l = new Lugar(
						r.getInt("id_lugar"),
						r.getString("nombre")
				);
			}
			r.close();
		} catch (SQLException ex) {
			Logger.getLogger(LugarDAL.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			bd.close();
		}
		return l;
	}
	public static List<Lugar> findLike(String text) throws SinBaseDatosException {
		List<Lugar> l = new ArrayList();
		List<Object[]> ob = ObjectDAL.findRaw("select id_lugar, nombre "
				+ "from lugar where lower(nombre) like '%" + text + "%'");
		for (Object[] o : ob) {
			l.add(new Lugar((int) o[0], (String) o[1]));
		}
		return l;
	}
}
