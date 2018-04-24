package br.com.caelum;

import java.util.Scanner;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;

public class TesteConsumidor {

  public static void main(String[] args) throws Exception {

    InitialContext context = new InitialContext();

    ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
    Connection conn = factory.createConnection();
    conn.start();

    Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);

    Destination dest = (Destination) context.lookup("fila.financeiro");
    MessageConsumer consumer = session.createConsumer(dest);

    consumer.setMessageListener(msg -> {
      TextMessage textMsg = (TextMessage) msg;
      try {
        System.out.println(textMsg.getText());
      } catch (JMSException e) {
        e.printStackTrace();
      }
    });

    new Scanner(System.in).nextLine();

    consumer.close();
    session.close();
    conn.close();
    context.close();
  }

}
