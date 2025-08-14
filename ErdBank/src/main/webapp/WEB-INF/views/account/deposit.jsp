<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>계좌입금</title>
	</head>
	<body>
		<h3>계좌입금</h3>
		
		<a href="/ErdBank">처음으로</a>
		<a href="/ErdBank/account/list.do">목록이동</a>
		
		<form action="/ErdBank/account/deposit.do" method="post">
			<table border="1">
				<tr>
					<td>계좌번호</td>
					<td><input type="test" name="a_no" /></td>
				</tr>
				<tr>
					<td>입금주</td>
					<td><input type="text" name="c_no"/></td>
				</tr>
				<tr>
					<td>입금액</td>
					<td><input type="number" name="t_amount"/></td>
				</tr>
				<tr>					
					<td colspan="2" align="right">
						<input type="submit" value="입금하기"/>
					</td>
				</tr>			
			</table>		
		</form>
	</body>
</html>