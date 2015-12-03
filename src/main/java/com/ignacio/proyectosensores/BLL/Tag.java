package com.ignacio.proyectosensores.BLL;

import com.ignacio.proyectosensores.DAL.CodigoRepetidoException;
import com.ignacio.proyectosensores.DAL.SinBaseDatosException;
import com.ignacio.proyectosensores.DAL.TagDAL;

/**
 *
 * @author ignacio
 */
public class Tag {

	private Integer id;
	private String nombre;
	private String url;
	private int segundos;
	private Sensor sensor;
	private Protocolo protocolo;

	public Tag() {
	}

	public Tag(String nombre, String url, int segundos) {
		this.nombre = nombre;
		this.url = url;
		this.segundos = segundos;
	}

	public Tag(Integer id, String nombre, String url, int segundos) {
		this.id = id;
		this.nombre = nombre;
		this.url = url;
		this.segundos = segundos;
	}

	public static Tag find(int id) throws SinBaseDatosException {
		return TagDAL.find(id);
	}

	public boolean save() throws SinBaseDatosException, CodigoRepetidoException {
		boolean s = false;
		if (id != null) {
			//actualizar
			s = TagDAL.actualizar(id,
					nombre, url,
					segundos,
					sensor.getId(),
					protocolo.getId());
		} else {
			//guardar
			id = TagDAL.guardar(
					nombre, url,
					segundos,
					sensor.getId(),
					protocolo.getId());
			if (id != null) {
				s = true;
			}
		}
		return s;
	}

	public boolean delete() throws SinBaseDatosException {
		boolean s;
		s = TagDAL.delete(id);
		return s;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Sensor getSensor() {
		return sensor;
	}

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}

	public Protocolo getProtocolo() {
		return protocolo;
	}

	public void setProtocolo(Protocolo protocolo) {
		this.protocolo = protocolo;
	}

	public void setSegundos(int segundos) {
		this.segundos = segundos;
	}

	public int getSegundos() {
		return this.segundos;
	}

	@Override
	public String toString() {
		return "Tag{" + "id=" + id + ", nombre=" + nombre + ", url=" + url + ", segundos=" + segundos + ", sensor=" + sensor + ", protocolo=" + protocolo + '}';
	}

}
