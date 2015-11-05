/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package betess;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author fredericomendes
 */
public class CasaApostas {
    private int idApostas;
    private int idJogo;
    private Map<Integer, Aposta> apostas;
    private Map<String, User> users;
    private Map<Integer, Admin> admins;
    private Map<Integer, Jogo> jogos;
    
    
    public CasaApostas(){
        this.idApostas = 0;
        this.idJogo = 1;
        this.apostas = new HashMap<>();
        this.users = new HashMap<>();
        this.admins = new HashMap<>();
        this.jogos = new HashMap<>();
    }
    
    public CasaApostas (int idApostas, int idJogo,Set<Aposta> ap, Set <User> us, Set<Admin> ad, Set<Jogo> jo){
        this.idApostas = idApostas;
        this.idJogo = idJogo;
        
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
        this.idJogo = ca.getIdJogo();
        this.apostas = ca.getApostas();
        this.users = ca.getUsers();
        this.admins = ca.getAdmins();
        this.jogos = ca.getJogos();
    }
    
    public void preDefinicao(){
        //Admins
        Admin ad1 = new Admin(0, "admin1", "passadmin1");
        Admin ad2 = new Admin(1, "admin2@gmail.com", "passadmin2");
        
        this.admins.put(ad1.getIdAdmin(), ad1);
        this.admins.put(ad2.getIdAdmin(), ad2);
        
        //Users
        User user1 = new User("user1@gmail.com", "passuser1","Sou o Utilizador 1", 150.00);
        User user2 = new User("user2@gmail.com", "passuser2","Sou o Utilizador 2", 1510.00);
        
        this.users.put(user1.getEmail(), user1);
        this.users.put(user2.getEmail(), user2);
        
        //Jogos
        
        criaJogo("Sporting","Braga", 1.32, 4.0, 8.0, new Date());
        criaJogo("Benfica","Sporting", 3.2, 4.0, 1.5, new Date());
        criaJogo("Porto","Guimarães", 1.4, 3.5, 5.0, new Date());
        criaJogo("Porto","Braga", 2.1, 3.2, 4.0, new Date());
        criaJogo("Benfica","Olhanense", 1.32, 4.0, 5.0, new Date());
        criaJogo("Prado","Merelim", 4.0, 2.0, 4.0, new Date());
        criaJogo("Portugal","Sérvia", 1.32, 4.0,  8.0, new Date());

    }

    
    public int getIdApostas(){
        return this.idApostas;
    }
    
    public int getIdJogo(){
        return this.idJogo;
    }
    
    public Map<Integer, Aposta> getApostas(){
        Map<Integer, Aposta> aux = new HashMap<>();
        for(Aposta a : this.apostas.values()){
            aux.put(a.getIdAposta(), a.clone());
        }
        return aux;
    }
    
    public Map<String, User> getUsers(){
        Map<String, User> aux = new HashMap<>();
        for(User u : this.users.values()){
            aux.put(u.getEmail(), u.clone());
        }
        return aux;
    }
    
    public Map<Integer, Admin> getAdmins(){
        Map<Integer, Admin> aux = new HashMap<>();
        for(Admin ad : this.admins.values()){
            aux.put(ad.getIdAdmin(), ad.clone());
        }
        return aux;
    }
    
    public Map<Integer, Jogo> getJogos(){
        Map<Integer, Jogo> aux = new HashMap<>();
        for(Jogo j : this.jogos.values()){
            aux.put(j.getIdJogo(), j.clone());
        }
        return aux;
    }
    
    public void setApostas(Map<Integer, Aposta> apostaAux){
        this.apostas = new HashMap<>();
        for(Aposta a : apostaAux.values())
            this.apostas.put(a.getIdAposta(), a.clone());
    }
    
    public void setUsers(Map<String, User> userAux){
        this.users = new HashMap<>();
        for(User u : userAux.values())
            this.users.put(u.getEmail(), u.clone());
    }
    
    public void setAdmins(Map<Integer, Admin> adminAux){
        this.admins = new HashMap<>();
        for(Admin a : adminAux.values())
            this.admins.put(a.getIdAdmin(), a.clone());
    }
    
    public void setJogos(Map<Integer, Jogo> jogoAux){
        this.jogos = new HashMap<>();
        for(Jogo a : jogoAux.values())
            this.jogos.put(a.getIdJogo(), a.clone());
    }
    
    
    
    //metodos
    
    //metodo para autenticar user
    public boolean aut_user(String email, String pass){
        boolean ret = false;
        
        for(User u : this.users.values()){
            if(u.getEmail().equals(email) && u.getPassword().equals(pass)){
                ret = true;
                u.setLog(true);
                break;
            }
        }
        
        return ret;
    }
    
    //metodo para autenticar admin
    public boolean aut_admin(String username, String pass){
        boolean ret = false;
        
        for(Admin a : this.admins.values()){
            if(a.getUsername().equals(username) && a.getPassword().equals(pass)){
                ret = true;
                a.setLog(true);
                break;
            }
        }
        
        return ret;
    }
    
    //metodo para registar novo user
    public void novoUser(String email, String password, String nome, double saldoInicial){
        User newUser = new User(email, password, nome, saldoInicial);
        this.users.put(email, newUser);
    }
    
    //metodo apostar
    public String apostar(String email, int id_jogo, double montante, String tipoAposta){
        User userAux = this.users.get(email);
        Jogo jogoAux = this.jogos.get(id_jogo);
        double odd = 0.0;
        String aposta = null;
        
        if(userAux.getSaldo() < montante){
            aposta = "Saldo insuficiente.\n"; 
        }
        else{
            this.idApostas++;
            
            if(tipoAposta.equals("1"))
                odd = jogoAux.getListaOdds().get(0).getOddUm();
            else if(tipoAposta.equals("x") || tipoAposta.equals("X"))
                odd = jogoAux.getListaOdds().get(0).getOddX();
            else if(tipoAposta.equals("2"))
                odd = jogoAux.getListaOdds().get(0).getOddDois();
            
            Aposta a = new Aposta(idApostas, true, montante, userAux.getEmail(), jogoAux.clone(), tipoAposta, odd);
            userAux.apostar(email, this.idApostas, jogoAux, montante, tipoAposta, odd);
            this.apostas.put(idApostas, a);
            aposta = "Aposta concluida.\n";
        }
        
        return aposta;
    }
      
    //ver o historico de apostas de um user
    public List<Aposta> verHistoricoAposta(String email){
        List<Aposta> auxAposta = new ArrayList<>();
        for(User u : this.users.values()){
            if(u.getEmail().equals(email)){
                auxAposta = u.getHistoricoApostas();
                break;
            }
        }
        return auxAposta;
    }
    
    //ver todas as apostas que estao a decorrer
    public List<Aposta> verApostasDecorrer(String email){
        List<Aposta> auxAposta = new ArrayList<>();
        for(User u : this.users.values()){
            if(u.getEmail().equals(email)){
                auxAposta = u.getApostasAtivas();
                break;
            }
        }
        
        return auxAposta;
    }
    
    //funcao para retirar aposta
    public String retirarAposta(String email, int id_aposta){
        String ret = null;
        for(User u : this.users.values()){
            if(u.getEmail().equals(email)){
                Aposta ap = u.getApostasAtivas().get(id_aposta);
                ret = u.retirarAposta(ap);
            }
        }
        return ret;
    }

    //metodto para depositar dinheiro
    public String depositarBetCoins(String email,double money){
        String ret = null;
        for(User u : this.users.values()){
            if(u.getEmail().equals(email)){
                ret = u.depositarBetCoins(money);
            }
        }
        return ret;
    }
    
    //meotodo para levantar dinheiro
    public String levantarBetCoins(String email, double money){
        String ret = null;
        for(User u : this.users.values()){
            if(u.getEmail().equals(email)){
                ret = u.levantarBetCoins(money);
            }
        }
        return ret;
    }
    
    //metodo para ver as informacoes do utilizador
    public String verMinhasInformacoes(String email){
        String ret = null;
        for(User u : this.users.values()){
            if(u.getEmail().equals(email)){
                ret = u.verMinhasInformacoes();
            }
        }
        
        return ret;
    }
    
    //metodo para fazer mudar a password
    public String alterarPassword(String email, String pass){
        String s = null;
        for(User u : this.users.values()){
            if(u.getEmail().equals(email)){
                s = u.alterarPassword(pass);
            }
        }
        
        return s;
            
    }
    
    //metodo para adicionar um jogo
    
    public void criaJogo(String equipa1, String equipa2, double odd1, double oddx, double odd2, Date date){
        
        Jogo j = new Jogo(this.idJogo, equipa1, equipa2);

        j.adicionaOdds(odd1, oddx, odd2);
        this.jogos.put(idJogo, j);
        this.idJogo++;
    }

    public String editaJogo(int idJogo, Odd odd){
        String res;
        if(this.jogos.get(idJogo)!=null){
            res="O jogo que escolheu não existe";
        }
       this.jogos.get(idJogo).adicionaOdds(odd.getOddUm(), odd.getOddX(), odd.getOddDois());

       res="Jogo editado com sucesso!!";
        System.out.println(this.jogos.get(idJogo).toString());
       return res;
    }
    
    public String eliminaJogo(int idJogo){
        String res;
        if(this.jogos.get(idJogo)!=null){
            res="O jogo que escolheu não existe";
        }
        this.jogos.remove(this.jogos.get(idJogo));
        res = "Jogo removido com sucesso";
        return res;
    }

    public List<Jogo> listaJogosDecorrer(){
        List<Jogo> aux = new ArrayList<>();
        for(Jogo j :this.jogos.values()){
            if(j.getAcabou() == false){
                aux.add(j);
            }
        }
        return aux;
    }
    
    public List<Jogo> listaHistoricoJogos(){
        List<Jogo> aux = new ArrayList<>();
        for(Jogo j :this.jogos.values()){
                aux.add(j);
        }
        return aux;
    }
    
    public List<User> listaUsersOn(){
        List<User> aux = new ArrayList<>();
        for(User u :this.users.values()){
            if(u.getLog()){
                aux.add(u);
            }
        }
        return aux;
}
    
    public List<User> listaUsers(){
        List<User> aux = new ArrayList<>();
        for(User u :this.users.values()){
                aux.add(u);
        }
        return aux;
}
    
    public String terminaJogo(int idJogo, String resultado){
        String res;
        List<Aposta> auxApostasAtivas = new ArrayList<>();
        
        if(!this.jogos.containsKey(idJogo)){
            res="O jogo que escolheu não existe";
        }
        
        this.jogos.get(idJogo).setAcabou(true);
        this.jogos.get(idJogo).setResultado(resultado);
        res = "Jogo terminado com sucesso";
        
//        for(User u : this.users.values()){
//            for(Aposta a : u.getApostasAtivas()){
//                if(a.getJogo().getIdJogo() == idJogo){
//                    double valor = resultadoAposta(a);
//                    u.setSaldo(u.getSaldo()+valor);
//                    System.out.println("Ganhou "+valor+" na aposta com "+a.getIdAposta()+" e ficou com um total de "+u.getSaldo());
//                }
//                    
//            }
//            
//        }
        return res;
    }
    
    //método para calcular o resultado das apostas
    public double resultadoAposta(Aposta a){
        Jogo j = a.getJogo();
        double valor = 0.0;
        if(a.getTipoAposta().equals(a.getResultado())){
            valor = a.getValorApostado() * a.getOddAposta();
        }
        
        return valor;
    }
    
    public CasaApostas clone() {
        return new CasaApostas(this);
    }
   
}
