/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package betess;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author fredericomendes
 */
class Jogo {
    private int idJogo;
    private String equipa1;
    private String equipa2;
    private String resultado; //so é preciso alterar depois de fechar o jogo
    private List<Odd> listaOdds;
    private boolean fechadoParaApostar; //boleano que diz que o jogou ainda tá fechou ou abriu (antes de começar)
    private boolean acabou; //boolean que diz se um jogo ja começou ou acabou
    private Date inicioJogo;
    
    //falta mudar para arrays odd's
    
    
    public Jogo(){
        this.idJogo=0;
        this.equipa1="";
        this.equipa2="";
        this.resultado="";
        this.listaOdds = new ArrayList<>();
        this.acabou=false;
        this.fechadoParaApostar = false;
        this.inicioJogo = new Date();
    }

    public Jogo(int idJogo, String equipa1, String equipa2) {
        this.idJogo = idJogo;
        this.equipa1 = equipa1;
        this.equipa2 = equipa2;
        this.listaOdds = new ArrayList<>();
        this.acabou = false;
        this.fechadoParaApostar = false;
        this.inicioJogo = new Date();
    }
    
    public Jogo(Jogo j){
        this.idJogo=j.getIdJogo();
        this.equipa1=j.getEquipa1();
        this.equipa2=j.getEquipa2();
        this.listaOdds = j.getListaOdds();
        this.resultado=j.getResultado();
        this.fechadoParaApostar = j.getFechadoParaApostar();
        this.inicioJogo = j.getInicioJogo();
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

    public boolean getAcabou(){
        return acabou;
    }
    
    public boolean getFechadoParaApostar(){
        return this.fechadoParaApostar;
    }

    public List<Odd> getListaOdds(){
        List<Odd> aux = new ArrayList<>();
        for(Odd o : this.listaOdds)
            aux.add(o);
        
        return aux;
    }
    
    public Date getInicioJogo(){
        return this.inicioJogo;
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

    public void setAcabou(boolean acabou) {
        this.acabou = acabou;
    }
    
    public void setFechadoParaApostar(boolean fechou){
        this.fechadoParaApostar = fechou;
    }
    
    public void setListaOdds(List<Odd> lista){
        this.listaOdds = new ArrayList<>();
        for(Odd o : lista){
            this.listaOdds.add(o);
        }
    }
    
    public void setInicioJogo(Date time){
        this.inicioJogo = time;
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
