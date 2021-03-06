package requisicao;

import investimento.Conta;
import requisicao.Requisicao.Formato;

public class RespostaCSV implements Resposta {

	private Resposta resposta;

	
	
	public RespostaCSV(Resposta resposta) {
		this.resposta = resposta;
	}
	
	@Override
	public void responde(Requisicao req, Conta conta) {
		if(req.getFormato().equals(Formato.CSV)) {
			System.out.println("Requisicao tratada no formato CSV -> " + req.getFormato());
		} else {
			resposta.responde(req, conta);
		}
	}

}
