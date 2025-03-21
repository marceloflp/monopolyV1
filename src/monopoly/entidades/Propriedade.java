package monopoly.entidades;

import java.util.Scanner;

public class Propriedade extends Lugar{
	
	public int preco;
	public int aluguel;
	private int hipoteca;
	private int precoCasa;
	public Jogador dono;

	public Propriedade(String nome, int preco, int aluguel, int precoCasa, int hipoteca) {
	    super(nome);
	    this.preco = preco;
	    this.aluguel = aluguel;
	    this.precoCasa = precoCasa;
	    this.hipoteca = hipoteca;
	    this.dono = null; // Inicialmente sem dono
	}
	
	@Override
    public void acao(Jogador jogador) {
        if (temDono()) {
            if (dono == jogador) {
                System.out.println("Você é o dono desta propriedade.");
            } else {
                jogador.pagar(aluguel);
                dono.receber(aluguel);
                System.out.println(jogador.nome + " pagou $" + aluguel + " de aluguel para " + dono.nome + ".");
            }
        } else {
            if (jogador.saldo >= preco) {
                System.out.println("O título da propriedade " + nome + " está disponível por $" + preco + ".");
                System.out.println(jogador.nome + ", você possui $" + jogador.saldo + ".");
                System.out.print("Você deseja comprar " + nome + " (Sim/Não)? ");
                Scanner scanner = new Scanner(System.in);
                String resposta = scanner.nextLine();
                if (resposta.equalsIgnoreCase("sim")) {
                    jogador.pagar(preco);
                    dono = jogador;
                    System.out.println(jogador.nome + " comprou " + nome + ".");
                } else {
                    System.out.println(jogador.nome + " optou por não comprar " + nome + ".");
                }
                
            } else {
                System.out.println("Você não possui dinheiro suficiente para comprar " + nome + ".");
            }
        }
    }

	public boolean temDono() {
		return this.dono != null;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPreco() {
		return preco;
	}

	public void setPreco(int preco) {
		this.preco = preco;
	}

	public int getAluguel() {
		return aluguel;
	}

	public void setAluguel(int aluguel) {
		this.aluguel = aluguel;
	}

	public int getHipoteca() {
		return hipoteca;
	}

	public void setHipoteca(int hipoteca) {
		this.hipoteca = hipoteca;
	}

	public int getPrecoCasa() {
		return precoCasa;
	}

	public void setPrecoCasa(int precoCasa) {
		this.precoCasa = precoCasa;
	}

	public Jogador getDono() {
		return dono;
	}

	public void setDono(Jogador dono) {
		this.dono = dono;
	}
	
	

}
