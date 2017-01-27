package investimento;

public class RealizadorDeInvestimentos {

	public void realizaInvestimento(Conta conta, Investimento investimento, TipoInvestidor tipoInvestidor) {
		conta.deposita(tipoInvestidor.calculaRendimento(investimento) * 0.75);
		System.out.println(conta.getValor());
	}

}
