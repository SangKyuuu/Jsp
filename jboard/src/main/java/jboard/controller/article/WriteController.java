package jboard.controller.article;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jboard.dto.ArticleDTO;
import jboard.dto.FileDTO;
import jboard.service.ArticleService;
import jboard.service.FileService;
import jboard.util.ResultCode;

@WebServlet("/article/write.do")
public class WriteController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private ArticleService articleService = ArticleService.INSTANCE;
	private FileService fileService = FileService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/article/write.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");
		String regIp = req.getRemoteAddr();
		
		//첨부파일 업로드
		List<FileDTO> files = fileService.fileUpload(req);
		
		ArticleDTO dto = new ArticleDTO();
		dto.setTitle(title);
		dto.setContent(content);
		dto.setFile_cnt(files.size());
		dto.setWriter(writer);
		dto.setReg_ip(regIp);
		
		logger.debug("ArticleDTO : " + dto);
		
		//글 등록
		int ano = articleService.register(dto);
		
		for(FileDTO file : files) {
			//FileDTO 생성
			FileDTO fileDTO = new FileDTO();
			fileDTO.setAno(ano);
			fileDTO.setOname(file.getOname());
			fileDTO.setSname(file.getSname());
			
			//파일 등록
			fileService.register(fileDTO);
		}
		
		resp.sendRedirect("/jboard/article/list.do?code=" + ResultCode.WRITE_SUCCESS.getCode());
	}

}
