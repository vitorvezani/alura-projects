package com.solid.java.ocp_dip;

public class CalculadoraDePrecos {

	private TabelaDePreco tabela;
	private ServicoDeEntrega frete;

	public CalculadoraDePrecos(TabelaDePreco tabela, ServicoDeEntrega frete) {
		this.frete = frete;
		this.tabela = tabela;
	}

	public double calcula(Compra produto) {

		double desconto = tabela.descontoPara(produto.getValor());
		double preco = frete.para(produto.getCidade());

		return produto.getValor() * (1 - desconto) + preco;
	}

}
