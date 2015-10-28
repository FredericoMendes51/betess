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
    private float saldo;
    private List<Aposta> historicoApostas;
    private List<Aposta> apostasAtivas;
    private boolean log;
    
    public User (String email, String pass, String nome, float saldo, Boolean log){
        this.email = email;
        this.password = pass;
        this.nome = nome;
        this.saldo = saldo;
        this.historicoApostas = new ArrayList<>();
        this.apostasAtivas = new ArrayList<>();
        this.log=log;
    }
    
    public User (User u){
        this.email = u.getEmail();
        this.password = u.getPassword();
        this.nome = u.getNome();
        this.saldo = u.getSaldo();
        this.historicoApostas = u.getHistoricoApostas();
        this.apostasAtivas = u.getApostasAtivas();
        this.log = u.getLog();
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
    
    public float getSaldo(){
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
    
    
    
    public void setSaldo(float saldo){
        this.saldo = saldo;
    }
    
    
    //metodos
    
    //metodo apostar
    public String apostar(int id_aposta, Jogo id_jogo, float montante, String tipoAposta){
       
    }
    
    //ver o historico de todas as apostas efetuadas
    public void verHistoricoApostas(){
        for(Aposta a : this.historicoApostas)
            System.out.println("Aposta: "+a.getIdAposta()+ " -> Valor Apostado: "+a.getValorApostado());
    }
    
    //ver todos os jogos a decorrer para apostar
    public void verJogosDecorrer(List<Jogo> listaJogos){
        for(Jogo j : listaJogos){
            System.out.println(j.getIdJogo()+" : "+j.getEquipa1()+"-"+j.getEquipa2()+" : "+j.getOddUm()+"-"+j.getOddX()+"-"+j.getOddUm());
        }
    }
    
    //metodo para depositar dinheiro
    public void depositarBetCoins(float money){
        float temp = this.getSaldo();
        this.setSaldo(temp+money);
        System.out.println("O seu saldo final é "+(temp+money));
    }
    
    //metodo para levantar dinheiro
    public void levantarBetCoins(float money){
        float temp = this.getSaldo();
        if(money > temp){
            System.out.println("Erro: Saldo Insuficiente.");
        }
        else{
            temp -= money;
            this.setSaldo(temp);
            System.out.println("Levantou "+money+" BetCoins.\n O seu saldo final é "+temp);
        }
    }
    
    
    public String verMinhasInformacoes(){
        StringBuilder str =  new StringBuilder();
        str.append("Email: ").append(this.getEmail()).append("\n");
        str.append("Nome: ").append(this.getNome()).append("\n");
        str.append("Saldo: ").append(this.getSaldo()).append("\n");
        
        return str.toString();
    }
    
    public void alterarPassword(String newPassword){
        this.setPassword(newPassword);
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
