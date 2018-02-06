package ufcg.ccc.sistema.basico;

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
	public void inicializar(int caixaSistema, double taxaSistema) {
		
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
	public int cadastrarApostaSeguraValor(int cenario, String apostador, int valor, String previsao, int valor, int custo) {
		
		return sistema.cadastrarApostaAsseguradaValor(cenario, apostador, valor, previsao, int valorSeguro, int custo);
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
		
		return sistema.cadastrarApostaSeguraTaxa(cenario, apostador, valor, previsao, taxaSeguro, custo);
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
	public int TotalDeApostas(int cenario) {
		
		return sistema.totalDeApostas(cenario);
	}
	
	/**
	 * @param cenario	Será usado para saber o cenário desejado
	 * @return		Retorna uma representação em string de todas as apostas de um cenário específico
	 */
	public String exibeApostas(int cenario) {
		
		return sistema.exibeApostas(cenario);
	}

	public int cadastrarCenario(String descricao, int bônus) {
		
		return this.sistema.cadastrarCenario(descricao, bônus);
	}
}