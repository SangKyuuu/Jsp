package jboard.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jboard.dto.ArticleDTO;
import jboard.dto.CommentDTO;
import jboard.util.DBHelper;
import jboard.util.Sql;

public class CommentDAO extends DBHelper {
	
	private final static CommentDAO INSTANCE = new CommentDAO();
	public static CommentDAO getInstance() {
		return INSTANCE;
	}	
	private CommentDAO() {}
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public CommentDTO insert(CommentDTO dto) {
		
		CommentDTO savedComment = null;
		
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			psmt = conn.prepareStatement(Sql.INSERT_COMMENT);
			psmt.setInt(1, dto.getAno());
			psmt.setString(2, dto.getContent());
			psmt.setString(3, dto.getWriter());
			psmt.setString(4, dto.getReg_ip());
			psmt.executeUpdate();			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(Sql.SELECT_COMMENT_LATEST);			
			if(rs.next()) {
				savedComment = new CommentDTO();
				savedComment.setCno(rs.getInt(1));
				savedComment.setAno(rs.getInt(2));
				savedComment.setContent(rs.getString(3));
				savedComment.setWriter(rs.getString(4));
				savedComment.setReg_ip(rs.getString(5));
				savedComment.setWdate(rs.getString(6));
				savedComment.setNick(rs.getString(7));
			}
			conn.commit();
			closeAll();			
		}catch (Exception e) {
			logger.error(e.getMessage());
		}		
		return savedComment;
	}
	
	public CommentDTO select(int cno) {
		return null;
	}
	
	public List<CommentDTO> selectAll(String ano) {
		
		List<CommentDTO> dtoList = new ArrayList<CommentDTO>(); 
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_COMMENT_ALL);
			psmt.setString(1, ano);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				CommentDTO dto = new CommentDTO();
				dto.setCno(rs.getInt(1));
				dto.setAno(rs.getInt(2));
				dto.setContent(rs.getString(3));
				dto.setWriter(rs.getString(4));
				dto.setReg_ip(rs.getString(5));
				dto.setWdate(rs.getString(6));
				dto.setNick(rs.getString(7));
				dtoList.add(dto);
			}			
			closeAll();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}		
		return dtoList;
	}
	
	public void update(CommentDTO dto) {
		
	}
	
	public void delete(int cno) {
		
	}
}