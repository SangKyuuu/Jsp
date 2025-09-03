<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>user1::register</title>
		<script type="text/javascript">
			document.addEventListener('DOMContentLoaded', function(){
				const form = document.formUser1;
				
				form.addEventListener('submit', function(e){
					e.preventDefault();
					
					//JSON 생성(form에 입력한 데이터)
					const jsonData = {
						"user_id" : this.user_id.value,
						"name" : this.name.value,
						"hp" : this.hp.value,
						"age" : this.age.value
					};
					
					console.log(jsonData);
					
					//서버전송
					fetch('/ch09/js/user1/register.do', {
						method: 'POST',
						headers: {"Content-Type": "application/json"}, //반드시 설정
						body: JSON.stringify(jsonData)
					})
						.then(res => res.json())
						.then(data => {
							//서버에서 전송된 JSON데이터 
							console.log(data);
							
							if(data.result > 0){
								alert('등록 성공!');
							}else{
								alert('등록 실패!');
							}
							
							//목록 이동
							location.href = '/ch09/js/user1/list.do';
						})
						.catch(err =>{
							console.log(err);
						});
				});
			});
		</script>
		
	</head>
	<body>
		<h3>User1 등록</h3>
		
		<a href="/ch09">처음으로</a>
		<a href="/ch09/js/user1/list.do">목록이동</a>
		
		<form name="formUser1">
			<table border="1">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="user_id" /></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" /></td>
				</tr>
				<tr>
					<td>휴대폰</td>
					<td><input type="text" name="hp" /></td>
				</tr>
				<tr>
					<td>나이</td>
					<td><input type="number" name="age" /></td>
				</tr>
				<tr>
					<td colspan="2" align="right">
						<input type="submit" value="등록하기"/>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>