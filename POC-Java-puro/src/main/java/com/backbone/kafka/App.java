package com.backbone.kafka;

/**
 * Hello world!
 *
 */

public class App 
{
    public static void main( String[] args )
    {
        var listener = new KafkaListener();
        var writer = new KafkaWriter();
        writer.writeToTopic("heyyyy");
        listener.pollTopic();
    }

}
