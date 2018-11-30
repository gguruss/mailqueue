import constants.EmailType;
import javax.jms.JMSException;
import model.Email;
import queueconsumer.MailQueueReceiver;
import queueproducer.MailQueueSender;

public class MailQueueDriver {

  public static void main(String[] args) throws JMSException {
    MailQueueSender mailQueueSender = new MailQueueSender();
    Email email = new Email.Builder()
        .setSender("romeo")
        .setReceiver("julieto")
        .setEmailType(EmailType.SUBSCRIPTION)
        .build();
    mailQueueSender.sendToQueue(email,"emailqueue");

    MailQueueReceiver mailQueueReceiver = new MailQueueReceiver();
    mailQueueReceiver.receiveFromQueue("emailqueue");
  }
}
