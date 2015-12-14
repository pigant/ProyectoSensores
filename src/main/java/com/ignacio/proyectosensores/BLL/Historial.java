/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ignacio.proyectosensores.BLL;

import com.ignacio.proyectosensores.DAL.CodigoRepetidoException;
import com.ignacio.proyectosensores.DAL.HistorialDAL;
import com.ignacio.proyectosensores.DAL.SinBaseDatosException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author ignacio
 */
public class Historial {


	Timestamp fecha;
	BigDecimal valor;
	Tag tag;

	public Historial() {
	}

	public Historial(Timestamp fecha, BigDecimal valor, Tag t) {
		this.fecha = fecha;
		this.valor = valor;
		this.tag = t;
	}

	public static List<Historial> findLast1000(int idTag) 
			throws SinBaseDatosException{
		return HistorialDAL.findLast1000(idTag);
	}

	public static List<Historial> findToDate(Integer id, Timestamp t) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Integer save() 
			throws SinBaseDatosException, CodigoRepetidoException {
		return HistorialDAL.guardar(fecha, valor, tag.getId());
	}
	
}
