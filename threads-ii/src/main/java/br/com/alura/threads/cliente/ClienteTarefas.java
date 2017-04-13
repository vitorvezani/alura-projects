package br.com.alura.threads.cliente;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTarefas {
  private static final class EnviaComandoTask implements Runnable {
    private Socket socket;

    public EnviaComandoTask(Socket socket) {
      this.socket = socket;
    }

    @Override
    public void run() {
      try {
        System.out.println("Pode enviar comandos!");
        PrintStream saida = new PrintStream(socket.getOutputStream());

        Scanner teclado = new Scanner(System.in);
        while (teclado.hasNextLine()) {

          String linha = teclado.nextLine();

          if (linha.trim().equals("")) {
            break;
          }

          saida.println(linha);
        }
        saida.close();
        teclado.close();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
  }

  private static final class RecebeRespostaTask implements Runnable {
    private Socket socket;

    public RecebeRespostaTask(Socket socket) {
      this.socket = socket;
    }

    @Override
    public void run() {
      try {
        System.out.println("Recebendo dados do servidor");
        Scanner respostaServidor = new Scanner(socket.getInputStream());
        while (respostaServidor.hasNextLine()) {
          String linha = respostaServidor.nextLine();
          System.out.println(linha);
        }

        respostaServidor.close();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
  }

  public static void main(String[] args) throws IOException, InterruptedException {
    Socket socket = new Socket("localhost", 12345);
    System.out.println("Conexão Estabelecida");

    Thread threadEnviaComando = new Thread(new EnviaComandoTask(socket));
    Thread threadRecebeResposta = new Thread(new RecebeRespostaTask(socket));

    threadRecebeResposta.start();
    threadEnviaComando.start();

    threadEnviaComando.join();

    System.out.println("Fechando o socket do cliente");
    socket.close();
  }

}
