<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./_header.jsp" %>
<body>
    <div id="wrapper">
        <header>
            <h3>
                <a href="/index.html" class="title">Board Project</a>
            </h3>
        </header>
        <main id="find">
            <section class="resultUserId">
                <form action="#">
                    <h2 class="tit">아이디 찾기 결과</h2>
                    <table border="0">                        
                        <tr>
                            <td>이름</td>
                            <td>홍길동</td>
                        </tr>
                        <tr>
                            <td>아이디</td>
                            <td>honggildong</td>
                        </tr>
                        <tr>
                            <td>이메일</td>
                            <td>honggildong@gmail.com</td>
                        </tr>
                        <tr>
                            <td>가입일</td>
                            <td>2022-11-16 10:20</td>
                        </tr>
                    </table>                                        
                </form>
                
                <p>
                    고객님의 정보와 일치하는 아이디 입니다.
                </p>

                <div>
                    <a href="../user/login.html" class="btn btnCancel">로그인</a>
                    <a href="./password.html" class="btn btnNext">비밀번호 찾기</a>
                </div>
            </section>
        </main>
<%@ include file="./_footer.jsp" %>