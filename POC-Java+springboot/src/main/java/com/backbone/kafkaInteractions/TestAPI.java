package com.backbone.kafkaInteractions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestAPI {

  @Autowired
  private TopicProducer producer;
  
  @GetMapping("/publish/{message}")
  @ResponseBody
  public String publishMessage(@PathVariable("message") final String message){
    System.out.println("Message: " + message);
    producer.send(message);
    return "Envio feito com sucesso";
  }
}
