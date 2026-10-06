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

public void perderEnergia (int valor) {

    energiaAtual = energiaAtual - valor; // diminui a energia 
    if (energiaAtual < 0){
        energiaAtual = 0; // impede energia negativa
    }
     
}

public void recuperarEnergia (int valor) {

    energiaAtual = energiaAtual + valor; // aumenta a energia
    if (energiaAtual > 100){
        energiaAtual = 100; // impede da energia ser mais de 100 
    }
}

public void registrarVitoria () {
    vitorias++; // registro de vitorias
}

public void registrarDerrota () {
    derrotas++; // registro de derrotas 
}

public void adicionarPontos(int valor){
    pontos = pontos + valor;
}

}

