package info.everybodylies.jmsconnector;

import org.w3c.dom.Text;

import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.TextMessage;

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
        MessageProducer mp = getSession().createProducer(getDestination());
        mp.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        return mp;
    }
    public TextMessage getTextMessage(String message) throws JMSException {
        return getSession().createTextMessage(message);
    }
}