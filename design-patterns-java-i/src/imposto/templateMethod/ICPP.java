package imposto.templateMethod;

import imposto.Orcamento;

public class ICPP extends TemplateDeImpostoCondicional {

  public boolean deveUsarMaximaTaxacao(Orcamento orcamento) {
    return orcamento.getValor() > 500;
  }
  public double maximaTaxacao(Orcamento orcamento) { 
    return orcamento.getValor() * 0.07;
  }
  public double minimaTaxacao(Orcamento orcamento) {
    return orcamento.getValor() * 0.05;
  }

}
