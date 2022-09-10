package com.itbank.chat;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component 	// 자바 클래스를 스프링 빈으로 등록하는 어노테이션 (@Controller, @Service, @Repository, @RestController...)
public class ChatComponent extends TextWebSocketHandler{
	
	private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();
	
	@Override	// 연결이 만들어지면 수행하는 메서드
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		sessionList.add(session);
	}
	
	@Override	// 메시지를 서버가 받으면 수행하는 메서드
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println(message.getPayload());
		for(WebSocketSession wss : sessionList) {					// 리스트에 저장된 모든 세션에게
			wss.sendMessage(new TextMessage(message.getPayload()));	// 서버가 받은 메시지를 뿌린다
		}
	}
	
	@Override	// 연결이 종료되면 수행하는 메서드
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		sessionList.remove(session);
	}
}
