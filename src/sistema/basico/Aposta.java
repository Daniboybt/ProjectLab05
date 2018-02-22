package sistema.basico;

import sistema.basico.seguro.*;

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
	 * @param apostador
	 *            Será usado para cadastrar o nome do apostador
	 * @param valor
	 *            Seraá usado para cadastrar o valor da aposta
	 * @param previsao
	 *            Será usado para cadastrar a previsão sobre o cenário
	 */
	public Aposta(String apostador, int valor, String previsao) {

		if (apostador == null || apostador.isEmpty() || apostador.trim().isEmpty()) {

			throw new IllegalArgumentException("Erro no cadastro de aposta: Apostador nao pode ser vazio ou nulo");
		}
		if (valor <= 0) {

			throw new IllegalArgumentException("Erro no cadastro de aposta: Valor nao pode ser menor ou igual a zero");
		}
		if (previsao == null || previsao.isEmpty() || previsao.trim().isEmpty()) {

			throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao nao pode ser vazia ou nula");
		}
		if (!(previsao.equals("VAI ACONTECER") || previsao.equals("N VAI ACONTECER"))) {

			throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao invalida");
		}

		this.apostador = apostador;
		this.valorAposta = valor;
		this.previsao = previsao;
		this.seguro = new SemSeguro();
	}

	/**
	 * Método construtor
	 * 
	 * @param apostador
	 *            Será usado para cadastrar o nome do apostador
	 * @param valor
	 *            Seraá usado para cadastrar o valor da aposta
	 * @param previsao
	 *            Será usado para cadastrar a previsão sobre o cenário
	 * @param valorSeguro
	 *            Será usado para cadastrar o valor do seguro
	 */
	public Aposta(String apostador, int valor, String previsao, int valorSeguro, int custo) {

		if (apostador == null || apostador.isEmpty() || apostador.trim().isEmpty()) {

			throw new IllegalArgumentException(
					"Erro no cadastro de aposta assegurada por valor: Apostador nao pode ser vazio ou nulo");
		}
		if (valor <= 0) {

			throw new IllegalArgumentException(
					"Erro no cadastro de aposta assegurada por valor: Valor nao pode ser menor ou igual a zero");
		}
		if (previsao == null || previsao.isEmpty() || previsao.trim().isEmpty()) {

			throw new IllegalArgumentException(
					"Erro no cadastro de aposta assegurada por valor: Previsao nao pode ser vazia ou nula");
		}
		if (!(previsao.equals("VAI ACONTECER") || previsao.equals("N VAI ACONTECER"))) {

			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Previsao invalida");
		}

		this.apostador = apostador;
		this.valorAposta = valor;
		this.previsao = previsao;
		this.seguro = new AsseguramentoValor(valorSeguro, custo);
	}

	/**
	 * Método construtor
	 * 
	 * @param apostador
	 *            Será usado para cadastrar o nome do apostador
	 * @param valor
	 *            Seraá usado para cadastrar o valor da aposta
	 * @param previsao
	 *            Será usado para cadastrar a previsão sobre o cenário
	 * @param valorSeguro
	 *            Será usado para cadastrar o valor do seguro
	 */
	public Aposta(String apostador, int valor, String previsao, double taxaSeguro, int custo) {

		if (apostador == null || apostador.isEmpty() || apostador.trim().isEmpty()) {

			throw new IllegalArgumentException(
					"Erro no cadastro de aposta assegurada por taxa: Apostador nao pode ser vazio ou nulo");
		}
		if (valor <= 0) {

			throw new IllegalArgumentException(
					"Erro no cadastro de aposta assegurada por taxa: Valor nao pode ser menor ou igual a zero");
		}
		if (previsao == null || previsao.isEmpty() || previsao.trim().isEmpty()) {

			throw new IllegalArgumentException(
					"Erro no cadastro de aposta assegurada por taxa: Previsao nao pode ser vazia ou nula");
		}
		if (!(previsao.equals("VAI ACONTECER") || previsao.equals("N VAI ACONTECER"))) {

			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Previsao invalida");
		}
		if (taxaSeguro <= 0) {

		}

		this.apostador = apostador;
		this.valorAposta = valor;
		this.previsao = previsao;
		this.seguro = new AsseguramentoTaxa(taxaSeguro, custo);
	}

	/**
	 * @return Retorna o valor da aposta
	 */
	public int getValor() {
		return this.valorAposta;
	}

	/**
	 * @return Retorna a previsão sobre o cenário da aposta
	 */
	public String getPrevisao() {
		return this.previsao;
	}

	/**
	 * Método toString da classe
	 */
	public String toString() {

		return this.apostador + " - R$" + this.valorAposta + ",00 - " + this.previsao + seguro.toString();
	}

	/**
	 * Altera o seguro da aposta de aposta por valor para aposta por taxa
	 * 
	 * @param taxaSeguro
	 *            Taxa do seguro
	 */
	public void setSeguroTaxa(double taxaSeguro) {
		this.seguro = new AsseguramentoTaxa(taxaSeguro, 0);
	}

	/**
	 * Método que altera o tipo do seguro por taxa para uma por valor
	 * 
	 * @param valorSeguro
	 *            Valor do seguro
	 */
	public void setSeguroValor(int valorSeguro) {
		this.seguro = new AsseguramentoValor(valorSeguro, 0);
	}

	/**
	 * Método que retorna o valor que foi perdido pela aposta
	 * 
	 * @return Um inteiro com o valor da aposta
	 */
	public int perdeuAposta() {

		int seguramento = this.seguro.asseguramento(this.valorAposta);
		int valorPerdido = this.valorAposta - seguramento;
		this.valorAposta = seguramento;

		return valorPerdido;
	}
}