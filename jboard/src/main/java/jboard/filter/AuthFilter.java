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

@WebFilter(urlPatterns = {"/article/write.do", "/article/view.do", "/article/delete.do", "/article/modify.do"})
public class AuthFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		
		UserDTO sessUser = (UserDTO) session.getAttribute("sessUser");
		String role = sessUser.getUs_role();
		
		// 인가처리
		if(role.equals("GUEST")) {
			HttpServletResponse  resp = (HttpServletResponse) response;
			resp.sendRedirect("/jboard/article/list.do?code="+ResultCode.ROLE_NOT_ENOUGH.getCode());
			return;
		}
		
		chain.doFilter(request, response);		
	}
}