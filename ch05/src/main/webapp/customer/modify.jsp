<%@page import="ch05.CustomerDTO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String cid = request.getParameter("cid");
	CustomerDTO dto = null;
	
	//DBCP 커넥션풀 객체 가져오기 
	Context ctx = (Context) new InitialContext().lookup("java:comp/env"); //자바 기본 환경객체 검색(WAS 환경)
		
	//jdbc/bisunesskyu 커넥션풀 객체 검색
	DataSource ds = (DataSource) ctx.lookup("jdbc/bisunesskyu"); 
				
	//커넥션풀에서 접속 커넥션 가져오기
	Connection conn = ds.getConnection();
	
	PreparedStatement psmt = conn.prepareStatement("SELECT * FROM CUSTOMER WHERE CID = ?");
	psmt.setString(1, cid);
	
	ResultSet rs = psmt.executeQuery();
	
	if(rs.next()){
		dto = new CustomerDTO();
		dto.setCid(rs.getString(1));
		dto.setName(rs.getString(2));
		dto.setHp(rs.getString(3));
		dto.setAddress(rs.getString(4));
		dto.setRdate(rs.getString(5));
	}
	
	rs.close();
	psmt.close();
	conn.close();
	
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>customer::modify</title>
	</head>
	<body>
		<h3>Customer 수정</h3>
		
		<a href="../dbcp.jsp">처음으로</a>
		<a href="./list.jsp">목록이동</a>
		
		<form action="./proc/modify.jsp" method="post">
			<table border="1">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="cid" value="<%=dto.getCid()%>" readonly/></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" value="<%=dto.getName()%>"/></td>
				</tr>
				<tr>
					<td>휴대폰</td>
					<td><input type="text" name="hp" value="<%=dto.getHp()%>"/></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="address" value="<%=dto.getAddress()%>"/></td>
				</tr>
				<tr>
					<td>등록일</td>
					<td><input type="date" name="rdate" value="<%=dto.getRdate()%>"/></td>
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