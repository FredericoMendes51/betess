/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package betess;

/**
 *
 * @author fredericomendes
 */
public class Aposta {
    private int idAposta;
    private boolean estado;
    private double valorApostado;
    private String userId; 
    private String resultado; //ganha ou perdida
    private Jogo jogo;
    private String tipoAposta;


    
    
    public Aposta(){
        this.idAposta=0;
        this.estado=false;
        this.valorApostado=0.0;
        this.userId="";
        this.resultado="";
        this.jogo = new Jogo();
        this.tipoAposta="";
    }

    public Aposta(int idAposta, boolean estado, double valorApostado, String userId, Jogo jogo, String tipoAposta) {
        this.idAposta = idAposta;
        this.estado = estado;
        this.valorApostado = valorApostado;
        this.userId = userId;
    //    this.resultado = resultado;
        this.jogo = jogo;
        this.tipoAposta = tipoAposta;
    }
    
    public Aposta(Aposta a){
        this.idAposta=a.getIdAposta();
        this.estado=a.isEstado();
        this.valorApostado=a.getValorApostado();
        this.userId=a.getUserId();
        this.resultado=a.getResultado();
        this.jogo=a.getJogo();
        this.tipoAposta=a.getTipoAposta();
    }

    public int getIdAposta() {
        return idAposta;
    }

    public boolean isEstado() {
        return estado;
    }

    public double getValorApostado() {
        return valorApostado;
    }

    public String getUserId() {
        return userId;
    }

    public String getResultado() {
        return resultado;
    }


    public Jogo getJogo() {
        return jogo.clone();
    }


    public String getTipoAposta() {
        return tipoAposta;
    }

    public void setIdAposta(int idAposta) {
        this.idAposta = idAposta;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setValorApostado(double valorApostado) {
        this.valorApostado = valorApostado;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }


    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }



    public void setTipoAposta(String tipoAposta) {
        this.tipoAposta = tipoAposta;
    }

    

    @Override
    
    public Aposta clone() {
        return new Aposta(this);
    }
    
    public boolean equals(Aposta a) {
        if (this == a) {
            return true;
        }
        if ((a == null) || (this.getClass() != a.getClass())) {
            return false;
        }
        Aposta e = (Aposta) a;
        return this.idAposta==(e.getIdAposta());
    }
    
    
        
}
