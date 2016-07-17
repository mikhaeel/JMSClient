package info.everybodylies.producer;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by mike on 12.07.16.
 */
public class MyMessageProducer
{
    public void produceMessage(int i) throws Exception
    {
        //Create a connection factory
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
        // Create a connection
        Connection connection = connectionFactory.createConnection();
        connection.start();

        //Create session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        //Create destination
        Destination destination = session.createQueue("foo.bar");

        // Create a MessageProducer from the Sessi  on to the Topic or Queue
        MessageProducer producer = session.createProducer(destination);
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

        // Create a messages
        String text = "Hello world! From: " + i;
        TextMessage message = session.createTextMessage(text);

        // Tell the producer to send the message
        System.out.println("Sent message: "+ text);
        producer.send(message);

        // Clean up
        session.close();
        connection.close();
    }
}
