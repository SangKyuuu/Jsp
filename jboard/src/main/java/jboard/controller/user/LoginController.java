package jboard.controller.user;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jboard.dto.UserDTO;
import jboard.service.UserService;
import jboard.util.ResultCode;

@WebServlet("/user/login.do")
public class LoginController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private UserService userService = UserService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String code = req.getParameter("code");
		
		if(code != null) {
			ResultCode rc = ResultCode.fromCode(Integer.parseInt(code));
			String message = rc.getMessage();
			req.setAttribute("message", message);
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/login.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//전송 데이터 수신
		String uid = req.getParameter("uid");
		String pass = req.getParameter("pass");
		
		UserDTO dto = new UserDTO();
		dto.setUsid(uid);
		dto.setPass(pass);
		
		logger.debug("dto : " + dto.toString());
		
		//서비스 요청
		UserDTO userDTO = userService.findByPass(dto);
		
		if(userDTO != null) {
			//회원이 맞으면 세션 저장
			HttpSession session =  req.getSession();
			session.setAttribute("sessUser", userDTO);
			
			//목록 이동
			resp.sendRedirect("/jboard/article/list.do");
		}else {
			//회원이 아니면 로그인 이동
			resp.sendRedirect("/jboard/user/login.do?code="+ ResultCode.LOGIN_FAIL.getCode());
		}
		
	}
}
