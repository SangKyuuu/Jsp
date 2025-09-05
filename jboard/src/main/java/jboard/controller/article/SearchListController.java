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
import jboard.dto.PagenationDTO;
import jboard.service.ArticleService;

@WebServlet("/article/search.do")
public class SearchListController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private ArticleService articleService = ArticleService.INSTANCE;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String pg = req.getParameter("pg");
		String searchType = req.getParameter("searchType");
		String keyword = req.getParameter("keyword");
		
		PagenationDTO pagenationDTO = articleService.getPagenationDTO(pg, searchType, keyword);
		logger.debug(pagenationDTO.toString());
		
		int start = pagenationDTO.getStart();
		
		List<ArticleDTO> dtoList = articleService.findAllSearch(start, searchType, keyword);
		
		req.setAttribute("dtoList", dtoList);
		req.setAttribute("searchType", searchType);
		req.setAttribute("keyword", keyword);
		req.setAttribute("pagenationDTO", pagenationDTO);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/article/searchList.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}