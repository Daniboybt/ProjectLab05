package sistema.basico.seguro;

/**
 * Classe que representa um asseguramento por taxa
 * 
 * @author danielbt
 */
public class AsseguramentoTaxa extends Seguro {

	/**
	 * Atributo que guarda o custo do seguro
	 */
	private int custo;

	/**
	 * Atributo que guarda a taxa do seguro
	 */
	private double taxaSeguro;

	public AsseguramentoTaxa(double taxaSeguro, int custo) {

		this.taxaSeguro = taxaSeguro;
		this.custo = custo;
	}

	/**
	 * Reescrita do metodo toString que mostra o tipo do seguro e sua taxa
	 */
	@Override
	public String toString() {

		return "- ASSEGURADA (TAXA) - R$ " + this.taxaSeguro + ",00";
	}

	/**
	 * Método que ativa o seguro para calcular o dinheiro que será retornado ao
	 * apostador
	 */
	@Override
	public int asseguramento(int valorAposta) {
		return (int) (valorAposta * this.taxaSeguro);
	}
}