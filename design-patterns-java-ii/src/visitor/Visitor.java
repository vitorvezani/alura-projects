package visitor;

import interpreter.Divisao;
import interpreter.Multiplicacao;
import interpreter.Numero;
import interpreter.Soma;
import interpreter.Subtracao;

public interface Visitor {

	void visitaSoma(Soma soma);

	void visitaSubtracao(Subtracao subtracao);

	void visitaNumero(Numero numero);

	void visitaMultiplicacao(Multiplicacao multiplicacao);

	void visitaDivisao(Divisao divisao);

}