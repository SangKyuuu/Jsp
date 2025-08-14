<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>강좌등록</title>
	</head>
	<body>
		<h3>강좌등록</h3>
		
		<a href="/ErdCollege">처음으로</a>
		<a href="/ErdCollege/lecture/list.do">목록이동</a>
		
		<form action="/ErdCollege/lecture/register.do" method="post">
			<table border="1">
				<tr>
					<td>강좌번호</td>
					<td><input type="number" name="lecNo" placeholder="강좌번호 입력"/></td>
				</tr>
				<tr>
					<td>강좌명</td>
					<td><input type="text" name="lecName" placeholder="강좌명 입력"/></td>
				</tr>
				<tr>
					<td>학점</td>
					<td><input type="number" name="lecCredit" placeholder="학점 입력"/></td>
				</tr>
				<tr>
					<td>시간</td>
					<td><input type="number" name="lecTime" placeholder="시간 입력"/></td>
				</tr>
				<tr>
					<td>강의실</td>
					<td><input type="text" name="lecClass" placeholder="강의실 입력"/></td>
				</tr>
				<tr>					
					<td colspan="2" align="right">
						<input type="submit" value="등록하기"/>
					</td>
				</tr>			
			</table>		
		</form>
	</body>
</html>