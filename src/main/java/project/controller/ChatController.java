package project.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import project.dto.ChatDto;
import project.dto.ChatroomDto;
import project.dto.UserDto;
import project.service.ChatService;

@Slf4j
@Controller
public class ChatController {

	@Autowired
	ChatService service;
	
	
	//-------------------------글로벌 채팅------------------------------------//
	//("/chat.addUser")로 요청이 오면
	//("/topic/chatting") 으로 보내버림(chatting)밖에 없으니까 글로벌 채팅방이라고 보면 됨. 
	@MessageMapping("/chat.addUser")
	@SendTo("/topic/chatting")
	public ChatDto addUser(@Payload ChatDto chatDto, SimpMessageHeaderAccessor headerAccessor) throws Exception{
		
		//(헤더)세션에 사용자 이름 저장, WebSocketEventListener에서 연결 끊길 시 사용자 식별위해 사용
		headerAccessor.getSessionAttributes().put("username", chatDto.getUserId());
		
		chatDto.setMessage(chatDto.getUserId() + "님이 입장하셨습니다.");
		service.insertMessage(chatDto);
		List<ChatDto> list = service.selectMessage();
		chatDto.setHistory(list);
		
		return chatDto;
	}
	
	//("/chat.sendMessage")로 요청이 오면
	//("/topic/chatting") 으로 보내버림(chatting)밖에 없으니까 글로벌 채팅방이라고 보면 됨.
	@MessageMapping("/chat.sendMessage")
	@SendTo("/topic/chatting")//리턴을 통해 토픽발행
	public ChatDto sendMessage(@Payload ChatDto chatDto, SimpMessageHeaderAccessor headerAccessor) throws Exception{
				
		//DB에 입력
		service.insertMessage(chatDto);
		
		return chatDto;
	}
	
	//---------------------------동행 채팅------------------------------------//
		//("/chat.addUser/{채팅방UUID}")로 요청이 오면
		//("/topic/chatting/{채팅방UUID}") 으로 보내버림
		@MessageMapping("/chat.addUser/{chatroomId}")
		@SendTo("/topic/chatting/{chatroomId}")
		public ChatDto addUserChatroom(@Payload ChatDto chatDto, SimpMessageHeaderAccessor headerAccessor) throws Exception{
			
			//(헤더)세션에 사용자 이름 저장, WebSocketEventListener에서 연결 끊길 시 사용자 식별위해 사용
			headerAccessor.getSessionAttributes().put("username", chatDto.getUserId());
			
			chatDto.setMessage(chatDto.getUserId() + "님이 입장하셨습니다.");
			service.insertMessageChatroom(chatDto);
			List<ChatDto> list = service.selectMessageChatroom(chatDto.getChatroomId());
			chatDto.setHistory(list);
			
			return chatDto;
		}
		
		//("/chat.sendMessage/{채팅방UUID}")로 요청이 오면	##문제는 userId를 어떻게 받아올지 모르겠음.
		//("/topic/chatting/{채팅방UUID}") 으로 보내버림.
		@MessageMapping("/chat.sendMessage/{chatroomId}")
		@SendTo("/topic/chatting/{chatroomId}")//리턴을 통해 토픽발행
		public ChatDto sendMessageChatroom(@Payload ChatDto chatDto, SimpMessageHeaderAccessor headerAccessor) throws Exception{
					
			//DB에 입력
			service.insertMessageChatroom(chatDto);
			
			return chatDto;
		}
		
	
}
