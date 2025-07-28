<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>서버 에러</title>
	</head>
	<body>
		<h3>일시적인 서버 장애가 발생했습니다. 고객센터로 문의하시기 바랍니다.</h3>
		<p>
			에러종류 : <%= exception.getClass().getName() %>
			에러내용 : <%= exception.getMessage() %>
		</p>
		<a href="../5_exception.jsp">뒤로가기</a>
	</body>
</html>