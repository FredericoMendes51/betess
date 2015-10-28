/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package betess;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author fredericomendes
 */
public class CasaApostas {
    private int idApostas;
    private Map<Integer, Aposta> apostas;
    private Map<String, User> users;
    private Map<Integer, Admin> admins;
    private Map<Integer, Jogo> jogos;
    
    
    public CasaApostas(){
        this.idApostas = 0;
        this.apostas = new HashMap<>();
        this.users = new HashMap<>();
        this.admins = new HashMap<>();
        this.jogos = new HashMap<>();
    }
    
    public CasaApostas (int idApostas, Set<Aposta> ap, Set <User> us, Set<Admin> ad, Set<Jogo> jo){
        this.idApostas = idApostas;
        
        this.apostas = new HashMap<>();
        for(Aposta a : ap){
            this.apostas.put(a.getIdAposta(), a.clone());
        }
        
        this.users = new HashMap<>();
        for(User u : us){
            users.put(u.getEmail(), u.clone());
        }
        
        this.admins = new HashMap<>();
        for(Admin a : ad){
            this.admins.put(a.getIdAdmin(), a.clone());
        }
        
        this.jogos = new HashMap<>();
        for(Jogo j : jo){
            this.jogos.put(j.getIdJogo(), j.clone());
        }
        
    }
    
    public CasaApostas(CasaApostas ca){
        this.idApostas = ca.getIdApostas();
        this.apostas = ca.getApostas();
        this.users = ca.getUsers();
        this.admins = ca.getAdmins();
        this.jogos = ca.getUsers();
    }
    
    
    
}
