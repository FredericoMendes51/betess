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
    private boolean abriu;
    private String tipoAposta;


    
    
    public Aposta(){
        this.idAposta=0;
        this.estado=false;
        this.valorApostado=0.0;
        this.userId="";
        this.resultado="";
        this.jogo = new Jogo();
        this.abriu=false;
        this.tipoAposta="";
    }

    public Aposta(int idAposta, boolean estado, double valorApostado, String userId, String resultado, float um, float dois, float x, Jogo jogo, boolean abriu, String tipoAposta) {
        this.idAposta = idAposta;
        this.estado = estado;
        this.valorApostado = valorApostado;
        this.userId = userId;
        this.resultado = resultado;
        this.jogo = jogo;
        this.abriu = abriu;
        this.tipoAposta = tipoAposta;
    }
    
    public Aposta(Aposta a){
        this.idAposta=a.getIdAposta();
        this.estado=a.isEstado();
        this.valorApostado=a.getValorApostado();
        this.userId=a.getUserId();
        this.resultado=a.getResultado();
        this.jogo=a.getJogo();
        this.abriu=a.isAbriu();
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

    public boolean isAbriu() {
        return abriu;
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

    public void setAbriu(boolean abriu) {
        this.abriu = abriu;
    }

    public void setTipoAposta(String tipoAposta) {
        this.tipoAposta = tipoAposta;
    }

    

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Aposta : ");
        s.append(this.idAposta).append(", tem como valor apostado: ");
        if(this.estado==false){
            if(this.abriu==true){
                s.append("e neste momento encontra-se fechada, e foi ").append(this.resultado);
                s.append(".\n");
            }
            else{
                s.append("e neste momento encontra-se fechada");
            }
        }else{
            s.append("e neste momento encontra-se aberta.\n");
        }
        return s.toString();
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
