package com.ignacio.proyectosensores.BLL;

import com.ignacio.proyectosensores.DAL.CodigoRepetidoException;
import com.ignacio.proyectosensores.DAL.LugarDAL;
import com.ignacio.proyectosensores.DAL.SinBaseDatosException;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author ignacio
 */
public class Lugar {

	public static List<Lugar> findAll() throws SinBaseDatosException {
		return LugarDAL.findAll();
	}

	public static List<Lugar> findLike(String text) throws SinBaseDatosException {
		return LugarDAL.findLike(text);
	}

	private Integer id;
	private String nombre;

	public Lugar() {
	}

	public Lugar(String nombre) {
		this.nombre = nombre;
	}

	public Lugar(Integer id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public static Lugar find(int codigo) throws SinBaseDatosException {
		return LugarDAL.find(codigo);
	}

	public boolean save() throws SinBaseDatosException, CodigoRepetidoException {
		// [ ] implementar falla en caso de no tener nombre
		// [x] implementar guardado
		// [x] Implementar actualizacion
		boolean s = false;
		if (id == null) {
			//guardar
			id = LugarDAL.guardar(nombre);
			if (id != null) {
				s = true;
			}
		} else {
			//Actualizar
			s = LugarDAL.actualizar(id, nombre);
		}
		return s;
	}

	public boolean delete() throws SinBaseDatosException {
		boolean s = false;
		if (id != null) {
			s = LugarDAL.delete(id);
		}
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

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 47 * hash + Objects.hashCode(this.id);
		hash = 47 * hash + Objects.hashCode(this.nombre);
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
		final Lugar other = (Lugar) obj;
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
