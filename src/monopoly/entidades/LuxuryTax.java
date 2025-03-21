package monopoly.entidades;

public class LuxuryTax extends Lugar {

	public LuxuryTax() {
		super("Luxury Tax");
	}

	@Override
	public void acao(Jogador jogador) {
		jogador.pagar(75);
		System.out.println(jogador.nome + " pagou $75 de imposto de luxo.");
	}

}
