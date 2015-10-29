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
public class User {
    private String email;
    private String password;
    private String nome;
    private double saldo;
    private List<Aposta> historicoApostas;
    private List<Aposta> apostasAtivas;
    private boolean log;
    
    public User (String email, String pass, String nome, double saldo){
        this.email = email;
        this.password = pass;
        this.nome = nome;
        this.saldo = saldo;
        this.historicoApostas = new ArrayList<>();
        this.apostasAtivas = new ArrayList<>();
    }
    
    public User (User u){
        this.email = u.getEmail();
        this.password = u.getPassword();
        this.nome = u.getNome();
        this.saldo = u.getSaldo();
        this.historicoApostas = u.getHistoricoApostas();
        this.apostasAtivas = u.getApostasAtivas();
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public double getSaldo(){
        return this.saldo;
    }
    
    public Boolean getLog(){
        return this.log;
    }
    
    public List<Aposta> getHistoricoApostas(){
        List<Aposta> aux = new ArrayList<>();
        for(Aposta a : this.historicoApostas)
            aux.add(a);
        
        return aux;
    }
    
    public List<Aposta> getApostasAtivas(){
        List<Aposta> aux = new ArrayList<>();
        for(Aposta a : this.apostasAtivas)
            aux.add(a);
        
        return aux;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setHistoricoApostas(List<Aposta> historicoApostas) {
        this.historicoApostas = historicoApostas;
    }

    public void setApostasAtivas(List<Aposta> apostasAtivas) {
        this.apostasAtivas = apostasAtivas;
    }

    public void setLog(boolean log) {
        this.log = log;
    }
    
    
    
    public void setSaldo(double saldo){
        this.saldo = saldo;
    }
    
    
    //metodos
    
    //metodo apostar
    public void apostar(String email, int id_aposta, Jogo id_jogo, double montante, String tipoAposta){
       Aposta apostaAux = new Aposta(id_aposta, true, montante, email, id_jogo, tipoAposta); 
       this.apostasAtivas.add(apostaAux);
       this.setSaldo(this.getSaldo()-montante);
    }
    
    //metodo para retirar aposta
    public String retirarAposta(Aposta a){
        String ret = null;
        if(a.getJogo().getAcabou() == true){
            ret = "Já não dá para retirar aposta.\n";
        }
        else{
            double valorApostado = a.getValorApostado();
            valorApostado *= 0.9;
            this.apostasAtivas.remove(a);
            this.setSaldo(this.getSaldo() + valorApostado);
            ret = "Aposta retirada com sucesso. Foram-lhe acrescentados "+valorApostado+"\n";
        }
        return ret;
    }
    
    //metodo para depositar dinheiro
    public String depositarBetCoins(double money){
        double temp = this.getSaldo();
        this.setSaldo(temp+money);
        String ret = "O seu saldo final é "+(temp+money);
        
        return ret;
    }
    
    //metodo para levantar dinheiro
    public String levantarBetCoins(double money){
        double temp = this.getSaldo();
        String ret = null;
        if(money > temp){
            ret = "Erro: Saldo Insuficiente.";
        }
        else{
            temp -= money;
            this.setSaldo(temp);
            ret = "Levantou "+money+" BetCoins.\n O seu saldo final é "+temp;
        }
        
        return ret;
    }
    
    
    public String verMinhasInformacoes(){
        StringBuilder str =  new StringBuilder();
        str.append("Email: ").append(this.getEmail()).append("\n");
        str.append("Nome: ").append(this.getNome()).append("\n");
        str.append("Saldo: ").append(this.getSaldo()).append("\n");
        
        return str.toString();
    }
    
    public String alterarPassword(String newPassword){
        this.setPassword(newPassword);
        return "Password alterada com sucesso!\n";
    }
    
    

    @Override
    public String toString() {
        return "User:" + "email=" + email + '.';
    }
    
    @Override
    public User clone() {
        return new User(this);
    }
    
    public boolean equals(User a) {
        if (this == a) {
            return true;
        }
        if ((a == null) || (this.getClass() != a.getClass())) {
            return false;
        }
        User e = (User) a;
        return this.email==(e.getEmail());
    }
    
}
