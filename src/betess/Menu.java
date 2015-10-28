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
        System.out.println("\t\t\t\t1 - Consulta de estatisticas");
        System.out.println("\t\t\t\t--------------------------------");
        System.out.println("\t\t\t\t2 - Consultas interactivas");
        System.out.println("\t\t\t\t--------------------------------");
        System.out.println("\t\t\t\t3 - Dados de leitura");
        System.out.println("\t\t\t\t--------------------------------");
        System.out.println("\t\t\t\t0 - Voltar");
        System.out.println("\t\t\t\t--------------------------------");
        int opcao;
        opcao = input.lerInteiro();
        switch (opcao) {
            case 1:
                apresenta_estatisticas_de_leitura_1_2();
                break;
            case 2:
                consultas_interactivas();
                break;
            case 3:
                apresenta_estatisticas_de_leitura_1_1();
                menu_after_leitura();
                break;

            case 0:
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

