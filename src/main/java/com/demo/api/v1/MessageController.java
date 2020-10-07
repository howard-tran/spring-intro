package com.demo.api.v1;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
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

  @MessageMapping("/secured/room")
  public void sendMessage(@Payload String msg, Principal user, @Header("simpSessionId") String sessionId)
      throws Exception {

  }
}
