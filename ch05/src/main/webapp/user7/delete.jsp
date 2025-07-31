<%@page import="ch05.User7VO"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
		
	String host = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "bisunesskyu";
	String pass = "1234";
	
	//삭제할 사용자 객체
	User7VO user7 = null;
	
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(host, user, pass);	
		
		
		String sql = "SELECT * FROM USER7 WHERE ID = ?";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, id);
		
		ResultSet rs = psmt.executeQuery();
		
		if(rs.next()){
			user7 = new User7VO();
			user7.setId(rs.getInt(1));
			user7.setName(rs.getString(2));
			user7.setAge(rs.getInt(3));
			user7.setEmail(rs.getString(4));
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
		<title>user7::delete</title>
	</head>
	<body>
		<h3>User7 삭제</h3>
		
		<a href="../jdbc.jsp">처음으로</a>
		<a href="./list.jsp">목록이동</a>
		
		<form action="./proc/delete.jsp" method="post">
			<table border="1">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="id" value="<%=user7.getId() %>" readonly /></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" value="<%=user7.getName() %>" readonly/></td>
				</tr>
				<tr>
					<td>나이</td>
					<td><input type="number" name="age" value="<%=user7.getAge() %>" readonly/></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="email" name="email" value="<%=user7.getEmail() %>" readonly/></td>
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