/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package betess;

import java.io.IOException;

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
                print_linha("Nome do ficheiro :");
                String nome_ficheiro2 = this.input.lerString();
                this.ca = this.ca.load_ca(nome_ficheiro2);
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
                if(ca.aut_user(String email,String pass)){
                    menu_to_user(email);
                }
                else{
                        System.out.println("Dados mal inseridos!");
                        }
                break;
            case 2:
                limparEcra(3);
                if(ca.aut_admin(String user,String pass)){
                menu_to_admin();
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
    
    private void menu_to_User(String email) throws IOException {

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
                
                resultado = ca.apostar(email, N2, N3);
                
                System.out.println(resultado + "\n");
                
                else{
                        System.out.println("Dados mal inseridos!");
                        }
                break;
            case 2:
                limparEcra(3);
                if(aut_admin(String user,String pass)){
                menu_to_admin();
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
    
    
    private void print_linha(String linha) {
        System.out.println(linha);

    }
    
    private void limparEcra(int x) {
        for (int i = 0; i < x; i++) {
            System.out.println("");
        }
    }
}

