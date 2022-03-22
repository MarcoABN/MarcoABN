
package models;

import beans.Despesas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import resources.ConnectionFactory;

public class DespesasDAO {

    private Connection conm;
    private PreparedStatement stmt;
    
    public DespesasDAO() {
        this.conm = new ConnectionFactory().getConnection();
    }
    
    public boolean save (Despesas despesas){
        
        String sql = "INSERT INTO despesas (user_id, data, descricao, valor, categoria, pago)"
                        + "values (?, ?, ?, ?, ?, ?)";
        
        try {
            
          stmt = this.conm.prepareStatement(sql);
          stmt.setInt(1, despesas.getUser_id());
          stmt.setDate(2, new java.sql.Date(despesas.getData().getTime()));
          stmt.setString(3, despesas.getDescricao());
          stmt.setDouble(4, despesas.getValor());
          stmt.setString(5, despesas.getCategoria());
          stmt.setBoolean(6, despesas.isPago());
          
          int result = stmt.executeUpdate();
          if (result == 1) {
              return true;
          }
          return false;
          
        }catch (SQLException e) {
            throw new RuntimeException (e);
        }   
    }
    
    public List<Despesas> listAll () throws SQLException{
        String sql = "SELECT * FROM DESPESAS";
        List<Despesas> list = null;
        
        try{
            list = new ArrayList<>();
            stmt = this.conm.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                Despesas recebimento = new Despesas();
                recebimento.setDespesas_id(result.getInt("despesas_id"));
                recebimento.setUser_id(result.getInt("user_id"));
                recebimento.setData (result.getDate("Data"));
                recebimento.setDescricao(result.getString("descricao"));
                recebimento.setValor(result.getDouble("valor"));
                recebimento.setCategoria(result.getString("categoria"));
                recebimento.setPago(result.getBoolean("pago"));
                list.add (recebimento);
                
            }
        }catch (SQLException e){
        throw new RuntimeException (e);
    }
        return list;
    }
    
    public boolean alterarItens (Despesas despesas) {
        
        String sql = "UPDATE despesas SET data = ?, descricao = ?, valor = ?, categoria = ?, pago = ? WHERE despesas_id = ?";
        
        try {
            
          stmt = this.conm.prepareStatement(sql);
          stmt.setDate(1, new java.sql.Date(despesas.getData().getTime()));
          stmt.setString(2, despesas.getDescricao());
          stmt.setDouble(3, despesas.getValor());
          stmt.setString(4, despesas.getCategoria());
          stmt.setBoolean(5, despesas.isPago()); 
          stmt.setInt(6, despesas.getDespesas_id());
          
          
          int result = stmt.executeUpdate();
          if (result == 1) {
              return true;
          }
          return false;
          
        }catch (SQLException e) {
            throw new RuntimeException (e);
        }   
    }
    
    public boolean deletarItens (Despesas despesas) throws SQLException{
        
        String sql = "DELETE FROM despesas WHERE despesas_id = ?";
        stmt = this.conm.prepareStatement(sql);
        stmt.setInt(1, despesas.getDespesas_id());
        int result = stmt.executeUpdate();
          if (result == 1) {
              return true;
          }
          return false;
    }
    
    public List<Despesas> filtrarPorData (Date data01, Date data02) throws SQLException, ParseException{
        
        List<Despesas> list = null;
        list = new ArrayList<>();
        
        DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        java.sql.Date date01 = new java.sql.Date (data01.getTime());
        java.sql.Date date02 = new java.sql.Date (data02.getTime());
        
        
        
        String sql = ("SELECT * FROM despesas WHERE data BETWEEN ? AND ?");
        stmt = this.conm.prepareStatement(sql);
        stmt.setDate(1, date01);
        stmt.setDate(2, date02);
        
        ResultSet result = stmt.executeQuery();
            while (result.next()) {
                Despesas despesas = new Despesas();
                despesas.setDespesas_id(result.getInt("despesas_id"));
                despesas.setUser_id(result.getInt("user_id"));
                despesas.setData (result.getDate("Data"));
                despesas.setDescricao(result.getString("descricao"));
                despesas.setValor(result.getDouble("valor"));
                despesas.setCategoria(result.getString("categoria"));
                despesas.setPago(result.getBoolean("pago"));
                list.add (despesas);
                }
            return list;
    }
}
