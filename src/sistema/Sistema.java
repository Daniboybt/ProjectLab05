package sistema;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import sistema.basico.Cenario;
import sistema.basico.CenarioBonus;
import sistema.basico.comparadores.*;

/**
 * Classe que representa o sistema de apostas
 * 
 * @author danielbt
 */
public class Sistema {
	
	/**
	 * Atributo que guarda todos os cenário cadastrados
	 */
	private List<Cenario> cenarios;
	
	/**
	 * Atributo que guarda o caixa do sistema
	 */
	private int caixa;
	
	/**
	 * Atributo que guarda a taxa do sistema
	 */
	private double taxa;
	
	/**
	 * Atributo que será usado para quebra de linha
	 */
	final String separador = System.lineSeparator();
	
	private Comparavel comparador;
	
	/**
	 * Método construtorque inicializa os atributos
	 * 
	 * @param caixaSistema	Será usado para guarda o caixa inicial do sistema
	 * @param taxaSistema	Será usado para cadastrar a taxa do sistema
	 */
	public Sistema(int caixaSistema, double taxaSistema) {
		
		if (caixaSistema < 0) {
			
			throw new IllegalArgumentException("Erro na inicializacao: Caixa nao pode ser inferior a 0");
		}
		if (taxaSistema < 0) {
			
			throw new IllegalArgumentException("Erro na inicializacao: Taxa nao pode ser inferior a 0");
		}
		
		this.caixa = caixaSistema;
		this.taxa = taxaSistema;
		cenarios = new ArrayList<>();
		this.comparador = new Ordem();
	}
	
	/**
	 * @return	Retorna o caixa atual do sistema
	 */
	public int getCaixa() {
		
		return this.caixa;
	}
	
	/**
	 * Cadastra um cenário no sistema
	 * 
	 * @param descricaoCenario	Será usado para cadastradar a descrição do sistema
	 * 
	 * @return	Retorna a numeração do cenário cadastrado
	 */
	public int cadastrarCenario(String descricaoCenario) {
		
		this.cenarios.add(new Cenario(descricaoCenario, this.cenarios.size() + 1));
		
		return this.cenarios.size();
	}
	
	/**
	 * Cadastra um cenário no sistema
	 * 
	 * @param descricaoCenario	Será usado para cadastradar a descrição do sistema
	 * @param bônus será usado para cadastrar o valor bonus que o cenario terá
	 * 
	 * @return	Retorna a numeração do cenário cadastrado
	 */
	public int cadastrarCenario(String descricaoCenario, int bônus) {
		
		
		this.cenarios.add(new CenarioBonus(descricaoCenario,(this.cenarios.size() + 1), bônus));
		this.caixa -= bônus; 
		
		return this.cenarios.size();
	}
	
	/**
	 * @param numeracao		Será usado para saber o cenário desejado
	 * @return		Retornar uma representação em string do cenário
	 */
	public String exibirCenario(int numeracao) {
		
		if (numeracao < 0) {
			
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario invalido");

		}else if (numeracao > this.cenarios.size()) {
			
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario nao cadastrado");
		}
		
		return this.cenarios.get(numeracao - 1).toString();
	}
	
	/**
	 * @return Retorna uma representação em string de todos os cenários
	 */
	public String exibirCenarios() {
		
		String listaCenarios = "";
		
		for (Cenario cenario: this.cenarios) {
			
			listaCenarios += cenario.toString() + this.separador;
		}
		return listaCenarios;
	}
	
	/**
	 * Método que cadastra um aposta no sistema
	 * 
	 * @param cenario	Será usado para saber em qual cenário será cadastrado a aposta
	 * @param apostador		Será usado para cadastrar o nome do apostador
	 * @param valor		Será usado para cadastrar o valor da aposta
	 * @param previsao		Será cadastrar a previsão da aposta
	 */
	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
		
		if (cenario <= 0) {
			
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario invalido");
		
		}else if (cenario > this.cenarios.size()) {
			
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario nao cadastrado");
		}
		
		this.cenarios.get(cenario - 1).cadastrarAposta(apostador, valor, previsao);
	}
	
	/**
	 * Método que cadastra um aposta assegurada por valor no sistema
	 * 
	 * @param cenario	Será usado para saber em qual cenário será cadastrado a aposta
	 * @param apostador		Será usado para cadastrar o nome do apostador
	 * @param valor		Será usado para cadastrar o valor da aposta
	 * @param previsao		Será cadastrar a previsão da aposta
	 * @param valorSeguro 	Será usado para guardar o seguro por valor
	 * @param custo 	Será usado para descontar o custo do seguro
	 * 
	 * @return O numero do cenário onde a aposta foi cadastrada
	 */
	public int cadastrarApostaAsseguradaValor(int cenario, String apostador, int valor, String previsao, int valorSeguro, int custo) {
		
		if (cenario <= 0 || cenario > this.cenarios.size()) {
			
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Cenario invalido");
		}
		
		this.caixa += custo;
		this.cenarios.get(cenario - 1).cadastrarAposta(apostador, valor, previsao, valorSeguro, custo);
		return cenario;
	}
	
	/**
	 * Método que cadastra um aposta assegurada por taxa no sistema
	 * 
	 * @param cenario	Será usado para saber em qual cenário será cadastrado a aposta
	 * @param apostador		Será usado para cadastrar o nome do apostador
	 * @param valor		Será usado para cadastrar o valor da aposta
	 * @param previsao		Será cadastrar a previsão da aposta
	 * @param taxaSeguro 	Será usado para guardar o seguro por taxa
	 * @param custo 	Será usado para descontar o valor do custo do seguro
	 * 
	 * @return O numero do cenário onde a aposta foi cadastrada
	 */
	public int cadastrarApostaAsseguradaTaxa(int cenario, String apostador, int valor, String previsao, double taxaSeguro, int custo) {
		
		if (cenario <= 0 || cenario > this.cenarios.size()) {
			
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Cenario invalido");
		}
		
		this.caixa += custo;
		this.cenarios.get(cenario - 1).cadastrarAposta(apostador, valor, previsao, taxaSeguro, custo);
		return cenario;
	}

	
	
	/**
	 * @param cenario	Será usado para saber o cenário desejado
	 * 
	 * @return		Retorna o valor total das apostas em um cenário específico 
	 */
	public int valorTotalDeApostas(int cenario) {
		
		if (cenario > this.cenarios.size()) {
			
			throw new IllegalArgumentException("Erro na consulta do valor total de apostas: Cenario nao cadastrado");
		}
		
		if (cenario <= 0) {
			
			throw new IllegalArgumentException("Erro na consulta do valor total de apostas: Cenario invalido");
		}
		return this.cenarios.get(cenario - 1).getValorTotalApostas();
	}
	
	/**
	 * @param cenario 	Será usado para saber o cenário desejado
	 * @return		Retorna o total de apostas feitas em um cenário
	 */
	public int totalDeApostas(int cenario) {
		
		if (cenario > this.cenarios.size()) {
			
			throw new IllegalArgumentException("Erro na consulta do total de apostas: Cenario nao cadastrado");
		}
		
		if (cenario <= 0) {
			
			throw new IllegalArgumentException("Erro na consulta do total de apostas: Cenario invalido");
		}
		return this.cenarios.get(cenario - 1).totalDeApostas();
	}
	
	/**
	 * @param cenario	Será usado para saber o cenário desejado
	 * @return		Retorna uma representação em string de todas as aposta de um cenário
	 */
	public String exibeApostas(int cenario) {
		
		if (cenario > this.cenarios.size()) {
			
			throw new IllegalArgumentException("Erro na exibição de Cenarios: Cenario não cadastrado");
		}
		
		if (cenario <= 0) {
			
			throw new IllegalArgumentException("Erro na exibição de Cenarios: Cenario inválido");
		}
		return this.cenarios.get(cenario - 1).exibeApostas();
	}
	
	/**
	 * Método que encerra um cenário do sistema
	 * 
	 * @param cenario	Será usado para saber o cenário desejado
	 * @param ocorreu		Será usado para saber se o cenário ocorreu ou não
	 */
	public void fecharAposta(int cenario, boolean ocorreu) {
		
		if (cenario > this.cenarios.size()) {
			
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario nao cadastrado");
		}
		
		if (cenario <= 0) {
			
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario invalido");
		}
		
		if (this.cenarios.get(cenario - 1).getEstado().equals("Finalizado (ocorreu)") || this.cenarios.get(cenario - 1).getEstado().equals("Finalizado (n ocorreu)")) {
			
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario ja esta fechado");
		}
			
		this.caixa += this.cenarios.get(cenario - 1).fecharAposta(ocorreu, this.taxa);
	}
	
	/**
	 * @param cenario	Será usado para sabero o cenario desejado
	 * @return		Retorna o valor que será destinado ao caixa de um cenário
	 */
    public int getCaixaCenario(int cenario) {
    	
    	if (cenario > this.cenarios.size()) {
			
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario nao cadastrado");
		}
		
		if (cenario <= 0) {
			
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario invalido");
		}
    	
		return this.cenarios.get(cenario - 1).getValorDestinadoAoCaixa();
    }
    
    /**
     * @param cenario	Será usado para saber o cenário desejado
     * @return		Retorna o valor que será usado para o rateio entre os vencedores
     */
    public int getTotalRateioCenario(int cenario) {
    	
    	if (cenario > this.cenarios.size()) {
			
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Cenario nao cadastrado");
		}
		
		if (cenario <= 0) {
			
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Cenario invalido");
		}
    	return this.cenarios.get(cenario - 1).getValorDevididoEntreVencedores();
    }
    
    /**
	 * Método que altera uma aposta com seguro por taxa para uma com seguro por valor
	 * 
	 * @param cenario		Cenário onde a aposta está cadastrada
	 * @param apostaAssegurada		Posição da aposta na lista de apostas
	 * @param valor			Valor do seguro
	 * @return				Posição do cenário onde a aposta foi alterada
	 */
    public int alterarSeguroValor(int cenario, int apostaAssegurada, int valorSeguro) {
    	
    	if (cenario <= 0 || apostaAssegurada <= 0) {
    		
    		throw new IllegalArgumentException("");
    	}
    	
    	this.cenarios.get(cenario - 1).getAposta(apostaAssegurada - 1).setSeguroValor(valorSeguro);
    	return cenario;
    }
    
    /**
   	 * Método que altera uma aposta com seguro por valor para uma com seguro por taxa
   	 * 
   	 * @param cenario		Cenário onde a aposta está cadastrada
   	 * @param apostaAssegurada		Posição da aposta na lista de apostas
   	 * @param taxa		Taxa do seguro
   	 * @return				Posição do cenário onde a aposta foi alterada
   	 */
    public int alterarSeguroTaxa(int cenario, int apostaAssegurada, double taxaSeguro) {
    	
    	if (cenario <= 0 || apostaAssegurada <= 0) {
    		
    		throw new IllegalArgumentException("");
    	}
    
    	this.cenarios.get(cenario - 1).getAposta(apostaAssegurada - 1).setSeguroTaxa(taxaSeguro);
    	return cenario;
    }

	public void alterarOrdem(String ordem) {
		
		if(ordem == null) {
			throw new NullPointerException("Erro ao alterar ordem: Ordem nao pode ser vazia ou nula");
		}
		
		if(ordem.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro ao alterar ordem: Ordem nao pode ser vazia ou nula");
		}
		
		switch(ordem){
		
		case "nome":
			this.comparador= new Nome();
			break;
		
		case "cadastro":
			this.comparador = new Ordem();
			break;
		
		case "apostas":
			this.comparador = new Apostas();
			break;
		
		default:
			throw new IllegalArgumentException("Erro ao alterar ordem: Ordem invalida");
		}
		Collections.sort(this.cenarios, this.comparador);
	}

	public String exibirCenarioOrdenado(int cenario) {
		
		if(cenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta de cenario ordenado: Cenario invalido");
		}
		
		if(cenario > this.cenarios.size()) {
			throw new IllegalArgumentException("Erro na consulta de cenario ordenado: Cenario nao cadastrado");
		}
		
		return this.cenarios.get(cenario - 1).toString();
	}
}