package br.com.alura.threads.cap7;

import java.io.File;

public class Deadlock {

	public static File arquivo1 = new File("arquivo1.txt");
	public static File arquivo2 = new File("arquivo2.txt");

	public static void main(String[] args) {

		new Thread(new TarefaEscreveArquivos(arquivo1, arquivo2), "TarefaEscreveArquivos").start();
		new Thread(new TarefaLeArquivos(arquivo1, arquivo2), "TarefaLeArquivos").start();

	}
}
