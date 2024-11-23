package com.example.oms.configuration.websocket;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {


 @Override
   public void configureMessageBroker(org.springframework.messaging.simp.config.MessageBrokerRegistry config){
    config.enableSimpleBroker("/topic");
    config.setApplicationDestinationPrefixes("/app");
}


@Override
    public void registerStompEndpoints(StompEndpointRegistry registry){
     registry.addEndpoint("/ws").setAllowedOrigins("*").withSockJS();

}
}
