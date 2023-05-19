package project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import project.dto.GoogleDto;
import project.dto.UserDto;
import project.service.LoginService;

@RestController
public class RestLoginApiController {

	@Autowired
	private LoginService loginService;
	
	
	
	
	@PostMapping("/api/regist")
	public ResponseEntity<Object> regist(@RequestBody UserDto userDto) throws Exception{
		int registedCount = loginService.registUser(userDto);
		if ( registedCount > 0 ) {
			return ResponseEntity.status(HttpStatus.CREATED).body(registedCount);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(registedCount);
		}
	}
	
	//구글 로그인 시 처리
	//axios 날라옴 만약 회원정보가 있다면 1 응답
	//회원정보가 없다면 0 응답.
	//프론트에서 1로 받았다면, 다시 lo	gin처리하면 됨( 소셜로그인용 임시 비번 사용)
	//0으로 받았다면, "/api/regist/google"로 추가 정보 입력(국가정보, 닉네임)
	@PostMapping("/api/login/google")
	public ResponseEntity<Object> googlelogin(@RequestBody GoogleDto googleDto) throws Exception{
		
		//userId확인하기
		//UserDto로 응답
		List<UserDto> userCheck = loginService.googlelogin(googleDto);
		if ( userCheck.size() > 0 ) {
			return ResponseEntity.status(HttpStatus.CREATED).body(userCheck.size());
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(userCheck.size());
		}
		
		
	}
	
	
}
