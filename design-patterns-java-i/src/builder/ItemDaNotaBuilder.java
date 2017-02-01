package builder;

import imposto.Item;

public class ItemDaNotaBuilder {

	private String nome;
	private double valor;

	public ItemDaNotaBuilder comNome(String nome) {
		this.nome = nome;
		return this;
	}

	public ItemDaNotaBuilder comValor(double valor) {
		this.valor = valor;
		return this;
	}

	public Item build() {
		return new Item(nome, valor);
	}
	
}
