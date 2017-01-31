package investimento;

public class Negativo implements EstadoDaConta {

	@Override
	public void sacar(Conta conta, double montante) {
		throw new RuntimeException("Sua conta está negativa, não é possivel efetuar o saque!");
	}

	@Override
	public void depositar(Conta conta, double montante) {
		conta.saldo += 0.95 * montante;
		if(conta.saldo > 0) conta.estado = new Positivo();
	}

}
