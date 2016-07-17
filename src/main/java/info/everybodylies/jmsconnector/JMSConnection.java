package info.everybodylies.jmsconnector;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Session;

/**
 * Created by mike on 17.07.16.
 */
public class JMSConnection implements AutoCloseable

{
    private Session session;
    private Connection connection;

    private Destination destination;

    JMSConnection(String queueName) throws JMSException
    {
        if (queueName == null)
            throw new IllegalArgumentException("queueName must not be null");

        // Create a ConnectionFactory
        ActiveMQConnectionFactory connectionFactory =
                new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);

        // Create a Connection
        connection = connectionFactory.createConnection();
        connection.start();

        // Create a Session
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // Create the destination (Topic or Queue)
        destination = session.createQueue(queueName);
    }

    @Override
    public void close() throws JMSException
    {
        if (session != null)
            session.close();

        if (connection != null)
            connection.close();
    }

    Session getSession()
    {
        return session;
    }

    Destination getDestination()
    {
        return destination;
    }
}
