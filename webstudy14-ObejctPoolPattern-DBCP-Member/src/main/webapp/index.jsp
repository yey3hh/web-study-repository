<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	
	<c:choose>
		<%-- <c:when test="${not empty sessionScope.mvo }"> --%>
		<c:when test="${sessionScope.mvo == null}">
			<form action="front" method="post">
				<input type="hidden" name="command" value="Login">
				<input type="text" name="id" placeholder="아이디" required="required"> <br>
				<input type="password" name="password" placeholder="패스워드" required="required"> <br>
				<button type="submit">로그인</button>
			</form> 
			
		</c:when>
		
		<c:otherwise>
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
				하나의 프론트 컨트롤러로 다양한 요청이 이루어지므로 어떤 요청인지를 hidden으로 알려준다
				<input type="hidden" name="command" value="FindMemberById">
				<input type="text" name="memberId" required="required" placeholder="회원 아이디">
				<button type="submit">회원 검색</button>
			</form>	
			<br><br><br>
			
			<form action="front" method="get">
				하나의 프론트 컨트롤러로 다양한 요청이 이루어지므로 어떤 요청인지를 hidden으로 알려준다
				<input type="hidden" name="command" value="FindMemberByAddress">
				<input type="text" name="memberAddress" required="required" placeholder="회원 주소">
				<button type="submit">회원 검색</button>
			</form>	
			<br><br><br> 
			<p>${sessionScope.mvo.name}님 로그인 상태 입니다.</p>
			
			<%--
					F.C -- H.M -- Controller
									|
								LogoutController
									세션 체크, 기존 세션 존재하면 session.invalidate()로 세션 무효화 후
									리다이렉트 index.jsp
			--%>
			
			<form action="front" method="post">
				<input type="hidden" name="command" value="Logout">
				<button type="submit">로그아웃</button>
			</form>	
		
		</c:otherwise>
	</c:choose>
	
	
	<%-- 
		jstl library와 선언부 확인, 없으면 등록하고
		choose ~ when ~ otherwise를 이용 : sessionScope.mvo의 존재 유무로 비교 후
		로그인 상태가 아니면 위의 로그인 폼을 보여주고
		로그인 상태이면 아래의 예처럼 사용자 정보와 로그아웃 버튼을 제공한다.
		예)
			손흥민님 로그인 상태 입니다.
			<form> ... 
				<button>로그아웃</button>
		
	--%>
	<img src="front-all.png" width="70%">
</body>
</html>