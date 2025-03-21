package monopoly.entidades;

public class IncomeTax extends Lugar {
	
	public IncomeTax() {
        super("Income Tax");
    }

    @Override
    public void acao(Jogador jogador) {
        jogador.pagar(200);
        System.out.println(jogador.nome + " pagou $200 de imposto de renda.");
    }

}
