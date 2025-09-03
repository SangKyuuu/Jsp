package controller.js.user1;

import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;

import dto.User1DTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.User1Service;

@WebServlet("/js/user1/getUser1.do")
public class GetUser1Controller extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private User1Service service = User1Service.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid = req.getParameter("uid");

		//수정 데이터 요청
		User1DTO dto =  service.findById(uid);
		
		//JSON 데이터 변환
		Gson gson = new Gson();
		String strJson = gson.toJson(dto);
		
		//Json 출력(클라이언트 전송)
		resp.setContentType("application/json; charset=UTF-8");
		
		PrintWriter out =  resp.getWriter();
		out.print(strJson);
	}

}
