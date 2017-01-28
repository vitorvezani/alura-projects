package requisicao;

import investimento.Conta;

public class TratadorDeRequisicao {

	private Resposta csv;
	private Resposta portento;
	private Resposta xml;

	public TratadorDeRequisicao() {
		xml = new RespostaXML(semResposta());
		portento = new RespostaPorcent(xml);
		csv = new RespostaCSV(portento);
	}

	public void trata(Requisicao req, Conta conta) {
		csv.responde(req, conta);
	}
	
	private Resposta semResposta() {
		return new Resposta() {
			
			@Override
			public void responde(Requisicao req, Conta conta) {
				System.out.println("Requisicao sem tratador");
			}
		};
	}
	
}
