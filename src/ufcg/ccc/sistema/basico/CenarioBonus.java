package ufcg.ccc.sistema.basico;

public class CenarioBonus extends Cenario{
	
	int bonus;
	
	public CenarioBonus(String descricao, int bônus) {
		
		super(descricao);
		bonus = bônus;
	}

	@Override
	public String toString() {
		
		return super.toString() + "-"  + bonus;
	}
}
