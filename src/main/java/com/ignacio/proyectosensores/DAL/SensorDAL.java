package com.ignacio.proyectosensores.DAL;

import com.ignacio.proyectosensores.BLL.Sensor;
import java.util.ArrayList;
import java.util.List;

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

	public static boolean delete(Integer id)
			throws SinBaseDatosException, RestriccionException {
		return ObjectDAL.delete("delete from sensor where id_sensor=?", id);
	}

	public static List<Sensor> findLike(String text) throws SinBaseDatosException {
		List<Object[]> ob = ObjectDAL.findRaw("select id_sensor, nombre, escala, detalle, p_escala"
				+ " from sensor where lower(nombre) like '%" + text + "%'");
		List<Sensor> l = new ArrayList(ob.size());
		for (Object[] o : ob) {
			l.add(new Sensor((int) o[0], (String) o[1],
					(String) o[2], (String) o[3], (boolean) o[4]));
		}
		return l;
	}

	public static List<Sensor> findAll() throws SinBaseDatosException {
		List<Object[]> ob = ObjectDAL.findAll("select id_sensor, nombre, escala, detalle, p_escala "
				+ "from sensor");
		List<Sensor> l = new ArrayList(ob.size());
		for (Object[] o : ob) {
			l.add(new Sensor((int) o[0], (String) o[1], (String) o[2],
					(String) o[3], (boolean) o[4]));
		}
		return l;
	}

	public static Sensor findByTag(int id) throws SinBaseDatosException {
		Sensor s = null;
		List<Object[]> p = ObjectDAL.findRaw(
				"select s.id_sensor, s.nombre, s.escala, s.detalle, s.p_escala "
				+ "from sensor as s "
				+ "join tag as t on t.id_sensor=s.id_sensor "
				+ "where t.id_tag=" + id);
		if (p.size() > 0) {
			Object[] o = p.get(0);
			s = new Sensor(
					(int) o[0], //id
					(String) o[1], //nombre
					(String) o[2], //Escala
					(String) o[3], //Detalle
					(Boolean) o[4]);	//p_escala
		}
		return s;
	}

}
