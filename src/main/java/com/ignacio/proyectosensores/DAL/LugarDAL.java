/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ignacio.proyectosensores.DAL;

import com.ignacio.proyectosensores.BLL.Lugar;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ignacio
 */
public class LugarDAL {

	private BD bd;

	public static Integer guardar(String nombre) {
		Integer s = null;
		try {
			BD bd = new BD();
			boolean b = bd.update("insert into lugar (nombre) values (?)", nombre);
			if (b) {
				s = bd.lastId();
			}
		} catch (SinBaseDatosException ex) {
			Logger.getLogger(LugarDAL.class.getName()).log(Level.SEVERE, null, ex);
		} catch (CodigoRepetidoException ex) {
			Logger.getLogger(LugarDAL.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(LugarDAL.class.getName()).log(Level.SEVERE, null, ex);
		}
		return s;
	}

	public static boolean delete(int id) {
		boolean s = false;
		try {
			BD bd = new BD();
			s = bd.update("delete from lugar where id_lugar=?", id);
		} catch (SinBaseDatosException ex) {
			Logger.getLogger(LugarDAL.class.getName()).log(Level.SEVERE, null, ex);
		} catch (CodigoRepetidoException ex) {
			//no aplica
		}
		return s;
	}

	public static boolean actualizar(Integer id, String nombre) {
		boolean s = false;
		try {
			BD bd = new BD();
			s = bd.update("update lugar set nombre=? where id_lugar=?", nombre, id);
		} catch (SinBaseDatosException ex) {
			Logger.getLogger(LugarDAL.class.getName()).log(Level.SEVERE, null, ex);
		} catch (CodigoRepetidoException ex) {
			//no aplica
		}
		return s;
	}

	public LugarDAL() throws SinBaseDatosException {
		bd = new BD();
	}

	public static Lugar find(int codigo) {
		Lugar l = null;
		try {
			BD bd = new BD();
			ArrayList<Object[]> select
					= bd.select("lugar", "id_lugar=" + codigo, "id_lugar", "nombre");
			if (select != null && select.size() > 0) {
				final Object[] lugar = select.get(0);
				l = new Lugar((Integer) lugar[0], (String) lugar[1]);
			}
		} catch (SinBaseDatosException ex) {
			Logger.getLogger(LugarDAL.class.getName()).log(Level.SEVERE, null, ex);
		}
		return l;
	}

}
