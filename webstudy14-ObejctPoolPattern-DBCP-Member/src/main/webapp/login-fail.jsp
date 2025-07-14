<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login-fail</title>
</head>
<body>
	<%-- 
		alert 후 location.href로 index.jsp로 보냄
	--%>
	<script type="text/javascript">
		alert('로그인에 실패하였습니다. 다시 로그인 하세요');
		location.href = "index.jsp";
	</script>
</body>
</html>