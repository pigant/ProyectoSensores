/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ignacio.proyectosensores.modbus;

import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.wimpi.modbus.ModbusException;
import net.wimpi.modbus.ModbusSlaveException;
import net.wimpi.modbus.io.ModbusTCPTransaction;
import net.wimpi.modbus.msg.ReadMultipleRegistersRequest;
import net.wimpi.modbus.msg.ReadMultipleRegistersResponse;
import net.wimpi.modbus.procimg.InputRegister;

/**
 *
 * @author ignacio
 */
public class Leer extends Pedido {

	private final int direccion;

	public Leer(int direccion) {
		super();
		this.direccion = direccion;
	}

	public Leer(int direccion, Observer observador) {
		super();
		this.direccion = direccion;
		addObserver(observador);
	}

	public Leer(int direccion, Observer[] observadores) {
		super();
		this.direccion = direccion;
		for (Observer o : observadores) {
			addObserver(o);
		}
	}

	@Override
	public boolean operacion(ModbusConector mc) {
		boolean salida = false;
		mc.conectar();
		ReadMultipleRegistersRequest leerComando
				= new ReadMultipleRegistersRequest(direccion, 1);
		ReadMultipleRegistersResponse rsLeer;
		ModbusTCPTransaction trans = mc.getTransaction();
		trans.setRequest(leerComando);
		try {
			trans.execute();
			rsLeer = (ReadMultipleRegistersResponse) trans.getResponse();
			InputRegister[] r = rsLeer.getRegisters();
			int ir = Integer.MIN_VALUE;
			for (InputRegister i : r) {
				ir = i.getValue();
			}
			salida = true;
			setChanged();
			notifyObservers(ir);
		} catch (ModbusSlaveException ex) {
			Logger.getLogger(ModbusConector.class.getName()).log(
					Level.SEVERE, null, ex);
		} catch (ModbusException ex) {
			Logger.getLogger(ModbusConector.class.getName()).log(
					Level.SEVERE, null, ex);
		}
		return salida;
	}

}
