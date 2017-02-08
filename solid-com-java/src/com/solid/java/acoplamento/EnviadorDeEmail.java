package com.solid.java.acoplamento;

public class EnviadorDeEmail implements AcaoAposGerarNotaFiscal {

	@Override
	public void executa(NotaFiscal nf) {
		System.out.println("envia nf por email");
	}

}
