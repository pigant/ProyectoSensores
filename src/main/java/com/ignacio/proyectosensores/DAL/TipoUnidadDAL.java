package com.ignacio.proyectosensores.DAL;

import com.ignacio.proyectosensores.BLL.TipoUnidad;

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

}
