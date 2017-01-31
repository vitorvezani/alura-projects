package investimento;

public class Positivo implements EstadoDaConta {

	@Override
	public void sacar(Conta conta, double montante) {
		conta.saldo -= montante;
		
		if(conta.saldo < 0) conta.estado = new Negativo();
		
	}

	@Override
	public void depositar(Conta conta, double montante) {
		conta.saldo += 0.98 * montante;
	}

}
