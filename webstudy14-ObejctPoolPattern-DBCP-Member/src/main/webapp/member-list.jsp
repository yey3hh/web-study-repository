<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- jstl 을 사용하기 위한 선언부 --%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소로 회원 검색 결과</title>
<style>
  table {
    width: 100%;
    border-collapse: collapse; /* 테두리 겹치게 설정*/
  }
  th {
    background-color: rgb(188, 211, 252);
  }
  th,
  td {
    border: 1px, solid black;
    padding: 8px;
    text-align: center;
  }
</style>
</head>
<body>
	<h2>${request.memberAddress }에 사는 회원들</h2>
	<table>
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${memberList }" var="member">
			<%-- <c:if test="${not empty memberList}"> --%>
			<tr>
				<td>${member.id }</td>
				<td>${member.name }</td>
			</tr>
			<%-- </c:if> --%>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>