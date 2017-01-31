package imposto.templateMethod;

import imposto.Imposto;
import imposto.Orcamento;

public class ICPP extends TemplateDeImpostoCondicional {
	
	public ICPP() {
		super();
	}
	
	public ICPP(Imposto outroImposto) {
		super(outroImposto);
	}
	
  @Override
	public boolean deveUsarMaximaTaxacao(Orcamento orcamento) {
    return orcamento.getValor() > 500;
  }
  
  @Override
	public double maximaTaxacao(Orcamento orcamento) { 
    return orcamento.getValor() * 0.07 + calculoDoOutroImposto(orcamento);
  }
  
  @Override
	public double minimaTaxacao(Orcamento orcamento) {
    return orcamento.getValor() * 0.05 + calculoDoOutroImposto(orcamento);
  }

}
