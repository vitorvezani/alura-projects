package com.solid.java.liskov;

public class ContaDeEstudante {

	private int milhas;
	private ManipuladorDeSaldo m;

	public ContaDeEstudante() {
		this.m = new ManipuladorDeSaldo();
	}

	public void deposita(double valor) {
		m.deposita(valor);
		this.milhas += (int) valor;
	}

	public int getMilhas() {
		return milhas;
	}

}
