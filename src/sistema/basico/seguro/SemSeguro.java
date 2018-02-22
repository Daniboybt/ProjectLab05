package sistema.basico.seguro;

/**
 * Classe que representa ausencia de seguro
 * 
 * @author danielbt
 */
public class SemSeguro extends Seguro {

	/**
	 * Método que retorna uma string vazia pois não há dados no seguro
	 */
	@Override
	public String toString() {

		return "";
	}

	/**
	 * Método que retorna o valor zero pois representa uma aposta sem seguro
	 */
	@Override
	public int asseguramento(int valorAposta) {
		return 0;
	}
}
