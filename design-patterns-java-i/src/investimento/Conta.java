package investimento;

import java.util.Calendar;

public class Conta {

	private String nome;
	private double numero;
	private double agencia;
	private Calendar dataAbertura;
	protected double saldo;
	protected EstadoDaConta estado;
	
	public Conta(String nome) {
		this.nome = nome;
		this.dataAbertura = Calendar.getInstance();
		this.estado = new Positivo();
	}
	
	public void deposita(double montante) {
		estado.depositar(this, montante);
	}
	
	public void sacar(double montante) {
		estado.sacar(this, montante);
	}

	public String getNome() {
		return nome;
	}

	public double getNumero() {
		return numero;
	}

	public double getAgencia() {
		return agencia;
	}

	public double getSaldo() {
		return saldo;
	}

	public Calendar getDataAbertura() {
		return dataAbertura;
	}
	
}
