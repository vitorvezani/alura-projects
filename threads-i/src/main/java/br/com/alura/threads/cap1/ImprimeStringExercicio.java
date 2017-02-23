package br.com.alura.threads.cap1;

public class ImprimeStringExercicio {
	public static void main(String[] args) {
		new Thread(() -> System.out.println("Estamos na thread " + Thread.currentThread().getName()), "ImprimeString").start();
	}
}
