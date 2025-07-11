<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>총 회원 수</title>
</head>
<body>
	<%-- 
		아래 EL의 requestScope 생략 가능 (sessionScope, applicationScope 또한 생략 가능 
		<%=request.getAttribute("totalMemberCount"); %> -> Controller에 set으로 작성해줘야함
	--%>
	<h3>총 회원 수 : ${totalMemberCount } 명</h3>
</body>
</html>