package interpreter;

import visitor.Visitor;

public class Numero implements Expressao {

	private int num;

	public Numero(int num) {
		this.num = num;
	}

	@Override
	public int avalia() {
		return num;
	}

	public int getNumero() {
		return num;
	}

	@Override
	public void aceita(Visitor impressoraVisitor) {
		impressoraVisitor.visitaNumero(this);
	}

}
