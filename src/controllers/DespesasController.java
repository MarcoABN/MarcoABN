
package controllers;

import beans.Despesas;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import models.DespesasDAO;
import views.DespesasCadastroUI;

public class DespesasController {
    
   public List<Despesas> listAll() throws SQLException{
    DespesasDAO dao = new DespesasDAO();
    return dao.listAll();
} 
    
   public boolean adicionar (Despesas despesas) throws SQLException, ParseException {
       
       if (despesas != null) {
           
           despesas.setUser_id(Application.getUser().getUser_id());
           
           DespesasDAO dao = new DespesasDAO();
           dao.save(despesas);
       }
       
       DespesasCadastroUI cadastro = new DespesasCadastroUI();
       cadastro.setVisible(true);
       Application.redesenhar(cadastro);
       
       return false;
   }
    
   public boolean updateTable ( Object[] ob) throws SQLException, ParseException{
       if (ob != null ) {

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  

           Despesas despesas = new Despesas();
           despesas.setDespesas_id((int) ob[1]);
           despesas.setUser_id((int) ob[2]);
           despesas.setData(sdf.parse(ob[3].toString()));
           despesas.setDescricao((String) ob[4]);
           despesas.setValor(Double.parseDouble(ob[5].toString()));
           despesas.setCategoria((String) ob[6]);
           despesas.setPago((boolean) ob[7]);
           
           DespesasDAO dao = new DespesasDAO();
           dao.alterarItens(despesas);
           
           return true;
           
           
       }
       return false;
   }
   
   
   public boolean deletarItens (Object[] ob) throws ParseException, SQLException{
       if (ob != null ) {

           SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
 
           Despesas despesas = new Despesas();
           despesas.setDespesas_id((int) ob[1]);
           despesas.setUser_id((int) ob[2]);
           despesas.setData(sdf.parse(ob[3].toString()));
           despesas.setDescricao((String) ob[4]);
           despesas.setValor(Double.parseDouble(ob[5].toString()));
           despesas.setCategoria((String) ob[6]);
           despesas.setPago((boolean) ob[7]);
           
           DespesasDAO dao = new DespesasDAO();
           dao.deletarItens(despesas); 

           return true;
           
   }
       return false;
      
}
   
    public boolean updateTable ( Despesas despesas){
        
       DespesasDAO dao = new DespesasDAO();
       dao.alterarItens(despesas);
       return true;
   }
    
    public void filtrarPorTexto (String texto) throws SQLException, ParseException{
        List<Despesas> lista = this.listAll();
        List<Despesas> separado = new ArrayList();
        
        for (int a=0; a<lista.size(); a++){
            if (texto.isEmpty()) {
                 DespesasCadastroUI cadastroUI = new DespesasCadastroUI(this.listAll()); 
                 break;
            }else if (lista.get(a).getDescricao().contains(texto)){
                separado.add(lista.get(a));
        }
    }
            DespesasCadastroUI cadastroUI = new DespesasCadastroUI(separado);
    }

    public void filtrarPorData (Date text01, Date text02) throws SQLException, ParseException{
        DespesasDAO dao = new DespesasDAO();
        List<Despesas> lista = dao.filtrarPorData(text01, text02);
        
        DespesasCadastroUI teste = new DespesasCadastroUI(lista);
        teste.setVisible(true);
        Application.redesenhar(teste);
        
        
    }
    
}