import constants.EmailType;
import javax.jms.JMSException;
import model.Email;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import queueconsumer.MailQueueReceiver;
import queueproducer.MailQueueSender;

@Ignore
public class MailQueueSenderTest {

  private MailQueueSender mailQueueSender;

  private MailQueueReceiver mailQueueReceiver;


  @Test
  @Ignore
  public void checkQueueSend() throws JMSException {
    MailQueueSender mailQueueSender = new MailQueueSender();
    Email email = new Email.Builder()
        .setSender("Guru")
        .setReceiver("Monisha")
        .setEmailType(EmailType.SUBSCRIPTION)
        .build();
    mailQueueSender.sendToQueue(email,"emailqueue");
  }

  @Test
  //@Ignore
  public void checkQueueReceive() throws JMSException {
    MailQueueReceiver mailQueueReceiver = new MailQueueReceiver();
    mailQueueReceiver.receiveFromQueue("emailqueue");
  }
}
