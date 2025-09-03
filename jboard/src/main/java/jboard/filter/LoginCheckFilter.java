package jboard.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jboard.dto.UserDTO;
import jboard.util.ResultCode;

@WebFilter(urlPatterns = {"/article/*"})
public class LoginCheckFilter implements Filter {
	
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)throws IOException, ServletException {
		//로그인 여부 확인
		HttpServletRequest req = (HttpServletRequest) servletRequest;
		HttpSession session = req.getSession();
		
		UserDTO sessUser = (UserDTO) session.getAttribute("sessUser");
		
		if(sessUser == null) {
			//로그인을 하지 않았으면 로그인으로 이동
			HttpServletResponse resp = (HttpServletResponse)servletResponse;
			resp.sendRedirect("/jboard/user/login.do?code=" + ResultCode.LOGIN_REQUIRE.getCode());
			return; //처리 종료
		}
		
		//다음 필터 요청(Controller 요청)
		chain.doFilter(servletRequest, servletResponse);
		
	}

}
