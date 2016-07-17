package info.everybodylies;


import info.everybodylies.consumer.MyMessageConsumer;
import info.everybodylies.producer.MyMessageProducer;

/**
 * Created by mike on 11.07.16.
 */
public class JmsClient
{
    public static void main(String[] args)
    {
        try {
            for (int i = 0; i < 100; i++) {
                new MyMessageProducer().produceMessage(i);
                Thread.sleep(100);
                new MyMessageConsumer().consumeMessage();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
