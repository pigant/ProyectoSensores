/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ignacio.proyectosensores.modbus;

import java.util.Observable;

/**
 *
 * @author ignacio
 */
abstract class Pedido extends Observable{
	public abstract boolean operacion(ModbusConector mc);
}
