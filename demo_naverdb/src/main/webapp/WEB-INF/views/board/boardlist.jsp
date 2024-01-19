<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>게시판</h1>
<table>
<tr>
<th>번호</th><th>제목</th><th>작성자</th><th>조회수</th>
</tr>
<c:forEach items="${paginBoardlist }" var="dto">
<tr>
<td>${dto.seq }</td><td><a href="boarddetail?seq=${dto.seq }">${dto.title }</a></td><td>${dto.writer }</td><td>${dto.viewcount }</td>
</tr>
</c:forEach>
</table>
<h1>페이지 번호 선택하세요</h1>
<%
int pagecount = (Integer)request.getAttribute("pagecount");
int totalcount = (Integer)request.getAttribute("totalcount");
int totalpage = 0;
if(totalcount % pagecount == 0){
	totalpage = totalcount / pagecount;
}else{
	totalpage = totalcount / pagecount + 1;
}
for(int i = 1;  i <= totalpage; i++){
%>	
<a href="boardlist?pagenum=<%=i %>"><%=i %>페이지</a>

<%
}
%>


</body>
</html>