<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login-ok</title>
</head>
<body>
	<%--
		성공 시 회원 정보 출력 후 home으로 이동 버튼 생성
	--%>
<%-- 	<% String id = (String)session.getAttribute("id"); %>
 --%>	
	${sessionScope.mvo.name }님 로그인 성공하셨습니다. <a href="index.jsp">Home으로 이동</a>
</body>
</html>