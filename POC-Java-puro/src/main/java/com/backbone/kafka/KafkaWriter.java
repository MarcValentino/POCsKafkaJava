package com.backbone.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class KafkaWriter {
  

  private static KafkaProducer<String, String> producer; 
  
  KafkaWriter(){
    producer = new KafkaProducer<String, String>(properties());
  }

  public static void main(String[] args) {
    var record = new ProducerRecord<>("NOVA_MENSAGEM", "oi", "oi");
        try {
            producer.send(record, (data, error) -> {
                if(error != null){
                    error.printStackTrace();
                    return;
                }
                System.out.println(data.topic() + ": Foi!");
            }).get();    
        } catch (Exception e) {
            //TODO: handle exception
        }
  }
  public void writeToTopic(String message) {
    var record = new ProducerRecord<>("NOVA_MENSAGEM", message, message);
        try {
            producer.send(record, (data, error) -> {
                if(error != null){
                    error.printStackTrace();
                    return;
                }
                System.out.println(data.topic() + ": Foi!");
            }).get();    
        } catch (Exception e) {
            //TODO: handle exception
        }
  }

  private static Properties properties() {
    var properties = new Properties();
    properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:29092");
    properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
    properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
    return properties;
  }
}
