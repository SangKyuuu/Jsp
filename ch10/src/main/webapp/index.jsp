<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>index</title>
		<!-- 
			날짜 : 2025/08/01
			이름 : 최상규
			내용 : 프로젝트 로그와 배포 실습하기			
			
			로그
			 - 시스템의 실행과정 및 서비스 개선을 위한 작업
			 - 로그 단계별 기록을 통해 서비스 개선
			 
			라이브러리(Maven 다운로드)
			 - logback-classic-1.5.18.jar
			 - logback-core-1.5.18.jar
			 - slf4j-api-2.0.17.jar
			
			로그 설정
			 - WEB-INF > classes 폴더 생성 > logback.xml 파일생성
			 - https://logback.qos.ch/manual/configuration.html 에서 설정 XML 복사
			
			배포
			 - 이클립스 프로젝트 > export > war 생성
			 - C:\Users\GGG\apache-tomcat-10.1.43\bin\startup.bat 실행
			 - C:\Users\GGG\apache-tomcat-10.1.43\webapps 폴더에 배포파일(ch10.war) 업로드 후 Deploy 확인 후 브라우저 확인
		-->		
	</head>
	<body>
		<h3>프로젝트 로그와 배포</h3>
		
		<h4>Shop</h4>
		<a href="/ch10/shop/customer/list.do">Customer CRUD</a>
		<a href="/ch10/shop/product/list.do">Product CRUD</a>
		
		<h4>College</h4>
		<a href="/ch10/college/student/list.do">Student CRUD</a>
		<a href="/ch10/college/course/list.do">Course CRUD</a>
		
		<h4>Bank</h4>
		<a href="/ch10/bank/account/list.do">Account CRUD</a>
		<a href="/ch10/bank/customer/list.do">Customer CRUD</a>
		
		<h4>Library</h4>
		<a href="/ch10/library/member/list.do">Member CRUD</a>
		<a href="/ch10/library/book/list.do">Book CRUD</a>
		
		<h4>User(MySQL)</h4>
		<a href="/ch10/user1/list.do">user1 CRUD</a>
		<a href="/ch10/user2/list.do">user2 CRUD</a>
		<a href="/ch10/user3/list.do">user3 CRUD</a>
		<a href="/ch10/user4/list.do">user4 CRUD</a>
		<a href="/ch10/user5/list.do">user5 CRUD</a>
		
	</body>
</html>