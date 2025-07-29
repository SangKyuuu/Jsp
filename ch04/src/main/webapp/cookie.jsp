<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>cookie</title>
		<!-- 
			25/07/29
			최상규
			JSP 쿠키 실습하기
		 -->
	</head>
	<body>
		<h3>cookie 실습</h3>
		
		<form action="./proc/createCookie.jsp" method="post">
			<input type="text" name="id"/><br/>
			<input type="password" name="pw"/><br/>
			<input type="submit" value="로그인"/>
		</form>
	</body>
</html>