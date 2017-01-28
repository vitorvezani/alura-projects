package requisicao;

import investimento.Conta;

interface Resposta {
	void responde(Requisicao req, Conta conta);
}