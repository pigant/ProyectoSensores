/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ignacio.proyectosensores.GUI.util;

import com.ignacio.proyectosensores.BLL.Protocolo;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author ignacio
 */
	public class ProtocoloComboModel extends DefaultComboBoxModel<String> {

		List<Protocolo> protocolos;

		
		public ProtocoloComboModel(List<Protocolo> protocolos) {
			this.protocolos = protocolos;
			for (Protocolo p : protocolos) {
				addElement(p.getNombre());
			}
		}

		public Protocolo getAt(int index) {
			return protocolos.get(index);
		}

		@Override
		public String getElementAt(int index) {
			return protocolos.get(index).getNombre();
		}

	}
