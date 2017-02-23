package br.com.alura.threads.cap2;

public class Principal {
	public static void main(String[] args) {
		String nomeProcurado = "da";

		new Thread(new TarefaBuscaNome("autores.txt", nomeProcurado)).start();
		new Thread(new TarefaBuscaNome("assinaturas1.txt", nomeProcurado)).start();
		new Thread(new TarefaBuscaNome("assinaturas2.txt", nomeProcurado)).start();
	}
}
