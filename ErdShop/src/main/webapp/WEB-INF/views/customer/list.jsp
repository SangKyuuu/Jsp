<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원 목록</title>
	</head>
	<body>
		<h3>회원 목록</h3>
		
		<a href="/shopApp">처음으로</a>
		<a href="/shopApp/customer/register.do">등록하기</a>
		
		<table border="1">
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>휴대폰</th>
				<th>주소</th>
				<th>가입일</th>
				<th>관리</th>
			</tr>			
			<%-- <c:forEach var="customer" items="${dtoList}"> --%>
			<tr>
				<td>a101</td>
				<td>홍길동</td>
				<td>010-1234-4567</td>
				<td>부산</td>
				<td>2025-08-13</td>
				<td>					
					<a href="">수정</a>					
					<a href="">삭제</a>
				</td>
			</tr>
			<%-- </c:forEach> --%>
		</table>		
	</body>
</html>