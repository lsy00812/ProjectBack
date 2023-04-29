package project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.extern.slf4j.Slf4j;
import project.dto.AccompanyChatroomDto;
import project.service.ChatroomService;

@Controller
@Slf4j
public class ChatroomController {
	
	@Autowired	//chatservice
	ChatroomService chatroomService;
	
	@MessageMapping("/chat.addUser")
	@SendTo("/topic/chatting")
	public ChatDto addUser(@Payload ChatDto chatDto, SimpMessageHeaderAccessor headerAccessor)
	throws Exception{
		headerAccessor.getSessionAttributes().put("username", chatDto.getSender());
		chatDto.setMessage(chatDto.getSender() + "님이 입장하셨습니다.");
		
		List<ChatDto> list = chatroomservice.selectMessage();
		chatDto.setHistory(list);
		
		return chatDto;
	}
	
	@MessageMapping("/chat.sendMessage")
	@SendTo("/topic/chatting")
	public ChatDto sendMessage(@Payload ChatDto chatDto) throws Exception{
		chatroomService.insertMessage(chatDto);
		return chatDto;
	}
	
	
	
	@GetMapping("/{userId}")
	public List<AccompanyChatroomDto> ChatroomList(@PathVariable(value="userId") String userId) throws Exception{
		
		// 매퍼, 서비스에서 룸 정보 가져오기
		
		
		
		return roomDto
	}
	
	
}
