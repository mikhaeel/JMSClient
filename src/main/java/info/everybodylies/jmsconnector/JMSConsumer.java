package info.everybodylies.jmsconnector;

import javax.jms.JMSException;
import javax.jms.MessageConsumer;

/**
 * Created by mike on 17.07.16.
 */
public class JMSConsumer extends JMSConnection
{
    public JMSConsumer(String queueName) throws JMSException
    {
        super(queueName);
    }

    public MessageConsumer getMessageConsumer() throws JMSException
    {
        return getSession().createConsumer(getDestination());
    }
}