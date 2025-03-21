package monopoly.entidades;

public class GoToJail extends Lugar {

	public GoToJail() {
		super("Go to Jail");
	}

	@Override
	public void acao(Jogador jogador) {
		jogador.posicao = 10; // Posição da prisão
		System.out.println(jogador.nome + " foi para a prisão.");
	}

}
