package investimento;

public class Conservador implements TipoInvestidor {

	@Override
	public double calculaRendimento(Investimento investimento) {
		return investimento.getValor() * 0.8 / 100;
	}

}
