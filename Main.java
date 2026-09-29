/* Requisitos técnicos
- A classe `Robo` deverá possuir construtor e métodos que representem suas ações, protegendo as regras de alteração de energia e indicadores. 
- A classe `Main` será responsável pelo menu, pelas buscas, pela organização dos confrontos e pela interação com o usuário.
- Não utilize métodos prontos de ordenação. Implemente buscas e ordenação utilizando repetições e condicionais. É permitido utilizar listas auxiliares.
- O programa deverá tratar entradas inválidas, códigos inexistentes e listas vazias, apresentando mensagens claras e mantendo os dados consistentes. */

import java.util.ArrayList;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        ArrayList<Robo> robos = new ArrayList<>();

    int option = 0;
    int codigoRobo = 1;
    int quantidadeRobos = 0;
    
    do { 
        
        System.out.println("ATIVIDADE AVALIATIVA Campeonato de robôs de combate\n");

        System.out.println("1. Cadastrar robôs");
        System.out.println("2. Consultar robô pelo código:");
        System.out.println("3. Listar todos os robôs:");
        System.out.println("4. Realizar um combate");
        System.out.println("5. Recuperar energia");
        System.out.println("6. Rodada Geral");
        System.out.println("7. Exibir Classificação");
        System.out.println("8. Excluir Participante");
        option = s.nextInt();

        switch (option) {

            case 1: 
                
                int codigo = codigoRobo; /* Professor, eu estava pedindo pro usuário informar o código, mas eu coloquei um contador
                gera o codigo automaticamente */
                codigoRobo++;


                System.out.print("Informe o nome do robô:");
                String nome = s.next();
                System.out.print("Informe o ataque do robô: ");
                int ataque = s.nextInt();

            while (ataque < 10 || ataque > 30) {
                System.out.println("Ataque invalido! Informe novamente: ");
                ataque = s.nextInt(); 
            }

                System.out.println("Informe a defesa do robô: ");
                int defesa = s.nextInt();
            while (defesa < 0 || defesa > 20) {
                System.out.println("Defesa invalida! Informe novamente: ");
                defesa = s.nextInt();
            }
            
                System.out.println("Seu código foi gerado: " + codigo);

                Robo robo = new Robo(
                    codigo, 
                    nome, 
                    ataque, 
                    defesa
                );
                robos.add(robo);
                quantidadeRobos++; // aumenta a qtdade de robo cadastrado 

                System.out.println("Robô cadastrado com sucesso!");
                break;
            
            case 2:
            
                System.out.print("Informe o codigo do robo: ");
                int codigoBusca = s.nextInt();
    
                for (Robo r : robos) {

                if (r.codigo == codigoBusca) /* procura pelo codigo */ {

                System.out.println("Codigo: " + r.codigo);
                System.out.println("Nome: " + r.nome);
                System.out.println("Ataque: " + r.ataque);
                System.out.println("Defesa: " + r.defesa);
                System.out.println("Energia: " + r.energiaAtual);
                System.out.println("Vitorias: " + r.vitorias);
                System.out.println("Derrotas: " + r.derrotas);
                System.out.println("Pontos: " + r.pontos);

                if (r.energiaAtual >= 30) {
                System.out.println("Disponivel");
                } else {
                System.out.println("Em recuperacao");
                }

                }
                }
            break;
            
            case 3: 
                
            for (Robo r : robos) {

                System.out.println("Codigo: " + r.codigo);
                System.out.println("Nome: " + r.nome);
                System.out.println("Ataque: " + r.ataque);
                System.out.println("Defesa: " + r.defesa);
                System.out.println("Energia: " + r.energiaAtual);
                System.out.println("Vitorias: " + r.vitorias);
                System.out.println("Derrotas: " + r.derrotas);
                System.out.println("Pontos: " + r.pontos);

                if (r.energiaAtual >= 30) {
                System.out.println("Situacao: Disponivel");
                } else {
                System.out.println("Situacao: Em recuperacao");
                }

                }

            
            } // SWITCH

    } while (option !=0);


    } // static

} // class

