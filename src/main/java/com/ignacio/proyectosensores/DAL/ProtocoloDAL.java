package com.ignacio.proyectosensores.DAL;

import com.ignacio.proyectosensores.BLL.Protocolo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ignacio
 */
public class ProtocoloDAL {
	
	public static Protocolo find(int id) {
		Protocolo s = null;
		BD bd = null;
		try {
			bd = new BD();
			ArrayList<Object[]> select
					= bd.select("protocolo",
							"id_protocolo=" + id,
							"id_protocolo", "nombre");
			final Object[] o = select.get(0);
			s = new Protocolo((int) o[0], (String) o[1]);
		} catch (SinBaseDatosException ex) {
			Logger.getLogger(ProtocoloDAL.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			if (bd != null) {
				bd.close();
			}
		}
		return s;
	}

	public static Integer guardar(String nombre) {
		Integer s = null;
		BD bd = null;
		try {
			bd = new BD();
			boolean b = bd.update(
					"insert into protocolo (nombre) values (?)", nombre);
			if (b) {
				s = bd.lastId();
			}
		} catch (SinBaseDatosException ex) {
			Logger.getLogger(ProtocoloDAL.class.getName()).log(Level.SEVERE, null, ex);
		} catch (CodigoRepetidoException ex) {
			Logger.getLogger(ProtocoloDAL.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(ProtocoloDAL.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			if (bd != null) {
				bd.close();
			}
		}
		return s;
	}

	public static boolean actualizar(Integer id, String nombre) {
		boolean s = false;
		BD bd = null;
		try {
			bd = new BD();
			s = bd.update(
					"update protocolo set nombre=? where id_protocolo=?",
					nombre, id);
		} catch (SinBaseDatosException ex) {
			Logger.getLogger(ProtocoloDAL.class.getName()).log(Level.SEVERE, null, ex);
		} catch (CodigoRepetidoException ex) {
			Logger.getLogger(ProtocoloDAL.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			if (bd != null) {
				bd.close();
			}
		}
		return s;
	}

	public static boolean delete(Integer id) {
		boolean s = false;
		BD bd = null;
		try {
			bd = new BD();
			s = bd.update("delete from protocolo where id_protocolo=?", id);
		} catch (SinBaseDatosException ex) {
			Logger.getLogger(ProtocoloDAL.class.getName()).log(Level.SEVERE, null, ex);
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
