<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form action="/jboard/article/search.do" method="get">
    <select name="searchType">
		<option value="title">제목</option>
		<option value="content">내용</option>
		<option value="nick">글쓴이</option>
	</select>
    <input type="text" name="keyword" placeholder="검색 키워드 입력">
    <input type="submit" value="검색">
</form>
        