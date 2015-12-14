/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ignacio.proyectosensores.modbus;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author ignacio
 */
public class Mostrar implements Observer{

	@Override
	public void update(Observable arg0, Object arg1) {
		System.out.println("El valor es de " + arg1);
	}
	
}
