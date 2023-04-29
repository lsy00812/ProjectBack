package project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import project.dto.AccompanyChatroomDto;
import project.dto.UserDto;

@Mapper
public interface ChatMapper {
	
	//유저 정보 기준으로 전체방 조회
	public List<AccompanyChatroomDto> selectRoomListByUser(UserDto userDto) throws Exception;
}
