package project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import project.dto.UserDto;

@Mapper
public interface LoginMapper {

	public UserDto login(UserDto userDto) throws Exception;
	public int registUser(UserDto userDto) throws Exception;
	public UserDto selectUserByUserId(String userId);
	public List<UserDto> googlelogin(String userId) throws Exception;
}
