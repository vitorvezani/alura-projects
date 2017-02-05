package interpreter;

public class RaizQuadrada implements Expressao {

	private Numero numero;

	public RaizQuadrada(Numero numero) {
		this.numero = numero;
	}

	@Override
	public int avalia() {
		return (int) Math.sqrt(numero.avalia());
	}

}
