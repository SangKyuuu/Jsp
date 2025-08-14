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
public class LoginController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private CustomerService service = CustomerService.INSTANCE;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String c_no = req.getParameter("c_no");
		String c_name = req.getParameter("c_name");
		
		CustomerDTO dto = service.findByIdAndName(c_no, c_name);
		
		if(dto != null) {
			//회원이 맞을경우 dto를 현재 세션에 저장
			HttpSession session = req.getSession();
			session.setAttribute("sessCustomer", dto);
			
			//이동
			resp.sendRedirect("/ErdBank/?login=success");
			
		}else {
			//이동
			resp.sendRedirect("/ErdBank/?login=fail");
		}

	}
}
