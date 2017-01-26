package br.com.caelum.leilao.servico;

public class AnoBissexto {

	/**
	 * Um ano bissexto é aquele que tem 366 dias. Para saber se um ano é bissexto, devemos seguir as regras abaixo:
	 * 	- De 4 em 4 anos é ano bissexto.
	 *  - De 100 em 100 anos NÃO é ano bissexto.
	 *  - De 400 em 400 anos é ano bissexto.
	 *  - Prevalecem as últimas regras sobre as primeiras.
	 */
	boolean ehBissexto(int ano) {
		if(ano % 400 == 0) return true;
		if(ano % 100 == 0) return false;
		if(ano % 4 == 0) return true;
		return false;
	}

}
