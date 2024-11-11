package com.lswr.demo.model.dao;

import com.lswr.demo.model.dto.ChatMessage;
import com.lswr.demo.model.dto.ChatRoom;
import com.lswr.demo.model.dto.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChatDao {

    // 1. 특정 채팅방에 있는 채팅 메시지 리스트 조회
    List<ChatMessage> selectMessageByRoomId(String roomId);

    // 2. 유저가 속한 채팅방 목록 조회
    List<ChatRoom> selectChatRoomList(Long userId);

    // 3. 오픈 채팅방 목록 조회
    List<ChatRoom> selectOpenChatRoomList();

    // 4. 유저가 속한 채팅방 유저 목록 조회
    List<User> selectUserListInChatRoom(String roomId);

    // 5. 유저와 채팅방 정보를 받아 특정 채팅방 퇴장
    int deleteUserInChatRoom(Long userId, String roomId);

    // 6. 유저와 채팅방 정보를 받아 특정 채팅방 입장
    int insertUserInChatRoom(Long userId, String roomId);

    // 7. 특정 채팅방 유저 채팅 메시지 전송
    int inserMessage(ChatMessage chatMessage);
    
    // 8. 특정 채팅방 조회
    ChatRoom selectChatRoomById(String roomId);

    // 9. 채팅방 생성
    int insertChatRoom(ChatRoom chatRoom);
}
