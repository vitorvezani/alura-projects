package br.com.alura.threads.cap4;

public class TarefaAdicionarElementos implements Runnable {

	private Lista lista;
	private int threadId;

	public TarefaAdicionarElementos(Lista lista, int threadId) {
		this.lista = lista;
		this.threadId = threadId;
	}

	@Override
	public void run() {
    for (int i = 0; i < 10; i++) {
      lista.adicionaElementos("Thread " + threadId + " - " + i);
  }
	}

}
