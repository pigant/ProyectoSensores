/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ignacio.proyectosensores.DAL;

import com.ignacio.proyectosensores.BLL.Lugar;
import java.util.ArrayList;

/**
 *
 * @author ignacio
 */
public class LugarDAL {

	public static ArrayList<Lugar> findAll() throws SinBaseDatosException {
		ArrayList<Lugar> al = new ArrayList();
		ArrayList<Object[]> todos = ObjectDAL.findAll(
			"select id_lugar, nombre from lugar");
		for (Object[] parte : todos) {
			Lugar l = new Lugar(
				(int) parte[0],
				(String) parte[1]
			);
			al.add(l);
		}
		return al;
	}

	public static Integer guardar(String nombre) throws SinBaseDatosException {
		return ObjectDAL.guardar(
			"insert into lugar (nombre) values (?)", nombre);
	}

	public static boolean delete(int id) throws SinBaseDatosException {
		return ObjectDAL.delete("delete from lugar where id_lugar=?", id);
	}

	public static boolean actualizar(Integer id, String nombre) throws SinBaseDatosException {
		return ObjectDAL.actualizar(
			"update lugar set nombre=? where id_lugar=?", nombre, id);
	}

	public static Lugar find(int codigo) throws SinBaseDatosException {
		Object[] parametros = ObjectDAL.find(
			"select id_lugar, nombre from lugar where id_lugar=?",
			codigo);
		Lugar l = null;
		if (parametros != null) {
			l = new Lugar(
				(int) parametros[0],
				(String) parametros[1]);
		}
		return l;
	}

}
