package com.demo.api.v1.Socket;

import com.demo.api.VersionHelper;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
  @Override
  public void registerStompEndpoints(StompEndpointRegistry registry) {
    WebSocketMessageBrokerConfigurer.super.registerStompEndpoints(registry);

    registry.addEndpoint("/secured").setAllowedOrigins("*").withSockJS();
  }

  @Override
  public void configureMessageBroker(MessageBrokerRegistry config) {
    WebSocketMessageBrokerConfigurer.super.configureMessageBroker(config);

    config.enableSimpleBroker("/topic/", "/queue/");
    config.setApplicationDestinationPrefixes(VersionHelper.V1 + "chat");
  }
}