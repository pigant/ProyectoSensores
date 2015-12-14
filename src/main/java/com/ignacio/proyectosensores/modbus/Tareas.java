/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ignacio.proyectosensores.modbus;

import java.util.LinkedList;

/**
 *
 * @author ignacio
 */
public class Tareas {

	private final LinkedList<Pedido> pedidos;

	public Tareas() {
		this.pedidos = new LinkedList<>();
	}

	/**
	 *
	 * @param p
	 */
	public void addPedido(final Pedido p){
		pedidos.add(p);
	}

	/**
	 *
	 * @param p
	 */
	public void removePedido(final Pedido p){
		pedidos.remove(p);
	}

	public void operar(){
		ModbusConector mc = new ModbusConector("10.0.0.16");
		int i = 1;
		while(pedidos.size()>0){
			pedidos.getFirst().operacion(mc);
			pedidos.removeFirst();
		}
		mc.cerrar();
	}

	
}
