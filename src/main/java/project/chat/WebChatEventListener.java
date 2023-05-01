package project.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import lombok.extern.slf4j.Slf4j;
import project.dto.ChatDto;



//웹소켓 연결해제시 세션에서 사용자 정보가 있는 경우 퇴장 메시지(토픽)를 발행 
@Slf4j
@Component
public class WebChatEventListener {

	@Autowired
	private SimpMessageSendingOperations messagingTemplate;
	
	
	//연결시에는 그냥 로그만 출력(처리는 이미 컨트롤러에서 입장문 처리함)
	@EventListener
	public void handleWebSocketConnectListener(SessionConnectedEvent event) {
		log.info("Received a new web socket connection");
	}
	
	@EventListener
	public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
		StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
		
		String username = (String) headerAccessor.getSessionAttributes().get("username");
		
		if(username != null ) {
			log.info("User Disconnected : " + username);
			
			ChatDto chatMessage = new ChatDto();
			chatMessage.setType(ChatDto.MessageType.LEAVE);
			chatMessage.setUserId(username);
			chatMessage.setMessage(username + "님이 퇴장하셨습니다.");
			
			//구독한 방에 다시 보내버림.
			//지금은 글로벌 채팅방에 보내버리지만, 채팅방이 여러개면 찾아서 보내줘야 할 듯.
			messagingTemplate.convertAndSend("/topic/chatting", chatMessage);
		}
	}
	
}
