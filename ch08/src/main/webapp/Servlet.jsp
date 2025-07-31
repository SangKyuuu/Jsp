<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Servlet</title>
		<!-- 
			25/07/31
			최상규
			서블릿 실습하기
		 -->
	</head>
	<body>
		<h3>서블릿 실습하기</h3>
		
		<a href="/ch08/hello.do">Hello Servlet</a><br>
		<a href="/ch08/welcome.do">Welcome Servlet</a><br>
		<a href="/ch08/greeting.do">Greeting Servlet</a><br>
		
		<form action="/ch08/hello.do" method="post">
			<input type="text" name="id" /><br>
			<input type="password" name="pw"/>
			<input type="submit" value="전송하기"/>
		</form>
	</body>
</html>