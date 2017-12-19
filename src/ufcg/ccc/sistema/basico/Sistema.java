package ufcg.ccc.sistema.basico;

import java.util.ArrayList;

public class Sistema {
	
	private ArrayList<Cenario> cenarios;
	private int caixa;
	private double taxa;
	final String separador = System.lineSeparator();
	
	public Sistema(int caixaSistema, double taxaSistema) {
		
		if (caixaSistema < 0) {
			
			throw new IllegalArgumentException("Caixa nao pode ser inferior a 0");
		}
		if (taxaSistema < 0) {
			
			throw new IllegalArgumentException("Taxa nao pode ser inferior a 0");
		}
		
		this.caixa = caixaSistema;
		this.taxa = taxaSistema;
	}

	public int getCaixa() {
		
		return this.caixa;
	}

	public int cadastrarCenario(String descricaoCenario) {
		
		this.cenarios.add(new Cenario(descricaoCenario));
		
		return this.cenarios.size();
	}

	public String exibirCenario(int numeracao) {
		
		if (numeracao < 0) {
			
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario invalido");

		}else if (numeracao > this.cenarios.size()) {
			
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario nao cadastrado");
		}
		
		return this.cenarios.get(numeracao - 1).toString();
	}

	public String exibirCenarios() {
		
		String listaCenarios = "";
		
		for (int i = 0; i < this.cenarios.size(); i++) {
			
			listaCenarios += this.separador + (i + 1) + "-" + this.cenarios.get(i).toString();
		}
		return listaCenarios;
	}

	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
		
		if (cenario < 0) {
			
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario invalido");
		
		}else if (cenario > this.cenarios.size()) {
			
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario nao cadastrado");
		}
		
		this.cenarios.get(cenario - 1).cadastrarAposta(apostador, valor, previsao);
	}

	public int valorTotalDeApostas(int cenario) {
		
		if (cenario > this.cenarios.size()) {
			
			throw new IllegalArgumentException("Erro na consulta do valor total de apostas: Cenario nao cadastrado");
		}
		
		if (cenario < 0) {
			
			throw new IllegalArgumentException("Erro na consulta do valor total de apostas: Cenario invalido");
		}
		return this.cenarios.get(cenario).getValorTotalApostas();
	}
	
	public int totalDeApostas(int cenario) {
		
		if (cenario > this.cenarios.size()) {
			
			throw new IllegalArgumentException("Erro na consulta do total de apostas: Cenario nao cadastrado");
		}
		
		if (cenario < 0) {
			
			throw new IllegalArgumentException("Erro na consulta do total de apostas: Cenario invalido");
		}
		return this.cenarios.get(cenario - 1).totalDeApostas();
	}

	public String exibeApostas(int cenario) {
		
		if (cenario > this.cenarios.size()) {
			
			throw new IllegalArgumentException("Erro na exibição de Cenarios: Cenario não cadastrado");
		}
		
		if (cenario < 0) {
			
			throw new IllegalArgumentException("Erro na exibição de Cenarios: Cenario inválido");
		}
		return this.cenarios.get(cenario - 1).exibeApostas();
	}

	public void fecharAposta(int cenario, boolean ocorreu) {
		
		if (cenario > this.cenarios.size()) {
			
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario nao cadastrado");
		}
		
		if (cenario < 0) {
			
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario invalido");
		}
		
		if (this.cenarios.get(cenario - 1).getEstado().equals("Finalizado (ocorreu)") || this.cenarios.get(cenario - 1).getEstado().equals("Finalizado (n ocorreu)")) {
			
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario ja esta fechado");
		}
			
		this.cenarios.get(cenario - 1).fecharAposta(ocorreu, this.taxa);
	}

    public int getCaixaCenario(int cenario) {
    	
    	if (cenario > this.cenarios.size()) {
			
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario nao cadastrado");
		}
		
		if (cenario < 0) {
			
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario invalido");
		}
    	
		return this.cenarios.get(cenario - 1).getValorDestinadoAoCaixa();
    }

    public int getTotalRateioCenario(int cenario) {
    	
    	if (cenario > this.cenarios.size()) {
			
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Cenario nao cadastrado");
		}
		
		if (cenario < 0) {
			
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Cenario invalido");
		}
    	return this.cenarios.get(cenario - 1).getValorDevididoEntreVencedores();
    }
}