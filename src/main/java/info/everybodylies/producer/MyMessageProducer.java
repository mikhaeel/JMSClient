package info.everybodylies.producer;

import info.everybodylies.consumer.MyMessageConsumer;
import info.everybodylies.jmsconnector.JMSConsumer;
import info.everybodylies.jmsconnector.JMSProducer;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by mike on 12.07.16.
 */
public class MyMessageProducer
{
    String queueName;

    public MyMessageProducer(String queueName) {
        this.queueName = queueName;
    }

    public void produceMessage(String message) throws JMSException
    {
        try(JMSProducer jmsProducer = new JMSProducer("foo.bar")) {
            MessageProducer messageProducer = jmsProducer.getMessageProducer();
            // Create a messages
            TextMessage textMessage = jmsProducer.getTextMessage("Best regards to Broad Street");
            // Tell the producer to send the message
            System.out.println("Sent message: "+ message);
            messageProducer.send(textMessage);
        }
    }
}
