<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- jstl 을 사용하기 위한 선언부 --%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step4-jstl-forEach</title>
<style>
    table {
        width: 100%;
        border-collapse: collapse;  /* 테두리 겹치게 설정*/
    }
    th {
        background-color: rgb(223, 187, 238);
    }
    th, td{
        border: 1px, solid black;
        padding: 8px;
        text-align: center;
    }
</style>
</head>
<body>
	<%-- 
		jstl forEach : java 또는 jsp의 for문에 해당
		items : 배열 또는 컬랙션
		var : 요소를 담을 임시 변수
	--%>
	<h3>step4 jstl forEach</h3>
	<c:forEach items="${foods }" var="food">
		${food} <br>
	</c:forEach>
	
</body>
</html>