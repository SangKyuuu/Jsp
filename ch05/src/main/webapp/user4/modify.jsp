<%@page import="ch05.User4VO"%>
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
	
	//수정할 사용자 객체
	User4VO user4 = null;
	
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(host, user, pass);	
		
		
		String sql = "SELECT * FROM USER4 WHERE NAME = ?";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, user_id);
		
		ResultSet rs = psmt.executeQuery();
		
		if(rs.next()){
			user4 = new User4VO();
			user4.setName(rs.getString(1));
			user4.setGender(rs.getString(2));
			user4.setAge(rs.getInt(3));
			user4.setAddr(rs.getString(4));
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
		<title>user4::modify</title>
	</head>
	<body>
		<h3>User4 수정</h3>
		
		<a href="../jdbc.jsp">처음으로</a>
		<a href="./list.jsp">목록이동</a>
		
		<form action="./proc/modify.jsp" method="post">
			<table border="1">
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" value="<%=user4.getName() %>" readonly/></td>
				</tr>
				<tr>
					<td>성별</td>
					<%if(user4.getGender().equals("M")){  %>
						<td><input type="radio" name="gender" value="M" checked="checked"/>남자</td>
						<td><input type="radio" name="gender" value="F"/>여자</td>
					<%} else{ %>
						<td><input type="radio" name="gender" value="M" />남자</td>
						<td><input type="radio" name="gender" value="F" checked="checked"/>여자</td>
					<%} %>
				</tr>
				<tr>
					<td>나이</td>
					<td><input type="number" name="age" value="<%=user4.getAge() %>"/></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="addr" value="<%=user4.getAddr() %>"/></td>
				</tr>
				<tr>
					<td colspan="2" align="right">
						<input type="submit" value="수정하기"/>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>