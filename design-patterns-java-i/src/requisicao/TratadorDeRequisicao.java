package requisicao;

import investimento.Conta;

public class TratadorDeRequisicao {

	private Resposta csv;
	private Resposta portento;
	private Resposta xml;

	public TratadorDeRequisicao() {
		csv = new RespostaCSV();
		portento = new RespostaPorcent();
		xml = new RespostaXML();
		
		insereOrder();
		
	}
	
	private void insereOrder() {
		csv.setProxima(portento);
		portento.setProxima(xml);
		xml.setProxima(semResposta());
	}

	private Resposta semResposta() {
		return new Resposta() {
			
			@Override
			public void setProxima(Resposta resposta) {
			}
			
			@Override
			public void responde(Requisicao req, Conta conta) {
				System.out.println("Requisicao sem tratador");
			}
		};
	}

	public void trata(Requisicao req, Conta conta) {
		csv.responde(req, conta);
	}
	
}
