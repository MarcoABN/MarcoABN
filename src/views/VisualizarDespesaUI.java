package views;

import beans.Despesas;
import controllers.Application;
import controllers.DespesasController;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marco
 */
public class VisualizarDespesaUI extends javax.swing.JFrame {
    
    int recebimento_id;
    int user_id;
    
    public VisualizarDespesaUI(Object[] data) throws ParseException {
         initComponents();
        
        recebimento_id = (int) data[1];
        user_id = (int) data[2];
         
            labelDespesa_id.setText( data[1].toString());
            campoData.setText(data[3].toString());
            campoData.setEnabled(false);
            campoDescricao.setText(data[4].toString());
            campoDescricao.setEnabled(false);
            campoValor.setText(data[5].toString());
            campoValor.setEnabled(false);
            campoCategoria.setText(data[6].toString());
            campoCategoria.setEnabled(false);
            if (data[7].equals(true)) {
                buttonPagoSim.setSelected(true);
                buttonPagoSim.setEnabled(false);
                buttonPagoNao.setEnabled(false);
            } else {
                buttonPagoNao.setSelected(true);
                buttonPagoSim.setEnabled(false);
                buttonPagoNao.setEnabled(false);
            }
        buttonSalvar.setVisible(false);
    }

    VisualizarDespesaUI() {
        initComponents();
        labelTitulo.setText("Adicionar Recebimento");
        labelDespesa_id.setText(null);
        this.setSize(400, 600);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.buttonEditarInformacoes.setVisible(false);
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        labelTitulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        campoData = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        campoDescricao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        campoValor = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        campoCategoria = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        buttonPagoSim = new javax.swing.JRadioButton();
        buttonPagoNao = new javax.swing.JRadioButton();
        buttonEditarInformacoes = new javax.swing.JButton();
        labelDespesa_id = new javax.swing.JLabel();
        buttonSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelTitulo.setText("Detalhes da despesa");

        jLabel2.setText("ID Despesa..:");

        jLabel3.setText("Data");

        jLabel4.setText("Descrição");

        jLabel5.setText("Valor");

        jLabel6.setText("Categoria");

        jLabel7.setText("Pago");

        buttonPagoSim.setText("SIM");
        buttonPagoSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPagoSimActionPerformed(evt);
            }
        });

        buttonPagoNao.setText("NÃO");
        buttonPagoNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPagoNaoActionPerformed(evt);
            }
        });

        buttonEditarInformacoes.setText("Editar informações");
        buttonEditarInformacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditarInformacoesActionPerformed(evt);
            }
        });

        labelDespesa_id.setText("labelRecebimentoID");

        buttonSalvar.setText("Salvar");
        buttonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(labelTitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(labelDespesa_id)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonEditarInformacoes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonSalvar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                            .addComponent(campoData, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                            .addComponent(campoValor)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buttonPagoSim)
                                .addGap(18, 18, 18)
                                .addComponent(buttonPagoNao)
                                .addContainerGap(99, Short.MAX_VALUE))
                            .addComponent(campoCategoria)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(labelDespesa_id))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(campoData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(campoDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(campoValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(campoCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(buttonPagoSim)
                    .addComponent(buttonPagoNao))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonEditarInformacoes)
                    .addComponent(buttonSalvar))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonPagoSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPagoSimActionPerformed
        this.buttonPagoNao.setSelected(false);
    }//GEN-LAST:event_buttonPagoSimActionPerformed

    private void buttonEditarInformacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditarInformacoesActionPerformed
        campoDescricao.setEnabled(true);
        campoData.setEnabled(true);
        campoValor.setEnabled(true);
        campoCategoria.setEnabled(true);
        buttonPagoSim.setEnabled(true);
        buttonPagoNao.setEnabled(true);
        buttonEditarInformacoes.setEnabled(false);
        buttonSalvar.setVisible(true);
    }//GEN-LAST:event_buttonEditarInformacoesActionPerformed

    private void buttonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSalvarActionPerformed
        Despesas recebimentos = new Despesas();
        
        recebimentos.setDespesas_id(recebimento_id);
        recebimentos.setUser_id(user_id);
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
        Date date = null;
        try {
            date = sdf.parse(this.campoData.getText());
        } catch (ParseException ex) {
            Logger.getLogger(VisualizarDespesaUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        recebimentos.setData(date);
        
        recebimentos.setDescricao(this.campoDescricao.getText());
        recebimentos.setValor(Double.parseDouble(this.campoValor.getText()));
        recebimentos.setCategoria(this.campoCategoria.getText());
        if (this.buttonPagoSim.isSelected()){
            recebimentos.setPago(true);
        } else if (this.buttonPagoNao.isSelected()){
            recebimentos.setPago(false);
        }
        if (this.labelDespesa_id.getText() == null){
            DespesasController recController = new DespesasController();
            try {
                recController.adicionar(recebimentos);
            } catch (SQLException ex) {
                Logger.getLogger(VisualizarDespesaUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(VisualizarDespesaUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else{
        DespesasController recController = new DespesasController();
                recController.updateTable(recebimentos);
                DespesasCadastroUI cadastro = null;
            try {
                cadastro = new DespesasCadastroUI();
            } catch (SQLException ex) {
                Logger.getLogger(VisualizarDespesaUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(VisualizarDespesaUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            cadastro.setVisible(true);
            Application.redesenhar(cadastro);
        }
         this.dispose();

    }//GEN-LAST:event_buttonSalvarActionPerformed

    private void buttonPagoNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPagoNaoActionPerformed
        this.buttonPagoSim.setSelected(false);
    }//GEN-LAST:event_buttonPagoNaoActionPerformed

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
            java.util.logging.Logger.getLogger(VisualizarDespesaUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisualizarDespesaUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisualizarDespesaUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisualizarDespesaUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VisualizarDespesaUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonEditarInformacoes;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JRadioButton buttonPagoNao;
    private javax.swing.JRadioButton buttonPagoSim;
    private javax.swing.JButton buttonSalvar;
    private javax.swing.JTextField campoCategoria;
    private javax.swing.JTextField campoData;
    private javax.swing.JTextField campoDescricao;
    private javax.swing.JTextField campoValor;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel labelDespesa_id;
    private javax.swing.JLabel labelTitulo;
    // End of variables declaration//GEN-END:variables
/*private String conversorData (String data) throws ParseException{
    if (data != null ) {
           
           char[] teste = data.toCharArray();
          
           char[] c = new char[teste.length];
           c[0] = teste[8];
           c[1] = teste[9];
           c[2] = '/';
           c[3] = teste[5];
           c[4] = teste[6];
           c[5] = '/';
           c[6] = teste[0];
           c[7] = teste[1];
           c[8] = teste[2];
           c[9] = teste[3];

           String datapronta = new String (c);
           
           return datapronta;
            
}
        return null;
}*/

    public void setLabelRecebimento_id(javax.swing.JLabel labelRecebimento_id) {
        this.labelDespesa_id = labelRecebimento_id;
    }

    public void setLabelTitulo(javax.swing.JLabel labelTitulo) {
        this.labelTitulo = labelTitulo;
    }

}