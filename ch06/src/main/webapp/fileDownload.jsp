<%@page import="ch06.FileDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	List<FileDTO> files = new ArrayList<>();

	try{
		//DBCP 커넥션풀 객체 가져오기 
		Context ctx = (Context) new InitialContext().lookup("java:comp/env"); //자바 기본 환경객체 검색(WAS 환경)
			
		//jdbc/bisunesskyu 커넥션풀 객체 검색
		DataSource ds = (DataSource) ctx.lookup("jdbc/bisunesskyu"); 
					
		//커넥션풀에서 접속 커넥션 가져오기
		Connection conn = ds.getConnection();
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM FILES");
		
		while(rs.next()){
			FileDTO dto = new FileDTO();
			dto.setNo(rs.getInt(1));
			dto.setTitle(rs.getString(2));
			dto.setName(rs.getString(3));
			dto.setoName(rs.getString(4));
			dto.setsName(rs.getString(5));
			dto.setRdate(rs.getString(6));
			
			files.add(dto);
			
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
		<title>fileDownload</title>
		<!-- 
			25/07/30
			최상규
			JSP 파일 업로드 실습하기
		 -->
	</head>
	<body>
		<h3>파일 다운로드</h3>
			<table border="1">
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>파일명</th>
					<th>관리</th>
				</tr>
				<%for(FileDTO fd : files){ %>
					<tr>
						<td><%=fd.getNo() %></td>
						<td><%=fd.getTitle() %></td>
						<td><%=fd.getName() %></td>
						<td><a href="/ch06/proc/fileDownload.jsp?no=<%=fd.getNo()%>"><%=fd.getoName() %></a></td>
						<td>
							<a href="#">삭제</a>
							<a href="/ch06/proc/fileDelete.jsp?no=<%=fd.getNo()%>">다운로드</a>
						</td>
					</tr>
				<%} %>
			</table>
	</body>
</html>