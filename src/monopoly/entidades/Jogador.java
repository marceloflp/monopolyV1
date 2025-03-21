package monopoly.entidades;

public class Jogador {
	public String nome;
	public String cor;
	public int saldo;
	public int posicao;

	public Jogador(String nome, String cor) {
		this.nome = nome;
		this.cor = cor;
		this.saldo = 1500; // Saldo inicial
		this.posicao = 0; // Começa no "Go"
	}

	public void receber(int valor) {
		this.saldo += valor;
	}

	public void pagar(int valor) {
		this.saldo -= valor;
	}

	public boolean estaFalido() {
		return this.saldo < 0;
	}

}
