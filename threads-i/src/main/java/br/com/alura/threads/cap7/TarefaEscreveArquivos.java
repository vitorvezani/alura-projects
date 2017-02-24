package br.com.alura.threads.cap7;

import java.io.File;

public class TarefaEscreveArquivos implements Runnable {

	private File arquivo1;
	private File arquivo2;

	public TarefaEscreveArquivos(File arquivo1, File arquivo2) {
		this.arquivo1 = arquivo1;
		this.arquivo2 = arquivo2;
	}

	@Override
	public void run() {
		synchronized (arquivo2) {
			System.out.println(Thread.currentThread().getName() + " - Adiquirindo chave do arquivo2");				
			synchronized (arquivo1) {
				System.out.println(Thread.currentThread().getName() + " - Adiquirindo chave do arquivo1");
			}
		}
	}

}
