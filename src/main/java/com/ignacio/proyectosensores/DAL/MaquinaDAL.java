/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ignacio.proyectosensores.DAL;

import com.ignacio.proyectosensores.BLL.Maquina;
import java.util.ArrayList;

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

	public static ArrayList<Maquina> findAll() throws SinBaseDatosException {
		ArrayList<Maquina> m = new ArrayList();
		ArrayList<Object[]> all = ObjectDAL.findAll("select id_maquina, nombre from maquina");
		for (Object[] o : all) {
			m.add(new Maquina(
				(int) o[0],
				(String) o[1]
			));
		}
		return m;
	}

}
