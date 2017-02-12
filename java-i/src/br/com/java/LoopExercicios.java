package br.com.java;

public class LoopExercicios {
	public static void main(String[] args) {
		whileExercice();

		sumUntil1000();

		printOnlyDivisibleBy3(100);

		factorial(30);
	}

	private static void factorial(int num) {
		int fatorial = 1;
		for (int i = 1; i < num; i++) {
			fatorial *= i;
		}
		System.out.println("O fatorial é " + fatorial);
	}

	private static void printOnlyDivisibleBy3(int i) {
		for (int j = 3; j <= i; j = j + 3) {
			System.out.println(j);
		}
	}

	private static void whileExercice() {
		int i = 150;

		while (i <= 300) {
			System.out.println(i);
			i++;
		}
	}

	private static void sumUntil1000() {
		int soma = 0;
		for (int j = 0; j <= 1000; j++) {
			soma += j;
		}
		System.out.println("A soma é " + soma);
	}
}
