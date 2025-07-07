<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="org.kosa.member.model.*"%>
<%
	MemberDao dao = new MemberDao();
//	
	String memberId = request.getParameter("memberId");
	MemberVo vo = dao.findMemberById(memberId);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Model 1 회원 검색 결과</title>
</head>
<body>
	<h3>Model 1 회원 검색 결과</h3>
	<%--
		java 아이디에 대한 회원 정보
		이름 : 손흥민
		주소 : 런던
		or
		java7 아이디에 대한 회원 정보
		회원 정보가 존재하지 않습니다.
	--%>
	<p><%=memberId %> 아이디에 대한 회원 정보</p>
	<%
		if(vo != null) {
	%>
	<p>이름 : <%=vo.getName() %></p>
	<p>주소 : <%=vo.getAddress() %></p>
	<%
		} else {
	%>
	<p>회원 정보가 존재하지 않습니다.</p>
	<%
		}
	%>
	
</body>
</html>