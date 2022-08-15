package com.example.chatRoom.config

import org.springframework.context.annotation.Configuration
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker
import org.springframework.web.socket.config.annotation.StompEndpointRegistry
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer

@Configuration//설정파일
@EnableWebSocketMessageBroker//웹소켓을 통한 메시징 기능 활성화
class WebSocketConfig : WebSocketMessageBrokerConfigurer{

    //웹소켓 연결을 위한 엔트포인트 지정
    override fun registerStompEndpoints(registry: StompEndpointRegistry) {
        registry.addEndpoint("/ws").withSockJS()
    }

    //메시지를 주고받는 엔드포인트에 대한 prefix 설정
    override fun configureMessageBroker(registry: MessageBrokerRegistry) {
        registry.setApplicationDestinationPrefixes("/app")//클라이언트 -> 서버
        registry.enableSimpleBroker("/topic")//서버 -> 클라이언트(구독할 주소)
    }

}