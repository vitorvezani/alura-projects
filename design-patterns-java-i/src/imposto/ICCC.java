package imposto;
/**
  * @author vitor
 *
 */
public class ICCC implements Imposto {
	/**
	 * Retorna 5% do valor total caso o orçamento seja menor do que R$ 1000,00 reais, 
	 * 7% caso o valor esteja entre R$ 1000 e R$ 3000,00 com os limites inclusos,
	 *  ou 8% mais 30 reais, caso o valor esteja acima de R$ 3000,00
	 */
	@Override
	public double calcula(Orcamento orcamento) {
		double valor = orcamento.getValor();
		
		if(orcamento.getValor() < 1000) {
			valor *= 0.05;
		} else if (orcamento.getValor() < 3000) {
			valor *= 0.08;
		} else {
			valor = valor * 0.08 + 30;
		}
		return valor;
	}

}
