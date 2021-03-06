package com.ignacio.proyectosensores.GUI.creaciones;

import com.ignacio.proyectosensores.BLL.Lugar;
import com.ignacio.proyectosensores.BLL.Maquina;
import com.ignacio.proyectosensores.DAL.CodigoRepetidoException;
import com.ignacio.proyectosensores.DAL.RestriccionException;
import com.ignacio.proyectosensores.DAL.SinBaseDatosException;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

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
	 *
	 * @throws com.ignacio.proyectosensores.DAL.SinBaseDatosException
	 */
	public JPCrearMaquina() throws SinBaseDatosException {
		m = new Maquina();
		initComponents();
		List<Maquina> maquinas = Maquina.findAllWithDependency();
		mtm = new MaquinaTableModel(maquinas);
		t_maquinas.setModel(mtm);
		t_maquinas.setRowHeight(24);
		List<Lugar> lugares = Lugar.findAll();
		lcb = new LugarComboBox(lugares);
		cb_lugar.setModel(lcb);
		cb_lugar.setSelectedIndex(0);
		t_maquinas.setDefaultEditor(Lugar.class, new MaquinaCellEditor(lugares));
		t_maquinas.setDefaultRenderer(Lugar.class, new MaquinaCellRenderer());
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
        cb_lugar = new javax.swing.JComboBox<Lugar>();
        b_crear = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ta_detalle = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_maquinas = new javax.swing.JTable();

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Nombre:");

        jLabel2.setText("Lugar:");

        tf_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_nombreKeyReleased(evt);
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

        jLabel3.setText("Detalle:");

        ta_detalle.setColumns(20);
        ta_detalle.setRows(5);
        jScrollPane2.setViewportView(ta_detalle);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cb_lugar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tf_nombre, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
                            .addComponent(jScrollPane2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(b_crear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(tf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(cb_lugar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b_crear))
        );

        t_maquinas.setModel(new MaquinaTableModel());
        t_maquinas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_maquinasKeyReleased(evt);
            }
        });
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cb_lugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_lugarActionPerformed
		final int lugar_i = cb_lugar.getSelectedIndex();
		final Lugar l = lcb.getElementAt(lugar_i);
		m.setLugar(l);
    }//GEN-LAST:event_cb_lugarActionPerformed

    private void b_crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_crearActionPerformed
		if (!tf_nombre.getText().isEmpty()) {
			String detalle = ta_detalle.getText();
			m.setDetalle(detalle);
			System.out.println("Maquina {" + m.getNombre() + ", "
					+ m.getLugar().getNombre() + "}");
			try {
				m.save();
				JOptionPane.showMessageDialog(this, "Registro guardado", "Exito",
						JOptionPane.INFORMATION_MESSAGE);
				mtm = new MaquinaTableModel(Maquina.findAllWithDependency());
				t_maquinas.setModel(mtm);
			} catch (SinBaseDatosException ex) {
				JOptionPane.showMessageDialog(this, "Sin base de datos",
						"Error", JOptionPane.ERROR_MESSAGE);
			} catch (CodigoRepetidoException ex) {
				JOptionPane.showMessageDialog(this, "El codigo ya existe",
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
    }//GEN-LAST:event_b_crearActionPerformed

    private void tf_nombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_nombreKeyReleased
		final String text = tf_nombre.getText();
		if (text.length() > 0) {
			m.setNombre(text);
		} else {
			m.setNombre(null);
		}
		List<Maquina> l;
		try {
			l = Maquina.findLike(text);
			if (l.size() > 0) {
				mtm = new MaquinaTableModel(l);
				t_maquinas.setModel(mtm);
			}
		} catch (SinBaseDatosException ex) {
			Logger.getLogger(JPCrearMaquina.class.getName()).log(Level.SEVERE, null, ex);
		}
    }//GEN-LAST:event_tf_nombreKeyReleased

    private void t_maquinasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_maquinasKeyReleased
		if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
			int op = JOptionPane.showConfirmDialog(
					this,
					"¿ Desea eliminar el registro ?", "Confirmación",
					JOptionPane.OK_CANCEL_OPTION);
			if (op == JOptionPane.OK_OPTION) {
				int r = t_maquinas.getSelectedRow();
				Maquina l
						= ((MaquinaTableModel) t_maquinas.getModel()).getAt(r);
				try {
					l.delete();
					mtm = new MaquinaTableModel(Maquina.findAllWithDependency());
					t_maquinas.setModel(mtm);
				} catch (SinBaseDatosException ex) {
					Logger.getLogger(JPCrearLugar.class.getName()).log(
							Level.SEVERE, null, ex);
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
    }//GEN-LAST:event_t_maquinasKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_crear;
    private javax.swing.JComboBox<Lugar> cb_lugar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable t_maquinas;
    private javax.swing.JTextArea ta_detalle;
    private javax.swing.JTextField tf_nombre;
    // End of variables declaration//GEN-END:variables

	class MaquinaTableModel extends AbstractTableModel {

		private final List<Maquina> maquinas;
		private final String columnas[] = {"Maquina", "Lugar"};

		public MaquinaTableModel() {
			maquinas = new ArrayList();
		}

		public Maquina getAt(int index) {
			return maquinas.get(index);
		}

		public MaquinaTableModel(List<Maquina> maquinas) {
			this.maquinas = maquinas;
		}

		@Override
		public Class<?> getColumnClass(int columnIndex) {
			return getValueAt(0, columnIndex).getClass();
		}

		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			return true;
		}

		@Override
		public Object getValueAt(int row, int column) {
			switch (column) {
				case 0:
					return maquinas.get(row).getNombre();
				case 1:
					return maquinas.get(row).getLugar();
				default:
					throw new AssertionError();
			}
		}

		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
			Maquina m = maquinas.get(rowIndex);
			switch (columnIndex) {
				case 0:
					m.setNombre((String) aValue);
					break;
				case 1:
					m.setLugar((Lugar) aValue);
					break;
				default:
					throw new AssertionError();
			}
			try {
				m.save();
			} catch (SinBaseDatosException ex) {
				JOptionPane.showMessageDialog(null, "Sin base de datos");
			} catch (CodigoRepetidoException ex) {
				JOptionPane.showMessageDialog(null, "No se pudo guardar");
				Logger.getLogger(JPCrearMaquina.class.getName()).log(Level.SEVERE, ex.getMessage());
			}
		}

		@Override
		public int getRowCount() {
			return maquinas.size();
		}

		@Override
		public String getColumnName(int column) {
			return columnas[column];
		}

		@Override
		public int getColumnCount() {
			return columnas.length;
		}
	}

	private class LugarComboBox extends DefaultComboBoxModel<Lugar> {

		private final List<Lugar> lugares;

		public LugarComboBox(List<Lugar> lugares) {
			this.lugares = lugares;
		}

		@Override
		public Lugar getElementAt(int index) {
			return lugares.get(index);
		}

		@Override
		public int getSize() {
			return lugares.size();
		}
	}

	private class MaquinaCellEditor
			extends AbstractCellEditor
			implements TableCellEditor {

		private Lugar m;
		private List<Lugar> l;

		public MaquinaCellEditor(List<Lugar> lista) {
			this.l = lista;
		}

		@Override
		public Object getCellEditorValue() {
			return m;
		}

		@Override
		public Component getTableCellEditorComponent(
				JTable arg0, Object arg1, boolean arg2, int arg3, int arg4) {
			JComboBox<Lugar> c = new JComboBox<>();
			for (Lugar lugar : l) {
				c.addItem(lugar);
			}
			c.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JComboBox<Maquina> c = (JComboBox<Maquina>) e.getSource();
					m = (Lugar) c.getSelectedItem();
				}
			});
			return c;
		}

	}

	private class MaquinaCellRenderer implements TableCellRenderer {

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value,
				boolean isSelected, boolean hasFocus, int row, int column) {
			Lugar l = null;
			if (value instanceof Lugar) {
				l = (Lugar) value;
			}
			JComboBox<Lugar> b = new JComboBox();
			b.addItem(l);
			return b;
		}
	}
}
