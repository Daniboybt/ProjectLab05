package sistema.basico.seguro;

/**
 * classe que representa um asseguramento por valor
 * 
 * @author danielbt
 */
public class AsseguramentoValor extends Seguro {

	/**
	 * Atributo que guarda o custo do seguro
	 */
	private int custo;

	/**
	 * Atributo que guarda o valor do seguro
	 */
	private int valorSeguro;

	public AsseguramentoValor(int valorSeguro, int custo) {

		if (valorSeguro <= 0) {

			throw new IllegalArgumentException(
					"Erro no cadastro de aposta assegurada por valor: Valor nao pode ser menor ou igual a zero");
		}

		this.custo = custo;
		this.valorSeguro = valorSeguro;
	}

	/**
	 * Reescrita do metodo toString que mostra o tipo do seguro e seu valor
	 */
	@Override
	public String toString() {

		return "- ASSEGURADA (VALOR) - R$ " + this.valorSeguro + ",00";
	}

	@Override
	public int asseguramento(int valorAposta) {
		return this.valorSeguro;
	}
}