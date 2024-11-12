package com.lswr.demo.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lswr.demo.model.dao.ChatDao;
import com.lswr.demo.model.dto.ChatMessage;
import com.lswr.demo.model.dto.ChatRoom;
import com.lswr.demo.model.dto.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService{

	private final ChatDao chatDao;

    // 1. 채팅방 안에 유저 리스트 조회
    @Override
    public List<User> getUserListInChatRoom(String roomId) {
        return chatDao.selectUserListByChatRoomId(roomId);
    }

    // 2. 특정 유저 채팅방 입장
    @Override
    public void enterChatRoom(Long userId, String roomId) {
        chatDao.insertUserInChatRoom(userId, roomId);
    }

    // 3. 특정 유저 채팅방 퇴장
    @Override
    public void exitChatRoom(Long userId, String roomId) {
        chatDao.removeUserFromChatRoom(userId, roomId);
    }

    // 4. 채팅방 리스트 조회
    @Override
    public List<ChatRoom> getChatRoomListByUserId(Long userId) {
        return chatDao.getChatRoomListByUserId(userId);
    }

    // 5. 특정 채팅방 메시지 조회
    @Override
    public List<ChatMessage> getMessageListInChatRoom(String roomId) {
        return chatDao.getMessageListByRoomId(roomId);
    }

    // 6. 메시지 전송
    @Override
    public void sendMessageToChatRoom(ChatMessage chatMessage) {
        chatDao.addMessageToChatRoom(chatMessage);
    }

}
