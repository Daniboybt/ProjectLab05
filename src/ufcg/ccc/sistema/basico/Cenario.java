package ufcg.ccc.sistema.basico;

import java.util.HashSet;

public class Cenario {

	public final String CENARIO_NAO_FINALIZADO =  "Não finalizado";
	public final String CENARIO_NAO_OCORREU =  "Finalizado (n ocorreu)";
	public final String CENARIO_OCORREU =  "Finalizado (ocorreu)";
	
	private final String separador = System.lineSeparator();
	private int valorTotalApostas = 0;
	private String descricao;
	private String estado;
	private HashSet<Aposta> apostas;
	private int valorDestinadoAoCaixa;
	private int valorDividoEntreVencedores;
	
	public Cenario(String descricaoCenario) {
		
		if (descricaoCenario == null) {
			
			throw new NullPointerException("Erro no cadastro de cenario: Descricao nao pode ser nula");
		}
		
		if(descricaoCenario.equals("")) {
			
			throw new IllegalArgumentException("Erro no cadastro de cenario: Descricao nao pode ser vazia");
		}
		
		this.descricao = descricaoCenario;
		this.estado = this.CENARIO_NAO_FINALIZADO;
	}
	
	public String getEstado() {
		
		return this.estado;
	}
	
	public String toString() {
		
		return this.descricao + "-" + this.estado;
	}

	public void cadastrarAposta(String nomeApostador, int valor, String previsao) {
	
		apostas.add(new Aposta(nomeApostador, valor, previsao));
		valorTotalApostas += valor;
	}

	public int getValorTotalApostas() {
		
		return this.valorTotalApostas;
	}

	public int totalDeApostas() {
		
		return this.apostas.size();
	}

    public int getValorDestinadoAoCaixa() {
    	
    	if (this.estado.equals(this.CENARIO_NAO_FINALIZADO)){
			
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario ainda esta aberto");
		}
    	
    	return this.valorDestinadoAoCaixa;
    }
	
    public int getValorDevididoEntreVencedores() {
    	
    	if (this.estado.equals(this.CENARIO_NAO_FINALIZADO)){
			
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Cenario ainda esta aberto");
		}
    	
    	return this.valorDividoEntreVencedores;
    }
    
    public String exibeApostas() {
		
		String listaApostas = "";
		
		for (Aposta aposta: apostas) {
			
			listaApostas += this.separador + aposta.toString();
		}
	
		return listaApostas;
	}

	public void fecharAposta(boolean ocorreu, double taxa) {
		
		if (ocorreu) {
			
			this.estado = this.CENARIO_OCORREU;
		
		}else {
			
			this.estado = this.CENARIO_NAO_OCORREU;
		}			
		
		int valorColetado = avaliaApostas(ocorreu);	
		this.valorDestinadoAoCaixa = (int) (valorColetado * taxa);
		
		valorColetado -= valorDestinadoAoCaixa;
		this.valorDividoEntreVencedores = valorColetado;
		
	}

	private int avaliaApostas(boolean ocorreu) {
		
		int somaApostasPerdedoras = 0;
		
		if(ocorreu) {
		
			for(Aposta aposta: this.apostas) {
			
				if (aposta.getPrevisao().equals("N VAI ACONTECER")) {
					
					somaApostasPerdedoras += aposta.getValor();
				}
			}
		
		}else {
			
			for(Aposta aposta: this.apostas) {
				
				if (aposta.getPrevisao().equals("VAI ACONTECER")) {
					
					somaApostasPerdedoras += aposta.getValor();
				}
			}
		}
		return somaApostasPerdedoras;
	}
}