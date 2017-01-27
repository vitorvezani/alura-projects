package imposto;

public class Item {

	private String descricao;
	private double valor;

	public Item(String descricao, double valor) {
		this.descricao = descricao;
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public double getValor() {
		return valor;
	}

}
