package br.com.caelum;

import java.util.Enumeration;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;

public class TesteBrowser {

  public static void main(String[] args) throws Exception {

    InitialContext context = new InitialContext();

    ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
    Connection conn = factory.createConnection();
    conn.start();

    Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);

    Destination dest = (Destination) context.lookup("fila.financeiro");
    QueueBrowser browser = session.createBrowser((Queue) dest);

    Enumeration<TextMessage> msgs = browser.getEnumeration();
    while (msgs.hasMoreElements()) {
        TextMessage msg = msgs.nextElement();
        System.out.println("Message: " + msg.getText());
    }

    browser.close();
    session.close();
    conn.close();
    context.close();
  }

}
