package requisicao;

import investimento.Conta;
import requisicao.Requisicao.Formato;

public class RespostaXML implements Resposta {

	private Resposta resposta;

	@Override
	public void responde(Requisicao req, Conta conta) {
		if(req.getFormato().equals(Formato.XML)) {
			System.out.println("Requisicao tratada no formato XML -> " + req.getFormato());
		} else {
			resposta.responde(req, conta);
		}
	}

	@Override
	public void setProxima(Resposta resposta) {
		this.resposta = resposta;
	}

}
