package com.lswr.demo.model.service;

import com.lswr.demo.model.dao.ChatDao;
import com.lswr.demo.model.dto.ChatMessage;
import com.lswr.demo.model.dto.ChatRoom;
import com.lswr.demo.model.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {

    private final ChatDao chatDao;

    @Autowired
    public ChatServiceImpl(ChatDao chatDao) {
        this.chatDao = chatDao;
    }

    @Override
    public List<ChatMessage> getMessagesByRoomId(String roomId) {
        return chatDao.selectMessageByRoomId(roomId);
    }

    @Override
    public List<ChatRoom> getChatRoomsByUserId(Long userId) {
        return chatDao.selectChatRoomList(userId);
    }

    @Override
    public List<ChatRoom> getOpenChatRooms() {
        return chatDao.selectOpenChatRoomList();
    }

    @Override
    public List<User> getUsersInChatRoom(String roomId) {
        return chatDao.selectUserListInChatRoom(roomId);
    }

    @Override
    public boolean exitChatRoom(Long userId, String roomId) {
        return chatDao.deleteUserInChatRoom(userId, roomId) > 0;
    }

    @Override
    public boolean enterChatRoom(Long userId, String roomId) {
        return chatDao.insertUserInChatRoom(userId, roomId) > 0;
    }

    @Override
    public boolean sendMessage(ChatMessage chatMessage) {
        return chatDao.inserMessage(chatMessage) > 0;
    }

    @Override
    public ChatRoom getChatRoomById(String roomId) {
        return chatDao.selectChatRoomById(roomId);
    }

    @Override
    public boolean createChatRoom(ChatRoom chatRoom) {
        return chatDao.insertChatRoom(chatRoom) > 0;
    }
}
