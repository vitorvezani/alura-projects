package imposto.templateMethod;

import imposto.Imposto;
import imposto.Orcamento;

public class IKCV extends TemplateDeImpostoCondicional {

	public IKCV() {
		super();
	}

	public IKCV(Imposto outroImposto) {
		super(outroImposto);
	}

	@Override
	public boolean deveUsarMaximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() > 500 && temItemMaiorQue100ReaisNo(orcamento);
	}

	@Override
	public double maximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.10;
	}

	@Override
	public double minimaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.06;
	}

	private boolean temItemMaiorQue100ReaisNo(Orcamento orcamento) {
		return orcamento.getItens().stream().filter(item -> item.getValor() > 100).findFirst().isPresent();
	}

}
