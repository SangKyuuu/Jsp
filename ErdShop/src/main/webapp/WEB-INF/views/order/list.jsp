<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>주문목록</title>
	</head>
	<body>
		<h3>주문 목록</h3>
		
		<a href="/shopApp">처음으로</a>
		<a href="/shopApp/order/register.do">등록하기</a>
		
		<table border="1">
			<tr>
				<th>주문번호</th>
				<th>주문자</th>
				<th>주문상품</th>
				<th>주문수량</th>
				<th>주문일</th>
				<th>관리</th>
			</tr>			
			<%-- <c:forEach var="customer" items="${dtoList}"> --%>
			<tr>
				<td>111</td>
				<td>홍길동</td>
				<td>초코파이</td>
				<td>23</td>
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