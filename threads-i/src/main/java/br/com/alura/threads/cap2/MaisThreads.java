package br.com.alura.threads.cap2;

public class MaisThreads {
	public static void main(String[] args) {
		new Thread(task()).start();
		new Thread(task()).start();
	}

	private static Runnable task() {
		return new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println(Thread.currentThread().getId() + " - " + i);
				}
			}
		};
	}
}
