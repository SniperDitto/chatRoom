package com.example.chatRoom.controller

import com.example.chatRoom.domain.ChatMessage
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.messaging.simp.SimpMessageHeaderAccessor
import org.springframework.web.bind.annotation.RestController

@RestController
class ChatController {
    @MessageMapping("/chat.sendMessage")//클라이언트 -> 서버
    @SendTo("/topic/public")//구독 중인 클라이언트에 chatMessage 발행
    fun sendMessage(@Payload chatMessage : ChatMessage?) : ChatMessage? {
        return chatMessage
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    fun addUser(@Payload chatMessage : ChatMessage, headerAccessor: SimpMessageHeaderAccessor) : ChatMessage? {
        headerAccessor.sessionAttributes!!["username"] = chatMessage.sender//세션에 새 유저 추가
        return chatMessage
    }

}
