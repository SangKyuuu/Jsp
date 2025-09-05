<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ include file="./_header.jsp" %>
<script>	
	document.addEventListener('DOMContentLoaded', function(){
		
		const formComment = document.formComment; // form 태그의 name 속성으로 문서객체 참조
		
		// 댓글 입력
		formComment.addEventListener('submit', function(e){
			e.preventDefault();
			
			// 폼 데이터 생성
			const formData = new FormData();
			formData.append('ano', formComment.ano.value);
			formData.append('writer', formComment.writer.value);
			formData.append('content', formComment.content.value);
			console.log(formData);
			
			// 데이터 전송
			fetch('/jboard/comment/write.do', {
				method: 'POST',
				body: formData
			})
				.then(response => response.json())
				.then(data => {
					console.log(data);					
					const commentArticle = `<article>
								                <span class="nick">\${data.nick}</span>
								                <span class="date">\${data.wdate}</span>
								                <p class="content">\${data.content}</p>                        
								                <div>
								                    <a href="#" class="remove">삭제</a>
								                    <a href="#" class="modify">수정</a>
								                </div>
								            </article>`;
					
		            commentList.insertAdjacentHTML('beforeEnd', commentArticle);
					empty.remove();
								            
								            
					// 폼 초기화(입력했던 데이터 비우기)
					formComment.reset();
										
				})
				.catch(err => {
					console.log(err);
				});
			
		}); // 댓글 입력 끝
		
		
		// 댓글 목록 출력
		const commentList = document.getElementsByClassName('commentList')[0];
		const empty = commentList.getElementsByClassName('empty')[0];
		
		const ano = ${articleDTO.ano};
			
		fetch('/jboard/comment/list.do?ano='+ano)
			.then(resp => resp.json())
			.then(data => {
				console.log(data);
				
				for(const comment of data){
					const commentArticle = `<article>
								                <span class="nick">\${comment.nick}</span>
								                <span class="date">\${comment.wdate}</span>
								                <p class="content">\${comment.content}</p>                        
								                <div>
								                    <a href="#" class="remove">삭제</a>
								                    <a href="#" class="modify">수정</a>
								                </div>
								            </article>`;								            
					
					commentList.insertAdjacentHTML('beforeEnd', commentArticle);
					empty.remove();
				}
			})
			.catch(err => {
				console.log(err);
			});
		
		
		// 글삭제
		const btnRemove = document.getElementsByClassName('btnRemove')[0];
		
		btnRemove.addEventListener('click', function(e){
			
			if(!confirm('정말 삭제 하시겠습니까?')){
				e.preventDefault();		
			}
		});
		
		
	});


</script>



<main id="article">
    <section class="view">
        <nav>
            <h1>글보기</h1>
        </nav>
        <table border="0">                    
            <tr>
                <th>제목</th>
                <td><input type="text" name="title" value="${articleDTO.title}" readonly/></td>
            </tr>
            <tr>
                <th>작성자</th>
                <td><input type="text" name="writer" value="${articleDTO.writer}(${articleDTO.nick})" readonly/></td>
            </tr>
            <c:if test="${articleDTO.file_cnt gt 0}">
	            <tr>
	                <th>파일</th>
	                <td>
	                	<c:forEach var="file" items="${articleDTO.files}">
	                    	<p><a href="/jboard/file/download.do?fno=${file.fno}">${file.oname}</a>&nbsp;<span>${file.download}</span>회 다운로드</p>
	                    </c:forEach>
	                </td>
	            </tr>
            </c:if>
            <tr>
                <th>내용</th>
                <td>
                    <textarea name="content" readonly>${articleDTO.content}</textarea>
                </td>
            </tr>                    
        </table>
        
        <div>
        	<c:if test="${sessUser.usid eq articleDTO.writer}">
	            <a href="/jboard/article/delete.do?ano=${articleDTO.ano}" class="btn btnRemove">삭제</a>
	            <a href="/jboard/article/modify.do" class="btn btnModify">수정</a>
            </c:if>
            <a href="/jboard/article/list.do" class="btn btnList">목록</a>
        </div>

        <!-- 댓글목록 -->
        <section class="commentList">
            <h3>댓글목록</h3>
            <p class="empty">등록된 댓글이 없습니다.</p>
		</section>
		
        <!-- 댓글쓰기 -->
        <section class="commentForm">
            <h3>댓글쓰기</h3>
            <form name="formComment">
            	<input type="hidden" name="ano" value="${articleDTO.ano}">
            	<input type="hidden" name="writer" value="${sessUser.usid}">
                <textarea name="content" placeholder="댓글 입력"></textarea>
                <div>
                    <a href="#" class="btn btnCancel">취소</a>
                    <input type="submit" value="작성완료" class="btn btnComplete"/>
                </div>
            </form>
        </section>

    </section>
</main>
<%@ include file="./_footer.jsp" %>