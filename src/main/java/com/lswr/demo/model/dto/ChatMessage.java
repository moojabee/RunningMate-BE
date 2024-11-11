package com.lswr.demo.model.dto;


import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessage {
	public enum MessageType{
		ENTER,TALK,QUIT
	}
	private MessageType type; 
	private String roomId;
	private Long userId; 	// userId
	private String message;
	private LocalDateTime sendedDate;
	private String content;
}
