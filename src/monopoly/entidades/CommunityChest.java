package monopoly.entidades;

import java.util.Stack;

public class CommunityChest extends Lugar {
    private Stack<Carta> cartas;

    public CommunityChest(String nome) {
        super(nome);
        this.cartas = new Stack<>();
        inicializarCartas();
    }

    private void inicializarCartas() {
        // Adiciona as cartas de Community Chest
        cartas.push(new Carta("Avance para o Ponto de Partida (Go)", "Receba $200"));
        cartas.push(new Carta("Erro do banco em seu favor", "Receba $200"));
        cartas.push(new Carta("Taxa do médico", "Pague $50"));
        cartas.push(new Carta("Abertura da Grande Ópera", "Receba $50 de cada jogador"));
        cartas.push(new Carta("Da liquidação fora de estoque", "Receba $45"));
        cartas.push(new Carta("Saia livre da prisão, sem pagar", "Mantenha esta carta até o uso ou venda"));
        cartas.push(new Carta("Vá para a prisão", "Vá direto para a prisão"));
        cartas.push(new Carta("Restituição do Imposto de Renda", "Receba $20"));
        cartas.push(new Carta("Aniversário do seguro de vida", "Receba $100"));
        cartas.push(new Carta("Pague o hospital", "Pague $100"));
        cartas.push(new Carta("Pague taxa da escola", "Pague $150"));
        cartas.push(new Carta("Receba por seus serviços", "Receba $25"));
        cartas.push(new Carta("Aniversário dos fundos de Natal", "Receba $100"));
        cartas.push(new Carta("Você tirou o segundo lugar no concurso de beleza", "Receba $10"));
        cartas.push(new Carta("Você herdou", "Receba $100"));
        cartas.push(new Carta("Você deve pagar os reparos da rua", "Pague $40 por casa e $115 por hotel"));
    }

    @Override
    public void acao(Jogador jogador) {
        if (cartas.isEmpty()) {
            System.out.println("Não há mais cartas de Community Chest disponíveis.");
            return;
        }

        Carta carta = cartas.pop();
        System.out.println("Carta de Community Chest: " + carta.getDescricao());
        executarAcaoCarta(carta, jogador);
        cartas.push(carta); // Coloca a carta no final da pilha
    }

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
}