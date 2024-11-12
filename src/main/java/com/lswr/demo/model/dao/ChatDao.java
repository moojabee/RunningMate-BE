package com.lswr.demo.model.dao;

import java.util.List;

import com.lswr.demo.model.dto.ChatMessage;
import com.lswr.demo.model.dto.ChatRoom;
import com.lswr.demo.model.dto.User;

public interface ChatDao {

    // 1. 방에 있는 유저 리스트 조회
    List<User> selectUserListByChatRoomId(String roomId);

    // 2. 방에 유저 추가
    void insertUserInChatRoom(Long userId, String roomId);

    // 3. 방에 유저 삭제
    void removeUserFromChatRoom(Long userId, String roomId);

    // 4. 유저가 있는 방 리스트 조회
    List<ChatRoom> getChatRoomListByUserId(Long userId);

    // 5. 방 추가
    void addChatRoom(ChatRoom chatRoom);

    // 6. 방 검색
    List<ChatRoom> searchChatRoomByName(String roomName);

    // 7. 방 안에 있는 메시지 리스트 조회
    List<ChatMessage> getMessageListByRoomId(String roomId);

    // 8. 방에 메시지 추가
    void addMessageToChatRoom(ChatMessage chatMessage);
}
