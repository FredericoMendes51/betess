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
    private String nome;
    private float saldo;
    List<Aposta> historicoApostas;
    List<Aposta> apostasAtivas;
    
    public User (String email, String nome, float saldo){
        this.email = email;
        this.nome = nome;
        this.saldo = saldo;
        this.historicoApostas = new ArrayList<>();
        this.apostasAtivas = new ArrayList<>();
    }
    
    public User (User u){
        this.email = u.getEmail();
        this.nome = u.getNome();
        this.saldo = u.getSaldo();
        for(Aposta a : u.getHistoricoApostas()){
            this.historicoApostas.add(a);
        }
        for(Aposta a : u.getApostasAtivas()){
            this.historicoApostas.add(a);
        }
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public float getSaldo(){
        return this.saldo;
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
    
}
