<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="common.DbConfig,java.sql.*"%>
<%--
	초기 웹 개발 형태
	jsp와 db가 연동하는 구조
	회원 수를 db에 조회하여 화면에 제공
	하나의 jsp에 데이터 연동 로직 + 비즈니스 로직 + 요청 처리 로직 + 응답 view에 대한 로직이 다 포함되어있다.
	=> 응집도가 낮고 결합도가 높다
	아래의 경우 간단한 예이므로 데이터 연동 로직 + 요청 처리 로직 + 응답 view에 대한 로직 정도로 볼 수 있음
--%>
<%
	Class.forName(DbConfig.DRIVER);
	Connection con = DriverManager.getConnection(DbConfig.URL, DbConfig.USER, DbConfig.PWD);
	String sql = "select count(*) from member";
	PreparedStatement pstmt = con.prepareStatement(sql);
	ResultSet rs = pstmt.executeQuery();
	int count = 0;
	if(rs.next()) {
		count = rs.getInt(1);
	}
	rs.close();
	pstmt.close();
	con.close();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp에서 DB 연동</title>
</head>
<body>
	<h2>db에 저장된 총 회원수 <%= count %> 명</h2>
</body>
</html>