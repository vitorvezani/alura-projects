package com.solid.java.srp;

public enum Cargo {
	DESENVOLVEDOR(new DezOuVintePorCento()), DBA(new DezOuVintePorCento()), TESTER(new QuinzeOuVinteECincoPorCento());

	RegraDeCalculo regra;

	Cargo(RegraDeCalculo regra) {
		this.regra = regra;
	}

	public RegraDeCalculo getRegra() {
		return regra;
	}
}
