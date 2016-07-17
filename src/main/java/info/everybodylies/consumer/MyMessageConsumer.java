package info.everybodylies.consumer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

/**
 * Created by mike on 17.07.16.
 */
public class MyMessageConsumer
{
    public void consumeMessage()
    {
        try(ConsumerConnection consumerConnection = new ConsumerConnection()) {
            consumerConnection.connect();
            Message message = consumerConnection.getMessage(1000);
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