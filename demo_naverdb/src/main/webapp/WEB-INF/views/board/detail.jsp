<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="/js/jquery-3.7.1.min.js"></script>
<script>
$(document).ready(function(){
	$("#deletebtn").on("click", ()=>{
		let pw = prompt("비번 입력")
		if($("#hiddenpw").val() == pw){
			location.href = "boarddelete?seq=${dto.seq}";
		}else{
			alert("비밀번호가 맞지 않습니다");
		}
	});
	
	$("#updatebtn").on("click", ()=>{
		let pw = prompt("비번 입력")
		if($("#hiddenpw").val() == pw){
			$("#f").attr("method", "post");
			$("#f").attr("action", "boardupdate")
			.submit();
			
		}else{
			alert("비밀번호가 맞지 않습니다");
		}
	});
});
</script>
<body>
<!--  모델 출력 -->
<form id="f" action="" method="">
<input name="title" value='${dto.title }'><br>
<input name="seq" value='${dto.seq }'readonly><br>
<textarea cols=50 rows=5 name="contents" >${dto.contents }</textarea>
<input name="viewcount" value='${dto.viewcount }' readonly><br>
<input name="writer" value='${dto.writer }' readonly><br>
<input name="writingtime" value='${dto.writingtime }' readonly><br>
<input id="hiddenpw" type="hidden" value="${dto.pw }">
<!-- 수정, 삭제 버튼 -->
<input id="updatebtn" type="button" value="수정">
<input id="deletebtn" type="button" value="삭제">
</form>
</body>
</html>