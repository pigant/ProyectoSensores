package com.ignacio.proyectosensores.DAL;

import com.ignacio.proyectosensores.BLL.Maquina;
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
public class MaquinaDAL {

	public static Integer guardar(String nombre, String detalle, int idLugar)
		throws SinBaseDatosException, CodigoRepetidoException {
		//
		return ObjectDAL.guardar(
			"insert into maquina (nombre, detalle, id_lugar) values (?,?,?)",
			nombre, detalle, idLugar);
	}

	public static boolean actualizar(Integer id, String nombre, String detalle,
		int idLugar) throws SinBaseDatosException {
		//
		return ObjectDAL.actualizar(
			"update maquina "
			+ "set nombre=?, id_lugar=?, detalle=? where id_maquina=?",
			nombre, idLugar, detalle, id);
	}

	public static boolean delete(Integer id) throws SinBaseDatosException {
		return ObjectDAL.delete("delete from maquina where id_maquina=?", id);
	}

	public static Maquina find(int id) throws SinBaseDatosException {
		Maquina m = null;
		Object[] parametros = ObjectDAL.find(
			"select id_maquina, nombre, detalle, id_lugar "
			+ "from maquina where id_maquina=?", id);
		if (parametros != null) {
			m = new Maquina(
				(int) parametros[0],
				(String) parametros[1],
				(String) parametros[2]
			);
		}
		return m;
	}

	public static List<Maquina> findAll() throws SinBaseDatosException {
		List<Maquina> m = new ArrayList();
		List<Object[]> all = ObjectDAL.findAll("select id_maquina, nombre, detalle from maquina");
		for (Object[] o : all) {
			m.add(new Maquina(
				(int) o[0],
				(String) o[1],
				(String) o[2]
			));
		}
		return m;
	}

	public static Maquina findBySensor(int id) throws SinBaseDatosException {
		Maquina m = null;
		BD bd = new BD();
		try {
			ResultSet r = bd.createStatement().executeQuery(
				"select m.id_maquina, m.nombre, m.detalle from maquina as m "
				+ "join sensor as s on m.id_maquina=s.id_maquina "
				+ "where s.id_sensor=" + id + " limit 1"
			);
			if (r.next()) {
				m = new Maquina(r.getInt("id_maquina"), r.getString("nombre"), r.getString("detalle"));
			}
			r.close();
		} catch (SQLException ex) {
			Logger.getLogger(MaquinaDAL.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			bd.close();
		}
		return m;
	}

}
