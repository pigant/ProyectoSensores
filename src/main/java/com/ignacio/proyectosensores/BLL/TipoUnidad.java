package com.ignacio.proyectosensores.BLL;

import com.ignacio.proyectosensores.DAL.CodigoRepetidoException;
import com.ignacio.proyectosensores.DAL.SinBaseDatosException;
import com.ignacio.proyectosensores.DAL.TipoUnidadDAL;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author ignacio
 */
public class TipoUnidad {

	public static List<TipoUnidad> findAll() throws SinBaseDatosException {
		return TipoUnidadDAL.findAll();
	}

	private Integer id;
	private String nombre;

	public TipoUnidad() {
	}

	public static TipoUnidad find(int id) throws SinBaseDatosException {
		return TipoUnidadDAL.find(id);
	}

	public boolean save() throws SinBaseDatosException, CodigoRepetidoException {
		boolean s = false;
		if (id == null) {
			//guardar
			id = TipoUnidadDAL.guardar(nombre);
			if (id != null) {
				s = true;
			}
		} else {
			//actualizar
			s = TipoUnidadDAL.actualizar(id, nombre);
		}
		return s;
	}

	public boolean delete() throws SinBaseDatosException{
		return TipoUnidadDAL.delete(id);
	}

	public TipoUnidad(String nombre) {
		this.nombre = nombre;
	}

	public TipoUnidad(Integer id, String nombre) {
		this.id = id;
		this.nombre = nombre;
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
		final TipoUnidad other = (TipoUnidad) obj;
		if (!Objects.equals(this.nombre, other.nombre)) {
			return false;
		}
		if (!Objects.equals(this.id, other.id)) {
			return false;
		}
		return true;
	}

}
