package com.example.contra_backend.gigs.websocket.config;

import com.example.contra_backend.gigs.websocket.handler.GigSocketHandler;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocket
@AllArgsConstructor
public class WebSocketConfig implements WebSocketConfigurer {
    private final GigSocketHandler gigSocketHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(gigSocketHandler, "/ws-gigs")
                .setAllowedOrigins("*");
    }
}


// This websocket receives the connection req on the uri ws://{{ base_url }}/ws-gigs
// It saves the gigs sent on this socket, the customer and the operator both can send
// receive all the gigs on this socket. the customer will post a gig with requested status
// and null in operator, then a operator will send another req with the same body replacing
// the status and the operator with itself

// This is barely working needs further improvement