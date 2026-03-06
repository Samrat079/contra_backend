package com.example.contra_backend.gigs.websocket.handler;

import com.example.contra_backend.gigs.models.Gig;
import com.example.contra_backend.gigs.services.GigsServices;
import lombok.AllArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import tools.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
@AllArgsConstructor
public class GigSocketHandler extends TextWebSocketHandler {
    private GigsServices gigsServices;
    private final List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();

    @Override
    public void afterConnectionEstablished(@NonNull WebSocketSession session) {
        sessions.add(session);
    }

    @Override
    public void handleTextMessage(@NonNull WebSocketSession session, TextMessage message) throws Exception {
        // Parse incoming JSON
        Gig gig = new ObjectMapper().readValue(message.getPayload(), Gig.class);

        // Save it
        Gig updated = gigsServices.saveGig(gig);

        // Broadcast to all sessions
        String payload = new ObjectMapper().writeValueAsString(updated);
        for (WebSocketSession s : sessions) {
            s.sendMessage(new TextMessage(payload));
        }
    }

    @Override
    public void afterConnectionClosed(@NonNull WebSocketSession session, @NonNull CloseStatus status) {
        sessions.remove(session);
    }
}

// This is sort of like a service layer, but it mostly handles the connection and requests
// better not to put business logic in this
