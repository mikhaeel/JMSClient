package info.everybodylies.consumer;

import info.everybodylies.jmsconnector.JMSConsumer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.TextMessage;

/**
 * Created by mike on 17.07.16.
 */
public class MyMessageConsumer
{
    String queueName;
    public MyMessageConsumer(String queueName) throws JMSException {
        this.queueName = queueName;
    }

    public void consumeMessage(int timeout) throws JMSException
    {
        try {
            JMSConsumer jmsConsumer = new JMSConsumer("foo.bar");
            MessageConsumer messageConsumer = jmsConsumer.getMessageConsumer();
            Message message = messageConsumer.receive(timeout);
            if (message instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) message;
                String text = textMessage.getText();
                System.out.println("Received: " + text);
            } else {
                System.out.println("Received: " + message);
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}