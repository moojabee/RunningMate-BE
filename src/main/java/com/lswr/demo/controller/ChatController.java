package com.lswr.demo.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.lswr.demo.model.dto.ChatMessage;
import com.lswr.demo.model.dto.User;
import com.lswr.demo.model.service.ChatService;
import com.lswr.demo.model.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class ChatController {

    private final SimpMessageSendingOperations messagingTemplate;
    private final UserService userService;
    private final ChatService chatService;
    
    @MessageMapping("/chat/message")
    public void handleMessage(ChatMessage message) {
        if (ChatMessage.MessageType.ENTER.equals(message.getType())) {
        	User user = userService.getUserById(message.getUserId());
            message.setMessage(user.getNickname() + "님이 입장하셨습니다.");
            chatService.enterChatRoom(message.getUserId(),message.getRoomId());
        }
        
        else if (ChatMessage.MessageType.ENTER.equals(message.getType())) {
        	User user = userService.getUserById(message.getUserId());
            message.setMessage(user.getNickname() + "님이 퇴장하셨습니다.");
            chatService.exitChatRoom(message.getUserId(), message.getRoomId());
        }
        
        messagingTemplate.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
        chatService.sendMessage(message);
    }
}
