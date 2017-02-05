package interpreter;

import visitor.Visitor;

public class Multiplicacao implements Expressao {

	private Expressao esquerda;
	private Expressao direita;

	public Multiplicacao(Expressao esquerda, Expressao direita) {
		this.esquerda = esquerda;
		this.direita = direita;
	}

	@Override
	public int avalia() {
		return esquerda.avalia() * direita.avalia();
	}

	@Override
	public void aceita(Visitor impressoraVisitor) {
		impressoraVisitor.visitaMultiplicacao(this);
	}

}
