package com.ignacio.proyectosensores.GUI;

import com.ignacio.proyectosensores.BLL.Lugar;
import com.ignacio.proyectosensores.BLL.Maquina;
import com.ignacio.proyectosensores.BLL.Sensor;
import com.ignacio.proyectosensores.DAL.SinBaseDatosException;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.table.AbstractTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author ignacio
 */
public class JDBuscarSensor extends javax.swing.JDialog {

	private SensorTableModel stm;
	private Sensor sensorSeleccionado;
	private Set<Lugar> lugares;
	private Set<Maquina> maquinas;

	public Sensor getSensorSeleccionado() {
		return sensorSeleccionado;
	}

	/**
	 * Creates new form JDBuscarSensor
	 *
	 * @param parent
	 * @param modal
	 * @param sensores
	 */
	public JDBuscarSensor(java.awt.Frame parent, boolean modal,
			List<Sensor> sensores) {
		super(parent, modal);
		stm = new SensorTableModel(sensores);
		initComponents();
		rellenoComboBox(sensores);
	}

	private void rellenoComboBox(List<Sensor> sensores) {
		List<ActionListener[]> arrayAction = quitarListener(cb_lugar, cb_maquina);
		lugares = new HashSet<>();
		maquinas = new HashSet<>();
		for (Sensor s : sensores) {
			lugares.add(s.getMaquina().getLugar());
			maquinas.add(s.getMaquina());
		}
		for (Lugar l : lugares) {
			cb_lugar.addItem(l);
		}
		for (Maquina m : maquinas) {
			cb_maquina.addItem(m);
		}
		cb_lugar.setSelectedIndex(-1);
		cb_maquina.setSelectedIndex(-1);
		AutoCompleteDecorator.decorate(cb_lugar);
		AutoCompleteDecorator.decorate(cb_maquina);
		addActionListener(arrayAction, cb_lugar, cb_maquina);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tf_fuzzy = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_vista = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cb_maquina = new javax.swing.JComboBox<Maquina>();
        jLabel3 = new javax.swing.JLabel();
        cb_lugar = new javax.swing.JComboBox<Lugar>();
        b_limpiar = new javax.swing.JButton();
        b_salir = new javax.swing.JButton();
        b_seleccionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tf_fuzzy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_fuzzyActionPerformed(evt);
            }
        });
        tf_fuzzy.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_fuzzyKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_fuzzyKeyReleased(evt);
            }
        });

        t_vista.setModel(stm);
        t_vista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_vistaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(t_vista);

        jLabel1.setText("Búsqueda:");

        jLabel2.setText("Filtrar por maquina:");

        cb_maquina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_maquinaActionPerformed(evt);
            }
        });

        jLabel3.setText("Filtrar por lugar:");

        cb_lugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_lugarActionPerformed(evt);
            }
        });

        b_limpiar.setText("Limpiar filtros");
        b_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_limpiarActionPerformed(evt);
            }
        });

        b_salir.setText("Salir");
        b_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_salirActionPerformed(evt);
            }
        });

        b_seleccionar.setText("Seleccionar");
        b_seleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_seleccionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_fuzzy)
                            .addComponent(cb_lugar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_maquina, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(b_limpiar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(b_seleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(tf_fuzzy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cb_maquina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cb_lugar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(b_limpiar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_salir)
                    .addComponent(b_seleccionar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_fuzzyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_fuzzyActionPerformed
		final String text = tf_fuzzy.getText();
		if (text.length() > 3) {
			try {
				List<Sensor> s = Sensor.findLike(text);
				for (Sensor sensor : s) {
					System.out.println(s);
				}
			} catch (SinBaseDatosException ex) {
				Logger.getLogger(JDBuscarSensor.class.getName()).
						log(Level.SEVERE, null, ex);
			}
		}
    }//GEN-LAST:event_tf_fuzzyActionPerformed

    private void tf_fuzzyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_fuzzyKeyTyped
    }//GEN-LAST:event_tf_fuzzyKeyTyped

    private void t_vistaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_vistaMouseClicked
		if (evt.getClickCount() == 2) {
			b_seleccionarActionPerformed(null);
		}
    }//GEN-LAST:event_t_vistaMouseClicked

    private void tf_fuzzyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_fuzzyKeyReleased
		String text = tf_fuzzy.getText();
		stm.filtrarTexto(text);
    }//GEN-LAST:event_tf_fuzzyKeyReleased

    private void cb_lugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_lugarActionPerformed
		Lugar l = (Lugar) cb_lugar.getSelectedItem();
		if (l != null) {
			stm.filtrarPorLugar(l);
		}
		((AbstractTableModel) t_vista.getModel()).fireTableDataChanged();
		ActionListener a[] = cb_maquina.getActionListeners();
		for (ActionListener a1 : a) {
			cb_maquina.removeActionListener(a1);
		}
		cb_maquina.removeAllItems();
		for (Maquina m : maquinas) {
			if (m.getLugar().equals(l)) {
				cb_maquina.addItem(m);
			}
		}
		cb_maquina.setSelectedIndex(-1);
		for (ActionListener a1 : a) {
			cb_maquina.addActionListener(a1);
		}
    }//GEN-LAST:event_cb_lugarActionPerformed

    private void cb_maquinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_maquinaActionPerformed
		Maquina m = (Maquina) cb_maquina.getSelectedItem();
		stm.filtrarPorMaquina(m);
		((AbstractTableModel) t_vista.getModel()).fireTableDataChanged();
		if (cb_lugar.getSelectedIndex() == -1) {
			List<ActionListener[]> a = quitarListener(cb_lugar);
			cb_lugar.setSelectedItem(m.getLugar());
			addActionListener(a, cb_lugar);
		}
    }//GEN-LAST:event_cb_maquinaActionPerformed

    private void b_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_limpiarActionPerformed
		List<ActionListener[]> a = quitarListener(cb_lugar, cb_maquina);
		cb_lugar.setSelectedIndex(-1);
		cb_maquina.setSelectedIndex(-1);
		tf_fuzzy.setText("");
		stm.limpiarFiltros();
		addActionListener(a, cb_lugar, cb_maquina);

    }//GEN-LAST:event_b_limpiarActionPerformed

	private void addActionListener(List<ActionListener[]> a, JComboBox... c) {
		for (int i = 0; i < c.length; i++) {
			ActionListener[] array = a.get(i);
			for (ActionListener valorArray : array) {
				c[i].addActionListener(valorArray);
			}
		}
	}

	private List<ActionListener[]> quitarListener(JComboBox... combobox) {
		List<ActionListener[]> array = new ArrayList<>(combobox.length);
		for (JComboBox a : combobox) {
			final ActionListener[] acciones = a.getActionListeners();
			array.add(acciones);
			for (ActionListener a1 : acciones) {
				a.removeActionListener(a1);
			}
		}
		return array;
	}

    private void b_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_salirActionPerformed
		dispose();
    }//GEN-LAST:event_b_salirActionPerformed

    private void b_seleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_seleccionarActionPerformed
		int seleccionado = t_vista.getSelectedRow();
		if (seleccionado >= 0) {
			sensorSeleccionado = (Sensor) stm.getValueAt(seleccionado, 0);
		}
		dispose();
    }//GEN-LAST:event_b_seleccionarActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
		 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(JDBuscarSensor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(JDBuscarSensor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(JDBuscarSensor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(JDBuscarSensor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the dialog */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				JDBuscarSensor dialog = new JDBuscarSensor(
						new javax.swing.JFrame(), true, new ArrayList());
				dialog.addWindowListener(new java.awt.event.WindowAdapter() {
					@Override
					public void windowClosing(java.awt.event.WindowEvent e) {
						System.exit(0);
					}
				});
				dialog.setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_limpiar;
    private javax.swing.JButton b_salir;
    private javax.swing.JButton b_seleccionar;
    private javax.swing.JComboBox<Lugar> cb_lugar;
    private javax.swing.JComboBox<Maquina> cb_maquina;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable t_vista;
    private javax.swing.JTextField tf_fuzzy;
    // End of variables declaration//GEN-END:variables

	private class SensorTableModel extends AbstractTableModel {

		final List<Sensor> sensores;
		List<Sensor> salida;
		String columnas[] = {"Sensor", "Maquina", "Lugar"};
		Maquina maquinaFiltro;
		Lugar lugarFiltro;

		public SensorTableModel(List<Sensor> sensores) {
			this.sensores = sensores;
			salida = sensores;
		}

		public void limpiarFiltros() {
			maquinaFiltro = null;
			lugarFiltro = null;
			salida = sensores;
			fireTableDataChanged();
		}

		public void filtrarPorLugar(Lugar l) {
			lugarFiltro = l;
			salida = new ArrayList();
			for (int i = 0; i < sensores.size(); i++) {
				Lugar lugar = sensores.get(i).getMaquina().getLugar();
				if (lugar.equals(l)) {
					salida.add(sensores.get(i));
				}
			}
		}

		public void filtrarPorMaquina(Maquina m) {
			maquinaFiltro = m;
			salida = new ArrayList();
			for (int i = 0; i < sensores.size(); i++) {
				Maquina maquina = sensores.get(i).getMaquina();
				if (maquina.equals(m)) {
					salida.add(sensores.get(i));
				}
			}
		}

		public void filtrarTexto(String s) {
			List<Sensor> nls = new ArrayList(salida);
			boolean encontrado = false;
			if (maquinaFiltro != null) {
				filtrarPorMaquina(maquinaFiltro);
			} else if (lugarFiltro != null) {
				filtrarPorLugar(lugarFiltro);
			} else {
				salida = sensores;
			}
			for (Sensor se : salida) {
				if (se.getNombre().toLowerCase().matches(".*" + s + ".*")) {
					if (!encontrado) {
						encontrado = true;
						nls = new ArrayList<>();
					}
					nls.add(se);
				}
			}
			salida = nls;
			fireTableDataChanged();
		}

		@Override
		public int getRowCount() {
			return salida.size();
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}

		@Override
		public Object getValueAt(int row, int column) {
			Sensor s = salida.get(row);
			Maquina m = s.getMaquina();
			switch (column) {
				case 0:
					return s;
				case 1:
					return m;
				case 2:
					return s.getMaquina().getLugar();
				default:
					throw new AssertionError();
			}
		}

		@Override
		public int getColumnCount() {
			return columnas.length;
		}

		@Override
		public String getColumnName(int column) {
			return columnas[column];
		}

	}
}
