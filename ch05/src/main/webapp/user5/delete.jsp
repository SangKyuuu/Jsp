<%@page import="ch05.User5VO"%>
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
	User5VO user5 = null;
	
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(host, user, pass);	
		
		
		String sql = "SELECT * FROM USER5 WHERE NAME = ?";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, user_id);
		
		ResultSet rs = psmt.executeQuery();
		
		if(rs.next()){
			user5 = new User5VO();
			user5.setName(rs.getString(1));
			user5.setGender(rs.getString(2));
			user5.setAge(rs.getInt(3));
			user5.setAddr(rs.getString(4));
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
		<title>user5::modify</title>
	</head>
	<body>
		<h3>User5 삭제</h3>
		
		<a href="../jdbc.jsp">처음으로</a>
		<a href="./list.jsp">목록이동</a>
		
		<form action="./proc/delete.jsp" method="post">
			<table border="1">
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" value="<%=user5.getName() %>" readonly/></td>
				</tr>
				<tr>
					<td>성별</td>
					<%if(user5.getGender().equals("M")){  %>
						<td><input type="radio" name="gender" value="M" checked="checked" readonly/>남자</td>
						<td><input type="radio" name="gender" value="F" readonly/>여자</td>
					<%} else{ %>
						<td><input type="radio" name="gender" value="M" readonly/>남자</td>
						<td><input type="radio" name="gender" value="F" checked="checked" readonly/>여자</td>
					<%} %>
				</tr>
				<tr>
					<td>나이</td>
					<td><input type="number" name="age" value="<%=user5.getAge() %>" readonly/></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="addr" value="<%=user5.getAddr() %>" readonly /></td>
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