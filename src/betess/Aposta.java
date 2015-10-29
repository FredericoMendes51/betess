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
    private boolean estado; //aberta ou fechado - fecha quando o jogo começa
    private double valorApostado;
//    private String userId; 
    private String resultado; //1 ou x ou 2
    private Jogo jogo;
    private String tipoAposta;
    private double oddAposta;

    
    public Aposta(){
        this.idAposta=0;
        this.estado=false;
        this.valorApostado=0.0;
//        this.userId="";
        this.resultado = null;
        this.jogo = new Jogo();
        this.tipoAposta = null;
        this.oddAposta = 0.0;
    }

    public Aposta(int idAposta, boolean estado, double valorApostado, String userId, Jogo jogo, String tipoAposta, double oddAposta) {
        this.idAposta = idAposta;
        this.estado = estado;
        this.valorApostado = valorApostado;
//        this.userId = userId;
        this.resultado = null;
        this.jogo = jogo;
        this.tipoAposta = tipoAposta;
        this.oddAposta = oddAposta;
    }
    
    public Aposta(Aposta a){
        this.idAposta=a.getIdAposta();
        this.estado=a.getEstado();
        this.valorApostado=a.getValorApostado();
//        this.userId=a.getUserId();
        this.resultado=a.getResultado();
        this.jogo=a.getJogo();
        this.tipoAposta=a.getTipoAposta();
        this.oddAposta = a.getOddAposta();
    }

    public int getIdAposta() {
        return idAposta;
    }

    public boolean getEstado() {
        return estado;
    }

    public double getValorApostado() {
        return valorApostado;
    }

//    public String getUserId() {
//        return userId;
//    }

    public String getResultado() {
        return resultado;
   }

    public Jogo getJogo() {
        return jogo.clone();
    }

    public String getTipoAposta() {
        return tipoAposta;
    }
    
    public double getOddAposta(){
        return this.oddAposta;
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

//    public void setUserId(String userId) {
//        this.userId = userId;
//    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public void setTipoAposta(String tipoAposta) {
        this.tipoAposta = tipoAposta;
    }
    
    public void setOddAposta(double odd){
        this.oddAposta = odd;
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
