package sistema.basico;


public enum Estado {
	
	Finalizado("Finalizado (ocorreu)"), FinalizadoNaoOcorreu("Finalizado (n ocorreu)"), NaoFinalizado("Nao finalizado");

	private final String valor;
	
	Estado(String valor){
		
		this.valor = valor;
	}

	public String getValor() {
		
		return this.valor;
	}
}
