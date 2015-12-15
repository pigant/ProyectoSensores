/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ignacio.proyectosensores.BLL;

import com.ignacio.proyectosensores.DAL.AdvertenciaDAL;
import com.ignacio.proyectosensores.DAL.CodigoRepetidoException;
import com.ignacio.proyectosensores.DAL.SinBaseDatosException;

/**
 *
 * @author ignacio
 */
public class Advertencia {

	public static Advertencia getBySensor(Integer id) 
			throws SinBaseDatosException {
		return AdvertenciaDAL.getBySensor(id);
	}

	private Integer idAdvertencia;
	private int minimo;
	private int maximo;
	private int idSensor;

	public Advertencia(int minimo, int maximo, int idSensor) {
		this.minimo = minimo;
		this.maximo = maximo;
		this.idSensor = idSensor;
	}

	public Advertencia(Integer idAdvertencia, int minimo, int maximo, int idSensor) {
		this.idAdvertencia = idAdvertencia;
		this.minimo = minimo;
		this.maximo = maximo;
		this.idSensor = idSensor;
	}



	public boolean save() throws SinBaseDatosException, CodigoRepetidoException{
		boolean salida = false;
		if (idAdvertencia == null){
			Integer i = AdvertenciaDAL.guardar(minimo, maximo, idSensor);
			if (i != null){
				idAdvertencia = i;
				salida = true;
			}
		}
		return salida;
	}

	public Integer getIdAdvertencia() {
		return idAdvertencia;
	}

	public void setIdAdvertencia(Integer idAdvertencia) {
		this.idAdvertencia = idAdvertencia;
	}

	public int getMinimo() {
		return minimo;
	}

	public void setMinimo(int minimo) {
		this.minimo = minimo;
	}

	public int getMaximo() {
		return maximo;
	}

	public void setMaximo(int maximo) {
		this.maximo = maximo;
	}

	public int getIdSensor() {
		return idSensor;
	}

	public void setIdSensor(int idSensor) {
		this.idSensor = idSensor;
	}

	public boolean delete() throws SinBaseDatosException {
		return AdvertenciaDAL.borrar(idAdvertencia);
	}

}
