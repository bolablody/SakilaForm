package form;

import dao.ActorDAO;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.Actor;
import util.ConnectionJDBC;

/**
 *
 * @author Cassiano Bortoli
 */
public class ActorForm extends javax.swing.JFrame {

    /**
     * Creates new form ActorForm
     */
    public ActorForm() {
        initComponents();
        table.setDefaultEditor(Object.class, null);
        try {
            actorDAO = new ActorDAO();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
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
        iID = new javax.swing.JTextField();
        iFirst_Name = new javax.swing.JTextField();
        iLast_Name = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        bNovo = new javax.swing.JButton();
        bSalvar = new javax.swing.JButton();
        bRemover = new javax.swing.JButton();
        DisplayMode = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("ACTOR ID:");

        jLabel2.setText("FIRST NAME:");

        jLabel3.setText("LAST NAME:");

        iID.setEnabled(false);
        iID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iIDActionPerformed(evt);
            }
        });

        iFirst_Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iFirst_NameActionPerformed(evt);
            }
        });

        iLast_Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iLast_NameActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "FIRST NAME", "LAST NAME", "LAST UPDATE"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        bNovo.setText("NOVO");
        bNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNovoActionPerformed(evt);
            }
        });

        bSalvar.setText("SALVAR");
        bSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalvarActionPerformed(evt);
            }
        });

        bRemover.setText("REMOVER");
        bRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRemoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(iLast_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(iFirst_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(30, 30, 30)
                                .addComponent(iID, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(DisplayMode, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bRemover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DisplayMode, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(iID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bNovo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(iFirst_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bSalvar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(iLast_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bRemover))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void iIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iIDActionPerformed

    private void iFirst_NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iFirst_NameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iFirst_NameActionPerformed

    private void iLast_NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iLast_NameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iLast_NameActionPerformed

    private void bNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNovoActionPerformed
        limpaCampo();
    }//GEN-LAST:event_bNovoActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        loadTable();
        DisplayMode();
    }//GEN-LAST:event_formWindowOpened

    private void bSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalvarActionPerformed
        Actor actor = criaAtor();
        
        try {
            if (mode.equals(INS)) {
            actorDAO.save(actor);
            } else if (mode.equals(UPD)) {
                actorDAO.update(actor);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        loadTable();
        limpaCampo();
    }//GEN-LAST:event_bSalvarActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int linha = table.getSelectedRow();
        iID.setText(""+model.getValueAt(linha, 0 ));
        iFirst_Name.setText(""+model.getValueAt(linha, 1 ));
        iLast_Name.setText(""+model.getValueAt(linha, 2 ));
        
        mode = UPD;
        DisplayMode();
    }//GEN-LAST:event_tableMouseClicked

    private void bRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRemoverActionPerformed
        try {
            actorDAO.delete(criaAtor());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        loadTable();
    }//GEN-LAST:event_bRemoverActionPerformed
    
    public void loadTable() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        //Limpar tabela
        model.setNumRows(0);
        try {
            for (Actor actor : actorDAO.findAll()) {
                String linha[] = {"" + actor.getActor_id(), actor.getFirst_name(), actor.getLast_name(), actor.getLast_update().toString()};
                model.addRow(linha);
            }
        } catch (Exception ex){
            System.out.println(""+ ex.getMessage());
        }
    }
    
    public void limpaCampo() {
        iID.setText("");
        iFirst_Name.setText("");
        iLast_Name.setText("");
        
        if (table.getSelectedRow() !=-1) {
            table.clearSelection();
        }
        mode = INS;
        DisplayMode();
    }
    
    public void DisplayMode() {
        DisplayMode.setText(mode);
    }
    
    private int ParseInt(String valor){
        try {
            return Integer.parseInt(valor);            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return 0;
        }
    }
    
    private Actor criaAtor() {
        Actor actor = new Actor();
        actor.setActor_id(ParseInt(iID.getText()));
        actor.setFirst_name(iFirst_Name.getText());
        actor.setLast_name(iLast_Name.getText());
        actor.setLast_update(new Timestamp((new Date()).getTime()));
        return actor;
    }
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
            java.util.logging.Logger.getLogger(ActorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ActorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ActorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ActorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ActorForm().setVisible(true);
            }
        });
    }
    
    private final String INS = "INSERT";
    private final String UPD = "UPDATE"; 
    
    private ActorDAO actorDAO;
    private String mode = INS;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DisplayMode;
    private javax.swing.JButton bNovo;
    private javax.swing.JButton bRemover;
    private javax.swing.JButton bSalvar;
    private javax.swing.JTextField iFirst_Name;
    private javax.swing.JTextField iID;
    private javax.swing.JTextField iLast_Name;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
