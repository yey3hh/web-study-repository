<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="org.kosa.member.model.*"%>
<%
	MemberDao memberDao = new MemberDao();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Model 1 아키텍쳐</title>
</head>
<body>
	<h2>Model 1 Architecture를 적용한 총 회원수 보기</h2>
	<h3>총 회원수 : <%=memberDao.getAllMemberCount() %>명</h3>
</body>
</html>