package com.solid.java.liskov;

public class ContaComum {

	private ManipuladorDeSaldo m;

	public ContaComum() {
		this.m = new ManipuladorDeSaldo();
	}

	public void deposita(double valor) {
		m.deposita(valor);
	}

	public void saca(double valor) {
		m.saca(valor);
	}

	public void rende() {
		m.rende();
	}

	public double getSaldo() {
		return m.getSaldo();
	}

}
