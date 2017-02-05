package interpreter;

public class Programa {
	public static void main(String[] args) {

		Expressao esquerda = new Multiplicacao(new Numero(10), new Numero(5));
		Expressao direita = new RaizQuadrada(new Numero(2));

		Expressao conta = new Soma(esquerda, direita);

		int resultado = conta.avalia();
		System.out.println(resultado);
	}

}
