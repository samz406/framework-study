package org.samz.webfluxwebsocket;

import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.core.io.buffer.DefaultDataBuffer;
import org.springframework.web.reactive.socket.HandshakeInfo;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketMessage.Type;
import org.springframework.web.reactive.socket.WebSocketSession;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

/**
 * @author: lilin
 * @Date: 2022/1/10 15:11
 * @Description:
 */
@Slf4j
public class MyWebSocketHandler implements WebSocketHandler {
    @Override
    public Mono<Void> handle(WebSocketSession session) {

        final HandshakeInfo handshakeInfo = session.getHandshakeInfo();

        final Mono<Void> input = session.receive().doOnNext(msg -> {
            log.info("请求参数为{},messageId {} url{} ", msg.getPayloadAsText(), session.getId(),session.getHandshakeInfo().getUri().toString());
        }).then();
        return input;
    }

    public void send(WebSocketSession session){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }

      //  session.send(Mono.just(new WebSocketMessage(Type.TEXT, new DefaultDataBuffer("hello".getBytes()))));
    }
}
