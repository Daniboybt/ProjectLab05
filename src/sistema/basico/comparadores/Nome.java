package sistema.basico.comparadores;

import sistema.basico.Cenario;

public class Nome extends Comparador{

	@Override
	public int compare(Cenario cenario1, Cenario cenario2) {
		if (cenario1.getDescricao().compareTo(cenario2.getDescricao()) == 0) {
			
			return cenario1.getId() - cenario2.getId();
		}
		return cenario1.getDescricao().compareTo(cenario2.getDescricao());
	}
}
