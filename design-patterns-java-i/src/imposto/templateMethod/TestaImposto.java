package imposto.templateMethod;

import imposto.Imposto;
import imposto.Orcamento;

public class TestaImposto {
	
	public static void main(String[] args) {
		Imposto icpp = new ICPP();
		Imposto ikcv = new IKCV();
		
		System.out.println(icpp.calcula(new Orcamento(1000)));
		System.out.println(ikcv.calcula(new Orcamento(1000)));
		
	}
	
}
