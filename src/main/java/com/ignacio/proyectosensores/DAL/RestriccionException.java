/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ignacio.proyectosensores.DAL;

import java.sql.SQLException;

/**
 *
 * @author ignacio
 */
public class RestriccionException extends Exception {

	public RestriccionException(SQLException ex) {
		super(ex);
	}
	
}
