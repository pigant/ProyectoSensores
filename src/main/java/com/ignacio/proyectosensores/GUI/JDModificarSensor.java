package com.ignacio.proyectosensores.GUI;

import com.ignacio.proyectosensores.BLL.Advertencia;
import com.ignacio.proyectosensores.GUI.creaciones.JPCrearSensor;
import com.ignacio.proyectosensores.BLL.Maquina;
import com.ignacio.proyectosensores.BLL.Sensor;
import com.ignacio.proyectosensores.BLL.TipoSensor;
import com.ignacio.proyectosensores.BLL.TipoUnidad;
import com.ignacio.proyectosensores.DAL.CodigoRepetidoException;
import com.ignacio.proyectosensores.DAL.SinBaseDatosException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jdesktop.swingx.combobox.ListComboBoxModel;

/**
 *
 * @author ignacio
 */
public class JDModificarSensor extends javax.swing.JDialog {

	private final Sensor sensor;

	/**
	 * Creates new form JDModificarSensor
	 *
	 * @param parent
	 * @param modal
	 * @param sensor
	 */
	public JDModificarSensor(java.awt.Frame parent, boolean modal,
			Sensor sensor) {
		super(parent, modal);
		this.sensor = sensor;
		initComponents();
		rellenoComboBox();
	}

	private void rellenoComboBox() {
		List<Maquina> maquinas;
		List<TipoSensor> tipoSensores;
		List<TipoUnidad> tipoUnidades;
		try {
			maquinas = Maquina.findAll();
			tipoSensores = TipoSensor.findAll();
			tipoUnidades = TipoUnidad.findAll();
			cb_maquina.setModel(new ListComboBoxModel<>(maquinas));
			cb_sensor.setModel(new ListComboBoxModel<>(tipoSensores));
			cb_unidad.setModel(new ListComboBoxModel<>(tipoUnidades));
			AutoCompleteDecorator.decorate(cb_maquina);
			AutoCompleteDecorator.decorate(cb_sensor);
			AutoCompleteDecorator.decorate(cb_unidad);
			cb_maquina.setSelectedItem(sensor.getMaquina());
			cb_sensor.setSelectedItem(sensor.getTipoSensor());
			cb_unidad.setSelectedItem(sensor.getTipoUnidad());
		} catch (SinBaseDatosException ex) {
			Logger.getLogger(JPCrearSensor.class.getName()).log(
					Level.SEVERE, null, ex);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        b_guardar = new javax.swing.JButton();
        cb_maquina = new javax.swing.JComboBox<Maquina>();
        cb_sensor = new javax.swing.JComboBox<TipoSensor>();
        cb_unidad = new javax.swing.JComboBox<TipoUnidad>();
        rb_positivo = new javax.swing.JRadioButton();
        rb_negativo = new javax.swing.JRadioButton();
        tf_escala = new javax.swing.JTextField(sensor.getEscala());
        tf_nombre = new javax.swing.JTextField(sensor.getNombre());
        b_guardar1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_descripcion = new javax.swing.JTextArea(sensor.getDetalle());
        b_guardar2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nombre:");

        jLabel2.setText("Escala:");

        jLabel3.setText("Descripción:");

        jLabel4.setText("Tipo de escala:");

        jLabel5.setText("Tipo de unidad:");

        jLabel6.setText("Tipo de sensor:");

        jLabel7.setText("Maquina:");

        b_guardar.setText("Guardar");
        b_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_guardarActionPerformed(evt);
            }
        });

        buttonGroup1.add(rb_positivo);
        rb_positivo.setSelected(true);
        rb_positivo.setText("Positiva");

        buttonGroup1.add(rb_negativo);
        rb_negativo.setText("Negativa");
        rb_negativo.setSelected(!sensor.isEscalaPositiva());

        tf_escala.setToolTipText("Por ejemplo 2*x+1, donde cada oparacion debe dejarse expresada explicitamente");

        b_guardar1.setText("Cancelar");
        b_guardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_guardar1ActionPerformed(evt);
            }
        });

        ta_descripcion.setColumns(20);
        ta_descripcion.setRows(5);
        jScrollPane1.setViewportView(ta_descripcion);

        b_guardar2.setText("Eliminar");
        b_guardar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_guardar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cb_unidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tf_escala)
                            .addComponent(tf_nombre)
                            .addComponent(cb_sensor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_maquina, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rb_positivo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rb_negativo)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(b_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_guardar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_guardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(tf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tf_escala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rb_positivo)
                        .addComponent(rb_negativo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel5)
                    .addComponent(cb_unidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel6)
                    .addComponent(cb_sensor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel7)
                    .addComponent(cb_maquina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_guardar)
                    .addComponent(b_guardar1)
                    .addComponent(b_guardar2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_guardarActionPerformed
		sensor.setNombre(tf_nombre.getText());
		sensor.setEscala(tf_escala.getText());
		sensor.setEscalaPositiva(rb_positivo.isSelected());
		sensor.setDetalle(ta_descripcion.getText());
		sensor.setMaquina((Maquina) cb_maquina.getSelectedItem());
		sensor.setTipoSensor((TipoSensor) cb_sensor.getSelectedItem());
		sensor.setTipoUnidad((TipoUnidad) cb_unidad.getSelectedItem());
		try {
			sensor.save();
			JOptionPane.showMessageDialog(this, "Guardado exitosamente");
			dispose();
		} catch (SinBaseDatosException ex) {
			JOptionPane.showMessageDialog(this, "Sin base de datos");
			Logger.getLogger(JPCrearSensor.class.getName()).log(
					Level.SEVERE, null, ex);
		} catch (CodigoRepetidoException ex) {
			JOptionPane.showMessageDialog(
					this, "Problemas al guardar el sensor");
			Logger.getLogger(JPCrearSensor.class.getName()).log(
					Level.SEVERE, null, ex);
		}
    }//GEN-LAST:event_b_guardarActionPerformed

    private void b_guardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_guardar1ActionPerformed
		dispose();
    }//GEN-LAST:event_b_guardar1ActionPerformed

    private void b_guardar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_guardar2ActionPerformed
		try {
			int sel = JOptionPane.showConfirmDialog(this, "¿ Desea eliminar ?");
			if (sel == JOptionPane.OK_OPTION) {
				Advertencia a = Advertencia.getBySensor(sensor.getId());
				if (a != null) {
					a.delete();
				}
				sensor.delete();
				JOptionPane.showMessageDialog(this, "Elemento eliminado");
			}
		} catch (SinBaseDatosException ex) {
			Logger.getLogger(JDModificarSensor.class.getName()).log(Level.SEVERE, null, ex);
			JOptionPane.showMessageDialog(this, "No se pudo eliminar el sensor");
		}
		dispose();
    }//GEN-LAST:event_b_guardar2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_guardar;
    private javax.swing.JButton b_guardar1;
    private javax.swing.JButton b_guardar2;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<Maquina> cb_maquina;
    private javax.swing.JComboBox<TipoSensor> cb_sensor;
    private javax.swing.JComboBox<TipoUnidad> cb_unidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rb_negativo;
    private javax.swing.JRadioButton rb_positivo;
    private javax.swing.JTextArea ta_descripcion;
    private javax.swing.JTextField tf_escala;
    private javax.swing.JTextField tf_nombre;
    // End of variables declaration//GEN-END:variables
}
