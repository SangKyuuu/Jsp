<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>redirect1</title>
	</head>
	<body>
		<h3>redirect3 페이지</h3>
		<%
			//해당 페이지를 파일로 응답
			response.setHeader("Content-Type", "application/octet-stream"); 
		%>
	</body>
</html>