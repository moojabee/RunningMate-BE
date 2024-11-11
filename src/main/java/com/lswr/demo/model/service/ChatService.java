package com.lswr.demo.model.service;

import com.lswr.demo.model.dto.ChatMessage;
import com.lswr.demo.model.dto.ChatRoom;
import com.lswr.demo.model.dto.User;
import java.util.List;

public interface ChatService {

    // 1. 특정 채팅방에 있는 채팅 메시지 리스트 조회
    List<ChatMessage> getMessagesByRoomId(String roomId);

    // 2. 유저가 속한 채팅방 목록 조회
    List<ChatRoom> getChatRoomsByUserId(Long userId);

    // 3. 오픈 채팅방 목록 조회
    List<ChatRoom> getOpenChatRooms();

    // 4. 유저가 속한 채팅방 유저 목록 조회
    List<User> getUsersInChatRoom(String roomId);

    // 5. 특정 채팅방 퇴장 처리
    boolean exitChatRoom(Long userId, String roomId);

    // 6. 특정 채팅방 입장 처리
    boolean enterChatRoom(Long userId, String roomId);

    // 7. 특정 채팅방에서 유저 채팅 메시지 전송
    boolean sendMessage(ChatMessage chatMessage);

    // 8. 특정 채팅방 정보 조회
    ChatRoom getChatRoomById(String roomId);

    // 9. 새로운 채팅방 생성
    boolean createChatRoom(ChatRoom chatRoom);
}
