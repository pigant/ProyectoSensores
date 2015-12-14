/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ignacio.proyectosensores.modbus;

import java.util.logging.Level;
import java.util.logging.Logger;
import net.wimpi.modbus.ModbusException;
import net.wimpi.modbus.ModbusSlaveException;
import net.wimpi.modbus.io.ModbusTCPTransaction;
import net.wimpi.modbus.msg.WriteSingleRegisterRequest;
import net.wimpi.modbus.procimg.SimpleRegister;

/**
 *
 * @author ignacio
 */
public class Guardar extends Pedido {

	private final int direccion;
	private final int dato;

	public Guardar(int direccion, int dato) {
		super();
		this.direccion = direccion;
		this.dato = dato;
	}

	@Override
	public boolean operacion(ModbusConector mc) {
		boolean salida = false;
		mc.conectar();
		WriteSingleRegisterRequest escrituraRegistro
				= new WriteSingleRegisterRequest(
						direccion,
						new SimpleRegister(dato));
		ModbusTCPTransaction trans = mc.getTransaction();
		trans.setRequest(escrituraRegistro);
		try {
			trans.execute();
			salida = true;
			notifyObservers();
		} catch (ModbusSlaveException ex) {
			Logger.getLogger(ModbusConector.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ModbusException ex) {
			Logger.getLogger(ModbusConector.class.getName()).log(Level.SEVERE, null, ex);
		}
		return salida;
	}

}
