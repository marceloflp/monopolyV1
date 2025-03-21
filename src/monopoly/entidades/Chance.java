package monopoly.entidades;

import java.util.Stack;

public class Chance extends Lugar {
    private Stack<Carta> cartas;

    public Chance(String nome) {
        super(nome);
        this.cartas = new Stack<>();
        inicializarCartas();
    }

    private void inicializarCartas() {
        // Adiciona as cartas de Chance
        cartas.push(new Carta("Avance para o Ponto de Partida", "Receba $200"));
        cartas.push(new Carta("Avance para Illinois Avenue", "Mova-se para Illinois Avenue"));
        cartas.push(new Carta("Avance para St. Charles Place", "Mova-se para St. Charles Place"));
        cartas.push(new Carta("Avance para o serviço público mais próximo", "Mova-se para o serviço público mais próximo"));
        cartas.push(new Carta("Avance para a ferrovia mais próxima", "Mova-se para a ferrovia mais próxima"));
        cartas.push(new Carta("O banco lhe pagou dividendos de $50", "Receba $50"));
        cartas.push(new Carta("Volte 3 espaços", "Mova-se 3 espaços para trás"));
        cartas.push(new Carta("Vá diretamente para a Prisão", "Vá para a prisão"));
        cartas.push(new Carta("Faça a manutenção de todas as suas propriedades", "Pague $25 por casa e $100 por hotel"));
        cartas.push(new Carta("Pague imposto de pobreza de $15", "Pague $15"));
        cartas.push(new Carta("Saia livre da prisão", "Mantenha esta carta até o uso ou venda"));
        cartas.push(new Carta("Dê uma volta na Reading", "Mova-se para Reading Railroad"));
        cartas.push(new Carta("Dê uma caminhada no Board Walk", "Mova-se para Boardwalk"));
        cartas.push(new Carta("Você foi eleito presidente do tabuleiro", "Pague $50 para cada jogador"));
        cartas.push(new Carta("Seus empréstimos e investimento fizeram aniversário", "Receba $150"));
    }

    @Override
    public void acao(Jogador jogador) {
        if (cartas.isEmpty()) {
            System.out.println("Não há mais cartas de Chance disponíveis.");
            return;
        }

        Carta carta = cartas.pop();
        System.out.println("Carta de Chance: " + carta.getDescricao());
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