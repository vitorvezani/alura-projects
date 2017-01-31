package investimento.decorator;

import java.util.List;
import java.util.stream.Collectors;

import investimento.Conta;

public class FiltroSaldoSuperior extends FiltroDeConta {

	/**
	 * Contas com saldo maior do que 500 mil reais
	 * 
	 * @param outroFiltro
	 */
	public FiltroSaldoSuperior(FiltroDeConta outroFiltro) {
		super(outroFiltro);
	}

	@Override
	List<Conta> filtra(List<Conta> contas) {
		return contas.stream().filter(c -> c.getSaldo() > 500.000).collect(Collectors.toList());
	}

}
