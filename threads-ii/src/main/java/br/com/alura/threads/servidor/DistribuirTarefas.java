package br.com.alura.threads.servidor;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class DistribuirTarefas implements Runnable {

  private Socket socket;
  private ServidorTarefas servidorTarefas;

  public DistribuirTarefas(Socket socket, ServidorTarefas servidorTarefas) {
    this.socket = socket;
    this.servidorTarefas = servidorTarefas;
  }

  @Override
  public void run() {
    try {
      System.out.println("Distribuindo as tarefas para o cliente " + socket);
      Scanner entradaCliente = new Scanner(socket.getInputStream());
      PrintStream saidaCliente = new PrintStream(socket.getOutputStream());

      while (entradaCliente.hasNextLine()) {
        String comando = entradaCliente.nextLine();
        System.out.println("Comando recebido " + comando);

        switch (comando) {
          case "c1":
            // confirmação do o cliente
            saidaCliente.println("Confirmação do comando c1");
            break;
          case "c2":
            saidaCliente.println("Confirmação do comando c2");
            break;
          case "stop":
            servidorTarefas.parar();
            break;
          default:
            saidaCliente.println("Comando " + comando + " não encontrado");
        }

        System.out.println(comando);
      }

      entradaCliente.close();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

}
