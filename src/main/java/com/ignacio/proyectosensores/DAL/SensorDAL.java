package com.ignacio.proyectosensores.DAL;

import com.ignacio.proyectosensores.BLL.Sensor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ignacio
 */
public class SensorDAL {

	public static Sensor find(int id) throws SinBaseDatosException {
		Sensor s = null;
		BD bd = null;
		try {
			bd = new BD();
			ArrayList<Object[]> select = bd.select("sensor", "id_sensor="+ id, "id_sensor", "nombre", 
				"escala", "detalle", "p_escala");
			if (select != null) {
			final Object[] o = select.get(0);
			s = new Sensor((int) o[0], 
				(String)o[1], 
				(String)o[2], 
				(String)o[3], 
				(boolean) o[4]);
			}
		}finally{
			if (bd != null) {
				bd.close();
			}
		}
		return s;
	}

	public static Integer guardar(
		String nombre, String escala,
		String detalle, boolean escalaPositiva,
		int idMaquina, Integer idTipoSensor,
		Integer idTipoUnidad) throws SinBaseDatosException {
		//Inicio metodo
		Integer s = null;
		BD bd = null;
		try {
			bd = new BD();
			boolean b = bd.update("insert into sensor "
				+ "(nombre, escala, detalle, p_escala, "
				+ "id_maquina, id_t_sensor, id_t_unidad)"
				+ " values (?,?,?,?,?,?,?)",
				nombre, escala, detalle, escalaPositiva,
				idMaquina, idTipoSensor, idTipoUnidad);
			if (b) {
				s = bd.lastId();
			}
		} catch (CodigoRepetidoException ex) {
			Logger.getLogger(SensorDAL.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(SensorDAL.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			if (bd != null) {
				bd.close();
			}
		}
		return s;
	}

	public static boolean actualizar(
		Integer id, String nombre,
		String escala, String detalle,
		boolean escalaPositiva, int idMaquina,
		Integer idTipoSensor, Integer idTipoUnidad)
		throws SinBaseDatosException {
		//Inicio metodo
		boolean s = false;
		BD bd = null;
		try {
			bd = new BD();
			s = bd.update("update sensor set nombre=?, escala=?,"
				+ "detalle=?, p_escala=?,"
				+ "id_maquina=?, id_t_sensor=?,"
				+ "id_t_unidad=? where id_sensor=?",
				nombre, escala, detalle, escalaPositiva,
				idMaquina, idTipoSensor, idTipoUnidad, id);
		} catch (CodigoRepetidoException ex) {
			Logger.getLogger(SensorDAL.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			if (bd != null) {
				bd.close();
			}
		}
		return s;
	}

	public static boolean delete(Integer id) throws SinBaseDatosException {
		boolean s = false;
		BD bd = null;
		try {
			bd = new BD();
			s = bd.update("delete from sensor where id_sensor=?", id);
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
