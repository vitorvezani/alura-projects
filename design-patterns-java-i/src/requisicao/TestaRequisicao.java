package requisicao;

import investimento.Conta;
import requisicao.Requisicao.Formato;

public class TestaRequisicao {
	
	public static void main(String[] args) {
		Requisicao reqXML = new Requisicao(Formato.XML);
		Requisicao reqCSV = new Requisicao(Formato.CSV);
		Requisicao reqPorcento = new Requisicao(Formato.PORCENTO);
		Requisicao reqOther = new Requisicao(Formato.OTHER);
		Conta conta = new Conta("Vitor");
		
		TratadorDeRequisicao tratDeReq = new TratadorDeRequisicao();
		
		tratDeReq.trata(reqXML, conta);
		tratDeReq.trata(reqPorcento, conta);
		tratDeReq.trata(reqCSV, conta);
		tratDeReq.trata(reqOther, conta);
		
	}
	
}
