package investimento;

public class DesignPattersJavaI {
	
	public static void main(String[] args) {
		TipoInvestidor conservador = new Conservador();
		TipoInvestidor moderado = new Moderado();
		TipoInvestidor arrojado = new Arrojado();
		
		Conta conta = new Conta();
		Conta conta1 = new Conta();
		Conta conta2 = new Conta();

		Investimento investimento = new Investimento(10000.0);

		RealizadorDeInvestimentos realizador = new RealizadorDeInvestimentos();

		// Calculando o ISS
		realizador.realizaInvestimento(conta, investimento, conservador);

		// Calculando o ICMS
		realizador.realizaInvestimento(conta1, investimento, moderado);
		
		// Calculando o ICMS
		realizador.realizaInvestimento(conta2, investimento, arrojado);
	}
	
}
