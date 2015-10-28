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
class Jogo {
    private int idJogo;
    private String equipa1;
    private String equipa2;
    private String resultado;
    private float oddUm;
    private float oddDois;
    private float oddX;
    
    
    public Jogo(){
        this.idJogo=0;
        this.equipa1="";
        this.equipa2="";
        this.resultado="";
        this.oddUm=0;
        this.oddDois=0;
        this.oddX=0;
    }

    public Jogo(int idJogo, String equipa1, String equipa2, String resultado, float oddUm, float oddDois, float oddX) {
        this.idJogo = idJogo;
        this.equipa1 = equipa1;
        this.equipa2 = equipa2;
        this.resultado = resultado;
        this.oddUm = oddUm;
        this.oddDois = oddDois;
        this.oddX = oddX;
    }
    
    public Jogo(Jogo j){
        this.idJogo=j.getIdJogo();
        this.equipa1=j.getEquipa1();
        this.equipa2=j.getEquipa2();
        this.resultado=j.getResultado();
        this.oddUm=j.getOddUm();
        this.oddDois=j.getOddDois();
        this.oddX=j.getOddX();
    }

    public int getIdJogo() {
        return idJogo;
    }

    public String getEquipa1() {
        return equipa1;
    }

    public String getEquipa2() {
        return equipa2;
    }

    public String getResultado() {
        return resultado;
    }

    public float getOddUm() {
        return oddUm;
    }

    public float getOddDois() {
        return oddDois;
    }

    public float getOddX() {
        return oddX;
    }

    public void setIdJogo(int idJogo) {
        this.idJogo = idJogo;
    }

    public void setEquipa1(String equipa1) {
        this.equipa1 = equipa1;
    }

    public void setEquipa2(String equipa2) {
        this.equipa2 = equipa2;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public void setOddUm(float oddUm) {
        this.oddUm = oddUm;
    }

    public void setOddDois(float oddDois) {
        this.oddDois = oddDois;
    }

    public void setOddX(float oddX) {
        this.oddX = oddX;
    }
    
    
    
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Jogo : ");
        s.append(this.idJogo).append("em que se defrontam a equipa ");
        s.append(this.equipa1).append("e a equipa ");
        s.append(this.equipa2).append(".\n");
        s.append("Neste momento o resultado é:").append(this.resultado);
        s.append("\n");
        s.append("Tem como odd para a vitória da equipa da casa: ").append(this.oddUm);
        s.append(" para o empate: ").append(this.oddX);
        s.append(" e para a vitória da equipa visitante: ").append(this.oddDois);
        s.append("\n");
        return s.toString();
    }
    
    
    public Jogo clone() {
        return new Jogo(this);
    } 
    
    public boolean equals(Jogo j) {
        if (this == j) {
            return true;
        }
        if ((j == null) || (this.getClass() != j.getClass())) {
            return false;
        }
        Jogo e = (Jogo) j;
        return this.idJogo==(e.getIdJogo());
    }
    
    
    
}
