package investimento.decorator;

import java.util.ArrayList;
import java.util.List;

import investimento.Conta;

public abstract class FiltroDeConta {

	protected FiltroDeConta outroFiltro;

	public FiltroDeConta(FiltroDeConta outroFiltro) {
		this.outroFiltro = outroFiltro;
	}

	protected final List<Conta> filtraOutrosFiltros(List<Conta> contas) {
		if (outroFiltro != null)
			return outroFiltro.filtra(contas);
		else
			return new ArrayList<Conta>();
	}

	abstract List<Conta> filtra(List<Conta> contas);

}
