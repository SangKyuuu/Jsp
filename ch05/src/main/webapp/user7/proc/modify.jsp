<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//전송 데이터 수신
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	String email = request.getParameter("email");
	
	//데이터베이스 INSERT
	String host = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "bisunesskyu";
	String pass = "1234";
	
	try{
		//드라이버로드
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//DB접속	
		Connection conn = DriverManager.getConnection(host, user, pass);
		
		//SQL 실행 객체 생성
		String sql = "UPDATE USER7 SET NAME = ? , AGE = ?, EMAIL = ? WHERE ID = ?";
		PreparedStatement psmt = conn.prepareStatement(sql);
		
		psmt.setString(1, name);		
		psmt.setString(2, age);
		psmt.setString(3, email);
		psmt.setString(4, id);
		
		//SQL실행
		psmt.executeUpdate();
		
		//DB연결 종료
		psmt.close();
		conn.close();
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
	//목록페이지로 이동
	response.sendRedirect("../list.jsp");
	
	
%>