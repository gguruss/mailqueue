package queueconsumer;

import com.google.gson.Gson;
import java.io.Serializable;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import model.Email;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQObjectMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MailQueueReceiver {

  private static final Logger LOGGER = LoggerFactory.getLogger(MailQueueReceiver.class);

  private Session session;

  private Connection connection;

  private MessageConsumer messageConsumer;

  private Queue queue;

  /**
   * @param queueName name of the queue
   */
  public void receiveFromQueue(final String queueName)
      throws JMSException {
    ConnectionFactory connectionFactory =
        new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_BROKER_URL);

    connection = connectionFactory.createConnection();

    session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
    connection.start();
    queue = session.createQueue(queueName);
    messageConsumer = session.createConsumer(queue);



    Message msg = messageConsumer.receive();
    TextMessage txtMsg = (TextMessage) msg;
    Gson gson = new Gson();
    Email email= gson.fromJson(txtMsg.getText(),Email.class);
    LOGGER.info(String.valueOf(email.getEmailType()));
    connection.close();
  }
}
