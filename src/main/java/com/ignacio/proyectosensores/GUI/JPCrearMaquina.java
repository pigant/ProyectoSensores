/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ignacio.proyectosensores.GUI;

import com.ignacio.proyectosensores.BLL.Lugar;
import com.ignacio.proyectosensores.BLL.Maquina;
import com.ignacio.proyectosensores.DAL.SinBaseDatosException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ignacio
 */
public class JPCrearMaquina extends javax.swing.JPanel {

	private final Maquina m;
	private MaquinaTableModel mtm;
	private LugarComboBox lcb;

	/**
	 * Creates new form JPCrearMaquina
	 */
	public JPCrearMaquina() throws SinBaseDatosException {
		m = new Maquina();
		initComponents();
		ArrayList<Maquina> maquinas = Maquina.findAll();
		mtm = new MaquinaTableModel(maquinas);
		t_maquinas.setModel(mtm);
		ArrayList<Lugar> lugares = Lugar.findAll();
		lcb = new LugarComboBox(lugares);
		cb_lugar.setModel(lcb);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tf_nombre = new javax.swing.JTextField();
        cb_lugar = new javax.swing.JComboBox<>();
        b_crear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_maquinas = new javax.swing.JTable();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Creación"));

        jLabel1.setText("Nombre:");

        jLabel2.setText("Lugar:");

        tf_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_nombreKeyTyped(evt);
            }
        });

        cb_lugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_lugarActionPerformed(evt);
            }
        });

        b_crear.setText("Crear");
        b_crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_crearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cb_lugar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tf_nombre, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)))
                    .addComponent(b_crear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(tf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(cb_lugar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(b_crear)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        t_maquinas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(t_maquinas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tf_nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_nombreKeyTyped
		final String text = tf_nombre.getText();
		if (text.length() > 0) {
			m.setNombre(text);
		} else {
			m.setNombre(null);
		}
    }//GEN-LAST:event_tf_nombreKeyTyped

    private void cb_lugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_lugarActionPerformed
		final int lugar_i= cb_lugar.getSelectedIndex();
		final Lugar l = lcb.getAt(lugar_i);
		m.setLugar(l);
    }//GEN-LAST:event_cb_lugarActionPerformed

    private void b_crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_crearActionPerformed
		System.out.println("Maquina {" + m.getNombre() + ", " + m.getLugar().getNombre() + "}");
		m.save();
    }//GEN-LAST:event_b_crearActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_crear;
    private javax.swing.JComboBox<String> cb_lugar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable t_maquinas;
    private javax.swing.JTextField tf_nombre;
    // End of variables declaration//GEN-END:variables
}

class MaquinaTableModel extends DefaultTableModel {

	private final ArrayList<Maquina> maquinas;

	public MaquinaTableModel(ArrayList<Maquina> maquinas) {
		this.maquinas = maquinas;
	}

	@Override
	public Object getValueAt(int row, int column) {
		return maquinas.get(row);
	}

	@Override
	public int getRowCount() {
		if (maquinas != null) {
			return maquinas.size();
		}
		return 0;
	}

	@Override
	public String getColumnName(int column) {
		switch (column) {
			case 0:
				return "Nombre";
			case 1:
				return "Lugar";
			default:
				throw new AssertionError();
		}
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

}

class LugarComboBox extends DefaultComboBoxModel<String> {

	private final ArrayList<Lugar> lugares;
	private Lugar seleccionado;

	public LugarComboBox(ArrayList<Lugar> lugares) {
		this.lugares = lugares;
	}

	public Lugar getAt(int index){
		return lugares.get(index);
	}

	@Override
	public String getElementAt(int index) {
		return lugares.get(index).getNombre();
	}

	@Override
	public int getSize() {
		return lugares.size();
	}

}
