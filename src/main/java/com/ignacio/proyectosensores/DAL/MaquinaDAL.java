/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ignacio.proyectosensores.DAL;

import com.ignacio.proyectosensores.BLL.Maquina;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ignacio
 */
public class MaquinaDAL {

	public static Integer guardar(String nombre, int idLugar) {
		BD bd = null;
		Integer s = null;
		try {
			bd = new BD();
			boolean b = bd.update("insert into maquina (nombre, id_lugar)"
					+ " values (?,?)", nombre, idLugar);
			if (b) {
				s = bd.lastId();
			}
		} catch (SinBaseDatosException ex) {
			Logger.getLogger(MaquinaDAL.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(MaquinaDAL.class.getName()).log(Level.SEVERE, null, ex);
		} catch (CodigoRepetidoException ex) {
			Logger.getLogger(MaquinaDAL.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			if (bd != null) {
				bd.close();
			}
		}
		return s;
	}

	public static boolean actualizar(Integer id, String nombre, int idLugar) {
		BD bd = null;
		boolean s = false;
		try {
			bd = new BD();
			s = bd.update("update maquina "
					+ "set nombre=?, id_lugar=? where id_maquina=?",
					nombre, idLugar, id);
		} catch (SinBaseDatosException ex) {
			Logger.getLogger(MaquinaDAL.class.getName()).log(Level.SEVERE, null, ex);
		} catch (CodigoRepetidoException ex) {
			Logger.getLogger(MaquinaDAL.class.getName()).log(Level.SEVERE, null, ex);
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
			s = bd.update("delete from maquina where id_maquina=?", id);
		} catch (SinBaseDatosException ex) {
			Logger.getLogger(MaquinaDAL.class.getName()).log(Level.SEVERE, null, ex);
		} catch (CodigoRepetidoException ex) {
			//no aplica
		} finally {
			if (bd != null) {
				bd.close();
			}
		}
		return s;
	}

	public static Maquina find(int id) {
		Maquina m = null;
		BD bd = null;
		try {
			bd = new BD();
			ArrayList<Object[]> select = bd.select("maquina", "id_maquina=" + id,
					"id_maquina", "nombre");
			final Object[] o = select.get(0);
			m = new Maquina((int) o[0], (String) o[1]);
		} catch (SinBaseDatosException ex) {
			Logger.getLogger(MaquinaDAL.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			if (bd != null) {
				bd.close();
			}
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
