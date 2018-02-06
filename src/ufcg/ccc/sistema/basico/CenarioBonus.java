package ufcg.ccc.sistema.basico;

/**
 * Classe filha de cenário que é diferente de sua classe pai por possuir um bonus
 * que é adicionado aos vencedores.
 * 
 * @author danielbt
 */
public class CenarioBonus extends Cenario{
	
	/**
	 * Atributo que guarda o valor do bonus
	 */
	private int bonus;
	
	/**
	 * Método construtor 
	 * @param descricao
	 * @param bônus
	 */
	public CenarioBonus(String descricao, int bônus) {
		
		super(descricao);
		bonus = bônus;
	}

	@Override
	public String toString() {
		
		return super.toString() + "-"  + bonus;
	}

	@Override
	public void fecharAposta(boolean ocorreu, double taxa) {
		
		super.fecharAposta(ocorreu, taxa);
		this.valorDestinadoAoCaixa -= bonus;
		this.valorDividoEntreVencedores += bonus;
	}

	
}
