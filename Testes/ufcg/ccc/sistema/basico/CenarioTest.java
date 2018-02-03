package ufcg.ccc.sistema.basico;

import static org.junit.Assert.*;

import org.junit.Test;

public class CenarioTest {

	@Test(expected = IllegalArgumentException.class)
	public void testCriarCenario() {
		
		Cenario cenario1 = new Cenario("");
		Cenario cenario4 = new Cenario("Tarzan preso hoje");
		cenario4.cadastrarAposta("daniel", 0, "VAI ACONTECER");
	}
	
	@Test(expected = NullPointerException.class)
	public void testCriarCenario2() {
		
		Cenario cenario2 = new Cenario(null);
	}
	
	@Test
	public void testAll() {
		Cenario cenario3 = new Cenario("Tarzan preso hoje");
		assertEquals("Não finalizado", cenario3.getEstado());
		cenario3.cadastrarAposta("daniel", 200, "VAI ACONTECER");
		assertEquals(200, cenario3.getValorTotalApostas());
		cenario3.fecharAposta(true, 0.01);
		assertEquals("Finalizado (ocorreu)", cenario3.getEstado());
		
		
		Cenario cenario5 = new Cenario("Aurora virá novamente ao Brasil!");
		cenario5.cadastrarAposta("gabriel", 10000, "VAI ACONTECER");
		cenario5.cadastrarAposta("Paulo", 10000, "N VAI ACONTECER");
		assertEquals(2, cenario5.totalDeApostas());
		cenario5.fecharAposta(true, 0.1);
		assertEquals(1000, cenario5.getValorDestinadoAoCaixa());
		assertEquals(9000, cenario5.getValorDevididoEntreVencedores());
		
		Cenario cenario6 = new Cenario("esse teste vai passar!");
		assertEquals(0, cenario6.totalDeApostas());
		
		
		
	}
	}
