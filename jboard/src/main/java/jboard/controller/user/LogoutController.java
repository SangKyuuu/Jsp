package jboard.controller.user;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jboard.util.ResultCode;

@WebServlet("/user/logout.do")
public class LogoutController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//로그아웃 처리 -> 현재세션(클라이언트)에 저장된 로그인 사용자 객체(sessUser) 제거
		HttpSession session = req.getSession();
		session.removeAttribute("sessUser");
		
		//세션 제거
		session.invalidate();
		
		//이동
		resp.sendRedirect("/jboard/user/login.do?code=" + ResultCode.LOGOUT_SUCCESS.getCode());
	}}
