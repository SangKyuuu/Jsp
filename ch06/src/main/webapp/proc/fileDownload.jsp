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
	
	//다운로드 파일 정보 객체
	FileDTO dto = null;

	//파일 정보 조회
	try{
		//DBCP 커넥션풀 객체 가져오기 
		Context ctx = (Context) new InitialContext().lookup("java:comp/env"); //자바 기본 환경객체 검색(WAS 환경)
		//jdbc/bisunesskyu 커넥션풀 객체 검색
		DataSource ds = (DataSource) ctx.lookup("jdbc/bisunesskyu"); 
		//커넥션풀에서 접속 커넥션 가져오기
		Connection conn = ds.getConnection();
		
		PreparedStatement psmt = conn.prepareStatement("SELECT * FROM FILES WHERE NO = ?");
		psmt.setInt(1, Integer.parseInt(no));
		
		ResultSet rs = psmt.executeQuery();
		
		if(rs.next()){
			dto = new FileDTO();
			dto.setNo(rs.getInt(1));
			dto.setTitle(rs.getString(2));
			dto.setName(rs.getString(3));
			dto.setoName(rs.getString(4));
			dto.setsName(rs.getString(5));
			dto.setRdate(rs.getString(6));
		}
		
		rs.close();
		psmt.close();
		conn.close();
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
	//response 헤더 정보 수정
	response.setContentType("application/octet-stream");
	response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(dto.getoName(), "utf-8"));
	response.setHeader("Content-Transfer-Encoding", "binary");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Cache-Control", "private");
	
	//파일 스트림 작업
	String path = application.getRealPath("/files");
	
	File savedFile = new File(path + File.separator + dto.getsName());
	
	BufferedInputStream bis = new BufferedInputStream(new FileInputStream(savedFile));
	BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream()); //response 스트림으로 출력
	
	//스트림 전송(파일 전송)
	bis.transferTo(bos);
	
	//버퍼 비우기
	bos.flush();
	
	//스트림 종료
	bos.close();
	bis.close();
%>
