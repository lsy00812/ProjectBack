package project.dto;

import lombok.Data;

@Data
public class AccompanyChatDto {
	
	//메시지 타입 열거
	//타입에 따라 이벤트 다르게 처리
	//TALK는 해당 채팅방 sub하고 있는 경우 모든 클라이언트에게 전달됨.
	public enum MessageType{
		ENTER, TALK, LEAVE
	}
	
	private MessageType type;				//메시지 타입
	//동반채팅정보
	private int accompanyChatIdx;			//채팅인덱스
	private String accompanyChatContent;	//채팅내용
	private String accompanyChatTime;		//채팅시간
	private String userId;					//유저아이디(외래키)
	private int accompanyIdx;				//동행게시글인덱스(외래키)
}
