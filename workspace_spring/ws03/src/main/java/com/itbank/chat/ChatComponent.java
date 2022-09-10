package com.itbank.chat;

import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component 	// 자바 클래스를 스프링 빈으로 등록하는 어노테이션 (@Controller, @Service, @Repository, @RestController...)
public class ChatComponent extends TextWebSocketHandler{
	
	private HashMap<String, WebSocketSession> sessionMap = new HashMap<String, WebSocketSession>();
	private String lastPeopleId;
	
	@Override	// 연결이 만들어지면 수행하는 메서드
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		
		String uri = session.getUri().toString();			// 접속에 사용된 주소를 가져온다
		String id = uri.substring(uri.indexOf("id=") + 3);	// 주소에서 파라미터 형식의 id를 추출한다
		id = URLDecoder.decode(id, "UTF-8");				// UTF-8로 인코딩하여 한글도 처리할 수 있도록한다
		
		sessionMap.put(id, session);						// 아이디를 key로, 세션을 value로 맵에 저장한다
		
		boolean flag1 = lastPeopleId != null && session.getId().split("_")[0].equals(lastPeopleId.split("_")[0]);
		boolean flag2 = lastPeopleId != null && new Date().getTime() - Long.parseLong(lastPeopleId.split("_")[1]) < 20000; 
		// 마지막 종료한 사용자와 일치하고 시간이 20000 이내일 경우는 전체에게 출력하지 않고, 자신에게만
		String welcomeMessage = String.format("{\"username\": \"alarm\", \"message\": \"%s 님이 입장하였습니다. \"}", id);
		
		if(flag1 && flag2) {
			session.sendMessage(new TextMessage(welcomeMessage));
			return;
		}
		
		for(WebSocketSession wss : sessionMap.values()) {		
			wss.sendMessage(new TextMessage(welcomeMessage));	
		}
	}
	
	@Override	// 메시지를 서버가 받으면 수행하는 메서드
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println(message.getPayload());
		for(WebSocketSession wss : sessionMap.values()) {					// 리스트에 저장된 모든 세션에게
			wss.sendMessage(new TextMessage(message.getPayload()));	// 서버가 받은 메시지를 뿌린다
		}
	}
	
	@Override	// 연결이 종료되면 수행하는 메서드
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		String uri = session.getUri().toString();
		String id = uri.substring(uri.indexOf("id=") + 3);
		id = URLDecoder.decode(id, "UTF-8");
		
		lastPeopleId = session.getId();
		sessionMap.remove(id);
	}

	public HashMap<String, WebSocketSession> getSessionMap() {
		return sessionMap;
	}
}
