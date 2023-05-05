package project.dto;

import java.util.List;
import lombok.Data;

@Data
public class ChatDto {

	public enum MessageType {
		JOIN, CHAT, LEAVE
	}
	
	private MessageType type;
	private int chatIdx;	//chatIdx
	private String message;	//message
	private String userId;	//userId
	private String createdDt;//createdDt
	private String chatroomId; //채팅룸 아이디 (외래키)
	private List<ChatDto> history;
	
}
