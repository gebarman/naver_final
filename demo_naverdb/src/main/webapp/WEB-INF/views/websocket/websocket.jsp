<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="/js/jquery-3.7.1.min.js"></script>
<body>
별명:<input type="text" id="nickname" value="${param.id }">
<input type=button id="enterbtn" value="입장">
<input type=button id="exitbtn" value="퇴장">
<h1>채팅 영역</h1>

<div id="chatmessagearea" style="background-color:pink; border:2px solid black"></div>
전송 메시지 <input type=text id="message">
<input type="button" id="sendbtn" value="메세지 전송" >
</body>
<script>
websocket = null;
$("#enterbtn").on('click', function(){
	if(websocket==null){
		websocket = new WebSocket("ws://localhost:9070/ws");
		websocket.onopen = function(){console.log("웹소켓연결성공");}
		websocket.onclose = function(){console.log("해제")}
		websocket.onmessage = function(event){
			console.log("웹소켓서버로부터 수신성공")
			let data = event.data;
			$("#chatmessagearea").append(data + "<br>");
		};
	}
	
})

$("#exitbtn").on('click', function(){
	websocket.close();
})

$("#sendbtn").on('click', function(){
	//메세지 서버로 보낸다
	let nick = $("#nickname").val();
	let msg = $("#message").val();
	websocket.send(nick +" : "+msg);
})

</script>
</html>