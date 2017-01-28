package requisicao;

import investimento.Conta;
import requisicao.Requisicao.Formato;

public class RespostaPorcent implements Resposta {

	private Resposta resposta;
	
	public RespostaPorcent(Resposta resposta) {
		this.resposta = resposta;
	}
	
	@Override
	public void responde(Requisicao req, Conta conta) {
		if(req.getFormato().equals(Formato.PORCENTO)) {
			System.out.println("Requisicao tratada no formato PORCENTO -> " + req.getFormato());
		} else {
			resposta.responde(req, conta);
		}
	}

}
