package com.solid.java.encapsulamento;

import java.util.List;

import com.solid.java.encapsulamento.Pagamento.MeioDePagamento;

public class ProcessadorDeBoletos {
	public void processa(List<Boleto> boletos, Fatura fatura) {

		for (Boleto boleto : boletos) {
			Pagamento pagamento = new Pagamento(boleto.getValor(), MeioDePagamento.BOLETO);
			fatura.adicionaPagamento(pagamento);
		}
	}
}
