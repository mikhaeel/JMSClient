package info.everybodylies.consumer;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.Closeable;

import javax.jms.*;

/**
 * Created by mike on 17.07.16.
 */
public class ConsumerConnection implements AutoCloseable
{
    MessageConsumer consumer;
    Session session;
    Connection connection;
    Destination destination;
    ActiveMQConnectionFactory connectionFactory;

    public void connect() throws JMSException
    {
        // Create a ConnectionFactory
        connectionFactory = new ActiveMQConnectionFactory("vm://localhost");

        // Create a Connection
        connection = connectionFactory.createConnection();
        connection.start();

        // Create a Session
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // Create the destination (Topic or Queue)
        destination = session.createQueue("foo.bar");

        // Create a MessageConsumer from the Session to the Topic or Queue
        consumer = session.createConsumer(destination);
    }

    public Message getMessage(int timeout) throws JMSException
    {
        if (timeout <= 0)
            timeout = 1000;

        // Wait for a message
        return consumer.receive(timeout);
    }

    public void close() throws JMSException
    {
        if (consumer != null)
            consumer.close();

        if (session != null)
            session.close();

        if (connection != null)
            connection.close();
    }
}
