
package resources;

import beans.Despesas;
import controllers.Application;
import controllers.DespesasController;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.AbstractTableModel;
import views.DespesasCadastroUI;
import views.VisualizarDespesaUI;

public class DespesasTableModel extends AbstractTableModel{
    
    //nome das colunas da tabela
    private String[] columnNames = {"VISUALIZAR", "despesas_id", "user_id", "DATA", "DESCRICAO", "VALOR", "CATEGORIA", "PAGO", "EXCLUIR"};
    
    //lista de objetos a serem exibidos na tabela 
    private Object [][] data;
    
    //lista de objetos originados do banco de dados
    private List <Despesas> despesas;
    
    //variaveis para controlar o numero de linhas e colunas
    private int rowCount, colCount;

    public DespesasTableModel(List <Despesas> despesas) throws ParseException {
        
        this.despesas = new ArrayList<Despesas>(despesas);
        
        rowCount = this.despesas.size();
        colCount = this.columnNames.length;
        data = new Object[rowCount][colCount];
        
        for (int i = 0; i< rowCount; i++){
            Despesas r = despesas.get(i);
            data[i][0] = new JButton("Visualizar");
            data[i][1] = r.getDespesas_id();
            data[i][2] = r.getUser_id();
            data[i][3] = this.conversorData(r.getData().toString());
            data[i][4] = r.getDescricao();
            data[i][5] = r.getValor();
            data[i][6] = r.getCategoria();
            data[i][7] = r.isPago();
            data[i][8] = new JButton("excluir");
            
            

        }
       
    }

    @Override
    public int getRowCount() {
        return rowCount;
    }

    @Override
    public int getColumnCount() {
        return colCount;
    }

    @Override
    public Object getValueAt(int rowIndex, int colIndex) {
        
        
        switch(colIndex){
            case 0:
                return new CellObject(new ImageIcon("images/pesquisar_icon.png"));
            case 8: 
                return new CellObject(new ImageIcon("images/delete-icon.png"));
            default:
                return data[rowIndex][colIndex];       
        }
    }
    
    @Override
    public Class getColumnClass (int columnIndex) {
        if (columnIndex == 8 || columnIndex == 0)
            return JButton.class;
        else if(columnIndex == 7)
            return Boolean.class;

    return Object.class;
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        
       return true;
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            
        DespesasController rc = new DespesasController();
        
            switch (columnIndex){
                case 0:
                    VisualizarDespesaUI visualizarDetalhado = null;
                    try {
                        visualizarDetalhado = new VisualizarDespesaUI(this.data[rowIndex]);
                    } catch (ParseException ex) {
                        Logger.getLogger(DespesasTableModel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    visualizarDetalhado.setSize(600, 400);
                    visualizarDetalhado.setVisible(true);
                    visualizarDetalhado.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    break;
                case 3:
                    this.data[rowIndex][columnIndex] = aValue.toString();//Colocar data no formato SQL
                    break;
                case 4:
                    this.data[rowIndex][columnIndex] = aValue.toString();
                    break;
                case 5:
                    this.data[rowIndex][columnIndex] = aValue.toString();
                    break;
                case 6:
                    this.data[rowIndex][columnIndex] = aValue.toString();
                    break;
                case 7:
                    this.data[rowIndex][columnIndex] = Boolean.valueOf(aValue.toString());//Pesquisar como alterar boolean
                    break;
                case 8:
                    int b = JOptionPane.showConfirmDialog(null, "Deseja excluir a linha selecionada?");
                    if ( b == JOptionPane.YES_OPTION)
                    try {
                        boolean opt = rc.deletarItens(this.data[rowIndex]);
                        
                        if (opt) {
                            DespesasCadastroUI cadastro = new DespesasCadastroUI();
                            cadastro.setVisible(true);
                            Application.redesenhar(cadastro);
                                  
                        }
                        } catch (ParseException ex) {
                        Logger.getLogger(DespesasTableModel.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SQLException ex) {
                        Logger.getLogger(DespesasTableModel.class.getName()).log(Level.SEVERE, null, ex);
                         }
                    break;
                }
            
           
        try {
            rc.updateTable(this.data[rowIndex]);
        } catch (SQLException ex) {
            Logger.getLogger(DespesasTableModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(DespesasTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            fireTableCellUpdated(rowIndex, columnIndex);
    }
    
    @Override
    public String getColumnName (int col) {
        return columnNames[col];
    }
    
    private String conversorData (String data) throws ParseException{
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
    }
}
