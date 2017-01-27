package imposto;

public class DescontoPorVendaCasada implements Desconto {

	private Desconto proximo;

	@Override
	public double desconta(Orcamento orcamento) {
    if(orcamento.possui("LAPIS") && orcamento.possui("CANETA")) {
      return orcamento.getValor() * 0.5/100;
    }
    else {
      return proximo.desconta(orcamento);
    }
	}

	@Override
	public void setProximo(Desconto proximo) {
		this.proximo = proximo;
	}

}
