package info.everybodylies;


/**
 * Created by mike on 11.07.16.
 */
public class JmsClient
{
    public static void main(String[] args)
    {
        try {
            new MyMessageProducer().produceMessage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
