package monopoly.entidades;

import java.util.Scanner;

public class Ferrovia extends Lugar {
    private int preco;
    private Jogador dono;
    private Tabuleiro tabuleiro;

    public Ferrovia(String nome, int preco) {
        super(nome);
        this.preco = preco;
        this.dono = null;
        this.tabuleiro = tabuleiro;
    }

    public boolean temDono() {
        return dono != null;
    }

    @Override
    public void acao(Jogador jogador) {
        if (temDono()) {
            if (dono == jogador) {
                System.out.println("Você é o dono desta ferrovia.");
            } else {
                int numFerrovias = contarFerrovias(dono);
                int aluguel = 25 * numFerrovias;
                jogador.pagar(aluguel);
                dono.receber(aluguel);
                System.out.println(jogador.nome + " pagou $" + aluguel + " de aluguel para " + dono.nome + ".");
            }
        } else {
            if (jogador.saldo >= preco) {
                System.out.println("O título da ferrovia " + nome + " está disponível por $" + preco + ".");
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

    private int contarFerrovias(Jogador dono) {
        int count = 0;
        for (Lugar lugar : tabuleiro.getLugares().values()) {
            if (lugar instanceof Ferrovia && ((Ferrovia) lugar).dono == dono) {
                count++;
            }
        }
        return count;
    }
}