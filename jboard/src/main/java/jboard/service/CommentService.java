package jboard.service;

import java.util.List;

import jboard.dao.CommentDAO;
import jboard.dto.CommentDTO;

public enum CommentService {
	INSTANCE;
	
	private CommentDAO dao = CommentDAO.getInstance();
	
	public void register(CommentDTO dto) {
		dao.insert(dto);
	}
	
	public CommentDTO findById(int cno) {
		return dao.select(cno);
	}
	
	public List<CommentDTO> findAll() {
		return dao.selectAll();
	}
	
	public void modify(CommentDTO dto) {
		dao.update(dto);
	}
	
	public void remove(int cno) {
		dao.delete(cno);
	}
}	
