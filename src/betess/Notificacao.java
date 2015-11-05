/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package betess;

import java.util.Date;

/**
 *
 * @author misterfour
 */
public class Notificacao {
    private String tipoNotificacao; //mensagens de sistema, mensagens das apostas que tem, mensagem dos jogos que esta a seguir
    private String from;
    private String mensagem;
    private Date data;
    private boolean notificacaoLida;
     
    public Notificacao(){
        this.tipoNotificacao = null;
        this.from = null;
        this.mensagem = null;
        this.data = new Date();
    }
    
    public Notificacao(String tipo, String from, String msg, Date d){
        this.tipoNotificacao = tipo;
        this.from = from;
        this.mensagem = msg;
        this.data = d;
    }
    
    public Notificacao(Notificacao n){
        this.tipoNotificacao = n.getTipoNotificacao();
        this.from = n.getFrom();
        this.mensagem = n.getMensagem();
        this.data = n.getData();
    }
  

    public String getTipoNotificacao() {
        return this.tipoNotificacao;
    }

    public String getFrom() {
        return this.from;
    }

    public String getMensagem() {
        return this.mensagem;
    }

    public Date getData() {
        return this.data;
    }
    
    
    public void setTipoNotificacao(String tipo){
        this.tipoNotificacao = tipo;
    }
    
    public void setFrom(String from){
        this.from = from;
    }
    
    public void setMensagem(String mensagem){
        this.mensagem = mensagem;
    }
    
    public void setData(Date date){
        this.data = date;
    }
    
      
    
    public int hashCode(){
        return this.data.hashCode();
    }
}
