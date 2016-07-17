package info.everybodylies;


import info.everybodylies.consumer.MyMessageConsumer;
import info.everybodylies.producer.MyMessageProducer;

import javax.jms.JMSException;
import javax.sound.midi.SysexMessage;

/**
 * Created by mike on 11.07.16.
 */
public class JmsClient
{
    public static void main(String[] args)
    {
        try {
            long start = System.currentTimeMillis();
            for (int i = 0; i < 100; i++)
                new MyMessageProducer("foo.bar").produceMessage(String.valueOf(i));
            long end = System.currentTimeMillis();
            System.out.println("Producer ran 100 times takes " + (end - start) + "msec" );
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            start = System.currentTimeMillis();
            for (int i = 0; i < 100; i++)
                new MyMessageConsumer("foo.bar").consumeMessage(i);
            end = System.currentTimeMillis();
            System.out.println("Consumer ran 100 times takes " + (end - start) + "msec" );
        }
        catch (JMSException e) {
            e.printStackTrace();
        }
    }
}