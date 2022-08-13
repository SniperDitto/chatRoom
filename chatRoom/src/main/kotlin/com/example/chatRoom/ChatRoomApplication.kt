package com.example.chatRoom

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ChatRoomApplication

fun main(args: Array<String>) {
	runApplication<ChatRoomApplication>(*args)
}
