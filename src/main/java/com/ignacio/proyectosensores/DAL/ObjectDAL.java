/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ignacio.proyectosensores.DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ignacio
 */
public class ObjectDAL {

	public static Integer guardar(String consulta, Object... parametros)
			throws SinBaseDatosException, CodigoRepetidoException {
		Integer s = null;
		try {
			BD bd = new BD();
			boolean b = bd.update(consulta, parametros);
			if (b) {
				s = bd.lastId();
			}
		} catch (SQLException ex) {
			Logger.getLogger(LugarDAL.class.getName()).log(Level.SEVERE, null, ex);
		}
		return s;
	}

	public static boolean delete(String consulta, int id) throws SinBaseDatosException {
		boolean s = false;
		try {
			BD bd = new BD();
			s = bd.update(consulta, id);
		} catch (CodigoRepetidoException ex) {
			//no aplica
		}
		return s;
	}

	public static boolean actualizar(String consulta,
			Object... parametros) throws SinBaseDatosException {
		//
		boolean s = false;
		try {
			BD bd = new BD();
			s = bd.update(consulta, parametros);
		} catch (CodigoRepetidoException ex) {
			//no aplica
		}
		return s;
	}

	/**
	 * Devuelve todos los parametros
	 *
	 * @param consulta
	 * @param codigo
	 * @return
	 */
	public static Object[] find(String consulta, int codigo) throws SinBaseDatosException {
		Object[] l = null;
		try {
			BD bd = new BD();
			PreparedStatement p = bd.createStatement(consulta);
			p.setInt(1, codigo);
			ResultSet r = p.executeQuery();
			if (r.next()) {
				ResultSetMetaData metaData = r.getMetaData();
				int co = metaData.getColumnCount();
				l = new Object[co];
				for (int i = 0; i < co; i++) {
					l[i] = r.getObject(i + 1);
				}
			}
		} catch (SQLException ex) {
			Logger.getLogger(ObjectDAL.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SecurityException ex) {
			Logger.getLogger(ObjectDAL.class.getName()).log(Level.SEVERE, null, ex);
		}
		return l;
	}

	public static ArrayList<Object[]> findAll(String consulta) throws SinBaseDatosException {
		ArrayList<Object[]> a = new ArrayList();
		try {
			BD bd = new BD();
			PreparedStatement ps = bd.createStatement(consulta);
			ResultSet r = ps.executeQuery();
			ResultSetMetaData metaData = r.getMetaData();
			int co = metaData.getColumnCount();
			while (r.next()) {
				Object o[] = new Object[co];
				for (int i = 0; i < co; i++) {
					o[i] = r.getObject(i + 1);
				}
				a.add(o);
			}

		} catch (SQLException ex) {
			Logger.getLogger(ObjectDAL.class.getName()).log(Level.SEVERE, null, ex);
		}
		return a;

	}

	public static ArrayList<Object[]> findRaw(String consulta) throws SinBaseDatosException {
		ArrayList<Object[]> al = new ArrayList();
		try {
			BD bd = new BD();
			ResultSet r = bd.createStatement().executeQuery(consulta);
			int col = r.getMetaData().getColumnCount();
			while (r.next()) {
				Object o[] = new Object[col];
				for (int i = 0; i < o.length; i++) {
					o[i] = r.getObject(i + 1);
				}
				al.add(o);
			}
		} catch (SQLException ex) {
			Logger.getLogger(ObjectDAL.class.getName()).log(Level.SEVERE, null, ex);
		}
		return al;
	}

}
