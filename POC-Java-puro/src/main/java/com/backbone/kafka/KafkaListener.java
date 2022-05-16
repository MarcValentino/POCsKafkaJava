package com.backbone.kafka;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

public class KafkaListener {

  private static KafkaConsumer<String, String> consumer;


  KafkaListener(){
    consumer = new KafkaConsumer<String, String>(properties());
  }

  public static void main(String[] args) {
    consumer.subscribe(Collections.singletonList("NOVA_MENSAGEM"));
    while(true){
      var records = consumer.poll(Duration.ofMillis(500));
      /*if (records.isEmpty()) {
        System.out.println("Timeout, sem registros");
      }*/
      for(var record: records) {
        System.out.println("Mensagem: " + record.value());
      }
    }

  }

  public void pollTopic() {
    consumer.subscribe(Collections.singletonList("NOVA_MENSAGEM"));
    while(true){
      var records = consumer.poll(Duration.ofMillis(500));
      /*if (records.isEmpty()) {
        System.out.println("Timeout, sem registros");
      }*/
      for(var record: records) {
        System.out.println("Mensagem: " + record.value());
      }
    }
  }

  private static Properties properties() {
    var properties = new Properties();
    properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:29092");
    properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
    properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
    properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "KafkaListener");
    return properties;
  }
}
