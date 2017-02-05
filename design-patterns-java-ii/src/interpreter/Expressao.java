package interpreter;

import visitor.Visitor;

public interface Expressao {

	int avalia();

	void aceita(Visitor visitor);

}
