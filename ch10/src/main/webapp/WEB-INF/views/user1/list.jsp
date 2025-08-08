<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>user2::list</title>
	</head>
	<body>
		<h3>MySQL User2 목록</h3>
		
		<a href="/ch10">처음으로</a>
		<a href="/ch10/user2/register.do">등록하기</a>
		
		<table border="1">
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>생일</th>
				<th>주소</th>
				<th>관리</th>
			</tr>
			<c:forEach var="dto" items="${requestScope.dtoList}"> <!-- Controller에서 request객체로 setAttribute 저장한 dtoList -->
			<tr>
				<td>${dto.getUid()}</td>
				<td>${dto.getName()}</td>
				<td>${dto.getHp()}</td>
				<td>${dto.age}</td> <!-- 표현언어에서 getter 호출 안하고 직접 속성 참조해서 출력 가능 -->
				<td>
					<a href="#">수정</a>
					<a href="#">삭제</a>
				</td>
			</tr>
			</c:forEach>
		</table>
	</body>
</html>