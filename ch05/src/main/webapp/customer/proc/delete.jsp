<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//전송 데이터 수신
	String cid = request.getParameter("cid");
	
	try{
		//DBCP 커넥션풀 객체 가져오기 
		Context ctx = (Context) new InitialContext().lookup("java:comp/env"); //자바 기본 환경객체 검색(WAS 환경)
		
		//jdbc/bisunesskyu 커넥션풀 객체 검색
		DataSource ds = (DataSource) ctx.lookup("jdbc/bisunesskyu"); 
					
		//커넥션풀에서 접속 커넥션 가져오기
		Connection conn = ds.getConnection();
		
		//SQL 실행 객체 생성
		String sql = "DELETE FROM CUSTOMER WHERE CID = ?";
		
		PreparedStatement psmt = conn.prepareStatement(sql);
		
		psmt.setString(1, cid);
		
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