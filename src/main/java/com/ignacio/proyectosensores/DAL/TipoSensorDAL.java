package com.ignacio.proyectosensores.DAL;

import com.ignacio.proyectosensores.BLL.TipoSensor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ignacio
 */
public class TipoSensorDAL {

	public static TipoSensor find(int id) throws SinBaseDatosException {
		TipoSensor ts = null;
		Object[] find = ObjectDAL.find("select id_t_sensor, nombre "
				+ "from t_sensor where id_t_sensor=?", id);
		if (find != null) {
			ts = new TipoSensor((int) find[0], (String) find[1]);
		}
		return ts;
	}

	public static Integer guardar(String nombre) throws SinBaseDatosException, CodigoRepetidoException {
		return ObjectDAL.guardar(
				"insert into t_sensor (nombre) values (?)", nombre);
	}

	public static boolean actualizar(Integer id, String nombre) throws SinBaseDatosException {
		return ObjectDAL.actualizar(
				"update t_sensor set nombre=? where id_t_sensor=?",
				nombre, id);
	}

	public static boolean delete(Integer id) throws SinBaseDatosException {
		return ObjectDAL.delete(
				"delete from t_sensor where id_t_sensor=?",
				id);
	}

	public static TipoSensor findBySensor(Integer id) throws SinBaseDatosException {
		TipoSensor ts = null;
		String q = "select ts.id_t_sensor, ts.nombre from t_sensor as ts "
				+ "join sensor as s on ts.id_t_sensor=s.id_t_sensor "
				+ "where s.id_sensor=" + id;
		BD bd = new BD();
		ResultSet r;
		try {
			r = bd.createStatement().executeQuery(q);
			if (r.next()) {
				ts = new TipoSensor(r.getInt("id_t_sensor"), r.getString("nombre"));
			}
			r.close();
		} catch (SQLException ex) {
			Logger.getLogger(TipoSensorDAL.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			bd.close();
		}
		return ts;
	}

}
