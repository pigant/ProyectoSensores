package com.ignacio.proyectosensores.DAL;

import com.ignacio.proyectosensores.BLL.TipoUnidad;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ignacio
 */
public class TipoUnidadDAL {

	public static TipoUnidad find(int id) {
		TipoUnidad s = null;
		BD bd = null;
		try {
			bd = new BD();
			ArrayList<Object[]> select
					= bd.select("t_unidad",
							"id_t_unidad=" + id,
							"id_t_unidad", "nombre");
			final Object[] o = select.get(0);
			s = new TipoUnidad((int) o[0], (String) o[1]);
		} catch (SinBaseDatosException ex) {
			Logger.getLogger(TipoUnidadDAL.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			if (bd != null) {
				bd.close();
			}
		}
		return s;
	}

	public static Integer guardar(String nombre) {
		Integer s = null;
		BD bd = null;
		try {
			bd = new BD();
			boolean b = bd.update(
					"insert into t_unidad (nombre) values (?)", nombre);
			if (b) {
				s = bd.lastId();
			}
		} catch (SinBaseDatosException ex) {
			Logger.getLogger(TipoUnidadDAL.class.getName()).log(Level.SEVERE, null, ex);
		} catch (CodigoRepetidoException ex) {
			Logger.getLogger(TipoUnidadDAL.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(TipoUnidadDAL.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			if (bd != null) {
				bd.close();
			}
		}
		return s;
	}

	public static boolean actualizar(Integer id, String nombre) {
		boolean s = false;
		BD bd = null;
		try {
			bd = new BD();
			s = bd.update(
					"update t_unidad set nombre=? where id_t_unidad=?",
					nombre, id);
		} catch (SinBaseDatosException ex) {
			Logger.getLogger(TipoUnidadDAL.class.getName()).log(Level.SEVERE, null, ex);
		} catch (CodigoRepetidoException ex) {
			Logger.getLogger(TipoUnidadDAL.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			if (bd != null) {
				bd.close();
			}
		}
		return s;
	}

	public static boolean delete(Integer id) {
		boolean s = false;
		BD bd = null;
		try {
			bd = new BD();
			s = bd.update("delete from t_unidad where id_t_unidad=?", id);
		} catch (SinBaseDatosException ex) {
			Logger.getLogger(TipoUnidadDAL.class.getName()).log(Level.SEVERE, null, ex);
		} catch (CodigoRepetidoException ex) {
			//no aplica
		} finally {
			if (bd != null) {
				bd.close();
			}
		}
		return s;
	}

}
