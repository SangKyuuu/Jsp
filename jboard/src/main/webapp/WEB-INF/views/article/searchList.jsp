<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ include file="./_header.jsp" %>
<main id="article">
    <section class="list">
        <nav>
            <h1>
                <a href="/jboard/article/list.do">전체 글목록</a>&nbsp;/&nbsp;검색 <span>${pagenationDTO.total}건</span>
            </h1>
            <jsp:include page="./_searchForm.jsp"></jsp:include>
        </nav>
        <table border="0">
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>글쓴이</th>
                <th>날짜</th>
                <th>조회</th>
            </tr>
            <c:forEach var="article" items="${dtoList}" varStatus="status">            	
	            <tr>
	                <td>${pagenationDTO.currentPageStartNum - status.index}</td>
	                <td><a href="/jboard/article/view.do?ano=${article.ano}">${article.title} [${article.comment_cnt}]</a></td>
	                <td>${article.nick}</td>
	                <td>${article.wdate}</td>
	                <td>${article.hit_cnt}</td>
	            </tr>
            </c:forEach>
        </table>

        <div class="page">
        	<c:if test="${pagenationDTO.pageGroupStart > 1}">
            	<a href="/jboard/article/search.do?pg=${pagenationDTO.pageGroupStart-1}&searchType=${searchType}&keyword=${keyword}" class="prev">이전</a>
            </c:if>
            <c:forEach var="num" begin="${pagenationDTO.pageGroupStart}" end="${pagenationDTO.pageGroupEnd}" >
            	<a href="/jboard/article/search.do?pg=${num}&searchType=${searchType}&keyword=${keyword}" class="num ${pagenationDTO.currentPage == num ? 'current' : 'off'}">${num}</a>
            </c:forEach>
            <c:if test="${pagenationDTO.pageGroupEnd < pagenationDTO.lastPageNum}">
            	<a href="/jboard/article/search.do?pg=${pagenationDTO.pageGroupEnd+1}&searchType=${searchType}&keyword=${keyword}" class="next">다음</a>
            </c:if>
        </div>
        <a href="./write.html" class="btn btnWrite">글쓰기</a>
        
    </section>
</main>
<%@ include file="./_footer.jsp" %>