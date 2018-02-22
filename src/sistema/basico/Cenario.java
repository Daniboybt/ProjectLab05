package sistema.basico;


import java.util.List;
import java.util.ArrayList;

/**
 * Classe que representa um cenário em um sistema de apostas
 * 
 * @author danielbt
 */
public class Cenario {
	
	
	/**
	 * Atributo auxiliar para quebra de linha
	 */
	private final String separador = System.lineSeparator();
	
	/**
	 * Posição do cenário na lista de cenários
	 */
	private int id;
	/**
	 * Atributo que guarda o valor de dinheiro total apostado num cenario
	 */
	private int valorTotalApostas = 0;

	/**
	 * Atributo que guarda a descrição que o cenário possui
	 */
	private String descricao;

	/**
	 * Atributo que guarda o estado que o cenário possui no momento seu valor
	 * inicial sempre será não finalizado
	 */
	private Estado estado;

	/**
	 * Um conjunto que possui todas as apostas que um cenário possui até o momento
	 */
	private List<Aposta> apostas;

	/**
	 * Atributo que possui o valor destinado ao caixa quando o cenário é finalizado
	 */
	protected int valorDestinadoAoCaixa;

	/**
	 * Possui o valor que seŕa divido aos apostadores vencedores quando o cenário é
	 * finalizado
	 */
	protected int valorDividoEntreVencedores;

	/**
	 * Método construtor que inicializa alguns atributos e cadastra a descrição que
	 * o cenário irá possuir
	 * 
	 * @param descricaoCenario
	 *            Carrega a descrição do cenário
	 */
	public Cenario(String descricaoCenario, int id) {

		if (descricaoCenario == null) {

			throw new NullPointerException("Erro no cadastro de cenario: Descricao nao pode ser nula");
		}

		if (descricaoCenario.equals("")) {

			throw new IllegalArgumentException("Erro no cadastro de cenario: Descricao nao pode ser vazia");
		}

		this.valorDividoEntreVencedores = 0;
		this.descricao = descricaoCenario;
		this.estado = Estado.NaoFinalizado;
		this.apostas = new ArrayList<>();
		this.id = id;
	}

	/**
	 * Método que auxiliara outras classes
	 * 
	 * @return Retorna o estado atual do cenário
	 */
	public String getEstado() {

		return estado.getValor();
	}

	/**
	 * @ return Retorna uma representação em String do cenário
	 */
	public String toString() {

		return this.id + " - " + this.descricao + " - " + this.estado.getValor();
	}

	public String getDescricao() {
		
		return this.descricao;
	}
	
	public int getId() {
		
		return this.id;
	}
	
	/**
	 * Método que cadastra uma aposta no cenário
	 * 
	 * @param nomeApostador
	 *            Guarda o nome do apostador
	 * @param valor
	 *            Carrega o valor em dinheiro da aposta
	 * @param previsao
	 *            Carrega o palpite do apostador sobre o cenário
	 */
	public void cadastrarAposta(String nomeApostador, int valor, String previsao) {

		apostas.add(new Aposta(nomeApostador, valor, previsao));
		valorTotalApostas += valor;
	}

	/**
	 * Método que cadastra uma aposta no cenário
	 * 
	 * @param nomeApostador
	 *            Guarda o nome do apostador
	 * @param valor
	 *            Carrega o valor em dinheiro da aposta
	 * @param previsao
	 *            Carrega o palpite do apostador sobre o cenário
	 * @param valorSeguro
	 *            Carrega o valor do seguro
	 */
	public void cadastrarAposta(String nomeApostador, int valor, String previsao, int valorSeguro, int custo) {

		apostas.add(new Aposta(nomeApostador, valor, previsao, valorSeguro, custo));
		valorTotalApostas += valor;
	}

	/**
	 * Método que cadastra uma aposta no cenário
	 * 
	 * @param nomeApostador
	 *            Guarda o nome do apostador
	 * @param valor
	 *            Carrega o valor em dinheiro da aposta
	 * @param previsao
	 *            Carrega o palpite do apostador sobre o cenário
	 * @pram taxaSeguro Carrega a taxa do seguro
	 */
	public void cadastrarAposta(String nomeApostador, int valor, String previsao, double taxaSeguro, int custo) {

		apostas.add(new Aposta(nomeApostador, valor, previsao, taxaSeguro, custo));
		valorTotalApostas += valor;
	}

	/**
	 * @return Retorna o valor total do dinheiro das apostas
	 */
	public int getValorTotalApostas() {

		return this.valorTotalApostas;
	}

	/**
	 * Retorna uma aposta cadastrada no cenário de acordo com a posição onde a
	 * aposta se encontra
	 * 
	 * @param aposta
	 *            Inteiro representando a posição de aposta
	 * @return Uma instância de Aposta
	 */
	public Aposta getAposta(int aposta) {

		return this.apostas.get(aposta - 1);
	}

	/**
	 * @return Retorna o numero total de apostas feitas no cenário
	 */
	public int totalDeApostas() {

		return this.apostas.size();
	}

	/**
	 * @return Retorna o valor destinado ao caixa do cenário
	 */
	public int getValorDestinadoAoCaixa() {

		if (this.estado == Estado.NaoFinalizado) {

			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario ainda esta aberto");
		}

		return this.valorDestinadoAoCaixa;
	}

	/**
	 * @return Retorna o valor que será divido aos vencedores
	 */
	public int getValorDevididoEntreVencedores() {

		if (this.estado == Estado.NaoFinalizado) {

			throw new IllegalArgumentException(
					"Erro na consulta do total de rateio do cenario: Cenario ainda esta aberto");
		}

		return this.valorDividoEntreVencedores;
	}

	/**
	 * @return Retorna em forma de string todas as apostas do cenário
	 */
	public String exibeApostas() {

		String listaApostas = "";

		for (Aposta aposta : apostas) {

			listaApostas += this.separador + aposta.toString();
		}

		return listaApostas;
	}

	/**
	 * Método que fecha o cenário e cacula os valores destinados ao caixa e
	 * vencedores
	 * 
	 * @param ocorreu
	 *            Carrega um booleano dizendo se o cenário ocorreu ou não
	 * 
	 * @param taxa
	 *            Carrega a taxa do sistema para o calculo dos valores destinados ao
	 *            caixa
	 */
	public int fecharAposta(boolean ocorreu, double taxa) {

		if (ocorreu) {

			this.estado = Estado.Finalizado;

		} else {

			this.estado = Estado.FinalizadoNaoOcorreu;
		}

		int valorColetado = avaliaApostas(ocorreu);
		this.valorDestinadoAoCaixa = (int) (valorColetado * taxa);

		valorColetado -= valorDestinadoAoCaixa;
		this.valorDividoEntreVencedores += valorColetado;

		return this.valorDestinadoAoCaixa;
	}

	/**
	 * Método auxiliar que avalia as apostas que venceram e perderam
	 * 
	 * @param ocorreu
	 *            Carrega um booleano dizendo se o cenário aconteceu ou não
	 * 
	 * @return A soma do valor das apostas perdedoras que serão destinadas ao caixa
	 *         e vencedores
	 */
	private int avaliaApostas(boolean ocorreu) {

		int somaApostasPerdedoras = 0;

		if (ocorreu) {

			for (Aposta aposta : this.apostas) {

				if (aposta.getPrevisao().equals("N VAI ACONTECER")) {

					somaApostasPerdedoras += aposta.perdeuAposta();
				}
			}

		} else {

			for (Aposta aposta : this.apostas) {

				if (aposta.getPrevisao().equals("VAI ACONTECER")) {

					somaApostasPerdedoras += aposta.perdeuAposta();
				}
			}
		}

		return somaApostasPerdedoras;
	}
}