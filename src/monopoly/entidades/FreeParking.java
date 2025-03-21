package monopoly.entidades;

public class FreeParking extends Lugar {
	
	public FreeParking() {
		super("Free Parking");
	}

	@Override
	public void acao(Jogador jogador) {
		System.out.println("Nada aconteceu. " + jogador.nome + " está no Free Parking.");
	}
}