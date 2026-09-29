// classe Robo
public class Robo {
  
    // caracteristicas do robo
    int codigo; 
    String nome;
    int ataque;
    int defesa;
    int energiaAtual;
    int vitorias;
    int derrotas;
    int pontos;

public Robo(int codigo, String nome, int ataque, int defesa){

    this.codigo = codigo;
    this.nome = nome;
    this.ataque = ataque;
    this.defesa = defesa;
    this.energiaAtual = 100;
    this.vitorias = 0;
    this.derrotas = 0;
    this.pontos = 0;

}

}
