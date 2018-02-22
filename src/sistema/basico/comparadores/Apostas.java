package sistema.basico.comparadores;

import sistema.basico.Cenario;

public class Apostas extends Comparador{

	@Override
	public int compare(Cenario cenario1, Cenario cenario2) {
		
		if (cenario1.totalDeApostas() - cenario2.totalDeApostas() == 0){
			
			return cenario1.getId() - cenario2.getId();
		}
		return cenario1.totalDeApostas() - cenario2.totalDeApostas();
	}
}
