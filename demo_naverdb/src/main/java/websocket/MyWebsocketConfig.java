package websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

//chatWebsocketHandler와 컨트롤러 연결하기 위한 설정
@Configuration
@EnableWebSocket //웹소켓관련 설정위해
public class MyWebsocketConfig implements WebSocketConfigurer{
	
	ChatWebsocketHandler chatWebsocketHandler;
	
	public MyWebsocketConfig(ChatWebsocketHandler chatWebsocketHandler) {
		super();
		this.chatWebsocketHandler = chatWebsocketHandler;
	}

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(chatWebsocketHandler, "/ws").setAllowedOrigins("*");
		//jsp에서 websocket 보내는 설정과 같은 이름이어야함 ex)/ws 			//접속자를 누구로 제한할것이냐
		
	}

}
