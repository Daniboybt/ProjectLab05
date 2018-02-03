package ufcg.ccc.sistema.basico;

import static org.junit.Assert.*;

import org.junit.Test;

public class ApostaTest {

	@Test(expected = IllegalArgumentException.class)
	public void testCriaApostasErros() {
		
		Aposta aposta1 = new Aposta(null, 50, "VAI ACONTECER");
		Aposta aposta2 = new Aposta("", 45, "VAI ACONTECER");
		Aposta aposta3 = new Aposta("neto", 50, null);
		Aposta aposta4 = new Aposta("neto", 50, "");
		Aposta aposta5 = new Aposta("neto", 0, "VAI ACONTECER");
		Aposta aposta6 = new Aposta("neto", -1, "VAI ACONTECER");
		Aposta aposta7 = new Aposta("neto", -1, "VAI");
	}
	
	@Test
	public void testGeters() {
		
		Aposta aposta1 = new Aposta("neto", 50, "VAI ACONTECER");
		Aposta aposta2 = new Aposta("neto", 45, "N VAI ACONTECER");
	
		assertEquals("VAI ACONTECER", aposta1.getPrevisao());
		assertEquals("N VAI ACONTECER", aposta2.getPrevisao());
	
		assertEquals(50, aposta1.getValor());
		assertEquals(45, aposta2.getValor());
	}

	@Test
	public void testToString() {
		
		Aposta aposta1 = new Aposta("neto", 50, "VAI ACONTECER");
		
		assertEquals("neto - R$50,00 - VAI ACONTECER", aposta1.toString());
	}
	

}