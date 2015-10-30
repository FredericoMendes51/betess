/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package betess;

import java.io.IOException;
import static java.util.Collections.list;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author fredericomendes
 */
public class Menu {
    
    private CasaApostas ca;
    private Input input;
    
    public Menu() {
        this.ca = new CasaApostas();
        this.input = new Input();
    }

    public Menu(CasaApostas ca) {
        this.ca = ca.clone();
        this.input = new Input();
    }
    
    public void menu_principal() throws IOException {
        Input i = new Input();
        System.out.println("  \t\t\t\t--------------------------------");
        System.out.println("  \t\t\t\t| 1 - Carregar dados             |");
        System.out.println("  \t\t\t\t--------------------------------");
        System.out.println("  \t\t\t\t| 0 - Sair                       |");
        System.out.println("  \t\t\t\t--------------------------------");
        int opcao = i.lerInteiro();
        switch (opcao) {
            case 1:
                limparEcra(2);
                //print_linha("Nome do ficheiro :");
                //String nome_ficheiro2 = this.input.lerString();
                //this.ca = this.ca.load_ca(nome_ficheiro2);
                this.ca.preDefinicao();
                menu_after_leitura();
                break;

            case 0:
                break;
        }

    }
    
    private void menu_after_leitura() throws IOException {

        limparEcra(4);
        System.out.println("\t\t\t\t--------------------------------");
        System.out.println("\t\t\t\t1 - Autenticar como User");
        System.out.println("\t\t\t\t--------------------------------");
        System.out.println("\t\t\t\t2 - Autenticar como Admin");
        System.out.println("\t\t\t\t--------------------------------");
        System.out.println("\t\t\t\t3 - Registar");
        System.out.println("\t\t\t\t--------------------------------");
        System.out.println("\t\t\t\t0 - Voltar");
        System.out.println("\t\t\t\t--------------------------------");
        int opcao;
        opcao = input.lerInteiro();
        switch (opcao) {
            case 1:
                limparEcra(3);
                print_linha("Introduza o seu email");
                String email = this.input.lerString();
                
                print_linha("Introduza a sua password");
                String pass = this.input.lerString();
                
                
                if(ca.aut_user( email, pass)){
                    menu_to_user(email);
                }
                else{
                        System.out.println("Dados mal inseridos!");
                        }
                break;
            case 2:
                limparEcra(3);
                print_linha("Introduza o seu email");
                String user = this.input.lerString();
                print_linha("Introduza a sua password");
                String pass2 = this.input.lerString();
                
                if(ca.aut_admin( user, pass2)){
                    menu_to_admin(user);
                }
                else{
                        System.out.println("Dados mal inseridos!");
                        }
                break;
            case 3:
                limparEcra(3);
                print_linha("Introduza o seu email");
                String userRegisto = this.input.lerString();
                print_linha("Introduza a sua password");
                String passRegisto = this.input.lerString();
                print_linha("Introduza o seu Nome");
                String nomeRegisto = this.input.lerString();
                print_linha("Introduza o saldo inicial");
                String saldoRegisto = this.input.lerString();
                double saldoR = Double.parseDouble(saldoRegisto);
                
                if(ca.getUsers().containsKey(userRegisto))
                    System.out.println("Utilizador ja existente. \n");
                
                ca.novoUser(userRegisto, passRegisto, nomeRegisto, saldoR);
                menu_after_leitura();
                break;
                
            case 0:
                limparEcra(3);
                menu_principal();
                break;

        }

    }
    
    private void menu_to_user(String email) throws IOException {

        limparEcra(4);
        System.out.println("\t\t\t\t--------------------------------");
        System.out.println("\t\t\t\t1 - Apostar");
        System.out.println("\t\t\t\t--------------------------------");
        System.out.println("\t\t\t\t2 - Listar jogos a decorrer");
        System.out.println("\t\t\t\t--------------------------------");
        System.out.println("\t\t\t\t3 - Listar histórico de apostas");
        System.out.println("\t\t\t\t--------------------------------");
        System.out.println("\t\t\t\t4 - Listar apostas a decorrer");
        System.out.println("\t\t\t\t--------------------------------");
        System.out.println("\t\t\t\t5 - Retirar Aposta");
        System.out.println("\t\t\t\t--------------------------------");
        System.out.println("\t\t\t\t6 - Depositar dinheiro");
        System.out.println("\t\t\t\t--------------------------------");
        System.out.println("\t\t\t\t7 - Levantar dinheiro");
        System.out.println("\t\t\t\t--------------------------------");
        System.out.println("\t\t\t\t8 - Ver o meu perfil");
        System.out.println("\t\t\t\t--------------------------------");
        System.out.println("\t\t\t\t9 - Mudar a password");
        System.out.println("\t\t\t\t--------------------------------");
        System.out.println("\t\t\t\t0 - Voltar");
        System.out.println("\t\t\t\t--------------------------------");
        int opcao;
        opcao = input.lerInteiro();
         String resultado ="";
         Scanner in = new Scanner(System.in);
        switch (opcao) {
            case 1:
                limparEcra(3);
                print_linha("Introduza o Numero de jogo");
                int N2 = this.input.lerInteiro();
                
                print_linha("Introduza o Montante que quer apostar");
                String s = in.next();
                double N3 = Double.parseDouble(s);
                
                print_linha("Introduza o tipo de aposta (1-X-2):");
                String tipo = this.input.lerString();
                
                resultado = ca.apostar(email, N2, N3, tipo);
                
                System.out.println(resultado + "\n");
                
                menu_to_user(email);
                break;
            case 2:
                limparEcra(3);
                List<Jogo> res = ca.verJogosDecorrer(); 
                
                for(Jogo j : res){
                    System.out.println(j.getIdJogo()+" : "+j.getEquipa1()+"-"+j.getEquipa2()+" : "+j.getListaOdds().get(j.getListaOdds().size()-1).getOddUm()+"-"+j.getListaOdds().get(j.getListaOdds().size()-1).getOddX()+"-"+j.getListaOdds().get(j.getListaOdds().size()-1).getOddUm());
                }
                
                menu_to_user(email);
                break;
                
            case 3:
                limparEcra(3);
                List<Aposta> res2 = ca.verHistoricoAposta(email); 
                
                for(Aposta a : res2){
                    System.out.println("Aposta: "+a.getIdAposta()+ " -> Valor Apostado: "+a.getValorApostado()+ "-> Ganho: ");
                }
                
                menu_to_user(email);
                break;
            
            case 4:
                limparEcra(3);
                List<Aposta> res3 = ca.verApostasDecorrer(email); 
                
                for(Aposta a : res3){
                    System.out.println("Aposta: "+a.getIdAposta()+ " -> Valor Apostado: "+a.getValorApostado());
                }
                
                menu_to_user(email);
                break;
            
            case 5:
                limparEcra(3);
                
                print_linha("Introduza o Numero de aposta que pretende eliminar");
                int N4 = this.input.lerInteiro();
                
                String resposta = ca.retirarAposta(email,N4); 
                        
                System.out.println(resposta);
                
                menu_to_user(email);
                break;
                
            case 6:
                limparEcra(3);
                print_linha("Introduza os BetESS que deseja depositar:");
                double N5 = this.input.lerDouble();
                
                String cenas =ca.depositarBetCoins(email, N5);
                System.out.println(cenas);
                
                
                menu_to_user(email);
                break;
                
                
            case 7:
                limparEcra(3);
                print_linha("Introduza a quantia que pretende levantar:");
                String s1 = in.next();
                double N6 = Double.parseDouble(s1);
                
                String resposta2 = ca.depositarBetCoins(email, N6);
                System.out.println(resposta2);
                
                menu_to_user(email);
                break;
                
            case 8:
                limparEcra(3);
                String str = ca.verMinhasInformacoes(email);
                System.out.println(str);
                menu_to_user(email);
                break;
            
            case 9:
                limparEcra(3);
               
                print_linha("Introduza a nova password que pretende inserir:");
                String passNova = this.input.lerString();
                
                String alteraPass = ca.alterarPassword(email,passNova);
                
                System.out.println(alteraPass);
                menu_to_user(email);
                break;
                
            case 0:
                limparEcra(3);
                menu_principal();
                break;

        }

    }
    
    private void menu_to_admin(String email) throws IOException {

        limparEcra(4);
        System.out.println("\t\t\t\t--------------------------------");
        System.out.println("\t\t\t\t1 - Criar Jogo");
        System.out.println("\t\t\t\t--------------------------------");
        System.out.println("\t\t\t\t2 - Editar Jogo");
        System.out.println("\t\t\t\t--------------------------------");
        System.out.println("\t\t\t\t3 - Eliminar Jogo");
        System.out.println("\t\t\t\t--------------------------------");
        System.out.println("\t\t\t\t4 - Listar Jogos a Decorrer");
        System.out.println("\t\t\t\t--------------------------------");
        System.out.println("\t\t\t\t5 - Listar Histórico de Jogos");
        System.out.println("\t\t\t\t--------------------------------");
        System.out.println("\t\t\t\t6 - Listar Utilizadores Online");
        System.out.println("\t\t\t\t--------------------------------");
        System.out.println("\t\t\t\t7 - Listar Todos os Users");
        System.out.println("\t\t\t\t--------------------------------");
        System.out.println("\t\t\t\t8 - Terminar Jogo");
        System.out.println("\t\t\t\t--------------------------------");
        System.out.println("\t\t\t\t0 - Voltar");
        System.out.println("\t\t\t\t--------------------------------");
        int opcao;
        opcao = input.lerInteiro();
         String resultado ="";
         Scanner in = new Scanner(System.in);
        switch (opcao) {
            case 1:
                limparEcra(3);
                print_linha("Introduza o Nome da equipa que joga em casa");
                String equipa1 = this.input.lerString();
                
                print_linha("Introduza o Nome da equipa que joga como visitante");
                String equipa2 = this.input.lerString();
                
                print_linha("Introduza a odd para a vitória da equipa da casa");
                String odd1 = in.next();
                double oddUm = Double.parseDouble(odd1);
                
                print_linha("Introduza a odd para empate");
                String oddx = in.next();
                double oddX = Double.parseDouble(oddx);
                
                print_linha("Introduza a odd para vitória da equipa visitante");
                String odd2 = in.next();
                double oddDois = Double.parseDouble(odd2);
                
                Odd odd = new Odd(oddUm, oddX, oddDois, new Date());
                ca.criaJogo(equipa1, equipa2, odd);
                
                System.out.println("Jogo inserido com sucesso");
                
                menu_to_admin(email);
                break;
                
            case 2:
                limparEcra(3);
                
                print_linha("Introduza o Numero do jogo que pretende editar");
                int idJogo = this.input.lerInteiro();
                
                print_linha("Introduza a odd para a vitória da equipa da casa");
                String odd11 = in.next();
                double oddUm1 = Double.parseDouble(odd11);
                
                print_linha("Introduza a odd para empate");
                String oddxx = in.next();
                double oddUXX = Double.parseDouble(oddxx);
                
                print_linha("Introduza a odd para vitória da equipa visitante");
                String odd22 = in.next();
                double oddDois2 = Double.parseDouble(odd22);
                
                Odd o1 = new Odd(oddUm1, oddUXX, oddDois2, new Date());
                
                String edit = ca.editaJogo(idJogo, o1);
                
                System.out.println(edit);
                
                menu_to_admin(email);
                break;
            case 3:
                limparEcra(3);
                
                print_linha("Introduza o Numero do jogo que pretende eliminar");
                int idJogo1 = this.input.lerInteiro();
               
                String remove = ca.eliminaJogo(idJogo1);
                
                System.out.println(remove);
                
                menu_to_admin(email);
                break;
            case 4:
                limparEcra(3);
                List<Jogo> aux = ca.listaJogosDecorrer();
                
                System.out.println("LISTA DE JOGOS A DECORRER\n");
                
                for(Jogo j: aux){
                    int size = j.getListaOdds().size();
                    System.out.print("SIZE "+size+"\n");
                    System.out.println("Jogo: "+j.getIdJogo()+":"+j.getEquipa1()+"-"+j.getEquipa2()+":"+j.getListaOdds().get(size-1).getOddUm()+"-"+j.getListaOdds().get(size-1).getOddX()+"-"+j.getListaOdds().get(size-1).getOddDois()+"\n");
                }
                
                menu_to_admin(email);
                break;
            case 5:
                limparEcra(3);
                List<Jogo> aux2 = ca.listaHistoricoJogos();
                
                System.out.println("HISTÒRICO DE JOGOS\n");
                
                for(Jogo j: aux2){
                    System.out.println("Jogo: "+j.getIdJogo()+":"+j.getEquipa1()+"-"+j.getEquipa2()+":"+j.getListaOdds().get(j.getListaOdds().size()-1).getOddUm()+"-"+j.getListaOdds().get(j.getListaOdds().size()-1).getOddX()+"-"+j.getListaOdds().get(j.getListaOdds().size()-1).getOddDois()+":"+j.getResultado()+"\n");
                }
                
                menu_to_admin(email);
                break;
            case 6:
                limparEcra(3);
                List<User> aux3 = ca.listaUsersOn();
                
                for(User u: aux3){
                   System.out.println("User: "+u.getEmail()+":"+u.getNome()+"\n");
                }
                
                menu_to_admin(email);
                break;
            case 7:
                limparEcra(3);
                List<User> aux4 = ca.listaUsers();
                
                for(User u: aux4){
                    System.out.println("User "+u.getEmail()+":"+u.getNome()+":"+u.getLog()+"\n");
                }
                
                menu_to_admin(email);
                break;
            case 8:
                print_linha("Introduza o Numero do jogo que pretende terminar");
                int idJogo2 = this.input.lerInteiro();
                
                print_linha("Introduza o resultado do jogo (1 em caso de vitoria da equipa da casa, 2 em caso de vitória da equipa visitanta, x em caso de empate");
                String score = this.input.lerString();
                
                while(!(score.equals("1")|(score.equals("x"))|(score.equals("2")))){
                    print_linha("Introduza o resultado do jogo (1 em caso de vitoria da equipa da casa, 2 em caso de vitória da equipa visitanta, x em caso de empate");
                    score = this.input.lerString();
                }
                String term = ca.terminaJogo(idJogo2, score);
                
                menu_to_admin(email);
                break;
            case 0:
                limparEcra(3);
                menu_principal();
                break;

        }

    }
    
    
    private void print_linha(String linha) {
        System.out.println(linha);

    }
    
    private void limparEcra(int x) {
        for (int i = 0; i < x; i++) {
            System.out.println("");
        }
    }
}

