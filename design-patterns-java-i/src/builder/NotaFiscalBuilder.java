package builder;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import imposto.Item;

public class NotaFiscalBuilder {
	private String razaoSocial;
	private String cnpj;
	private double impostos;
	private Calendar dataEmissao = Calendar.getInstance();
	private String observacoes;
	private double valorBruto;

	private List<Item> itens = new ArrayList<Item>();

	public NotaFiscalBuilder paraEmpresa(String razaoSocial) {
		this.razaoSocial = razaoSocial;
		return this; // retorno eu mesmo, o próprio builder, para que o cliente
		             // continue utilizando
	}

	public NotaFiscalBuilder comCnpj(String cnpj) {
		this.cnpj = cnpj;
		return this;
	}

	public NotaFiscalBuilder comItem(Item item) {
		itens.add(item);
		valorBruto += item.getValor();
		impostos += item.getValor() * 0.05;
		return this;
	}

	public NotaFiscalBuilder comObservacoes(String observacoes) {
		this.observacoes = observacoes;
		return this;
	}

	public NotaFiscalBuilder naData(Calendar cal) {
		dataEmissao = cal;
		return this;
	}

	public NotaFiscal build() {
		return new NotaFiscal(razaoSocial, cnpj, dataEmissao, valorBruto, impostos, itens, observacoes);
	}

}
