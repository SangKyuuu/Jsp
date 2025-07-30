<%@page import="java.net.URLEncoder"%>
<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.BufferedInputStream"%>
<%@page import="java.io.File"%>
<%@page import="ch06.FileDTO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//파일 번호 수신
	String no = request.getParameter("no");

	String savedName = null;

	//파일 정보 삭제
	try{
		//DBCP 커넥션풀 객체 가져오기 
		Context ctx = (Context) new InitialContext().lookup("java:comp/env"); //자바 기본 환경객체 검색(WAS 환경)
		//jdbc/bisunesskyu 커넥션풀 객체 검색
		DataSource ds = (DataSource) ctx.lookup("jdbc/bisunesskyu"); 
		//커넥션풀에서 접속 커넥션 가져오기
		Connection conn = ds.getConnection();
		
		String sql = "DELETE FROM FILES WHERE NO = ?";
		
		PreparedStatement psmt = conn.prepareStatement("SELECT SNAME FROM FILES WHERE NO = ?");
		psmt.setInt(1, Integer.parseInt(no));
		
		ResultSet rs = psmt.executeQuery();
		
		if(rs.next()){
			savedName = rs.getString(1);
		}
		
		PreparedStatement psmtD = conn.prepareStatement("DELETE FROM FILES WHERE NO = ?");
		psmtD.setString(1, no);
		
		psmtD.executeUpdate();
		
		rs.close();
		psmtD.close();
		psmt.close();
		conn.close();
		
	}catch(Exception e){
		e.printStackTrace();
	}
	//저장된 파일 삭제
	String path = application.getRealPath("/files");
	
	File savedFile = new File(path + File.separator + savedName);
	
	savedFile.delete();
	
	//목록 이동
	response.sendRedirect("/ch06/fileDownload.jsp");
%>
