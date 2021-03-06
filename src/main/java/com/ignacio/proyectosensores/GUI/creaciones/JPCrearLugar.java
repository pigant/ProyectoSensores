package com.ignacio.proyectosensores.GUI.creaciones;

import com.ignacio.proyectosensores.BLL.Lugar;
import com.ignacio.proyectosensores.DAL.CodigoRepetidoException;
import com.ignacio.proyectosensores.DAL.RestriccionException;
import com.ignacio.proyectosensores.DAL.SinBaseDatosException;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ignacio
 */
public class JPCrearLugar extends javax.swing.JPanel {

	List<Lugar> lugares;

	/**
	 * Creates new form JPCrearLugar
	 */
	public JPCrearLugar() {
		initComponents();
		try {
			lugares = Lugar.findAll();
			actualizarTabla();
		} catch (SinBaseDatosException ex) {
			Logger.getLogger(JPCrearLugar.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tf_nombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_lugares = new javax.swing.JTable();
        b_agregar = new javax.swing.JButton();

        jLabel1.setText("Nombre:");

        tf_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_nombreKeyReleased(evt);
            }
        });

        t_lugares.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lugares existentes"
            }
        ));
        t_lugares.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_lugaresKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(t_lugares);

        b_agregar.setText("Agregar");
        b_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_agregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_nombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_agregar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1)))
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(tf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_agregar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void b_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_agregarActionPerformed
		final String text = tf_nombre.getText();
		if (!text.isEmpty()) {
			Lugar l = new Lugar(text);
			try {
				l.save();
				lugares = Lugar.findAll();
				actualizarTabla();
			} catch (SinBaseDatosException ex) {
				JOptionPane.showMessageDialog(this, "Sin base de datos",
						"Error", JOptionPane.ERROR_MESSAGE);
			} catch (CodigoRepetidoException ex) {
				JOptionPane.showMessageDialog(this, "El codigo ya existe",
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
    }//GEN-LAST:event_b_agregarActionPerformed

    private void tf_nombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_nombreKeyReleased
		try {
			List<Lugar> t = Lugar.findLike(tf_nombre.getText());
			if (t.size() > 0) {
				lugares = t;
				actualizarTabla();
			}
		} catch (SinBaseDatosException ex) {
			Logger.getLogger(JPCrearTipoUnidad.class.getName()).log(Level.SEVERE, null, ex);
		}
    }//GEN-LAST:event_tf_nombreKeyReleased

    private void t_lugaresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_lugaresKeyReleased
		if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
			int op = JOptionPane.showConfirmDialog(
					this,
					"¿ Desea eliminar el registro ?", "Confirmación",
					JOptionPane.OK_CANCEL_OPTION);
			if (op == JOptionPane.OK_OPTION) {
				int r = t_lugares.getSelectedRow();
				Lugar l = (Lugar) t_lugares.getModel().getValueAt(r, 0);
				try {
					l.delete();
					lugares = Lugar.findAll();
					actualizarTabla();
				} catch (SinBaseDatosException ex) {
					Logger.getLogger(JPCrearLugar.class.getName()).log(Level.SEVERE, null, ex);
				} catch (RestriccionException ex) {
					JOptionPane.showMessageDialog(
							this,
							"Para eliminar este registro es necesario "
							+ "borrar sus dependencias",
							"Advertencia",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		}
    }//GEN-LAST:event_t_lugaresKeyReleased

	public void actualizarTabla() {
		final LugarTableModel ltm = new LugarTableModel(lugares);
		t_lugares.setModel(ltm);
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_agregar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable t_lugares;
    private javax.swing.JTextField tf_nombre;
    // End of variables declaration//GEN-END:variables

	private class LugarTableModel extends AbstractTableModel {

		List<Lugar> l;

		private LugarTableModel(List<Lugar> lugares) {
			this.l = lugares;
		}

		public Lugar getAt(int index) {
			return l.get(index);
		}

		@Override
		public int getRowCount() {
			return l.size();
		}

		@Override
		public String getColumnName(int column) {
			switch (column) {
				case 0:
					return "Lugares existentes";
				default:
					throw new AssertionError();
			}
		}

		@Override
		public int getColumnCount() {
			return 1;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			return l.get(rowIndex);
		}

		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
			super.setValueAt(aValue, rowIndex, columnIndex); //To change body of generated methods, choose Tools | Templates.
			Lugar lugar = l.get(rowIndex);
			lugar.setNombre((String) aValue);
			try {
				lugar.save();
			} catch (SinBaseDatosException ex) {
				JOptionPane.showMessageDialog(null,
						"Sin base de datos");
			} catch (CodigoRepetidoException ex) {
				JOptionPane.showMessageDialog(null,
						"No se pudo realizar el cambio");
				Logger.getLogger(
						JPCrearLugar.class.getName()).
						log(Level.SEVERE, null, ex);
			}
		}

		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			return true;
		}

	}
}
