package controller.lecture;

import java.io.IOException;

import dto.LectureDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.LectureService;

@WebServlet("/lecture/register.do")
public class RegisterController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private LectureService service = LectureService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/lecture/register.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		LectureDTO dto = new LectureDTO();
		dto.setLecNo(req.getParameter("lecNo"));
		dto.setLecName(req.getParameter("lecName"));
		dto.setLecCredit(req.getParameter("lecCredit"));
		dto.setLecTime(req.getParameter("lecTime"));
		dto.setLecClass(req.getParameter("lecClass"));		
		
		service.register(dto);
		
		resp.sendRedirect("/ErdCollege/lecture/list.do");
		
	}
}
