package investimento;

public class Conta {

	private double valor = 1000;
	
	public void deposita(double montante) {
		this.valor += montante;
	}

	public double getValor() {
		return valor;
	}
	
}
