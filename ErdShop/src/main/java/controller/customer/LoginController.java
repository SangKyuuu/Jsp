package controller.customer;

import java.io.IOException;

import dto.CustomerDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.CustomerService;

@WebServlet("/customer/login.do")
public class LoginController extends HttpServlet {
	private CustomerService service = CustomerService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//뷰 포워드
		RequestDispatcher dispatcher =  req.getRequestDispatcher("/WEB-INF/views/customer/list.jsp");
		dispatcher.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String custid = req.getParameter("custid");
		
		//회원이 아니면 null
		CustomerDTO dto = service.findById(custid);
		
		if(dto != null) {
			//회원일 경우(세션처리) -> 회원이 맞을 경우에 DB에서 조회환 회원객체를 세션저장
			HttpSession session =  req.getSession();
			session.setAttribute("sessUser", dto);
			
			//상품목록 이동
			resp.sendRedirect("/shopApp/product/list.do?login=success");
			
		}else {
			//회원이 아니면 상품목록으로 이동
			resp.sendRedirect("/shopApp/product/list.do?login=fail");
		}
	}
}
