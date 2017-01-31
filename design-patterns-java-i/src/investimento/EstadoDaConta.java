package investimento;

public interface EstadoDaConta {

	void sacar(Conta conta, double montante);
	void depositar(Conta conta, double montante);

}
