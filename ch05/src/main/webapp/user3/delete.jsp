<%@page import="ch05.User3VO"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String user_id = request.getParameter("user_id");
		
	String host = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "bisunesskyu";
	String pass = "1234";
	
	//삭제할 사용자 객체
	User3VO user3 = null;
	
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(host, user, pass);	
		
		
		String sql = "SELECT * FROM USER3 WHERE USER_ID = ?";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, user_id);
		
		ResultSet rs = psmt.executeQuery();
		
		if(rs.next()){
			user3 = new User3VO();
			user3.setUser_id(rs.getString(1));
			user3.setName(rs.getString(2));
			user3.setHp(rs.getString(3));
			user3.setAge(rs.getInt(4));
		}
		
		rs.close();
		psmt.close();
		conn.close();
		
	}catch(Exception e){
		e.printStackTrace();
	}

%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>user3::modify</title>
	</head>
	<body>
		<h3>User3 삭제</h3>
		
		<a href="../jdbc.jsp">처음으로</a>
		<a href="./list.jsp">목록이동</a>
		
		<form action="./proc/delete.jsp" method="post">
			<table border="1">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="user_id" value="<%=user3.getUser_id() %>" readonly /></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" value="<%=user3.getName() %>" readonly/></td>
				</tr>
				<tr>
					<td>휴대폰</td>
					<td><input type="text" name="hp" value="<%=user3.getHp() %>" readonly/></td>
				</tr>
				<tr>
					<td>나이</td>
					<td><input type="number" name="age" value="<%=user3.getAge() %>" readonly/></td>
				</tr>
				<tr>
					<td colspan="2" align="right">
						<input type="submit" value="삭제하기"/>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>