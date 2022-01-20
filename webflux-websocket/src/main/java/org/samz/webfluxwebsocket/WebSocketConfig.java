package org.samz.webfluxwebsocket;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.server.WebSocketService;
import org.springframework.web.reactive.socket.server.support.HandshakeWebSocketService;
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter;
import org.springframework.web.reactive.socket.server.upgrade.ReactorNettyRequestUpgradeStrategy;

/**
 * @author: lilin
 * @Date: 2022/1/10 15:09
 * @Description:
 */
@Configuration
public class WebSocketConfig {

    @Bean
    public HandlerMapping getMapping() {
        Map<String, WebSocketHandler> map = new HashMap<>();
        map.put("/echo/**", new MyWebSocketHandler());
        map.put("/in", new InboundSocketHandler());
        return new SimpleUrlHandlerMapping(map, Ordered.HIGHEST_PRECEDENCE);
    }

    @Bean
    public WebSocketHandlerAdapter handlerAdapter() {

        return new WebSocketHandlerAdapter(webSocketService());
    }

    @Bean
    public WebSocketService webSocketService() {
        ReactorNettyRequestUpgradeStrategy strategy = new ReactorNettyRequestUpgradeStrategy();
        return new HandshakeWebSocketService(strategy);
    }

}
