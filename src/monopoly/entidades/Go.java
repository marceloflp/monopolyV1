package monopoly.entidades;

public class Go extends Lugar {

	public Go() {
		super("Go");
	}

	@Override
	public void acao(Jogador jogador) {
		jogador.receber(200);
		System.out.println(jogador.nome + " recebeu $200 por passar pelo Go.");
	}

}
