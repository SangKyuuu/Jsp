<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//전송 데이터 수신
	String cid = request.getParameter("cid");
	String name = request.getParameter("name");
	String hp = request.getParameter("hp");
	String address = request.getParameter("address");
	String rdate = request.getParameter("rdate");
	
	try{
		//DBCP 커넥션풀 객체 가져오기 
		Context ctx = (Context) new InitialContext().lookup("java:comp/env"); //자바 기본 환경객체 검색(WAS 환경)
			
		//jdbc/bisunesskyu 커넥션풀 객체 검색
		DataSource ds = (DataSource) ctx.lookup("jdbc/bisunesskyu"); 
					
		//커넥션풀에서 접속 커넥션 가져오기
		Connection conn = ds.getConnection();
		
		String sql = "UPDATE CUSTOMER SET NAME = ?, HP = ?, ADDRESS = ?, RDATE = ? WHERE CID = ?";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, name);
		psmt.setString(2, hp);
		psmt.setString(3, address);
		psmt.setString(4, rdate);
		psmt.setString(5, cid);
		
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