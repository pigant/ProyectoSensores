package com.ignacio.proyectosensores.BLL;

import com.ignacio.proyectosensores.DAL.CodigoRepetidoException;
import com.ignacio.proyectosensores.DAL.RestriccionException;
import com.ignacio.proyectosensores.DAL.SinBaseDatosException;
import com.ignacio.proyectosensores.DAL.TipoSensorDAL;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author ignacio
 */
public class TipoSensor {

	public static List<TipoSensor> findAll() throws SinBaseDatosException {
		return TipoSensorDAL.findAll();
	}

	public static List<TipoSensor> findLike(String text) throws SinBaseDatosException {
		return TipoSensorDAL.findLike(text);
	}

	private Integer id;
	private String nombre;

	public TipoSensor() {
	}

	public static TipoSensor find(int id) throws SinBaseDatosException {
		return TipoSensorDAL.find(id);
	}

	public TipoSensor(String nombre) {
		this.nombre = nombre;
	}

	public TipoSensor(Integer id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public boolean save() throws SinBaseDatosException, CodigoRepetidoException {
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

	public boolean delete() throws SinBaseDatosException, RestriccionException{
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

	@Override
	public String toString() {
		return nombre;
	}

}

