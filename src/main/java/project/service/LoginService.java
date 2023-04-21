package project.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import project.dto.UserDto;

public interface LoginService extends UserDetailsService {

	public UserDto login(UserDto userDto) throws Exception;
	public int registUser(UserDto userDto) throws Exception;
	public UserDto selectUserByUserId(String userId) throws Exception;
	
}
