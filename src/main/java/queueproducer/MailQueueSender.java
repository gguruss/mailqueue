package queueproducer;

import com.google.gson.Gson;
import java.io.Serializable;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import model.Email;
import org.apache.activemq.ActiveMQConnectionFactory;

public class MailQueueSender {

  private Session session;

  private Connection connection;

  private MessageProducer messageProducer;

  private Queue queue;

  /**
   * @param message object to send to receiver
   * @param queueName name of the queue
   */
  public void sendToQueue(final Email message, final String queueName)
      throws JMSException {
    ConnectionFactory connectionFactory =
        new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_BROKER_URL);

    connection = connectionFactory.createConnection();

    session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
    queue = session.createQueue(queueName);
    messageProducer = session.createProducer(queue);

    connection.start();

    TextMessage msg= buildMessage(message);
    messageProducer.send(msg);
    connection.close();
  }

  private TextMessage buildMessage(final Email message) throws JMSException {
    Gson gson = new Gson();
    String msg = gson.toJson(message);
    TextMessage textMessage = session.createTextMessage(msg);
    return textMessage;
  }
}
