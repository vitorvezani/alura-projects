package br.com.alura.threads.cap4;

public class Lista {
	private String[] elementos = new String[1000];
	private int indice = 0;

	public synchronized void adicionaElementos(String elemento) {
		this.elementos[indice] = elemento;
		this.indice++;
	}

	public int tamanho() {
		return this.indice;
	}

	public String pegaElemento(int posicao) {
		return this.elementos[posicao];
	}

}
