<%@page import="model.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<MemberVO> list = new ArrayList<MemberVO>();
	list.add(new MemberVO("angel", null, "아이유", "수원"));
	list.add(new MemberVO("joy", null, "차은우", "런던"));
	list.add(new MemberVO("peace", null, "제니", "시드니"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>VO List JSP 활용</title>
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
	<table>
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>주소</th>
			</tr>
		</thead>
		<tbody>
			<%
				for(MemberVO m : list) {
				// for(int i = 0; i < list.size(); i++) {}
			%>
			<tr>
				<td><%=m.getId() %></td>
				<td><%=m.getName() %></td>
				<td><%=m.getAddress() %></td>
<%-- 				<td><%=list.get(i).getId() %></td>
				<td><%=list.get(i).getName() %></td>
				<td><%=list.get(i).getAddress() %></td> --%>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>

</body>
</html>