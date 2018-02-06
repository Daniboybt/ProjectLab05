package ufcg.ccc.sistema.basico;

/**
 * Classe que representa apostas no sistema
 * 
 * @author danielbt
 */
public class Aposta {
	
	/**
	 * Atributo que guarda o nome do apostador
	 */
	private String apostador;
	
	/**
	 * Atributo que guarda o valor da aposta
	 */
	private int valorAposta;
	
	/**
	 * Atributo que guarda o palpite sobre o cenário
	 */
	private String previsao;
	
	private Seguro seguro;
	
	/**
	 * Método construtor
	 * 
	 * @param apostador		Será usado para cadastrar o nome do apostador 
	 * @param valor			Seraá usado para cadastrar o valor da aposta
	 * @param previsao		Será usado para cadastrar a previsão sobre o cenário
	 */
	public Aposta(String apostador, int valor, String previsao) {
		
		if (apostador == null || apostador.equals("") || apostador.isEmpty()) {
			
			throw new IllegalArgumentException("Erro no cadastro de aposta: Apostador nao pode ser vazio ou nulo");
		}
		if(valor <= 0) {
			
			throw new IllegalArgumentException("Erro no cadastro de aposta: Valor nao pode ser menor ou igual a zero");
		}
		if(previsao == null || previsao.equals("") || previsao.isEmpty()) {
			
			throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao nao pode ser vazia ou nula");
		}
		if(!(previsao.equals("VAI ACONTECER") || previsao.equals("N VAI ACONTECER"))) {
			
			throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao invalida");
		}
	
		this.apostador = apostador;
		this.valorAposta = valor;
		this.previsao = previsao;
		this.seguro = new SemSeguro();
	}
	
	/**
	 * @return	Retorna o valor da aposta
	 */
	public int getValor() {
		
		return this.valorAposta;
	}
	
	/**
	 * @return		Retorna a previsão sobre o cenário da aposta
	 */
	public String getPrevisao() {
		
		return this.previsao;
	}
	
	/**
	 * Método toString que representará a aposta em forma de string
	 */
	public String toString() {
		
		return this.apostador + " - " + "R$" + this.valorAposta + ",00 - " + this.previsao;
	}
}