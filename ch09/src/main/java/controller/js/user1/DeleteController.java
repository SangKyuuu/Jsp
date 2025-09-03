package controller.js.user1;

import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.JsonObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.User1Service;

@WebServlet("/js/user1/delete.do")
public class DeleteController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private User1Service service = User1Service.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid = req.getParameter("uid");
		
		//삭제 서비스 요청
		int rowCount = service.delete(uid);
		
		//응답 JSON 객체 생성
		JsonObject json = new JsonObject();
		json.addProperty("result", rowCount);
		
		//JSON 출력(클라이언트 전송)
		resp.setContentType("application/json; charset=UTF-8");
		PrintWriter out =  resp.getWriter();
		out.print(json.toString());
	}

}
