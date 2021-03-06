/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.categoria;

import app.Contenido;
import app.Lista;
import app.modelos.CategoriaModelo;
import mojica.alexander.mvc.ModeloTabla;

/**
 *
 * @author MekakuZero
 */
public class FrameListaCategoria extends javax.swing.JInternalFrame implements Lista {

    /**
     * Creates new form FrameListaCategoria
     */
    FrameModificarCategoria modificarCategoria;
    ModeloTabla categorias;
    Contenido con;
    
    public FrameListaCategoria(Contenido con) {
        initComponents();
        this.con = con;
        actualizarLista();
    }

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        pnlOpciones = new javax.swing.JPanel();
        lblCategoria = new javax.swing.JLabel();
        txtCategoria = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCategoria = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setClosable(true);
        setIconifiable(true);
        setTitle("Lista de categorias");

        pnlOpciones.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Filtro"));
        pnlOpciones.setPreferredSize(new java.awt.Dimension(394, 75));

        lblCategoria.setText("Categoria:");

        txtCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCategoriaKeyReleased(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnRefresh.setText("Refrescar");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlOpcionesLayout = new javax.swing.GroupLayout(pnlOpciones);
        pnlOpciones.setLayout(pnlOpcionesLayout);
        pnlOpcionesLayout.setHorizontalGroup(
            pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCategoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRefresh)
                .addContainerGap())
        );
        pnlOpcionesLayout.setVerticalGroup(
            pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCategoria)
                    .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar)
                    .addComponent(btnRefresh))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        getContentPane().add(pnlOpciones, java.awt.BorderLayout.PAGE_START);

        tblCategoria.setModel(new javax.swing.table.DefaultTableModel(
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
        tblCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCategoriaMouseClicked(evt);
            }
        });
        tblCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tblCategoriaKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(tblCategoria);

        getContentPane().add(jScrollPane2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        this.actualizarLista();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        this.txtCategoria.setText("");
        this.actualizarLista();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void tblCategoriaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblCategoriaKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tblCategoriaKeyTyped

    private void tblCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCategoriaMouseClicked
        // TODO add your handling code here:
        int fila = this.tblCategoria.rowAtPoint(evt.getPoint());
        CategoriaModelo categoria = (CategoriaModelo)this.categorias.obtenerFilaModelo(fila);
        
        if (modificarCategoria != null) modificarCategoria.dispose();
        
        modificarCategoria = new FrameModificarCategoria(categoria, this);
        this.con.agregarComponente(modificarCategoria);
    }//GEN-LAST:event_tblCategoriaMouseClicked

    private void txtCategoriaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCategoriaKeyReleased
        // TODO add your handling code here:
        this.actualizarLista();
    }//GEN-LAST:event_txtCategoriaKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JPanel pnlOpciones;
    private javax.swing.JTable tblCategoria;
    private javax.swing.JTextField txtCategoria;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actualizarLista() {
        String categoria_filtro = this.txtCategoria.getText().trim();
        
        this.categorias = CategoriaModelo.getModelo(categoria_filtro);
        
        this.tblCategoria.setModel(this.categorias);
    }
}
