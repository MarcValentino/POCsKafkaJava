package com.backbone.kafkaInteractions;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class TopicListener {

  @KafkaListener(topics = "NOVA_MENSAGEM")
  public void listenTopic(
    @Payload String message,
    @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition){
      System.out.println("Received message: " + message + ", from partition: " + partition);
    
  }
}
