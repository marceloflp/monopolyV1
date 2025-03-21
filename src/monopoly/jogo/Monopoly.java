package monopoly.jogo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import monopoly.entidades.Carta;
import monopoly.entidades.Jogador;
import monopoly.entidades.Lugar;
import monopoly.entidades.Propriedade;
import monopoly.entidades.Tabuleiro;

public class Monopoly {

	private List<Jogador> jogadores;
	private Tabuleiro tabuleiro;
	private int jogadorAtual;

	public Monopoly() {
		this.jogadores = new ArrayList<>();
		this.tabuleiro = new Tabuleiro();
		this.jogadorAtual = 0;
	}

	public void criarJogo() {
		Scanner scanner = new Scanner(System.in);

		// Validação do número de jogadores
		int numJogadores;
		do {
			System.out.print("Entre com o número de jogadores [2-8]: ");
			numJogadores = scanner.nextInt();
		} while (numJogadores < 2 || numJogadores > 8);

		scanner.nextLine();

		List<String> coresDisponiveis = new ArrayList<>(
				Arrays.asList("preto", "branco", "vermelho", "verde", "azul", "amarelo", "laranja", "rosa"));

		for (int i = 0; i < numJogadores; i++) {
			System.out.print("Entre com o nome do jogador no. " + (i + 1) + ": ");
			String nome = scanner.nextLine();

			// Mostrar cores disponíveis
			System.out.println("Escolha a cor do peão do jogador no. " + (i + 1) + " entre as opções seguintes:");
			System.out.println("[" + String.join("][", coresDisponiveis) + "]");

			String cor;
			do {
				cor = scanner.nextLine().toLowerCase();
				if (!coresDisponiveis.contains(cor)) {
					System.out.println("Cor inválida ou já escolhida. Tente novamente.");
				}
			} while (!coresDisponiveis.contains(cor));

			coresDisponiveis.remove(cor); // Remove a cor escolhida
			jogadores.add(new Jogador(nome, cor));
		}

		System.out.println("O jogo Monopoly foi iniciado.");
		iniciarJogada();

	}

	public void iniciarJogada() {
		Scanner scanner = new Scanner(System.in);
		while (jogadores.size() > 1) {
			Jogador jogador = jogadores.get(jogadorAtual);
			System.out.println("A jogada de " + jogador.nome + " começou.");
			System.out.println("Comandos disponíveis: [jogar][sair][status]");
			System.out.print("Entre com um comando: ");
			String comando = scanner.nextLine();

			if (comando.equalsIgnoreCase("sair")) {
				System.out.print("Você tem certeza de que quer sair (Sim/Não)? ");
				String confirmacao = scanner.nextLine();
				if (confirmacao.equalsIgnoreCase("sim")) {
					System.out.println("Jogo encerrado.");
					return;
				}
			} else if (comando.equalsIgnoreCase("jogar")) {
				jogarDados(jogador);
			} else if (comando.equalsIgnoreCase("status")) {
				exibirStatus(jogador);
			}

			jogadorAtual = (jogadorAtual + 1) % jogadores.size();

		}
		System.out.println("O jogo terminou. O vencedor é " + jogadores.get(0).nome + "!");
	}

	public void jogarDados(Jogador jogador) {
		Random random = new Random();
		int dado1 = random.nextInt(6) + 1;
		int dado2 = random.nextInt(6) + 1;
		int total = dado1 + dado2;

		System.out.println("O jogador " + jogador.nome + " tirou " + dado1 + "," + dado2 + " e o peão avançou para "
				+ total + " casas.");

		jogador.posicao = (jogador.posicao + total) % tabuleiro.getTamanho();
		Lugar lugar = tabuleiro.getLugar(jogador.posicao);

		System.out.println("O jogador " + jogador.nome + " caiu em " + lugar.getNome() + ".");
		//polimorfismo
		lugar.acao(jogador);

		if (jogador.estaFalido()) {
			System.out.println(jogador.nome + " entrou em falência e foi eliminado do jogo.");
			// Devolve propriedades ao banco
			for (Lugar l : tabuleiro.getLugares().values()) {
				if (l instanceof Propriedade && ((Propriedade) l).dono == jogador) {
					((Propriedade) l).dono = null;
				}
			}
			jogadores.remove(jogador);
		}
	}
/*
	private void executarAcaoCarta(Carta carta, Jogador jogador) {
		switch (carta.getAcao()) {
		case "Receba $200":
			jogador.receber(200);
			System.out.println(jogador.nome + " recebeu $200.");
			break;
		case "Pague $50":
			jogador.pagar(50);
			System.out.println(jogador.nome + " pagou $50.");
			break;
		// Adicione mais casos para outras ações
		default:
			System.out.println("Ação não implementada: " + carta.getAcao());
			break;
		}
	}
*/
	// Método auxiliar para calcular aluguéis de ferrovias
	private int calcularAluguel(Propriedade propriedade) {
		if (propriedade.getNome().contains("Railroad")) {
			int numFerrovias = 0;
			for (Propriedade p : tabuleiro.getPropriedades().values()) {
				if (p.dono == propriedade.dono && p.getNome().contains("Railroad"))
					numFerrovias++;
			}
			return 25 * numFerrovias;
		}
		return propriedade.aluguel; // Aluguel padrão para outras propriedades
	}

	public void exibirStatus(Jogador jogador) {
		System.out.println("O status de " + jogador.nome + " – " + jogador.cor + " é o seguinte:");

		// Posição atual
		Propriedade propriedadeAtual = tabuleiro.getPropriedade(jogador.posicao);
		System.out.println("Situado na posição " + jogador.posicao + " – " + propriedadeAtual.getNome());

		// Saldo atual
		System.out.println("Possui $" + jogador.saldo);

		// Títulos possuídos
		System.out.println("Títulos:");
		for (Propriedade propriedade : tabuleiro.getPropriedades().values()) {
			if (propriedade.dono == jogador) {
				if (propriedade.getNome().contains("Railroad")) {
					System.out.println(
							"[" + propriedade.getNome() + "] – ferrovia, corrida " + calcularAluguel(propriedade));
				} else if (propriedade.getNome().equals("Electric Company")
						|| propriedade.getNome().equals("Water Works")) {
					System.out.println("[" + propriedade.getNome() + "] – serviço público");
				} else {
					System.out.println("[" + propriedade.getNome() + "] – propriedade, aluguel " + propriedade.aluguel);
				}
			}
		}

		// Volta ao menu de comandos
		System.out.println("Comandos disponíveis: [jogar][status][sair]");
		System.out.print("Entre com um comando: ");
	}

}
