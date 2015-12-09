package com.ignacio.proyectosensores.DAL;

import com.ignacio.proyectosensores.BLL.Sensor;
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
public class SensorDAL {

	public static Sensor find(int id) throws SinBaseDatosException {
		Object[] o = ObjectDAL.find("select id_sensor, nombre, escala, detalle , p_escala "
				+ "from sensor where id_sensor=?", id);
		return new Sensor(
				(int) o[0],
				(String) o[1],
				(String) o[2],
				(String) o[3],
				(boolean) o[4]);

	}

	public static Integer guardar(
			String nombre, String escala,
			String detalle, boolean escalaPositiva,
			int idMaquina, Integer idTipoSensor,
			Integer idTipoUnidad) throws SinBaseDatosException, CodigoRepetidoException {
		//Inicio metodo
		return ObjectDAL.guardar(
				"insert into sensor "
				+ "(nombre, escala, detalle, p_escala, "
				+ "id_maquina, id_t_sensor, id_t_unidad)"
				+ " values (?,?,?,?,?,?,?)",
				nombre, escala, detalle, escalaPositiva,
				idMaquina, idTipoSensor, idTipoUnidad
		);
	}

	public static boolean actualizar(
			Integer id, String nombre,
			String escala, String detalle,
			boolean escalaPositiva, int idMaquina,
			Integer idTipoSensor, Integer idTipoUnidad)
			throws SinBaseDatosException {
		//Inicio metodo
		return ObjectDAL.actualizar("update sensor set nombre=?, escala=?,"
				+ "detalle=?, p_escala=?,"
				+ "id_maquina=?, id_t_sensor=?,"
				+ "id_t_unidad=? where id_sensor=?",
				nombre, escala, detalle, escalaPositiva,
				idMaquina, idTipoSensor, idTipoUnidad, id);
	}

	public static boolean delete(Integer id) throws SinBaseDatosException {
		return ObjectDAL.delete("delete from sensor where id_sensor=?", id);
	}

	public static List<Sensor> findLike(String text) throws SinBaseDatosException {
		ArrayList<Object[]> ob = ObjectDAL.findRaw("select id_sensor, nombre, escala, detalle, p_escala"
				+ " from sensor where lower(nombre) like '%" + text + "%'");
		ArrayList<Sensor> l = new ArrayList(ob.size());
		for (Object[] o : ob) {
			l.add(new Sensor((int) o[0], (String) o[1],
					(String) o[2], (String) o[3], (boolean) o[4]));
		}
		return l;
	}

	public static List<Sensor> findAll() throws SinBaseDatosException {
		ArrayList<Object[]> ob = ObjectDAL.findAll("select id_sensor, nombre, escala, detalle, p_escala "
				+ "from sensor");
		ArrayList<Sensor> l = new ArrayList(ob.size());
		for (Object[] o : ob) {
			l.add(new Sensor((int) o[0], (String) o[1], (String) o[2],
					(String) o[3], (boolean) o[4]));
		}
		return l;
	}

}
