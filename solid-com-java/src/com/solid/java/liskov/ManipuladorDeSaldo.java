package com.solid.java.liskov;

public class ManipuladorDeSaldo {
	
	protected double saldo = 0d;
	
	public void deposita(double valor) {
		this.saldo += valor;
	}

	public void saca(double valor) {
		if (valor <= this.saldo) {
			this.saldo -= valor;
		} else {
			throw new IllegalArgumentException();
		}
	}

	public void rende() {
		this.saldo += this.saldo * 0.01;
	}

	public double getSaldo() {
		return saldo;
	}
	
}
