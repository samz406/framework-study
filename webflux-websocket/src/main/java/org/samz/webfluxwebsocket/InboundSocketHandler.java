package org.samz.webfluxwebsocket;

import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketSession;

import reactor.core.publisher.Mono;

/**
 * @author: lilin
 * @Date: 2022/1/10 16:25
 * @Description:
 */

public class InboundSocketHandler implements WebSocketHandler {


    @Override
    public Mono<Void> handle(WebSocketSession session) {
        return null;
    }
}
