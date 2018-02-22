package sistema;


import easyaccept.EasyAccept;

/**
 * Controler do sistema
 * 
 * @author danielbt
 */
public class Facade {

	private Sistema sistema;
	
	/**
	 * Método que inicializa o sistema
	 * 
	 * @param caixaSistema		Será usado para cadastrar o caixa inicial do sistema
	 * @param taxaSistema		Será usado para cadastrar a taxa que o sistema possui
	 */
	public void inicializa(int caixaSistema, double taxaSistema) {
		
		sistema = new Sistema(caixaSistema, taxaSistema);
	}
	
	/**
	 * @return	Retorna o valor do caixa atual do sistema
	 */
	public int getCaixa(){
		
		return sistema.getCaixa();
	}
	
	/**
	 * Método que cadastra um cenário no sistema
	 * 
	 * @param descricaoCenario		Será usado para cadastrar a descrição do cenário
	 *
	 * @return		Retorna a numeração do cenário criado
	 */
	public int cadastrarCenario(String descricaoCenario) {
		
		return sistema.cadastrarCenario(descricaoCenario);
	}
	
	/**
	 * Método que exibi um cenário específico
	 * 
	 * @param numeracaoCenario	Será usado para saber a numeração do cenário desejado
	 * 
	 * @return		Retorna a representação em string do cenário
	 */
	public String exibirCenario(int numeracaoCenario) {
		
		return sistema.exibirCenario(numeracaoCenario);
	}
	
	/**
	 * @return	Retorna a representação em string de todos os cenário em ordem que foram colocados
	 */
	public String exibirCenarios() {
		
		return sistema.exibirCenarios();
	}
	
	/**
	 * Cadastra uma aposta em um cenário
	 * 
	 * @param cenario	Será usado para saber em qual cenário será cadastrado a aposta
	 * @param apostador		Será usado para cadastrar o nome do apostador
	 * @param valor		Será usador para cadastrar o valor da aposta
	 * @param previsao		Será usado para cadastrar a previsão da aposta	
	 */
	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
		
		sistema.cadastrarAposta(cenario, apostador, valor, previsao);
	}
	
	/**
	 * Cadastra uma aposta em um cenário
	 * 
	 * @param cenario	Será usado para saber em qual cenário será cadastrado a aposta
	 * @param apostador		Será usado para cadastrar o nome do apostador
	 * @param valor		Será usador para cadastrar o valor da aposta
	 * @param previsao		Será usado para cadastrar a previsão da aposta	
	 * @param valorSeguro 	Será usado para cadastrar o seguro por valor
	 * @param custo 	Será usado para guardar o custo do seguro
	 */
	public int cadastrarApostaSeguraValor(int cenario, String apostador, int valor, String previsao, int valorSeguro, int custo) {
		
		return sistema.cadastrarApostaAsseguradaValor(cenario, apostador, valor, previsao, valorSeguro, custo);
	}
	
	/**
	 * Cadastra uma aposta em um cenário
	 * 
	 * @param cenario	Será usado para saber em qual cenário será cadastrado a aposta
	 * @param apostador		Será usado para cadastrar o nome do apostador
	 * @param valor		Será usador para cadastrar o valor da aposta
	 * @param previsao		Será usado para cadastrar a previsão da aposta	
	 * @param taxaSeguro 	Será usado para cadastrar o seguro por valor
	 * @param custo 	Será usado para guardar o custo do seguro
	 */
	public int cadastrarApostaSeguraTaxa(int cenario, String apostador, int valor, String previsao, double taxaSeguro, int custo) {
		
		return sistema.cadastrarApostaAsseguradaTaxa(cenario, apostador, valor, previsao, taxaSeguro, custo);
	}
	
	
	/**
	 * @param cenario	Será usado para saber o cenário desejado
	 * @return	Retorna o valor total das apostas do cenário específico
	 */
	public int valorTotalDeApostas(int cenario) {
		
		return sistema.valorTotalDeApostas(cenario);
	}
	
	/**
	 * @param cenario	Será usado para saber o cenário desejado
	 * @return		Retorna o total de apostas feitas em um cenário específico
	 */
	public int totalDeApostas(int cenario) {
		
		return sistema.totalDeApostas(cenario);
	}
	
	/**
	 * @param cenario	Será usado para saber o cenário desejado
	 * @return		Retorna uma representação em string de todas as apostas de um cenário específico
	 */
	public String exibeApostas(int cenario) {
		
		return sistema.exibeApostas(cenario);
	}
	
	/***
	 * Método que cadastra um cenário no sistema
	 * 
	 * @param descricao		Descrição do cenário
	 * @param bônus			Bonus que o cenário possui
	 * @return				A posição do cenário na lista de cenários	
	 */
	public int cadastrarCenario(String descricao, int bônus) {
		
		return this.sistema.cadastrarCenario(descricao, bônus);
	}
	
	/**
	 * Método que altera uma aposta com seguro por taxa para uma com seguro por valor
	 * 
	 * @param cenario		Cenário onde a aposta está cadastrada
	 * @param apostaAssegurada		Posição da aposta na lista de apostas
	 * @param valor			Valor do seguro
	 * @return				Posição do cenário onde a aposta foi alterada
	 */
    public int alterarSeguroValor(int cenario, int apostaAssegurada, int valor) {
    	
    	return sistema.alterarSeguroValor(cenario, apostaAssegurada, valor);
    }
    
    /**
	 * Método que altera uma aposta com seguro por valor para uma com seguro por taxa
	 * 
	 * @param cenario		Cenário onde a aposta está cadastrada
	 * @param apostaAssegurada		Posição da aposta na lista de apostas
	 * @param taxa		Taxa do seguro
	 * @return				Posição do cenário onde a aposta foi alterada
	 */
    public int alterarSeguroTaxa(int cenario, int apostaAssegurada, double taxa) {
    	
    	return sistema.alterarSeguroTaxa(cenario, apostaAssegurada, taxa);
    }
    
    /**
     * Método que finaliza um cenário e a suas apostas
     * 
     * @param cenario	Posição do cenário na lista de cenários
     * @param ocorreu	Indica o acontecimento do cenário
     */
    public void fecharAposta(int cenario, boolean ocorreu) {
    	
    	sistema.fecharAposta(cenario, ocorreu);
    }
    
    /**
     * Método retorna o valor que seŕa disponibilizado ao caixa do cenário
     * 
     * @param cenario	Posição do cenário na lista de cenários
     * @return			Valor disponibilizado ao caixa
     */
    public int getCaixaCenario(int cenario) {
    	
    	return sistema.getCaixaCenario(cenario);
    }
    
    
    /**
     * Método retorna o valor que seŕa rateado aos vencedores
     * 
     * @param cenario	Posição do cenário na lista de cenários
     * @return			Valor rateado entre os vencedores
     */
    public int getTotalRateioCenario(int cenario) {
    	
    	return sistema.getTotalRateioCenario(cenario);
    }
    
    public void alterarOrdem(String ordem) {
    	
    	sistema.alterarOrdem(ordem);
    }
    
    public String exibirCenarioOrdenado(int cenario) {
    	
    	return sistema.exibirCenarioOrdenado(cenario);
    }
    
    public static void main(String[] args) {
    	
    	args = new String[] {"sistema.Facade", "EasyAccept/us1_test.txt",
    													"EasyAccept/us2_test.txt",
    													"EasyAccept/us3_test.txt",
    													"EasyAccept/us4_test.txt",
    													"EasyAccept/us5_test.txt",
    													"EasyAccept/us6_test.txt",
    													"EasyAccept/us7_test.txt"};
    	EasyAccept.main(args);
    }
}