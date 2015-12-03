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

	public static Integer guardar(String nombre, int idLugar) throws SinBaseDatosException, CodigoRepetidoException {
		return ObjectDAL.guardar(
				"insert into maquina (nombre, id_lugar) values (?,?)",
				nombre, idLugar);
	}

	public static boolean actualizar(Integer id, String nombre, int idLugar) throws SinBaseDatosException {
		return ObjectDAL.actualizar(
				"update maquina "
				+ "set nombre=?, id_lugar=? where id_maquina=?",
				nombre, idLugar, id);
	}

	public static boolean delete(Integer id) throws SinBaseDatosException {
		return ObjectDAL.delete("delete from maquina where id_maquina=?", id);
	}

	public static Maquina find(int id) throws SinBaseDatosException {
		Maquina m = null;
		Object[] parametros = ObjectDAL.find(
				"select id_maquina, nombre, id_lugar "
				+ "from maquina where id_maquina=?", id);
		if (parametros != null) {
			m = new Maquina(
					(int) parametros[0],
					(String) parametros[1]);
		}
		return m;
	}

	public static List<Maquina> findAll() throws SinBaseDatosException {
		List<Maquina> m = new ArrayList();
		List<Object[]> all = ObjectDAL.findAll("select id_maquina, nombre from maquina");
		for (Object[] o : all) {
			m.add(new Maquina(
					(int) o[0],
					(String) o[1]
			));
		}
		return m;
	}

	public static Maquina findBySensor(int id) throws SinBaseDatosException {
		Maquina m = null;
		BD bd = new BD();
		try {
			ResultSet r = bd.createStatement().executeQuery(
					"select m.id_maquina, m.nombre from maquina as m "
					+ "join sensor as s on m.id_maquina=s.id_maquina "
					+ "where s.id_sensor=" + id + " limit 1"
			);
			if (r.next()) {
				m = new Maquina(r.getInt("id_maquina"), r.getString("nombre"));
			}
			r.close();
		} catch (SQLException ex) {
			Logger.getLogger(MaquinaDAL.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			bd.close();
		}
		return m;
	}

	public static ArrayList<Maquina> findAll() {
		ArrayList<Maquina> m = new ArrayList();
		BD bd = null;
		try {
			bd = new BD();
			ArrayList<Object[]> select = bd.select("maquina", "true",
					"id_maquina", "nombre");
			for (Object[] o : select) {
				m.add(new Maquina((int) o[0], (String) o[1]));
			}
		} catch (SinBaseDatosException ex) {
			Logger.getLogger(MaquinaDAL.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			if (bd != null) {
				bd.close();
			}
		}
		return m;
	}

}
