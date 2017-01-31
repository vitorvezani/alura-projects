package investimento;

import java.util.Calendar;

public class Conta {

	private String nome;
	private double numero;
	private double agencia;
	private double saldo;
	private Calendar dataAbertura;
	
	public Conta(String nome) {
		this.nome = nome;
	}
	
	public void deposita(double montante) {
		this.saldo += montante;
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
