package com.ignacio.proyectosensores.DAL;

import com.ignacio.proyectosensores.BLL.TipoSensor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ignacio
 */
public class TipoSensorDAL {

	public static TipoSensor find(int id) {
		TipoSensor s = null;
		BD bd = null;
		try {
			bd = new BD();
			ArrayList<Object[]> select
					= bd.select("t_sensor",
							"id_t_sensor=" + id,
							"id_t_sensor", "nombre");
			final Object[] o = select.get(0);
			s = new TipoSensor((int) o[0], (String) o[1]);
		} catch (SinBaseDatosException ex) {
			Logger.getLogger(TipoSensorDAL.class.getName()).log(Level.SEVERE, null, ex);
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
					"insert into t_sensor (nombre) values (?)", nombre);
			if (b) {
				s = bd.lastId();
			}
		} catch (SinBaseDatosException ex) {
			Logger.getLogger(TipoSensorDAL.class.getName()).log(Level.SEVERE, null, ex);
		} catch (CodigoRepetidoException ex) {
			Logger.getLogger(TipoSensorDAL.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(TipoSensorDAL.class.getName()).log(Level.SEVERE, null, ex);
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
					"update t_sensor set nombre=? where id_t_sensor=?",
					nombre, id);
		} catch (SinBaseDatosException ex) {
			Logger.getLogger(TipoSensorDAL.class.getName()).log(Level.SEVERE, null, ex);
		} catch (CodigoRepetidoException ex) {
			Logger.getLogger(TipoSensorDAL.class.getName()).log(Level.SEVERE, null, ex);
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
			s = bd.update("delete from t_sensor where id_t_sensor=?", id);
		} catch (SinBaseDatosException ex) {
			Logger.getLogger(TipoSensorDAL.class.getName()).log(Level.SEVERE, null, ex);
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
