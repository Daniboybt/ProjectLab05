package ufcg.ccc.sistema.basico;

public class Aposta {
	
	private String apostador;
	private int valorAposta;
	private String previsao;

	public Aposta(String apostador, int valor, String previsao) {
		
		if (apostador.equals("") || apostador.isEmpty() || apostador == null) {
			
			throw new IllegalArgumentException("Erro no cadastro de aposta: Apostador nao pode ser vazio ou nulo");
		}
		if(valor <= 0) {
			
			throw new IllegalArgumentException("Erro no cadastro de aposta: Valor nao pode ser menor ou igual a zero");
		}
		if(previsao.equals("") || previsao.isEmpty() || previsao == null) {
			
			throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao nao pode ser vazia ou nula");
		}
		if(previsao.equals("VAI ACONTECER") || previsao.equals("N VAI ACONTECER")) {
			
			throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao invalida");
		}
	
		this.apostador = apostador;
		this.valorAposta = valor;
		this.previsao = previsao;
	}
	
	public int getValor() {
		
		return this.valorAposta;
	}
	
	public String getPrevisao() {
		
		return this.previsao;
	}
	
	public String toString() {
		
		return this.apostador + " - " + "R$" + this.valorAposta + ",00 - " + this.previsao;
	}
}
