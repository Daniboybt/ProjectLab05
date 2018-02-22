package sistema.basico;


/**
 * Classe filha de cenário que é diferente de sua classe pai por possuir um
 * bonus que é adicionado aos vencedores.
 * 
 * @author danielbt
 */
public class CenarioBonus extends Cenario {

	/**
	 * Atributo que guarda o valor do bonus
	 */
	private int bonus;

	/**
	 * Método construtor
	 * 
	 * @param descricao
	 * @param bônus
	 */
	public CenarioBonus(String descricao,int id, int bônus) {

		super(descricao, id);

		if (bônus <= 0) {

			throw new IllegalArgumentException("Erro no cadastro de cenario: Bonus invalido");
		}

		this.valorDividoEntreVencedores += bônus;
		bonus = bônus;
	}

	@Override
	public String toString() {

		return super.toString() + " - " + "R$ " + (this.bonus / 100) + ",00";
	}

	@Override
	public int fecharAposta(boolean ocorreu, double taxa) {

		super.fecharAposta(ocorreu, taxa);

		return this.valorDestinadoAoCaixa;
	}
}