/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import beans.Despesas;
import controllers.DespesasController;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import resources.ButtonCellRender;
import resources.ButtonEditor;
import resources.DespesasTableModel;

public class DespesasCadastroUI extends javax.swing.JPanel {

    public DespesasCadastroUI() throws SQLException, ParseException {
        initComponents();
        
        DespesasController recebimentoController = new DespesasController();
        List<Despesas> list = recebimentoController.listAll();
        this.updateTable(list);
    }
    
    public DespesasCadastroUI(List<Despesas> lista) throws SQLException, ParseException {
        initComponents();
        this.updateTable(lista);
               
    }
    
    
    private void updateTable(List<Despesas> list) throws ParseException{ 
        
        DespesasTableModel model = new DespesasTableModel(list);
        
        tabelaDespesas.setModel(model);
        tabelaDespesas.getColumnModel().getColumn(1).setMinWidth(0);
        tabelaDespesas.getColumnModel().getColumn(1).setMaxWidth(0);
        tabelaDespesas.getColumnModel().getColumn(2).setMinWidth(0);
        tabelaDespesas.getColumnModel().getColumn(2).setMaxWidth(0);   
        
        
        tabelaDespesas.getColumn("EXCLUIR").setCellRenderer(new ButtonCellRender());
        tabelaDespesas.getColumn("EXCLUIR").setCellEditor(new ButtonEditor(new JCheckBox()));
        tabelaDespesas.getColumn("VISUALIZAR").setCellRenderer(new ButtonCellRender());
        tabelaDespesas.getColumn("VISUALIZAR").setCellEditor(new ButtonEditor(new JCheckBox()));
    }


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jTextField1 = new javax.swing.JTextField();
        buttonAdicionarDespesa = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaDespesas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        campoBusca = new javax.swing.JTextField();
        buttonBuscarTexto = new javax.swing.JButton();
        campoData02 = new javax.swing.JTextField();
        campoData01 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        buttonBuscarData = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jList1);

        jTextField1.setText("jTextField1");

        setToolTipText("");
        setPreferredSize(new java.awt.Dimension(600, 400));

        buttonAdicionarDespesa.setText("Adicionar Despesa");
        buttonAdicionarDespesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAdicionarDespesaActionPerformed(evt);
            }
        });

        tabelaDespesas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Data", "Descrição", "Valor", "Categoria", "Pago"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabelaDespesas);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Despesas");

        campoBusca.setToolTipText("Insira uma descriçao para realizar uma busca");
        campoBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoBuscaActionPerformed(evt);
            }
        });

        buttonBuscarTexto.setText("Buscar");
        buttonBuscarTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBuscarTextoActionPerformed(evt);
            }
        });

        campoData02.setToolTipText("dd/mm/aaaa");

        campoData01.setToolTipText("dd/mm/aaaa");

        jLabel2.setText("à");

        jLabel3.setText("Data:");

        buttonBuscarData.setText("Buscar");
        buttonBuscarData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBuscarDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(campoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonBuscarTexto)
                                .addGap(85, 85, 85)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoData01, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoData02, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonBuscarData))
                            .addComponent(buttonAdicionarDespesa)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(269, 269, 269)
                        .addComponent(jLabel1)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(52, 52, 52)
                .addComponent(buttonAdicionarDespesa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonBuscarTexto)
                    .addComponent(jLabel3)
                    .addComponent(campoData01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(campoData02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonBuscarData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 57, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAdicionarDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAdicionarDespesaActionPerformed
        VisualizarDespesaUI visaoUI = new VisualizarDespesaUI();
        
        
        
        
    }//GEN-LAST:event_buttonAdicionarDespesaActionPerformed

    private void campoBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoBuscaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoBuscaActionPerformed

    private void buttonBuscarTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBuscarTextoActionPerformed
        String campobusca = campoBusca.getText();
        List<Despesas> listAll = null;
        List<Despesas> selecionado = new ArrayList();
        DespesasController despesasController = new DespesasController();

        try {
             listAll = despesasController.listAll();
        } catch (SQLException ex) {
            Logger.getLogger(DespesasCadastroUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (campobusca.isEmpty()) {
            try {
                this.updateTable(listAll);
            } catch (ParseException ex) {
                Logger.getLogger(DespesasCadastroUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else {
            for (int a=0; a<listAll.size(); a++){
                if (listAll.get(a).getDescricao().contains(campobusca)){
                    selecionado.add(listAll.get(a));
                }
            }
            try {
                this.updateTable(selecionado);
            } catch (ParseException ex) {
                Logger.getLogger(DespesasCadastroUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_buttonBuscarTextoActionPerformed

    private void buttonBuscarDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBuscarDataActionPerformed
        
        String data01 = this.campoData01.getText();
        String data02 = this.campoData02.getText();
        if (data01.isEmpty() && data02.isEmpty()){
            DespesasController recController = new DespesasController();
            List<Despesas> list;
            try {
                list = recController.listAll();
                this.updateTable(list);
            } catch (SQLException ex) {
            } catch (ParseException ex) {
            }
            }else {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date data1 = null, data2 = null;
        try {
            data1 = formatter.parse(data01);
            data2 = formatter.parse(data02);
        } catch (ParseException ex) {
        }
        
        
        
        DespesasController despesasController = new DespesasController();
        try {
            despesasController.filtrarPorData(data1, data2);
        } catch (SQLException ex) {
            Logger.getLogger(DespesasCadastroUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(DespesasCadastroUI.class.getName()).log(Level.SEVERE, null, ex);
        }      
        }
    }//GEN-LAST:event_buttonBuscarDataActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAdicionarDespesa;
    private javax.swing.JButton buttonBuscarData;
    private javax.swing.JButton buttonBuscarTexto;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField campoBusca;
    private javax.swing.JTextField campoData01;
    private javax.swing.JTextField campoData02;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tabelaDespesas;
    // End of variables declaration//GEN-END:variables

}