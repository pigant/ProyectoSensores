package com.ignacio.proyectosensores.GUI.creaciones;

import com.ignacio.proyectosensores.BLL.TipoUnidad;
import com.ignacio.proyectosensores.DAL.CodigoRepetidoException;
import com.ignacio.proyectosensores.DAL.SinBaseDatosException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ignacio
 */
public class JPCrearTipoUnidad extends javax.swing.JPanel {

	/**
	 * Creates new form JPCrearTipoUnidad
	 */
	public JPCrearTipoUnidad() {
		initComponents();
		try {
			tipoUnidades = TipoUnidad.findAll();
			actualizarTabla();
		} catch (SinBaseDatosException ex) {
			Logger.getLogger(JPCrearTipoUnidad.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	List<TipoUnidad> tipoUnidades;

	public final void actualizarTabla() {
		final TipoUnidadTableModel ttm
				= new TipoUnidadTableModel(tipoUnidades);
		t_vista.setModel(ttm);
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
        b_crear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_vista = new javax.swing.JTable();

        jLabel1.setText("Nombre:");

        tf_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_nombreKeyReleased(evt);
            }
        });

        b_crear.setText("Crear");
        b_crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_crearActionPerformed(evt);
            }
        });

        t_vista.setModel(new TipoUnidadTableModel());
        jScrollPane1.setViewportView(t_vista);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_nombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_crear)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(tf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(b_crear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void b_crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_crearActionPerformed
		final String text = tf_nombre.getText();
		if (!text.isEmpty()) {
			TipoUnidad l = new TipoUnidad(text);
			try {
				l.save();
			} catch (SinBaseDatosException ex) {
				JOptionPane.showMessageDialog(this, "Sin base de datos",
						"Error", JOptionPane.ERROR_MESSAGE);
			} catch (CodigoRepetidoException ex) {
				JOptionPane.showMessageDialog(this, "El codigo ya existe",
						"Error", JOptionPane.ERROR_MESSAGE);
			}
			try {
				tipoUnidades = TipoUnidad.findAll();
				actualizarTabla();
			} catch (SinBaseDatosException ex) {
				Logger.getLogger(JPCrearTipoUnidad.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
    }//GEN-LAST:event_b_crearActionPerformed

    private void tf_nombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_nombreKeyReleased
		try {
			List<TipoUnidad> t = TipoUnidad.findLike(tf_nombre.getText());
			if (t.size() > 0) {
				tipoUnidades = t;
				actualizarTabla();
			}
		} catch (SinBaseDatosException ex) {
			Logger.getLogger(JPCrearTipoUnidad.class.getName()).log(Level.SEVERE, null, ex);
		}

    }//GEN-LAST:event_tf_nombreKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_crear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable t_vista;
    private javax.swing.JTextField tf_nombre;
    // End of variables declaration//GEN-END:variables

	private class TipoUnidadTableModel extends AbstractTableModel {

		List<TipoUnidad> l;

		public TipoUnidadTableModel() {
			l = new ArrayList();
		}

		public TipoUnidadTableModel(List<TipoUnidad> lista) {
			this.l = lista;
		}

		public TipoUnidad getAt(int index) {
			return l.get(index);
		}

		@Override
		public int getRowCount() {
			return l.size();
		}

		@Override
		public int getColumnCount() {
			return 1;
		}

		@Override
		public Object getValueAt(int arg0, int arg1) {
			TipoUnidad t = l.get(arg0);
			return t.getNombre();
		}

		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
			super.setValueAt(aValue, rowIndex, columnIndex); //To change body of generated methods, choose Tools | Templates.
			TipoUnidad unidad = l.get(rowIndex);
			unidad.setNombre((String) aValue);
			try {
				unidad.save();
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

		@Override
		public String getColumnName(int column) {
			return "Tipo de unidades";
		}
	}
}