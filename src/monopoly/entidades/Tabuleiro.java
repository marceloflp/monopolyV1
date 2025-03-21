package monopoly.entidades;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Tabuleiro {
	private Map<Integer, Propriedade> propriedades;

	private Stack<Carta> communityChest;
	private Stack<Carta> chance;
	private Map<Integer, Lugar> lugares;
	
	public Tabuleiro() {
		this.propriedades = new HashMap<>();
		this.communityChest = new Stack<>();
		this.lugares = new HashMap<>();
		this.chance = new Stack<>();
		inicializarTabuleiro();
		//inicializarCartas();
	}

	private void inicializarTabuleiro() {
	    
	    lugares.put(0, new Go());
	    lugares.put(1, new Propriedade("Mediterranean Avenue", 60, 2, 50, 30)); 
	    lugares.put(2, new CommunityChest("Community Chest 1")); 
	    lugares.put(3, new Propriedade("Baltic Avenue", 60, 4, 50, 30)); 
	    lugares.put(4, new IncomeTax()); 
	    lugares.put(5, new Ferrovia("Reading Railroad", 200)); 
	    lugares.put(6, new Propriedade("Oriental Avenue", 100, 6, 50, 50)); 
	    lugares.put(7, new Chance("Chance 1"));
	    lugares.put(8, new Propriedade("Vermont Avenue", 100, 6, 50, 50)); 
	    lugares.put(9, new Propriedade("Connecticut Avenue", 120, 8, 50, 60)); 
	    lugares.put(10, new FreeParking()); // Posição 10: Jail – Just Visiting (tratado como Free Parking)
	    lugares.put(11, new Propriedade("St. Charles Place", 140, 10, 100, 70)); 
	    lugares.put(12, new Propriedade("Electric Company", 150, 0, 0, 75)); // Posição 12 (tratado como propriedade)
	    lugares.put(13, new Propriedade("States Avenue", 140, 10, 100, 70)); 
	    lugares.put(14, new Propriedade("Virginia Avenue", 160, 12, 100, 80)); 
	    lugares.put(15, new Ferrovia("Pennsylvania Railroad", 200));
	    lugares.put(16, new Propriedade("St. James Place", 180, 14, 100, 90));
	    lugares.put(17, new CommunityChest("Community Chest 2")); // Posição 17
	    lugares.put(18, new Propriedade("Tennessee Avenue", 180, 14, 100, 90)); 
	    lugares.put(19, new Propriedade("New York Avenue", 200, 16, 100, 100)); 
	    lugares.put(20, new FreeParking()); // Posição 20: Free Parking
	    lugares.put(21, new Propriedade("Kentucky Avenue", 220, 18, 150, 110)); 
	    lugares.put(22, new Chance("Chance 2")); 
	    lugares.put(23, new Propriedade("Indiana Avenue", 220, 18, 150, 110)); 
	    lugares.put(24, new Propriedade("Illinois Avenue", 240, 20, 150, 120)); 
	    lugares.put(25, new Ferrovia("B & O Railroad", 200)); 
	    lugares.put(26, new Propriedade("Atlantic Avenue", 260, 22, 150, 130)); 
	    lugares.put(27, new Propriedade("Ventnor Avenue", 260, 22, 150, 130)); 
	    lugares.put(28, new Propriedade("Water Works", 150, 0, 0, 75)); // Posição 28 (tratado como propriedade)
	    lugares.put(29, new Propriedade("Marvin Gardens", 280, 24, 150, 140)); 
	    lugares.put(30, new GoToJail()); // Posição 30: Go to Jail
	    lugares.put(31, new Propriedade("Pacific Avenue", 300, 26, 200, 150)); 
	    lugares.put(32, new Propriedade("North Carolina Avenue", 300, 26, 200, 150)); 
	    lugares.put(33, new CommunityChest("Community Chest 3")); 
	    lugares.put(34, new Propriedade("Pennsylvania Avenue", 320, 28, 200, 160)); 
	    lugares.put(35, new Ferrovia("Short Line Railroad", 200)); 
	    lugares.put(36, new Chance("Chance 3")); 
	    lugares.put(37, new Propriedade("Park Place", 350, 35, 200, 175)); 
	    lugares.put(38, new LuxuryTax()); // Posição 38: Luxury Tax
	    lugares.put(39, new Propriedade("Boardwalk", 400, 50, 200, 200));
	}


/*
	private void inicializarCartas() {
		// Cartas de Community Chest
		communityChest.push(new Carta("Avance para o Ponto de Partida (Go)", "Receba $200"));
		communityChest.push(new Carta("Erro do banco em seu favor", "Receba $200"));
		communityChest.push(new Carta("Taxa do médico", "Pague $50"));
		communityChest.push(new Carta("Abertura da Grande Ópera", "Receba $50 de cada jogador"));
		communityChest.push(new Carta("Da liquidação fora de estoque", "Receba $45"));
		communityChest.push(new Carta("Saia livre da prisão, sem pagar", "Mantenha esta carta até o uso ou venda"));
		communityChest.push(new Carta("Vá para a prisão", "Vá direto para a prisão"));
		communityChest.push(new Carta("Restituição do Imposto de Renda", "Receba $20"));
		communityChest.push(new Carta("Aniversário do seguro de vida", "Receba $100"));
		communityChest.push(new Carta("Pague o hospital", "Pague $100"));
		communityChest.push(new Carta("Pague taxa da escola", "Pague $150"));
		communityChest.push(new Carta("Receba por seus serviços", "Receba $25"));
		communityChest.push(new Carta("Aniversário dos fundos de Natal", "Receba $100"));
		communityChest.push(new Carta("Você tirou o segundo lugar no concurso de beleza", "Receba $10"));
		communityChest.push(new Carta("Você herdou", "Receba $100"));
		communityChest.push(new Carta("Você deve pagar os reparos da rua", "Pague $40 por casa e $115 por hotel"));

		// Cartas de Chance
		chance.push(new Carta("Avance para o Ponto de Partida", "Receba $200"));
		chance.push(new Carta("Avance para Illinois Avenue", "Mova-se para Illinois Avenue"));
		chance.push(new Carta("Avance para St. Charles Place", "Mova-se para St. Charles Place"));
		chance.push(
				new Carta("Avance para o serviço público mais próximo", "Mova-se para o serviço público mais próximo"));
		chance.push(new Carta("Avance para a ferrovia mais próxima", "Mova-se para a ferrovia mais próxima"));
		chance.push(new Carta("O banco lhe pagou dividendos de $50", "Receba $50"));
		chance.push(new Carta("Volte 3 espaços", "Mova-se 3 espaços para trás"));
		chance.push(new Carta("Vá diretamente para a Prisão", "Vá para a prisão"));
		chance.push(
				new Carta("Faça a manutenção de todas as suas propriedades", "Pague $25 por casa e $100 por hotel"));
		chance.push(new Carta("Pague imposto de pobreza de $15", "Pague $15"));
		chance.push(new Carta("Saia livre da prisão", "Mantenha esta carta até o uso ou venda"));
		chance.push(new Carta("Dê uma volta na Reading", "Mova-se para Reading Railroad"));
		chance.push(new Carta("Dê uma caminhada no Board Walk", "Mova-se para Boardwalk"));
		chance.push(new Carta("Você foi eleito presidente do tabuleiro", "Pague $50 para cada jogador"));
		chance.push(new Carta("Seus empréstimos e investimento fizeram aniversário", "Receba $150"));

		// Embaralhar as cartas
		Collections.shuffle(communityChest);
		Collections.shuffle(chance);
	}
*/
	public Map<Integer, Propriedade> getPropriedades() {
		return propriedades;
	}
	
	public Stack<Carta> getCommunityChest() {
		return communityChest;
	}

	public Stack<Carta> getChance() {
		return chance;
	}

	public Propriedade getPropriedade(int posicao) {
		return propriedades.get(posicao);
	}

	public Lugar getLugar(int posicao) {
        return lugares.get(posicao);
    }

	public int getTamanho() {
		return lugares.size();
	}

	public Map<Integer, Lugar> getLugares() {
		return lugares;
	}
	
}