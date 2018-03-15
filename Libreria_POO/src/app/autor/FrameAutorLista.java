/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.autor;

import app.Contenido;
import app.Libreria;
import app.Lista;
import app.modelos.AutorModelo;
import mojica.alexander.mvc.ModeloTabla;
import mojica.alexander.utilidades.Mensaje;

/**
 *
 * @author MekakuZero
 */
public class FrameAutorLista extends javax.swing.JInternalFrame implements Lista {

    /**
     * Creates new form AutorLista
     */
    ModeloTabla modelo;
    Contenido desktop;
    
    public static FrameModificarAutor frameModificar = null;
    
    public FrameAutorLista(Contenido desktop) {
        initComponents();
        this.desktop = desktop;
        establecerModelo("");
    }

    private void establecerModelo(String seudonimo){
        modelo = AutorModelo.getModelo(seudonimo);
        this.tblAutor.setModel(modelo);
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
        tblAutor = new javax.swing.JTable();
        pnlFiltro = new javax.swing.JPanel();
        lblSeudonimo = new javax.swing.JLabel();
        txtFiltroSeudonimo = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        btnReflesh = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Lista de autores");

        tblAutor.setModel(new javax.swing.table.DefaultTableModel(
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
        tblAutor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAutorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAutor);

        pnlFiltro.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder()));

        lblSeudonimo.setText("Seunonimo:");

        txtFiltroSeudonimo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltroSeudonimoKeyReleased(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnReflesh.setText("Reflescar");
        btnReflesh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefleshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFiltroLayout = new javax.swing.GroupLayout(pnlFiltro);
        pnlFiltro.setLayout(pnlFiltroLayout);
        pnlFiltroLayout.setHorizontalGroup(
            pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFiltroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSeudonimo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFiltroSeudonimo, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                .addComponent(btnReflesh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnActualizar)
                .addContainerGap())
        );
        pnlFiltroLayout.setVerticalGroup(
            pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFiltroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSeudonimo)
                    .addComponent(txtFiltroSeudonimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar)
                    .addComponent(btnReflesh))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(pnlFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFiltroSeudonimoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroSeudonimoKeyReleased
        // TODO add your handling code here:
        establecerModelo(this.txtFiltroSeudonimo.getText().trim());
    }//GEN-LAST:event_txtFiltroSeudonimoKeyReleased

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        establecerModelo(this.txtFiltroSeudonimo.getText().trim());
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnRefleshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefleshActionPerformed
        // TODO add your handling code here:
        this.txtFiltroSeudonimo.setText("");
        establecerModelo(this.txtFiltroSeudonimo.getText().trim());
    }//GEN-LAST:event_btnRefleshActionPerformed

    private void tblAutorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAutorMouseClicked
        // TODO add your handling code here:
        int fila = this.tblAutor.rowAtPoint(evt.getPoint());
        AutorModelo autor = (AutorModelo)this.modelo.obtenerFilaModelo(fila);
        
        if (frameModificar != null) frameModificar.dispose();
        
        frameModificar = new FrameModificarAutor(autor, this);
        
        desktop.agregarComponente(frameModificar);
    }//GEN-LAST:event_tblAutorMouseClicked

    @Override
    public void dispose() {
        Libreria.listaAutores = null;
        super.dispose(); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnReflesh;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSeudonimo;
    private javax.swing.JPanel pnlFiltro;
    private javax.swing.JTable tblAutor;
    private javax.swing.JTextField txtFiltroSeudonimo;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actualizarLista() {
        establecerModelo(this.txtFiltroSeudonimo.getText().trim());
    }
}