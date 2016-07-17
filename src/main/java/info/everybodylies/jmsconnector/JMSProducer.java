package info.everybodylies.jmsconnector;

import javax.jms.JMSException;
import javax.jms.MessageProducer;

/**
 * Created by mike on 17.07.16.
 */
public class JMSProducer extends JMSConnection
{
    public JMSProducer(String queueName) throws JMSException
    {
        super(queueName);
    }

    public MessageProducer getMessageProducer() throws JMSException
    {
        return getSession().createProducer(getDestination());
    }
}
