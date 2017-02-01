package observer;

import builder.NotaFiscal;

public class EnviadorDeSms implements AcaoAposGerarNota {

	@Override
	public void executa(NotaFiscal notaFiscal) {
		System.out.println("enviando por sms");
	}

}
