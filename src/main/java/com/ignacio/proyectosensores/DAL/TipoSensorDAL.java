package com.ignacio.proyectosensores.DAL;

import com.ignacio.proyectosensores.BLL.TipoSensor;

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

}
