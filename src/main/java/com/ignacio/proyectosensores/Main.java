package com.ignacio.proyectosensores;

import com.ignacio.proyectosensores.BLL.Sensor;
import com.ignacio.proyectosensores.DAL.SinBaseDatosException;
import com.ignacio.proyectosensores.GUI.JDBuscarSensor;
import com.ignacio.proyectosensores.GUI.JPVerTodo;
import com.ignacio.proyectosensores.GUI.creaciones.JPCrearLugar;
import com.ignacio.proyectosensores.GUI.creaciones.JPCrearMaquina;
import com.ignacio.proyectosensores.GUI.creaciones.JPCrearProtocolo;
import com.ignacio.proyectosensores.GUI.creaciones.JPCrearSensor;
import com.ignacio.proyectosensores.GUI.creaciones.JPCrearTag;
import com.ignacio.proyectosensores.GUI.creaciones.JPCrearTipoSensor;
import com.ignacio.proyectosensores.GUI.creaciones.JPCrearTipoUnidad;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author ignacio
 */
public class Main extends javax.swing.JFrame {

	/**
	 * Creates new form Main
	 */
	public Main() {
		initComponents();
		p_principal.add(new JPVerTodo());
		p_principal.repaint();
		instancia = this;
	}

	public static Main instancia = null;

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        p_principal = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        mi_crearProtocolo = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mi_crearLugar = new javax.swing.JMenuItem();
        mi_crearMaquina = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        p_principal.setMinimumSize(new java.awt.Dimension(500, 500));
        p_principal.setLayout(new javax.swing.BoxLayout(p_principal, javax.swing.BoxLayout.LINE_AXIS));

        jMenu1.setText("Crear");

        jMenu4.setText("Tipos");

        jMenuItem3.setText("Tipo sensor");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem3);

        jMenuItem4.setText("Tipo unidad");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem4);

        mi_crearProtocolo.setText("Protocolo");
        mi_crearProtocolo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_crearProtocoloActionPerformed(evt);
            }
        });
        jMenu4.add(mi_crearProtocolo);

        jMenu1.add(jMenu4);
        jMenu1.add(jSeparator1);

        mi_crearLugar.setText("Lugar");
        mi_crearLugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_crearLugarActionPerformed(evt);
            }
        });
        jMenu1.add(mi_crearLugar);

        mi_crearMaquina.setText("Maquina");
        mi_crearMaquina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_crearMaquinaActionPerformed(evt);
            }
        });
        jMenu1.add(mi_crearMaquina);

        jMenuItem5.setText("Sensor");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem6.setText("Tag");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Ver");

        jMenuItem1.setText("Ver Sensores");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem8.setText("Monitoreo");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem8);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(p_principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(p_principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mi_crearLugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_crearLugarActionPerformed
		final JPCrearLugar p_lugar = new JPCrearLugar();
		actualizarPantalla(p_lugar);
    }//GEN-LAST:event_mi_crearLugarActionPerformed

	private void actualizarPantalla(final JPanel p_lugar) {
		p_lugar.setSize(p_principal.getSize());
		p_principal.removeAll();
		p_principal.add(p_lugar);
		p_principal.updateUI();
	}

    private void mi_crearMaquinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_crearMaquinaActionPerformed
		final JPCrearMaquina m;
		try {
			m = new JPCrearMaquina();
			actualizarPantalla(m);
		} catch (SinBaseDatosException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}
    }//GEN-LAST:event_mi_crearMaquinaActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
		try {
			List<Sensor> ls = Sensor.findAllWithDependency();
			for (Sensor s : ls) {
				s.getMaquina().findDependencias();
			}
			JDBuscarSensor j = new JDBuscarSensor(this, true, ls);
			j.setVisible(true);
		} catch (SinBaseDatosException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void mi_crearProtocoloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_crearProtocoloActionPerformed
		JPCrearProtocolo j = new JPCrearProtocolo();
		actualizarPantalla(j);
    }//GEN-LAST:event_mi_crearProtocoloActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
		JPCrearTipoSensor j = new JPCrearTipoSensor();
		actualizarPantalla(j);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
		JPCrearTipoUnidad j = new JPCrearTipoUnidad();
		actualizarPantalla(j);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
		JPCrearSensor j = new JPCrearSensor();
		actualizarPantalla(j);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
		JPCrearTag j = new JPCrearTag(this);
		actualizarPantalla(j);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
		JPVerTodo j = new JPVerTodo();
		actualizarPantalla(j);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

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
			java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Main().setVisible(true);
			}
		});
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				//BusquedaTag bt = BusquedaTag.getInstance();
				//bt.atender();
			}
		});
		t.start();
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem mi_crearLugar;
    private javax.swing.JMenuItem mi_crearMaquina;
    private javax.swing.JMenuItem mi_crearProtocolo;
    private javax.swing.JPanel p_principal;
    // End of variables declaration//GEN-END:variables

}
