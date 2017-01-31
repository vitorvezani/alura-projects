package imposto.decorator;

import imposto.ICMS;
import imposto.ISS;
import imposto.Imposto;
import imposto.Orcamento;

public class TestaImpostos {

	public static void main(String[] args) {
    Imposto impostoComplexo = new ISS(new ICMS(new ImpostoMuitoAlto()));

    Orcamento orcamento = new Orcamento(1000.0);

    double valor = impostoComplexo.calcula(orcamento);

    System.out.println(valor);
	}
	
}
