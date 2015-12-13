/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ignacio.proyectosensores.BLL;

import com.ignacio.proyectosensores.DAL.HistorialDAL;
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

	public Historial() {
	}

	public Historial(Timestamp fecha, BigDecimal valor) {
		this.fecha = fecha;
		this.valor = valor;
	}

	public static List<Historial> findLast1000(int idTag){
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
	
}
