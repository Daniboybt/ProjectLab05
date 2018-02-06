package ufcg.ccc.sistema.basico;

import java.util.HashSet;

/**
 * Classe que representa um cenário em um sistema de apostas
 *  
 * @author danielbt
 */
public class Cenario {
	
	/**
	 * Atributo auxliar que guarda a string que representa  o estado de um cenário
	 * não finalizado
	 */
	private final String CENARIO_NAO_FINALIZADO =  "Não finalizado";
	
	/**
	 * Atributo auxliar que guarda a string que representa  o estado de um cenário
	 * finalizado que não ocorreu
	 */
	private final String CENARIO_NAO_OCORREU =  "Finalizado (n ocorreu)";
	
	/**
	 * Atributo auxliar que guarda a string que representa  o estado de um cenário
	 * finalizado que ocorreu
	 */
	private final String CENARIO_OCORREU =  "Finalizado (ocorreu)";
	
	/**
	 * Atributo auxiliar para quebra de linha
	 */
	private final String separador = System.lineSeparator();
	
	/**
	 * Atributo que guarda o valor de dinheiro total apostado num cenario
	 */
	private int valorTotalApostas = 0;
	
	/**
	 * Atributo que guarda a descrição que o cenário possui
	 */
	private String descricao;
	
	/**
	 * Atributo que guarda o estado que o cenário possui no momento
	 * seu valor inicial sempre será não finalizado
	 */
	private String estado;
	
	/**
	 * Um conjunto que possui todas as apostas que um cenário possui até o momento
	 */
	private HashSet<Aposta> apostas;
	
	/**
	 * Atributo que possui o valor destinado ao caixa quando o cenário é finalizado
	 */
	protected int valorDestinadoAoCaixa;
	
	/**
	 * Possui o valor que seŕa divido aos apostadores vencedores quando o cenário
	 * é finalizado
	 */
	protected int valorDividoEntreVencedores;
	
	/**
	 * Método construtor que inicializa alguns atributos e cadastra a descrição
	 * que o cenário irá possuir
	 * 
	 * @param descricaoCenario	Carrega a  descrição do cenário
	 */
	public Cenario(String descricaoCenario) {
		
		if (descricaoCenario == null) {
			
			throw new NullPointerException("Erro no cadastro de cenario: Descricao nao pode ser nula");
		}
		
		if(descricaoCenario.equals("")) {
			
			throw new IllegalArgumentException("Erro no cadastro de cenario: Descricao nao pode ser vazia");
		}
		
		this.descricao = descricaoCenario;
		this.estado = this.CENARIO_NAO_FINALIZADO;
		this.apostas = new HashSet<>();
	}
	
	/**
	 * Método que auxiliara outras classes
	 * 
	 * @return		Retorna o estado atual do cenário
	 */
	public String getEstado() {
		
		return this.estado;
	}
	
	/**
	 * @ return 	Retorna uma representação em String do cenário
	 */
	public String toString() {
		
		return this.descricao + "-" + this.estado;
	}
	
	/**
	 * Método que cadastra uma aposta no cenário
	 * 
	 * @param nomeApostador		Guarda o nome do apostador
	 * @param valor			Carrega o valor em dinheiro da aposta
	 * @param previsao		Carrega o palpite do apostador sobre o cenário
	 */
	public void cadastrarAposta(String nomeApostador, int valor, String previsao) {
	
		apostas.add(new Aposta(nomeApostador, valor, previsao));
		valorTotalApostas += valor;
	}
	
	/**
	 * Método que cadastra uma aposta no cenário
	 * 
	 * @param nomeApostador		Guarda o nome do apostador
	 * @param valor			Carrega o valor em dinheiro da aposta
	 * @param previsao		Carrega o palpite do apostador sobre o cenário
	 */
	public void cadastrarAposta(String nomeApostador, int valor, String previsao, int valorSeguro, int custo) {
	
		apostas.add(new ApostaAsseguradaValor(nomeApostador, valor, previsao, valorSeguro, custo));
		valorTotalApostas += valor;
	}
	
	/**
	 * Método que cadastra uma aposta no cenário
	 * 
	 * @param nomeApostador		Guarda o nome do apostador
	 * @param valor			Carrega o valor em dinheiro da aposta
	 * @param previsao		Carrega o palpite do apostador sobre o cenário
	 */
	public void cadastrarAposta(String nomeApostador, int valor, String previsao, double taxaSeguro, int custo) {
	
		apostas.add(new ApostaAsseguradaTaxa(nomeApostador, valor, previsao, taxaSeguro, custo));
		valorTotalApostas += valor;
	}
	
	/**
	 * @return	Retorna o valor total do dinheiro das apostas 
	 */
	public int getValorTotalApostas() {
		
		return this.valorTotalApostas;
	}
	
	/**/**
 * Classe filha de Aposta que apresenta alterações por guardar um seguro por valor quanto a aposta
 * e isso alterará outros métodos da classe. 
 * 
 * @author danielbt
 */
	 * @return		Retorna o numero total de apostas feitas no cenário
	 */
	public int totalDeApostas() {
		
		return this.apostas.size();
	}
	
	/**
	 * @return		Retorna o valor destinado ao caixa do cenário
	 */
    public int getValorDestinadoAoCaixa() {
    	
    	if (this.estado.equals(this.CENARIO_NAO_FINALIZADO)){
			
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario ainda esta aberto");
		}
    	
    	return this.valorDestinadoAoCaixa;
    }
	
    /**
     * @return		Retorna o valor que será divido aos vencedores
     */
    public int getValorDevididoEntreVencedores() {
    	
    	if (this.estado.equals(this.CENARIO_NAO_FINALIZADO)){
			
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Cenario ainda esta aberto");
		}
    	
    	return this.valorDividoEntreVencedores;
    }
    
    /**
     * @return	Retorna em forma de string todas as apostas do cenário
     */
    public String exibeApostas() {
		
		String listaApostas = "";
		
		for (Aposta aposta: apostas) {
			
			listaApostas += this.separador + aposta.toString();
		}
	
		return listaApostas;
	}
    
    /**
     * Método que fecha o cenário e cacula os valores destinados ao caixa e vencedores
     * 
     * @param ocorreu	Carrega um booleano dizendo se o cenário ocorreu ou não
     * 
     * @param taxa	Carrega a taxa do sistema para o calculo dos valores destinados ao caixa
     */
	public void fecharAposta(boolean ocorreu, double taxa) {
		
		if (ocorreu) {
			
			this.estado = this.CENARIO_OCORREU;
		
		}else {
			
			this.estado = this.CENARIO_NAO_OCORREU;
		}			
		
		int valorColetado = avaliaApostas(ocorreu);	
		this.valorDestinadoAoCaixa = (int) (valorColetado * taxa);
		
		valorColetado -= valorDestinadoAoCaixa;
		this.valorDividoEntreVencedores = valorColetado;
		
		
	}
	
	/**
	 * Método auxiliar que avalia as apostas que venceram e perderam
	 * 
	 * @param ocorreu	Carrega um booleano dizendo se o cenário aconteceu ou não
	 * 
	 * @return	A soma do valor das apostas perdedoras que serão destinadas ao caixa e vencedores
	 */
	private int avaliaApostas(boolean ocorreu) {
		
		int somaApostasPerdedoras = 0;
		
		
		if(ocorreu) {

			for(Aposta aposta: this.apostas) {

				if (aposta.getPrevisao().equals("N VAI ACONTECER")) {

					somaApostasPerdedoras += aposta.getValor();
				}
			}

		}else {

			for(Aposta aposta: this.apostas) {

				if (aposta.getPrevisao().equals("VAI ACONTECER")) {

					somaApostasPerdedoras += aposta.getValor();
				}
			}
		}

		return somaApostasPerdedoras;
	}
}