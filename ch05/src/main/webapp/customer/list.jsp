<%@page import="ch05.CustomerDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.Context"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	List<CustomerDTO> customers = new ArrayList<>();

	try{
		//DBCP 커넥션풀 객체 가져오기 
		Context ctx = (Context) new InitialContext().lookup("java:comp/env"); //자바 기본 환경객체 검색(WAS 환경)
		
		//jdbc/bisunesskyu 커넥션풀 객체 검색
		DataSource ds = (DataSource) ctx.lookup("jdbc/bisunesskyu"); 
				
		//커넥션풀에서 접속 커넥션 가져오기
		Connection conn = ds.getConnection();
		
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery("SELECT * FROM CUSTOMER");
		
		while(rs.next()){
			
			CustomerDTO dto = new CustomerDTO();
			dto.setCid(rs.getString("cid"));
			dto.setName(rs.getString("name"));
			dto.setHp(rs.getString("hp"));
			dto.setAddress(rs.getString("address"));
			dto.setRdate(rs.getString("rdate"));
			
			customers.add(dto);
		}
		
		//커넥션 반납
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
		<title>customer::list</title>
	</head>
	<body>
		<h3>Customer 목록</h3>
		
		<a href="../dbcp.jsp">처음으로</a>
		<a href="./register.jsp">등록하기</a>
		
		<table border="1">
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>휴대폰</th>
				<th>주소</th>
				<th>등록일</th>
				<th>관리</th>
			</tr>
			<%for(CustomerDTO customer : customers){ %>
			<tr>
				<td><%=customer.getCid() %></td>
				<td><%=customer.getName() %></td>
				<td><%=customer.getHp() %></td>
				<td><%=customer.getAddress() %></td>
				<td><%=customer.getRdate().substring(0,10) %></td>
				<td>
					<a href="/ch05/customer/modify.jsp?cid=<%=customer.getCid()%>">수정</a>
					<a href="/ch05/customer/delete.jsp?cid=<%=customer.getCid()%>">삭제</a>
				</td>
			</tr>
			<%} %>
		</table>
	</body>
</html>