/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ignacio.proyectosensores;

import com.ignacio.proyectosensores.DAL.BD;
import com.ignacio.proyectosensores.DAL.CodigoRepetidoException;
import com.ignacio.proyectosensores.DAL.SinBaseDatosException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ignacio
 */
public class Main {
	public static void main(String[] args) {
		BD bd = null;
		try {
			bd = new BD();
			bd.update("insert into lugar values (?,?)", 2, "Edificio");
		} catch (SinBaseDatosException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		} catch (CodigoRepetidoException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}finally{
			if (bd != null){
				bd.close();
			}
		}
	}
}
