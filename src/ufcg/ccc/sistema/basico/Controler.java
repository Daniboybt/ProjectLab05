package ufcg.ccc.sistema.basico;

public class Controler {

	private Sistema sistema;
	

	public void inicializar(int caixaSistema, double taxaSistema) {
		
		sistema = new Sistema(caixaSistema, taxaSistema);
	}

	public int getCaixa(){
		
		return sistema.getCaixa();
	}

	public int cadastrarCenario(String descricaoCenario) {
		
		return sistema.cadastrarCenario(descricaoCenario);
	}

	public String exibirCenario(int numeracaoCenario) {
		
		return sistema.exibirCenario(numeracaoCenario);
	}

	public String exibirCenarios() {
		
		return sistema.exibirCenarios();
	}

	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
		
		sistema.cadastrarAposta(cenario, apostador, valor, previsao);
	}

	public int valorTotalDeApostas(int cenario) {
		
		return sistema.valorTotalDeApostas(cenario);
	}

	public int TotalDeApostas(int cenario) {
		
		return sistema.totalDeApostas(cenario);
	}

	public String exibeApostas(int cenario) {
		
		return sistema.exibeApostas(cenario);
	}
}