package controller.register;

import java.io.IOException;

import dto.RegisterDTO;
import dto.StudentDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.RegisterService;

@WebServlet("/register/request.do")
public class RequestController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private RegisterService service = RegisterService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//전송 데이터 수신
		String lecNo = req.getParameter("lecNo");
		
		//현재 세션 구하기	
		HttpSession session = req.getSession();
		
		//현재 로그인 사용자 구하기
		StudentDTO sessStudent = (StudentDTO) session.getAttribute("sessStudent");
		String stdNo = sessStudent.getStdNo();
		
		RegisterDTO dto = new RegisterDTO();
		dto.setRegStdNo(stdNo);
		dto.setRegLecNo(lecNo);
		
		service.register(dto);
		
		//수강목록 이동
		resp.sendRedirect("/ErdCollege/lecture/list.do");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
