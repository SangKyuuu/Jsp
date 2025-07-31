<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ch05.User7VO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	
	String host = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "bisunesskyu";
	String pass = "1234";
	
	List<User7VO> users = new ArrayList<>();

	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(host, user, pass);	
		
		Statement stmt = conn.createStatement();
		
		String sql = "SELECT * FROM USER7";
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()){
			User7VO vo = new User7VO();
			vo.setId(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setAge(rs.getInt(3));
			vo.setEmail(rs.getString(4));
			
			users.add(vo);
		}
		
		rs.close();
		stmt.close();
		conn.close();
		
	}catch(Exception e){
		e.printStackTrace();
	}

%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>user7::list</title>
	</head>
	<body>
		<h3>User7 목록</h3>
		
		<a href="../jdbc.jsp">처음으로</a>
		<a href="./register.jsp">등록하기</a>
		
		<table border="1">
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>나이</th>
				<th>이메일</th>
				<th>관리</th>
			</tr>
			<%for(User7VO user7VO : users){ %>
				<tr>
					<td><%=user7VO.getId() %></td>
					<td><%=user7VO.getName() %></td>
					<td><%=user7VO.getAge() %></td>
					<td><%=user7VO.getEmail() %></td>
					<td>
						<!-- 수정하고자 하는 사용자 아이디를 modify.jsp로 전송 -->
						<a href="./modify.jsp?id=<%=user7VO.getId()%>">수정</a>
						<a href="./delete.jsp?id=<%=user7VO.getId()%>">삭제</a>
					</td>
				</tr>
			<% } %>		
		</table>
	</body>
</html>