package com.backbone.kafkaInteractions;

import org.springframework.beans.factory.annotation.*;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

// @Slf4j
@Service
public class TopicProducer {

  @Autowired KafkaTemplate<String, String> kafkaTemplate;

  public void send(String message){
    kafkaTemplate.send("NOVA_MENSAGEM", message);
  }
}
