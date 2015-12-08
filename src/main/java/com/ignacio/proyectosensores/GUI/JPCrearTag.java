package com.ignacio.proyectosensores.GUI;

import com.ignacio.proyectosensores.BLL.ParametrosFaltantesException;
import com.ignacio.proyectosensores.BLL.Protocolo;
import com.ignacio.proyectosensores.BLL.Sensor;
import com.ignacio.proyectosensores.BLL.Tag;
import com.ignacio.proyectosensores.DAL.CodigoRepetidoException;
import com.ignacio.proyectosensores.DAL.SinBaseDatosException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ignacio
 */
public class JPCrearTag extends javax.swing.JPanel {

	private final Tag tag;
	private ProtocoloComboBox pcb;
	private final JFrame parent;

	/**
	 * Creates new form JPCrearTag
	 *
	 * @param parent
	 */
	public JPCrearTag(JFrame parent) {
		this.tag = new Tag();
		tag.setSegundos(1);
		this.parent = parent;
		initComponents();
		//Obtener los protocolos
		List<Protocolo> a;
		try {
			a = Protocolo.findAll();
			pcb = new ProtocoloComboBox(a);
			jcb_protocolo.setModel(pcb);
			jcb_protocolo.setSelectedIndex(0);
		} catch (SinBaseDatosException ex) {
			JOptionPane.showMessageDialog(this, "Sin coneccion a la base datos");
			Logger.getLogger(JPCrearTag.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tf_nombre = new javax.swing.JTextField();
        tf_url = new javax.swing.JTextField();
        jSpinner1 = new javax.swing.JSpinner();
        tf_sensorSeleccionado = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jcb_protocolo = new javax.swing.JComboBox<String>();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_detalles = new javax.swing.JTextArea();

        jLabel1.setText("Nombre:");

        jLabel2.setText("URL:");

        jLabel3.setText("Tiempo actualizacion:");

        jLabel4.setText("Sensor asociado:");

        jLabel5.setText("Protocolo");

        tf_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_nombreKeyReleased(evt);
            }
        });

        tf_url.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_urlKeyReleased(evt);
            }
        });

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));

        tf_sensorSeleccionado.setEditable(false);

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jcb_protocolo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcb_protocolo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_protocoloActionPerformed(evt);
            }
        });

        jButton2.setText("Agregar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel6.setText("Detalles:");

        ta_detalles.setColumns(20);
        ta_detalles.setRows(5);
        jScrollPane1.setViewportView(ta_detalles);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_nombre)
                            .addComponent(tf_url)
                            .addComponent(jSpinner1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tf_sensorSeleccionado, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jcb_protocolo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)))
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(tf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(tf_url, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(tf_sensorSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jcb_protocolo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
		JDBuscarSensor b = new JDBuscarSensor(parent, true);
		b.setVisible(true);
		Sensor sensorSeleccionado = b.getSensorSeleccionado();
		tag.setSensor(sensorSeleccionado);
		tf_sensorSeleccionado.setText(sensorSeleccionado.getNombre());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jcb_protocoloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_protocoloActionPerformed
		Protocolo p = (Protocolo) pcb.getAt(jcb_protocolo.getSelectedIndex());
		tag.setProtocolo(p);
    }//GEN-LAST:event_jcb_protocoloActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
		try {
			final int segundos = (int) jSpinner1.getValue();
			tag.setSegundos(segundos);
			tag.setDetalle(ta_detalles.getText());
			tag.save();
			JOptionPane.showMessageDialog(this, "Tag agregado", "Exito",
				JOptionPane.INFORMATION_MESSAGE);
		} catch (SinBaseDatosException ex) {
			JOptionPane.showMessageDialog(this, "Sin base de datos.");
		} catch (CodigoRepetidoException ex) {
			JOptionPane.showMessageDialog(this, "El codigo ya existe");
		} catch (ParametrosFaltantesException ex) {
			JOptionPane.showMessageDialog(this, "Faltan datos por rellenar",
				"Error", JOptionPane.ERROR_MESSAGE);
		}
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tf_nombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_nombreKeyReleased
		final String text = tf_nombre.getText();
		tag.setNombre(text);
    }//GEN-LAST:event_tf_nombreKeyReleased

    private void tf_urlKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_urlKeyReleased
		final String text = tf_url.getText();
		tag.setUrl(text);
    }//GEN-LAST:event_tf_urlKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JComboBox<String> jcb_protocolo;
    private javax.swing.JTextArea ta_detalles;
    private javax.swing.JTextField tf_nombre;
    private javax.swing.JTextField tf_sensorSeleccionado;
    private javax.swing.JTextField tf_url;
    // End of variables declaration//GEN-END:variables
}

class ProtocoloComboBox extends DefaultComboBoxModel<String> {

	List<Protocolo> protocolos;

	public ProtocoloComboBox(List<Protocolo> protocolos) {
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
