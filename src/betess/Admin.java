/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package betess;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author misterfour
 */
public class Admin {
    private int idAdmin;
    private String username;
    private String password;
    private List<Jogo> jogosCriados;
    private List<Jogo> jogosSeguidos;
    private List<Notificacao> listaNotificacoes;
    private boolean log;
    
    
    public Admin(){
        this.idAdmin = 0;
        this.username = null;
        this.password = null;
        this.jogosCriados = new ArrayList<>();
        this.jogosSeguidos = new ArrayList<>();
        this.log = false;
    }
    
    public Admin(int idAdmin, String username, String password){
        this.idAdmin = idAdmin;
        this.username = username;
        this.password = password;
        this.jogosCriados = new ArrayList<>();
        this.jogosSeguidos = new ArrayList<>();
    }
    
    public Admin(Admin a){
        this.idAdmin = a.getIdAdmin();
        this.username = a.getUsername();
        this.password = a.getPassword();
        this.log = a.getLog();
        this.jogosCriados = a.getJogosCriados();
        this.jogosSeguidos = a.getJogosSeguidos();
    }
    
    
    //get's
    public int getIdAdmin(){
        return this.idAdmin;
    }
    
    public String getUsername(){
        return this.username;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public List<Jogo> getJogosCriados(){
        List<Jogo> aux = new ArrayList<>();
        for(Jogo g : this.jogosCriados)
            aux.add(g);
        
        return aux;
    }
    
    public List<Jogo> getJogosSeguidos(){
        List<Jogo> aux = new ArrayList<>();
        for(Jogo g : this.jogosSeguidos)
            aux.add(g);
        
        return aux;
    }
   
    public Boolean getLog(){
        return this.log;
    }
    
    //set's
    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setJogosCriados(List<Jogo> criados){
        this.jogosCriados = new ArrayList<>();
        for(Jogo j : criados)
            this.jogosCriados.add(j);
        
    }
    
    public void setJogosSeguidos(List<Jogo> seguidos){
        this.jogosSeguidos = new ArrayList<>();
        for(Jogo j : seguidos)
            this.jogosSeguidos.add(j);
        
    }

    public void setLog(boolean log) {
        this.log = log;
    }

    public void adicionaJogoCriado(Jogo j){
        this.jogosCriados.add(j);
    }

    @Override
    public Admin clone() {
        return new Admin(this);
    }
    
    public boolean equals(Admin a) {
        if (this == a) {
            return true;
        }
        if ((a == null) || (this.getClass() != a.getClass())) {
            return false;
        }
        Admin e = (Admin) a;
        return this.idAdmin==(e.getIdAdmin());
    }
    
    @Override
    public String toString() {
        return "Admin:" + "idAdmin=" + idAdmin + ", username=" + username + '.';
    }

}