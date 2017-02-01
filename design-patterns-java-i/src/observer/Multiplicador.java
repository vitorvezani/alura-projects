package observer;

import builder.NotaFiscal;

public class Multiplicador implements AcaoAposGerarNota {

	private double factor;

	public Multiplicador(double factor) {
		this.factor = factor;
	}
	
	@Override
	public void executa(NotaFiscal notaFiscal) {
		System.out.println("nf foi multiplicada para " + notaFiscal.getValorBruto() * factor);
	}

}
