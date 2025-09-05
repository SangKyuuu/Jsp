package jboard.service;

import java.util.List;


import jboard.dao.CommentDAO;
import jboard.dto.ArticleDTO;
import jboard.dto.CommentDTO;

public enum CommentService {
	
	INSTANCE;
	
	private CommentDAO dao = CommentDAO.getInstance();
	
	public CommentDTO register(CommentDTO dto) {
		return dao.insert(dto);
	}	
	public CommentDTO findById(int cno) {
		return dao.select(cno);
	}
	public List<CommentDTO> findAll(String ano) {
		return dao.selectAll(ano);
	}
	public void modify(CommentDTO dto) {
		dao.update(dto);
	}	
	public void remove(int cno) {
		dao.delete(cno);
	}
}