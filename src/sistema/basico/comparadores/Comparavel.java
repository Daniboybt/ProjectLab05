package sistema.basico.comparadores;

import sistema.basico.Cenario;
import java.util.Comparator;

public interface Comparavel extends Comparator<Cenario> {

	@Override
	public int compare(Cenario cenario1, Cenario cenario2);
}
