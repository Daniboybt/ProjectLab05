package sistema.basico.comparadores;

import sistema.basico.Cenario;

public abstract class Comparador implements Comparavel{
	
	@Override
	public abstract int compare(Cenario cenario1, Cenario cenario2);
}
