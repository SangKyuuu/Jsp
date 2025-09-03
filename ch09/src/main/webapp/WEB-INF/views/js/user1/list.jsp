<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>user1::list</title>
		
		<script type="text/javascript">
			document.addEventListener('DOMContentLoaded', function(){
				
				const table = document.getElementsByTagName('table')[0];
				
				//목록 데이터 요청
				fetch('/ch09/js/user1/getUser1All.do')
					.then(res => res.json())
					.then(data => {
						console.log(data);
						
						for(const user of data){
							
							const tr = `<tr>
											<td>\${user.user_id}</td>
											<td>\${user.name}</td>
											<td>\${user.hp}</td>
											<td>\${user.age}</td>
											<td>
												<a href="#" class="modify" data-uid='\${user.user_id}'>수정</a>
												<a href="#" class="remove" data-uid='\${user.user_id}'>삭제</a>
											</td>
										</tr>`;
							table.insertAdjacentHTML('beforeEnd', tr);
						}
						
					})
					.catch(err => {
						console.log(err);
					});
				
				/*
					동적 이벤트 처리
					- 동적으로 생성되는 태그는 이벤트 처리를 할 수 없음
					- 동적 이벤트 처리를 위해 document 문서객체로 이벤트 구현
					- 특정 문서객체를 대상으로 이벤트 처리
				*/
				
				document.addEventListener('click', function(e){
					e.preventDefault();
					
					//수정 클릭
					if(e.target.classList == 'modify'){
						
						//사용자 정의 속성(data- 로 시작하는)으로 수정 아이디 가져오기
						const uid = e.target.dataset.uid;
						
						//수정페이지 이동
						location.href='/ch09/js/user1/modify.do?uid='+uid;
					}
					
					//삭제 클릭
					if(e.target.classList == 'remove'){
						//삭제 예정 문서 객체
						const tr = e.target.closest('tr');
						
						//삭제 아이디 가져오기
						const uid = e.target.dataset.uid;
						
						//삭제 요청하기
						fetch('/ch09/js/user1/delete.do?uid='+uid)
							.then(res => res.json)
							.then(data => {
								console.log(data);
								
								if(data.result > 0){
									alert('삭제완료!');
								}else{
									alert('삭제실패!');
								}
								
								/*
									삭제한 문서객체 제거
									location.reload(); - 새로고침 -> 불필요한 요청이 발생
								*/
								
								//삭제한 문서객체 제거
								tr.remove();
								
							})
							.catch(err => {
								console.log(err);
							});
						
					}
					
					
				});
				
			});
		</script>
		
	</head>	
	<body>
		<h3>User1 목록</h3>
		
		<a href="/ch09">처음으로</a>
		<a href="/ch09/js/user1/register.do">등록하기</a>
		
		<table border="1">
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>휴대폰</th>
				<th>나이</th>
				<th>관리</th>
			</tr>
		</table>
	</body>
</html>