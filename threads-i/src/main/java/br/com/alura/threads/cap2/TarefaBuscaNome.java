package br.com.alura.threads.cap2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TarefaBuscaNome implements Runnable {

	private String nomeArquivo;
	private String nome;

	public TarefaBuscaNome(String nomeArquivo, String nome) {
		this.nomeArquivo = nomeArquivo.toLowerCase();
		this.nome = nome.toLowerCase();
	}

	@Override
	public void run() {
		try (Scanner scanner = new Scanner(new File(nomeArquivo))) {
			
			int numeroLinha = 1;
			
			while (scanner.hasNextLine()) {
				String linha = scanner.nextLine().toLowerCase();
				if (linha.contains(nome)) {
					System.out.println(nomeArquivo + " - " + numeroLinha + " - " + linha);
				}
				numeroLinha++;
			}
			
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

}
