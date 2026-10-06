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


                System.out.print("Informe o nome do robô: \n");
                String nome = s.next();
                System.out.print("Informe o ataque do robô: \n");
                int ataque = s.nextInt();

            while (ataque < 10 || ataque > 30) {
                System.out.println("Ataque invalido! Informe novamente: \n");
                ataque = s.nextInt(); 
            }

                System.out.print("Informe a defesa do robô: \n");
                int defesa = s.nextInt();
            while (defesa < 0 || defesa > 20) {
                System.out.println("Defesa invalida! Informe novamente: \n");
                defesa = s.nextInt();
            }
            
                System.out.println("Seu código foi gerado: " + codigo + "\n");

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
            break;

            case 4:
            
                if (quantidadeRobos < 2){
                System.out.print("É necessario ter pelo menos dois robos cadastrados!");
                break;
                }

            int encontrouRobo1 = 0;
            int codigoRobo1 = 0;
            
            int encontrouRobo2 = 0;
            int codigoRobo2 = 0;

            while (encontrouRobo1 == 0 || encontrouRobo2 == 0 || codigoRobo1 == codigoRobo2){

                encontrouRobo1 = 0;
                encontrouRobo2 = 0;

                System.out.print("Informe o codigo do primeiro robo: ");
                codigoRobo1 = s.nextInt();

                System.out.print("Informe o codigo do segundo robo: ");
                codigoRobo2 = s.nextInt();

                if (codigoRobo1 == codigoRobo2) {

                System.out.println("Os robos precisam ser diferentes!");

            } else {

            for (Robo r : robos) {

                if (r.codigo == codigoRobo1) {
                    encontrouRobo1 = 1;
                }
                if (r.codigo == codigoRobo2) {
                    encontrouRobo2 = 1;
                }

            }

                if (encontrouRobo1 == 0 || encontrouRobo2 == 0) {
                System.out.println("Um dos robos nao existe! Informe novamente.\n");
                }
            }
            } //while

            Robo atacante; // para o robo que for atacar
            Robo defensor; // para o robo que for defnder

            for (Robo robo1 : robos) {
                if (robo1.codigo == codigoRobo1) {
            
            for (Robo robo2 : robos) {
                
                
                if (robo2.codigo == codigoRobo2){
                if (robo1.energiaAtual < 30 || robo2.energiaAtual < 30){
                    System.out.print("Um dos robos estão em recuperação!");
                } 
                else{
                    System.out.print("Estão disponiveis para combate!");
                } 
                if (robo1.pontos < robo2.pontos) {
                    atacante = robo1;
                    defensor = robo2;
                }
                else if (robo2.pontos < robo1.pontos) {
                    atacante = robo2;
                    defensor = robo1;
                }
                else {
                    
                    if(robo1.codigo < robo2.codigo) {
                        atacante = robo1;
                        defensor = robo2;   
                    }
                    else {
                        atacante  = robo2;
                        defensor = robo1;   
                    }
                }
                for (int rodada = 1; rodada <= 5; rodada++) {
                    
                    System.out.println("Rodada " + rodada);
                    int dano = atacante.ataque - defensor.defesa;
                    
                    if (dano < 5){
                        dano = 5;
                    }
                    if (rodada % 2 == 0){ // *Nas rodadas pares, o dano calculado receberá um bônus de 5.
                        dano = dano + 5;
                    }
                    defensor.perderEnergia(dano);
                    System.out.println(atacante.nome + " atacou " + defensor.nome);
                    System.out.println("Dano causado: " + dano);
                    System.out.println("Energia restante " + defensor.energiaAtual);
                }
            } 
            }   
            }
            }


                
            } // SWITCH

    } while (option !=0);


    } // static

} // class

