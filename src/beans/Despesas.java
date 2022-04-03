
package beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Despesas {
    
    private int despesas_id;
    private int user_id;
    private Date data;
    private String descricao;
    private double valor;
    private String categoria;
    private boolean pago;

    public int getDespesas_id() {
        return despesas_id;
    }

    public void setDespesas_id(int despesas_id) {
        this.despesas_id = despesas_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }
   
    public void setStringDate (String date) {
        try {
        SimpleDateFormat sdf = new SimpleDateFormat ("dd/mm/yyyy");
        this.data = sdf.parse(date);
        }catch (ParseException e){
            throw new RuntimeException(e);
        }
    }
    
}
