<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Object Pool Pattern : DBCP</title>
</head>
<body>
	<h3>Object Pool Pattern : DBCP</h3>
	<%--
		qeuryString : 처리할 서버 프로그램 url?name=value
		? : 구분자
	--%>
	<a href="front?command=Test">web test</a>
	<br><br><br>
	<h3>회원 관리 예제</h3>
	<%-- 
		구조
		index -- Front -- HandlerMapping -- Controller
												|
									GetTotalMemberCountController	<---->  MemberDao <---> DataSourceManager
												|
												| forwartd
										member-count.jsp
	--%>
	<a href="front?command=GetTotalMemberCount">총 회원 수 보기</a>
	<br><br><br>
	
	<form action="front" method="get">
		<%-- 하나의 프론트 컨트롤러로 다양한 요청이 이루어지므로 어떤 요청인지를 hidden으로 알려준다 --%>
		<input type="hidden" name="command" value="FindMemberById">
		<input type="text" name="memberId" required="required" placeholder="회원 아이디">
		<button type="submit">회원 검색</button>
	</form>	
	<br><br><br>
	
	<form action="front" method="get">
		<%-- 하나의 프론트 컨트롤러로 다양한 요청이 이루어지므로 어떤 요청인지를 hidden으로 알려준다 --%>
		<input type="hidden" name="command" value="FindMemberByAddress">
		<input type="text" name="memberAddress" required="required" placeholder="회원 주소">
		<button type="submit">회원 검색</button>
	</form>	
	<br><br><br>
	
	<img src="front-all.png" width="70%">
</body>
</html>