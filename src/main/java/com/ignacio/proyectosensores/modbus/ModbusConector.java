/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ignacio.proyectosensores.modbus;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.wimpi.modbus.Modbus;
import net.wimpi.modbus.ModbusException;
import net.wimpi.modbus.ModbusSlaveException;
import net.wimpi.modbus.io.ModbusTCPTransaction;
import net.wimpi.modbus.msg.ReadMultipleRegistersRequest;
import net.wimpi.modbus.msg.ReadMultipleRegistersResponse;
import net.wimpi.modbus.msg.WriteSingleRegisterRequest;
import net.wimpi.modbus.net.TCPMasterConnection;
import net.wimpi.modbus.procimg.InputRegister;
import net.wimpi.modbus.procimg.SimpleRegister;

/**
 *
 * @author ignacio
 */
public class ModbusConector {

	private TCPMasterConnection con;
	private final byte ip[];

	public ModbusConector(String ip) {
		Pattern p = Pattern.compile("(\\d+)\\.(\\d+)\\.(\\d+)\\.(\\d+)");
		Matcher m = p.matcher(ip);
		boolean buenFormato = m.find() && m.groupCount() == 4;
		this.ip = new byte[4];
		for (int i = 0; i < 4; i++) {
			this.ip[i] = Byte.decode(m.group(i + 1));
		}
	}

	public ModbusTCPTransaction getTransaction(){
		return new ModbusTCPTransaction(con);
	}

	private boolean _conectar() {
		boolean salida = false;
		int puerto = Modbus.DEFAULT_PORT;
		InetAddress addr = null; //the slave's address
		int port = Modbus.DEFAULT_PORT;
		//Se realiza la conexion
		try {
			addr = InetAddress.getByAddress(ip);
			con = new TCPMasterConnection(addr);
			con.setPort(port);
			con.connect();
			salida = true;
		} catch (UnknownHostException ex) {
			Logger.getLogger(ModbusConector.class.getName()).log(Level.SEVERE, null, ex);
		} catch (Exception ex) {
			Logger.getLogger(ModbusConector.class.getName()).log(Level.SEVERE, null, ex);
		}
		//Se retorna el estado
		return salida;
	}

	public void escribirRegistro(int direccion, int dato) {
		conectar();
		WriteSingleRegisterRequest escrituraRegistro
				= new WriteSingleRegisterRequest(
						direccion,
						new SimpleRegister(dato));
		ModbusTCPTransaction trans = new ModbusTCPTransaction(con);
		trans.setRequest(escrituraRegistro);
		try {
			trans.execute();
		} catch (ModbusSlaveException ex) {
			Logger.getLogger(ModbusConector.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ModbusException ex) {
			Logger.getLogger(ModbusConector.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void conectar() {
		if (con != null) {
			if (!con.isConnected()) {
				_conectar();
			}
		}else{
			_conectar();
		}
	}

	public void leerRegistro(int direccion) {
		conectar();
		ReadMultipleRegistersRequest leerComando
				= new ReadMultipleRegistersRequest(direccion, direccion);
		ReadMultipleRegistersResponse rsLeer;
		ModbusTCPTransaction trans = new ModbusTCPTransaction(con);
		trans.setRequest(leerComando);
		try {
			trans.execute();
			rsLeer = (ReadMultipleRegistersResponse) trans.getResponse();
			InputRegister[] r = rsLeer.getRegisters();
			for (InputRegister i : r) {
				System.out.println("Valor leido " + i.getValue());
			}
		} catch (ModbusSlaveException ex) {
			Logger.getLogger(ModbusConector.class.getName()).log(
					Level.SEVERE, null, ex);
		} catch (ModbusException ex) {
			Logger.getLogger(ModbusConector.class.getName()).log(
					Level.SEVERE, null, ex);
		}

	}

	public boolean cerrar() {
		if (con != null) {
			con.close();
			return !con.isConnected();
		} else {
			return true;
		}
	}

	public static void main(String[] args) {
		ModbusConector mc = new ModbusConector("10.0.0.16");
		mc.escribirRegistro(1, 51);
		mc.leerRegistro(1);
		mc.cerrar();
	}

}
