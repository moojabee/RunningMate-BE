package com.lswr.demo.model.service;

import java.util.List;

import com.lswr.demo.model.dto.ChatMessage;
import com.lswr.demo.model.dto.ChatRoom;
import com.lswr.demo.model.dto.User;

public interface ChatService {
	
    // 1. 채팅방 안에 유저 리스트 조회
    List<User> getUserListInChatRoom(String roomId);

    // 2. 특정 유저 채팅방 입장
    void enterChatRoom(Long userId, String roomId);

    // 3. 특정 유저 채팅방 퇴장
    void exitChatRoom(Long userId, String roomId);

    // 4. 채팅방 리스트 조회
    List<ChatRoom> getChatRoomListByUserId(Long userId);

    // 5. 특정 채팅방 메시지 조회
    List<ChatMessage> getMessageListInChatRoom(String roomId);

    // 6. 메시지 전송
    void sendMessageToChatRoom(ChatMessage chatMessage);
}
