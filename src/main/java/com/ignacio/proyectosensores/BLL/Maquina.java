package com.ignacio.proyectosensores.BLL;

import com.ignacio.proyectosensores.DAL.CodigoRepetidoException;
import com.ignacio.proyectosensores.DAL.LugarDAL;
import com.ignacio.proyectosensores.DAL.MaquinaDAL;
import com.ignacio.proyectosensores.DAL.RestriccionException;
import com.ignacio.proyectosensores.DAL.SinBaseDatosException;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author ignacio
 */
public class Maquina {

	public static List<Maquina> findAll() throws SinBaseDatosException {
		List<Maquina> l = MaquinaDAL.findAll();
		return l;
	}

	public static List<Maquina> findLike(String text)
			throws SinBaseDatosException {
		List<Maquina> l = MaquinaDAL.findLike(text);
		for (Maquina m : l) {
			m.findDependencias();
		}
		return l;
	}

	public static List<Maquina> findAllWithDependency() 
			throws SinBaseDatosException {
		List<Maquina> l = MaquinaDAL.findAll();
		for (Maquina m : l) {
			m.findDependencias();
		}
		return l;
	}

	public static Maquina findByTag(Integer id) throws SinBaseDatosException {
		return MaquinaDAL.findByTag(id);
	}

	private Integer id;
	private String nombre;
	private String detalle;
	private Lugar lugar;

	public Maquina() {
	}

	public Maquina(String nombre) {
		this.nombre = nombre;
	}

	public Maquina(int id, String nombre, String detalle) {
		this.id = id;
		this.nombre = nombre;
		this.detalle = detalle;
	}

	public Maquina(int id, String nombre, String detalle, Lugar lugar) {
		this.id = id;
		this.nombre = nombre;
		this.detalle = detalle;
		this.lugar = lugar;
	}

	public static Maquina find(int id) throws SinBaseDatosException {
		return MaquinaDAL.find(id);
	}

	public void findLugar() throws SinBaseDatosException {
		Lugar lugar = LugarDAL.findByMaquina(id);
		setLugar(lugar);
	}

	public void findDependencias() throws SinBaseDatosException {
		findLugar();
	}

	public boolean save() throws SinBaseDatosException, CodigoRepetidoException {
		boolean s = false;
		int idLugar = lugar.getId();
		if (id == null) {
			id = MaquinaDAL.guardar(nombre, detalle, idLugar);
			if (id != null) {
				s = true;
			}
		} else {
			s = MaquinaDAL.actualizar(id, nombre, detalle, idLugar);
		}
		return s;
	}

	public boolean delete() throws SinBaseDatosException, RestriccionException {
		return MaquinaDAL.delete(id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Lugar getLugar() {
		return lugar;
	}

	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 29 * hash + Objects.hashCode(this.id);
		hash = 29 * hash + Objects.hashCode(this.nombre);
		hash = 29 * hash + Objects.hashCode(this.lugar);
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
		final Maquina other = (Maquina) obj;
		if (!Objects.equals(this.nombre, other.nombre)) {
			return false;
		}
		if (!Objects.equals(this.id, other.id)) {
			return false;
		}
		if (!Objects.equals(this.lugar, other.lugar)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return nombre;
	}

}
