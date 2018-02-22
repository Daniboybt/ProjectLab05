package sistema.basico.seguro;


/**
 * Classe abastrata que servirá de base para aspostas por taxa, valor e apostas
 * sem seguro
 * 
 * @author danielbt
 */
public abstract class Seguro {

	/**
	 * Método toString que representará os dados do seguro em forma de string
	 */
	public abstract String toString();

	/**
	 * Método que irá calcular o valor retornado ao apostador
	 * 
	 * @param valorAposta
	 *            Valor que foi apostado
	 * @return Valor que será retornado ao apostador
	 */
	public abstract int asseguramento(int valorAposta);
}
