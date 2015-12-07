package com.ignacio.proyectosensores.DAL;

import com.ignacio.proyectosensores.BLL.TipoUnidad;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ignacio
 */
public class TipoUnidadDAL {

	public static TipoUnidad find(int id) throws SinBaseDatosException {
		TipoUnidad s = null;
		Object[] f = ObjectDAL.find("select id_t_unidad, nombre "
				+ "from t_unidad where id_t_unidad=?", id);
		s = new TipoUnidad((int) f[0], (String) f[1]);
		return s;
	}

	public static Integer guardar(String nombre)
			throws SinBaseDatosException, CodigoRepetidoException {
		return ObjectDAL.guardar(
				"insert into t_unidad (nombre) values (?)",
				nombre);
	}

	public static boolean actualizar(Integer id, String nombre) throws SinBaseDatosException {
		return ObjectDAL.actualizar("update t_unidad "
				+ "set nombre=? where id_t_unidad=?",
				nombre, id);
	}

	public static boolean delete(Integer id) throws SinBaseDatosException {
		return ObjectDAL.delete(
				"delete from t_unidad where id_t_unidad=?",
				id);
	}

	public static TipoUnidad findBySensor(Integer id) throws SinBaseDatosException {
		TipoUnidad ts = null;
		String q = "select ts.id_t_unidad, ts.nombre from t_unidad as ts "
				+ "join sensor as s on ts.id_t_unidad=s.id_t_unidad "
				+ "where s.id_sensor=" + id;
		BD bd = new BD();
		ResultSet r;
		try {
			r = bd.createStatement().executeQuery(q);
			if (r.next()) {
				ts = new TipoUnidad(r.getInt("id_t_unidad"), r.getString("nombre"));
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
