package project.dto;

import java.util.HashMap;
import java.util.UUID;

import lombok.Data;

@Data
public class AccompanyChatroomDto {

	
	private	String roomId;			//룸 아이디
	private String roomName;		//룸 이름
	private int userCount;			//룸 유저수
	private String userId;			//유저 아이디 (외래키)
	
	
	private HashMap<String, String> userList = new HashMap<>();
	
	
	
	//createroom() 메서드 실행시 객체가 생성되고 인자로 (방 이름)만 설정해주면 
	//ID, 생성후 채팅방 생성됨.
	public AccompanyChatroomDto createroom(String roomName) {
		AccompanyChatroomDto chatroom = new AccompanyChatroomDto();
		chatroom.roomId = UUID.randomUUID().toString();
		chatroom.roomName = roomName;
		
		return chatroom;
	}
	
}
