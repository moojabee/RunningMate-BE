package com.lswr.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.lswr.demo.model.dto.ChatMessage;
import com.lswr.demo.model.dto.ChatRoom;
import com.lswr.demo.model.dto.User;
import com.lswr.demo.model.service.ChatService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatRoomController {

    private final ChatService chatService;

    // 1. 특정 채팅방에 있는 채팅 메시지 리스트 조회
    @GetMapping("/messages/{roomId}")
    public List<ChatMessage> getMessagesByRoomId(@PathVariable String roomId) {
        return chatService.getMessagesByRoomId(roomId);
    }
    
    // 2. 유저가 속한 채팅방 목록 조회
    @GetMapping("/rooms/user/{userId}")
    public List<ChatRoom> getChatRoomsByUserId(@PathVariable Long userId) {
        return chatService.getChatRoomsByUserId(userId);
    }
    
    // 3. 오픈 채팅방 목록 조회
    @GetMapping("/rooms/open")
    public List<ChatRoom> getOpenChatRooms() {
        return chatService.getOpenChatRooms();
    }
    
    // 4. 유저가 속한 채팅방 유저 목록 조회
    @GetMapping("/room/{roomId}/users")
    public List<User> getUsersInChatRoom(@PathVariable String roomId) {
        return chatService.getUsersInChatRoom(roomId);
    }
    
    // 5. 특정 채팅방 정보 조회
    @GetMapping("/room/{roomId}")
    public ChatRoom getChatRoomById(@PathVariable String roomId) {
        return chatService.getChatRoomById(roomId);
    }
    
    // 6. 새로운 채팅방 생성
    @PostMapping("/new-room")
    public boolean createChatRoom(@RequestBody ChatRoom chatRoom) {
        return chatService.createChatRoom(chatRoom);
    }
}
