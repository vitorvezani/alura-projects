package br.com.caelum;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;

public class TesteProdutor {

  public static void main(String[] args) throws Exception {

    InitialContext context = new InitialContext();

    ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
    Connection conn = factory.createConnection();
    conn.start();

    Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);

    Destination dest = (Destination) context.lookup("fila.financeiro");
    MessageProducer producer = session.createProducer(dest);

    TextMessage message = session.createTextMessage("Esta é uma mensagem de texto");
    producer.send(message);

    producer.close();
    session.close();
    conn.close();
    context.close();
  }

}
