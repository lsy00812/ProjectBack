package project.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import project.dto.LoginDto;
import project.dto.UserDto;
import project.mapper.LoginMapper;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginMapper loginMapper;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public UserDto login(UserDto userDto) throws Exception{
		return loginMapper.login(userDto);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDto userDto = loginMapper.selectUserByUserId(username);
		if ( userDto == null ) {
			throw new UsernameNotFoundException(username);
		}
		
		return new User(userDto.getUserId(), userDto.getUserPw(),
				true, true, true, true, new ArrayList<>());
	}
	
	@Override
	public UserDto selectUserByUserId(String userId) throws Exception {
		return loginMapper.selectUserByUserId(userId);
	}

	@Override
	public int registUser(UserDto userDto) throws Exception {
		userDto.setUserPw(passwordEncoder.encode(userDto.getUserPw()));
		return loginMapper.registUser(userDto);
	}

}
