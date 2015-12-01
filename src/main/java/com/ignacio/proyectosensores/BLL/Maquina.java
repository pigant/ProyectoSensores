/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ignacio.proyectosensores.BLL;

import com.ignacio.proyectosensores.DAL.MaquinaDAL;
import java.util.Objects;

/**
 *
 * @author ignacio
 */
public class Maquina {

	private Integer id;
	private String nombre;
	private Lugar lugar;

	public Maquina() {
	}

	public Maquina(String nombre) {
		this.nombre = nombre;
	}

	public Maquina(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public Maquina(int id, String nombre, Lugar lugar) {
		this.id = id;
		this.nombre = nombre;
		this.lugar = lugar;
	}

	public static Maquina find(int id){
		return MaquinaDAL.find(id);
	}

	public boolean save() {
		boolean s = false;
		int idLugar = lugar.getId();
		if (id == null) {
			id = MaquinaDAL.guardar(nombre, idLugar);
			if (id != null) {
				s = true;
			}
		} else {
			s = MaquinaDAL.actualizar(id, nombre, idLugar);
		}
		return s;
	}

	public boolean delete(){
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

}
