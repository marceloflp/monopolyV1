package monopoly.entidades;

public abstract class Lugar {

	protected String nome;

	public Lugar(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
	public abstract void acao(Jogador jogador);

}
