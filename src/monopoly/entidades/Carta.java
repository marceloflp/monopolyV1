package monopoly.entidades;

public class Carta {

	String descricao;
	String acao;

	public Carta(String descricao, String acao) {
		this.descricao = descricao;
		this.acao = acao;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getAcao() {
		return acao;
	}

}
