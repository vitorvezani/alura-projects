package memento;

import java.util.ArrayList;
import java.util.List;

public class Historico {

	private List<Estado> estadosSalvos = new ArrayList<>();

	public void adiciona(Estado estado) {
		this.estadosSalvos.add(estado);
	}

	public Estado getEstado(int index) {
		return estadosSalvos.get(index);
	}

}
