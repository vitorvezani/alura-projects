package investimento.decorator;

import java.util.List;
import java.util.stream.Collectors;

import investimento.Conta;

/**
 * Contas com saldo menor que 100 reais
 * 
 * @author vitor
 *
 */
public class FiltroSaldoInferior extends FiltroDeConta {

	public FiltroSaldoInferior(FiltroDeConta outroFiltro) {
		super(outroFiltro);
	}

	@Override
	List<Conta> filtra(List<Conta> contas) {
		return contas.stream().filter(c -> c.getSaldo() < 100).collect(Collectors.toList());
	}
	
}
