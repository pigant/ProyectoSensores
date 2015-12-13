package com.ignacio.proyectosensores.DAL;

import com.ignacio.proyectosensores.BLL.Tag;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ignacio
 */
public class TagDAL {

	public static Tag find(int id) throws SinBaseDatosException {
		Object[] o = ObjectDAL.find(
				"select id_tag, nombre, url, detalle, segundos "
				+ "from tag where id_tag=?", id);
		Tag s = new Tag((int) o[0], (String) o[1], (String) o[2], 
				(String) o[3], (int) o[4]);
		return s;
	}

	public static boolean actualizar(Integer idTag, String nombre, String url,
			int segundos, String detalle, Integer idSensor, Integer idProtocolo)
			throws SinBaseDatosException {
		//
		return ObjectDAL.actualizar("update tag set "
				+ "nombre=?, url=?, segundos=?, id_sensor=?, id_protocolo=?,"
				+ "detalle=? where id_tag=?", nombre, url, segundos,
				idSensor, idProtocolo, detalle, idTag);
	}

	public static Integer guardar(
			String nombre, String url, int segundos,
			String detalle, Integer id, Integer id0)
			throws CodigoRepetidoException, SinBaseDatosException {
		return ObjectDAL.guardar("insert into tag "
				+ "(nombre,url, segundos, detalle, id_sensor, id_protocolo) "
				+ "values (?,?,?,?,?,?)",
				nombre, url, segundos, detalle, id, id0);
	}

	public static boolean delete(Integer id) throws SinBaseDatosException {
		return ObjectDAL.delete("delete from tag where id_tag=?", id);
	}

	public static List<Tag> findByLugar(int id) throws SinBaseDatosException {
		ArrayList<Object[]> tagsRaw = ObjectDAL.findRaw(
				"select t.id_tag, t.nombre, t.url, t.segundos, "
				+ "t.detalle from tag as t "
				+ "join sensor as s on t.id_sensor=s.id_sensor "
				+ "join maquina as m on s.id_maquina=m.id_maquina "
				+ "join lugar as l on m.id_lugar=l.id_lugar "
				+ "where l.id_lugar=" + id);
		ArrayList<Tag> tags = new ArrayList(tagsRaw.size());
		for (Object[] ob : tagsRaw) {
			tags.add(new Tag((
					int) 		ob[0], //id
					(String) 	ob[1], //nombre
					(String) 	ob[2], //url
					(String) 	ob[4], //detalle
					(Integer)	ob[3]) //segundos
			);
		}
		return tags;
	}

	public static List<Tag> findByMaquina(int id) throws SinBaseDatosException {
		ArrayList<Object[]> tagsRaw = ObjectDAL.findRaw(
				"select t.id_tag, t.nombre, t.url, t.segundos, "
				+ "t.detalle from tag as t "
				+ "join sensor as s on t.id_sensor=s.id_sensor "
				+ "join maquina as m on s.id_maquina=m.id_maquina "
				+ "where m.id_maquina=" + id);
		ArrayList<Tag> tags = new ArrayList(tagsRaw.size());
		for (Object[] ob : tagsRaw) {
			tags.add(new Tag((
					int) 		ob[0], //id
					(String) 	ob[1], //nombre
					(String) 	ob[2], //url
					(String) 	ob[4], //detalle
					(Integer)	ob[3]) //segundos
			);
		}
		return tags;
	}

	public static List<Tag> findLike(String text) throws SinBaseDatosException {
		ArrayList<Object[]> ob = ObjectDAL.findRaw("select id_tag, nombre, url, segundos, detalle "
				+ "from tag "
				+ "where lower(nombre) like '%" + text + "%'");
		ArrayList<Tag> t = new ArrayList<>(ob.size());
		for (Object[] o : ob) {
			t.add(new Tag(
					(int) o[0],		//id
					(String) o[1],	//nombre
					(String) o[2],	//url
					(String) o[4],  //detalle
					(int) o[3]		//detalle
			));
		}
		return t;
	}

	public static List<Tag> findAll() throws SinBaseDatosException {
		ArrayList<Object[]> ob = ObjectDAL.findAll("select id_tag, nombre, url, segundos, detalle "
				+ "from tag");
		ArrayList<Tag> ts = new ArrayList(ob.size());
		for (Object[] o : ob) {
			ts.add(new Tag(
					(int) o[0],		//id
					(String) o[1],	//nombre
					(String) o[2],	//url
					(String) o[4],  //detalle
					(int) o[3]		//detalle
			));
		}
		return ts;
	}

}
