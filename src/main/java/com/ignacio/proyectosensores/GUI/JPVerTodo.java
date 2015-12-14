package com.ignacio.proyectosensores.GUI;

import com.ignacio.proyectosensores.BLL.Historial;
import com.ignacio.proyectosensores.BLL.Lugar;
import com.ignacio.proyectosensores.BLL.Maquina;
import com.ignacio.proyectosensores.BLL.Sensor;
import com.ignacio.proyectosensores.BLL.Tag;
import com.ignacio.proyectosensores.DAL.SinBaseDatosException;
import com.ignacio.proyectosensores.GUI.metadata.JPMetaTag;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

/**
 *
 * @author ignacio
 */
public class JPVerTodo extends javax.swing.JPanel {

	/**
	 * Creates new form JPVerTodo
	 */
	public JPVerTodo() {
		initComponents();
		//
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
        tf_buscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        arbol = new javax.swing.JTree();
        p_meta = new javax.swing.JPanel();
        p_grafico = new javax.swing.JPanel();

        jLabel1.setText("Buscar:");

        tf_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_buscarActionPerformed(evt);
            }
        });

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Escriba en el buscador");
        arbol.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        arbol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                arbolMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(arbol);

        p_meta.setBackground(new java.awt.Color(215, 239, 236));
        p_meta.setLayout(new javax.swing.BoxLayout(p_meta, javax.swing.BoxLayout.LINE_AXIS));

        p_grafico.setBackground(new java.awt.Color(230, 230, 230));
        p_grafico.setLayout(new javax.swing.BoxLayout(p_grafico, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(p_grafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(p_meta, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_buscar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tf_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                    .addComponent(p_meta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p_grafico, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tf_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_buscarActionPerformed
		String text = tf_buscar.getText();
		try {
			List<DefaultMutableTreeNode> tns = new ArrayList<>();
			DefaultMutableTreeNode root
					= new DefaultMutableTreeNode("Busqueda");
			DefaultMutableTreeNode lugares
					= new DefaultMutableTreeNode("Lugares");
			DefaultMutableTreeNode maquinas
					= new DefaultMutableTreeNode("Maquinas");
			DefaultMutableTreeNode tags
					= new DefaultMutableTreeNode("Tags");
			buscarPorLugar(text, lugares);
			buscarPorMaquina(text, maquinas);
			buscarPorTag(text, tags);
			if (lugares.getChildCount() > 0) {
				root.add(lugares);
			}
			if (maquinas.getChildCount() > 0) {
				root.add(maquinas);
			}
			if (tags.getChildCount() > 0) {
				root.add(tags);
			}
			final DefaultTreeModel modelo = new DefaultTreeModel(root);
			arbol.setModel(modelo);
		} catch (SinBaseDatosException ex) {
			Logger.getLogger(JPVerTodo.class.getName()).log(
					Level.SEVERE, null, ex);
			JOptionPane.showMessageDialog(this, "Error de conexion");
		}
    }//GEN-LAST:event_tf_buscarActionPerformed

    private void arbolMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_arbolMouseClicked
		if (evt.getClickCount() > 1) {
			return;
		}
		DefaultMutableTreeNode o
				= (DefaultMutableTreeNode) arbol.getLastSelectedPathComponent();
		if (o != null) {
			Object u = o.getUserObject();
			if (u instanceof Tag) {
				try {
					Tag t = (Tag) u;
					List<Historial> hs = Historial.findLast1000(t.getId());
					p_meta.removeAll();
					p_grafico.removeAll();
					if (hs.size() > 0) {
						rellenoGrafico(t, hs);
						JPMetaTag mt = new JPMetaTag(t, hs.get(hs.size() - 1));
						mt.setPreferredSize(p_meta.getPreferredSize());
						p_meta.add(mt);
					} else {
						JPMetaTag mt = new JPMetaTag(t);
						p_meta.add(mt);
						p_meta.revalidate();
						p_meta.repaint();
						p_grafico.repaint();
					}
				} catch (SinBaseDatosException ex) {
					Logger.getLogger(JPVerTodo.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
    }//GEN-LAST:event_arbolMouseClicked

	private void rellenoGrafico(Tag t, List<Historial> hs) {
		TimeSeries s1 = new TimeSeries("Fecha", Second.class);
		for (Historial h : hs) {
			s1.add(new Second(h.getFecha()), h.getValor());
		}
		TimeSeriesCollection c = new TimeSeriesCollection(s1);
		JFreeChart graficoTiempo
				= ChartFactory.createTimeSeriesChart(
						"", "Tiempo", "valor", c,
						false, false, false);
		final ChartPanel panelTiempo
				= new ChartPanel(graficoTiempo);
		panelTiempo.setPreferredSize(p_grafico.getPreferredSize());
		p_grafico.add(panelTiempo);
		p_grafico.revalidate();
	}

	private void buscarPorLugar(String text, DefaultMutableTreeNode lugares)
			throws SinBaseDatosException {
		//Busqueda por lugar
		Map<Lugar, DefaultMutableTreeNode> tnLugares = new HashMap<>();
		Map<Maquina, DefaultMutableTreeNode> tnMaquinas = new HashMap<>();
		Map<Sensor, DefaultMutableTreeNode> tnSensores = new HashMap<>();
		List<Lugar> ls = Lugar.findLike(text);
		for (Lugar l : ls) {
			//crea o busca el lugar
			DefaultMutableTreeNode tnLugar = tnLugares.get(l);
			if (tnLugar == null) {
				tnLugares.put(l, new DefaultMutableTreeNode(l));
				tnLugar = tnLugares.get(l);
				lugares.add(tnLugar);
			}
			List<Tag> t = Tag.findByLugar(l.getId());
			for (Tag tag : t) {
				tag.findDependencias();
				Maquina m = Maquina.findByTag(tag.getId());
				m.setLugar(l);
				tag.getSensor().setMaquina(m);
				//Busca o crea maquina
				DefaultMutableTreeNode tnMaquina = tnMaquinas.get(m);
				if (tnMaquina == null) {
					tnMaquinas.put(m, new DefaultMutableTreeNode(m));
					tnMaquina = tnMaquinas.get(m);
					tnLugar.add(tnMaquina);
				}
				//Crea el tag
				DefaultMutableTreeNode tnTag = new DefaultMutableTreeNode(tag);
				tnMaquina.add(tnTag);
			}
		}
	}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree arbol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel p_grafico;
    private javax.swing.JPanel p_meta;
    private javax.swing.JTextField tf_buscar;
    // End of variables declaration//GEN-END:variables

	private void buscarPorMaquina(String text, DefaultMutableTreeNode maquinas)
			throws SinBaseDatosException {
		HashMap<Maquina, DefaultMutableTreeNode> tnMaquinas = new HashMap<>();
		List<Maquina> ms = Maquina.findLike(text);
		for (Maquina m : ms) {
			DefaultMutableTreeNode tnMaquina = tnMaquinas.get(m);
			if (tnMaquina == null) {
				tnMaquina = new DefaultMutableTreeNode(m);
				tnMaquinas.put(m, tnMaquina);
			}
			maquinas.add(tnMaquina);
			m.findDependencias();
			List<Tag> ts = Tag.findByMaquina(m.getId());
			for (Tag t : ts) {
				t.findDependencias();
				tnMaquina.add(new DefaultMutableTreeNode(t));
			}

		}
	}

	private void buscarPorTag(String text, DefaultMutableTreeNode tags)
			throws SinBaseDatosException {
		List<Tag> ts = Tag.findLike(text);
		for (Tag t : ts) {
			tags.add(new DefaultMutableTreeNode(t));
		}
	}
}
