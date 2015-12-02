package com.ignacio.proyectosensores.BLL;

import com.ignacio.proyectosensores.DAL.TipoSensorDAL;
import java.util.Objects;

/**
 *
 * @author ignacio
 */
public class TipoSensor {

	private Integer id;
	private String nombre;

	public TipoSensor() {
	}

	public static TipoSensor find(int id) {
		return TipoSensorDAL.find(id);
	}

	public TipoSensor(String nombre) {
		this.nombre = nombre;
	}

	public TipoSensor(Integer id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public boolean save() {
		boolean s = false;
		if (id == null) {
			//guardar
			id = TipoSensorDAL.guardar(nombre);
			if (id != null) {
				s = true;
			}
		} else {
			//actualizar
			s = TipoSensorDAL.actualizar(id, nombre);
		}
		return s;
	}

	public boolean delete(){
		return TipoSensorDAL.delete(id);
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

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 29 * hash + Objects.hashCode(this.id);
		hash = 29 * hash + Objects.hashCode(this.nombre);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final TipoSensor other = (TipoSensor) obj;
		if (!Objects.equals(this.nombre, other.nombre)) {
			return false;
		}
		if (!Objects.equals(this.id, other.id)) {
			return false;
		}
		return true;
	}

}

