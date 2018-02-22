package sistema.basico;

import static org.junit.Assert.*;

import org.junit.Test;

import sistema.Sistema;

public class SistemaTest {

	@Test(expected = IllegalArgumentException.class)
	public void test() {
		
		Sistema sistema1 = new Sistema(-1, 0.2);
		Sistema sistema2 = new Sistema(1, -2);
		Sistema sistema4 = new Sistema(3, 0.01);
		sistema4.cadastrarCenario("Vai passar!");
		sistema4.exibirCenario(-2);
		sistema4.exibirCenario(5);
		sistema4.cadastrarAposta(-1, "Daniel", 200, "VAI ACONTECER");
		sistema4.cadastrarAposta(3, "Daniel", 200, "N VAI ACONTECER");
		sistema4.valorTotalDeApostas(-1);
		sistema4.valorTotalDeApostas(5);
		sistema4.exibeApostas(-2);
		sistema4.exibeApostas(7);
		sistema4.getCaixaCenario(-2);
		sistema4.getCaixaCenario(7);
		sistema4.getTotalRateioCenario(-2);
		sistema4.getTotalRateioCenario(12);
		
		sistema4.fecharAposta(0, true);
		sistema4.fecharAposta(3, false);
		sistema4.fecharAposta(1, true);
		sistema4.fecharAposta(1, true);
		
		sistema4.exibeApostas(-2);
		sistema4.exibeApostas(4);
		
		sistema4.totalDeApostas(0);
		sistema4.totalDeApostas(22);
		
		
		
	}
	@Test
	public void testCadastrarExibir() {
		
		Sistema sistema3 = new Sistema(2,0.2);
		assertEquals(2, sistema3.getCaixa());
		sistema3.cadastrarCenario("Vai passar!");
		sistema3.fecharAposta(1, true);
		assertEquals(System.lineSeparator() + 1 + "-" + "Vai passar!"+"-"+"Finalizado (ocorreu)", sistema3.exibirCenarios());
		sistema3.cadastrarCenario("PSG vai ganhar do Real Madrid!");
		sistema3.cadastrarAposta(1, "Paulo", 1000, "N VAI ACONTECER");
		assertEquals(System.lineSeparator() + "Paulo" + " - " + "R$"+"1000"+",00 - " + "N VAI ACONTECER", sistema3.exibeApostas(1));
	
	
	}


}
