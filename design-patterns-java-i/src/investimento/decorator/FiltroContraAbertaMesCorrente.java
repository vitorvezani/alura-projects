package investimento.decorator;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import investimento.Conta;

/**
 * Contas com data de abertura no mês corrente Todas essas são geralmente
 * selecionadas para uma análise mais detalhada.
 * 
 * @author vitor
 *
 */
public class FiltroContraAbertaMesCorrente extends FiltroDeConta {

	public FiltroContraAbertaMesCorrente(FiltroDeConta outroFiltro) {
		super(outroFiltro);
	}

	@Override
	List<Conta> filtra(List<Conta> contas) {
		List<Conta> filtrada = new ArrayList<Conta>();
		for (Conta c : contas) {
			if (c.getDataAbertura().get(Calendar.MONTH) == Calendar.getInstance().get(Calendar.MONTH)
			    && c.getDataAbertura().get(Calendar.YEAR) == Calendar.getInstance().get(Calendar.YEAR)) {
				filtrada.add(c);
			}
		}
		return filtrada;
	}

}
