package com.ignacio.proyectosensores.DAL;

import com.ignacio.proyectosensores.BLL.Protocolo;

/**
 *
 * @author ignacio
 */
public class ProtocoloDAL {

	public static Protocolo find(int id) throws SinBaseDatosException {
		Object[] o = ObjectDAL.find("select id_protocolo, nombre "
				+ "from protocolo where id_protocolo=?",
				id);
		return new Protocolo((int) o[0], (String) o[1]);
	}

	public static Integer guardar(String nombre) throws SinBaseDatosException, CodigoRepetidoException {
		return ObjectDAL.guardar("insert into protocolo (nombre) values (?)", nombre);
	}

	public static boolean actualizar(Integer id, String nombre) throws SinBaseDatosException {
		return ObjectDAL.actualizar("update protocolo set nombre=? "
				+ "where id_protocolo=?",
				id);
	}

	public static boolean delete(Integer id) throws SinBaseDatosException {
		return ObjectDAL.delete(
				"delete from protocolo where id_protocolo=?",
				id);
	}

}
