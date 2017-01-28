package imposto.templateMethod;

import java.util.ArrayList;
import java.util.List;

import imposto.Item;
import imposto.Orcamento;

public class IHIT extends TemplateDeImpostoCondicional {

	@Override
	protected boolean deveUsarMaximaTaxacao(Orcamento orcamento) {
    List<String> noOrcamento = new ArrayList<String>();

    for(Item item : orcamento.getItens()) {
      if(noOrcamento.contains(item.getNome())) return true;
      else noOrcamento.add(item.getNome());
    }

    return false;
	}

	@Override
	protected double maximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 13 / 100 + 100;
	}

	@Override
	protected double minimaTaxacao(Orcamento orcamento) {
		return 1 / 100 * orcamento.getItens().size();
	}

}
