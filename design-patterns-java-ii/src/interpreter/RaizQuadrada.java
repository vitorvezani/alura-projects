package interpreter;

import visitor.Visitor;

public class RaizQuadrada implements Expressao {

	private Numero numero;

	public RaizQuadrada(Numero numero) {
		this.numero = numero;
	}

	@Override
	public int avalia() {
		return (int) Math.sqrt(numero.avalia());
	}

	@Override
	public void aceita(Visitor impressoraVisitor) {
		// TODO Auto-generated method stub
		
	}

}
