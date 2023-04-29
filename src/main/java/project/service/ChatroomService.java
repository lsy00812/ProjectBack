package project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.dto.AccompanyChatroomDto;
import project.dto.UserDto;
import project.mapper.ChatMapper;

@Service
public class ChatroomService {

	@Autowired ChatMapper chatMapper;
	
	//유저정보 기준으로 전체 방 조회
	public List<AccompanyChatroomDto> selectRoomListByUser(UserDto userDto) throws Exception {
		
		return chatMapper.selectRoomListByUser(userDto);
	}
}
