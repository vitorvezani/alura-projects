package br.com.alura.threads.cliente;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class ClienteTarefasMultiplos {

  private static List<Thread> threads = new ArrayList<>();

  public static void main(String[] args) throws IOException, InterruptedException {

    for (int i = 0; i < 10; i++) {
      Thread.sleep(1000);
      Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
          try {
            doWork();
          } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            new RuntimeException(e);
          }
        }
      });
      thread.start();
      threads.add(thread);
    }

    for (Thread t : threads) {
      t.join();
    }

  }

  protected static void doWork() throws UnknownHostException, IOException, InterruptedException {
    Socket socket = new Socket("localhost", 12345);
    System.out.println("Conexão Estabelecida");

    PrintStream saida = new PrintStream(socket.getOutputStream());
    saida.println("c1");

    Thread.sleep(5000);

    saida.close();
    socket.close();
  }
}
