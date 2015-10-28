/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package betess;

import java.io.IOException;
import static java.util.Collections.list;
import java.util.List;

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
        switch (opcao) {
            case 1:
                limparEcra(3);
                print_linha("Introduza o Numero de jogo");
                int N2 = this.input.lerInteiro();
                
                print_linha("Introduza o Montante que quer apostar");
                double N3 = this.input.lerDouble();
                
                print_linha("Introduza o tipo de aposta");
                String tipo = this.input.lerString();
                
                resultado = ca.apostar(email, N2, N3, tipo);
                
                System.out.println(resultado + "\n");
                
                break;
            case 2:
                limparEcra(3);
                List<Jogo> res = ca.verJogosDecorrer(); 
                        for(Jogo j : res){
                            System.out.println(j.getIdJogo()+" : "+j.getEquipa1()+"-"+j.getEquipa2()+" : "+j.getOddUm()+"-"+j.getOddX()+"-"+j.getOddUm());
                        }
                        break;
            case 3:
                limparEcra(3);
                List<Aposta> res2 = ca.verHistoricoAposta(email); 
                        for(Aposta a : res2){
                            System.out.println("Aposta: "+a.getIdAposta()+ " -> Valor Apostado: "+a.getValorApostado()+ "-> Ganho: ");
                        }
            break;
            
            case 4:
                limparEcra(3);
                List<Aposta> res3 = ca.verApostasDecorrer(email); 
                        for(Aposta a : res3){
                            System.out.println("Aposta: "+a.getIdAposta()+ " -> Valor Apostado: "+a.getValorApostado());
                        }
            break;
            
            case 5:
                limparEcra(3);
                
                print_linha("Introduza o Numero de aposta que pretende eliminar");
                int N4 = this.input.lerInteiro();
                
                String resposta = ca.retirarAposta(email,N4); 
                        
                System.out.println(resposta);
                break;
                
            case 6:
                limparEcra(3);
                print_linha("Introduza os BetESS que deseja depositar:");
                double N5 = this.input.lerDouble();
                
                String cenas =ca.depositarBetCoins(email, N5);
                System.out.println(cenas);
                
                break;
                
                
            case 7:
                limparEcra(3);
                print_linha("Introduza a quantia que pretende levantar:");
                double N6 = this.input.lerDouble();
                
                String resposta2 = ca.depositarBetCoins(email, N6);
                System.out.println(resposta2);
                break;
                
            case 8:
                limparEcra(3);
                ca.verMinhasInformacoes(email);
                break;
            
            case 9:
                limparEcra(3);
               
                print_linha("Introduza a nova password que pretende inserir:");
                String passNova = this.input.lerString();
                
                ca.alterarPassword(email,passNova);
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
        switch (opcao) {
            case 1:
                limparEcra(3);
                print_linha("Introduza o Nome da equipa que joga em casa");
                String equipa1 = this.input.lerString();
                
                print_linha("Introduza o Nome da equipa que joga como visitante");
                String equipa2 = this.input.lerString();
                
                print_linha("Introduza a odd para a vitória da equipa da casa");
                double oddUm = this.input.lerDouble();
                
                print_linha("Introduza a odd para empate");
                double oddX = this.input.lerDouble();
                
                print_linha("Introduza a odd para vitória da equipa visitante");
                double oddDois = this.input.lerDouble();
                
                ca.criaJogo(equipa1, equipa2, oddUm, oddDois, oddX);
                
                System.out.println("Jogo inserido com sucesso");
                
                break;
            case 2:
                limparEcra(3);
                
                print_linha("Introduza o Numero do jogo que pretende editar");
                int idJogo = this.input.lerInteiro();
                
                print_linha("Introduza o Nome da equipa que joga em casa");
                String equipa3 = this.input.lerString();
                
                print_linha("Introduza o Nome da equipa que joga como visitante");
                String equipa4 = this.input.lerString();
                
                print_linha("Introduza a odd para a vitória da equipa da casa");
                Float oddUm1 = this.input.lerFloat();
                
                print_linha("Introduza a odd para empate");
                Float oddXX = this.input.lerFloat();
                
                print_linha("Introduza a odd para vitória da equipa visitante");
                Float odd2 = this.input.lerFloat();
                
                String edit = ca.editaJogo(idJogo, equipa3, equipa4, oddUm1, oddXX, odd2);
                
                System.out.println(edit);
                
                break;
                
            case 3:
                limparEcra(3);
                
                print_linha("Introduza o Numero do jogo que pretende eliminar");
                int idJogo1 = this.input.lerInteiro();
               
                String remove = ca.eliminaJogo(idJogo1);
                
                System.out.println(remove);
                break;
           
            case 4:
                limparEcra(3);
                List<Jogo> aux = ca.listaJogosDecorrer();
                
                for(Jogo j: aux){
                    j.toString();
                }
                break;
                
            case 5:
                limparEcra(3);
                List<Jogo> aux2 = ca.listaHistoricoJogos();
                
                for(Jogo j: aux2){
                    j.toString();
                }
                break;
                
            case 6:
                limparEcra(3);
                List<User> aux3 = ca.listaUsersOn();
                
                for(User u: aux3){
                    u.toString();
                }
                break;
                
            case 7:
                limparEcra(3);
                List<User> aux4 = ca.listaUsers();
                
                for(User u: aux4){
                    u.toString();
                }
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

