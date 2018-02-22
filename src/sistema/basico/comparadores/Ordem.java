package sistema.basico.comparadores;

import sistema.basico.Cenario;

public class Ordem extends Comparador{

	@Override
	public int compare(Cenario cenario1, Cenario cenario2) {
		return cenario1.getId() - cenario2.getId();
	}
}
