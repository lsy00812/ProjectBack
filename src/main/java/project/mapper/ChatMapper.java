package project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import project.dto.ChatDto;
import project.dto.ChatroomDto;

@Mapper
public interface ChatMapper {
	
	//채팅방UUID 검색
	public String selectChatroomByAccompanyId(int accompanyIdx) throws Exception;
	
	//채팅방 없으면 채팅방 만들기
	public void insertChatroom(ChatroomDto chatroomDto) throws Exception;
	
	//채팅방 리스트 ByUserId
	public List<ChatroomDto> selectChatroomByUserId(String userId) throws Exception;
	
	
	//1.글로벌 채팅 입력/조회(최근 채팅 10개)
	public List<ChatDto> selectMessage(int num) throws Exception;
	public void insertMessage(ChatDto chatDto) throws Exception;
	
	//2.동행 채팅 입력/조회
	public List<ChatDto> selectMessageChatroom(String chatroomId) throws Exception;
	public void insertMessageChatroom(ChatDto chatDto) throws Exception;
	
	
}
