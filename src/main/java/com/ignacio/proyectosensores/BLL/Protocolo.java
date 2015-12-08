/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ignacio.proyectosensores.BLL;

import com.ignacio.proyectosensores.DAL.CodigoRepetidoException;
import com.ignacio.proyectosensores.DAL.ProtocoloDAL;
import com.ignacio.proyectosensores.DAL.SinBaseDatosException;
import java.util.Objects;

/**
 *
 * @author ignacio
 */
public class Protocolo {

	public static ArrayList<Protocolo> findAll() throws SinBaseDatosException {
		return ProtocoloDAL.findAll();
	}

	private Integer id;
	private String nombre;

	public Protocolo() {
	}

	public static Protocolo find(int id) throws SinBaseDatosException {
		return ProtocoloDAL.find(id);
	}

	public Protocolo(String nombre) {
		this.nombre = nombre;
	}

	public Protocolo(Integer id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public boolean save() throws SinBaseDatosException, CodigoRepetidoException {
		boolean s = false;
		if (id == null) {
			//guardar
			id = ProtocoloDAL.guardar(nombre);
			if (id != null) {
				s = true;
			}
		} else {
			//actualizar
			s = ProtocoloDAL.actualizar(id, nombre);
		}
		return s;
	}

	public boolean delete() throws SinBaseDatosException {
		return ProtocoloDAL.delete(id);
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
		final Protocolo other = (Protocolo) obj;
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
