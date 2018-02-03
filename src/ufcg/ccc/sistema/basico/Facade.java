package ufcg.ccc.sistema.basico;

public class Facade {
	
	Controller control;
	
	public Facade() {
		
		control = new Controller();
		
	}

	public void inicializarSistema(int caixaSistema, double taxaSistema) {
		
		this.control.inicializar(caixaSistema, taxaSistema);
	}

	public int getCaixa() {
		
		return this.control.getCaixa();
	}

	public int cadastrarCenario(String descricaoCenario) {
		
		return this.control.cadastrarCenario(descricaoCenario);
	}
	
	public String exibirCenario(int numeracaoCenario) {
		
		return this.control.exibirCenario(numeracaoCenario);
	}

	public String exibirCenarios() {
		
		return this.control.exibirCenarios();
	}

	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
		
		control.cadastrarAposta(cenario, apostador, valor, previsao);
	}

	public int valorTotalDeApostas(int cenario) {
		
		return control.valorTotalDeApostas(cenario);
	}

	public int totalDeApostas(int cenario) {
		
		return control.TotalDeApostas(cenario);
	}

	public String exibeApostas(int cenario) {
		
		return control.exibeApostas(cenario);
	}

	public void fecharAposta(int cenario, boolean ocorreu) {
		
		
	}

	public int cadastrarCenario(String descricao, int bônus) {
		
		return this.control.cadastrarCenario(descricao, bônus);
	}
}