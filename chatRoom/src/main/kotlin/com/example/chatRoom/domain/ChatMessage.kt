package com.example.chatRoom.domain

import java.time.LocalDateTime

data class ChatMessage (
    var type: MessageType,
    var content: String?,
    var sender: String
)
