<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>hidden-result</title>
</head>
<body>
<%--
	아래의 EL은 <%=request.getParameter("command") %>와 동일한 표현
--%>
	Hidden 값을 서버에서 확인 : ${param.command }
</body>
</html>