package com.demo.api.v1;

import java.security.Principal;

import com.demo.model.ChatMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
  @Autowired
  private SimpMessagingTemplate simpMessaginTemplate;

  @MessageMapping("/news")
  public void broadcastNews(@Payload String message) {
    simpMessaginTemplate.convertAndSend("/topic/news", message);
  }
}
