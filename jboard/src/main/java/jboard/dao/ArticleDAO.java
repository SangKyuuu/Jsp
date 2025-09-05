package jboard.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jboard.dto.ArticleDTO;
import jboard.dto.FileDTO;
import jboard.util.DBHelper;
import jboard.util.Sql;

public class ArticleDAO extends DBHelper {
	
	private final static ArticleDAO INSTANCE = new ArticleDAO();
	public static ArticleDAO getInstance() {
		return INSTANCE;
	}	
	private ArticleDAO() {}
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	public int insert(ArticleDTO dto) {
		
		int ano = 0;
		
		try {
			conn = getConnection();
			
			conn.setAutoCommit(false); // 트랜잭션 시작			
			psmt = conn.prepareStatement(Sql.INSERT_ARTICLE);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setInt(3, dto.getFile_cnt());
			psmt.setString(4, dto.getWriter());
			psmt.setString(5, dto.getReg_ip());
			psmt.executeUpdate();
			
			// 방금 INSERT한 글 번호 조회
			stmt = conn.createStatement();
			rs = stmt.executeQuery(Sql.SELECT_MAX_ANO);
			
			if(rs.next()) {
				ano = rs.getInt(1);
			}			
			conn.commit(); // 작업완료
			closeAll();			
		}catch (Exception e) {			
			logger.error(e.getMessage());
			
			try {
				conn.rollback();
			} catch (SQLException e1) {
				logger.error(e1.getMessage());
			}
		}
		
		return ano;
	}
	
	public int selectCountTotal() {
		
		int total = 0;		
		try {
			conn = getConnection();			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(Sql.SELECT_COUNT_TOTAL);
			
			if(rs.next()) {
				total = rs.getInt(1);
			}			
			closeAll();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return total;
	}	
	
	public ArticleDTO selectArticleWithFile(String ano) {
		
		ArticleDTO dto = null;
		
		List<FileDTO> fileList = new ArrayList<FileDTO>();
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_ARTICLE_WITH_FILE);
			psmt.setString(1, ano);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				
				if(dto == null) {
					dto = new ArticleDTO();
					dto.setAno(rs.getInt(1));
					dto.setCate(rs.getString(2));
					dto.setTitle(rs.getString(3));
					dto.setContent(rs.getString(4));
					dto.setComment_cnt(rs.getInt(5));
					dto.setFile_cnt(rs.getInt(6));
					dto.setHit_cnt(rs.getInt(7));
					dto.setWriter(rs.getString(8));
					dto.setReg_ip(rs.getString(9));
					dto.setWdate(rs.getString(10));
					dto.setNick(rs.getString(11));
				}
				
				FileDTO fileDTO = new FileDTO();
				fileDTO.setFno(rs.getInt(12));
				fileDTO.setAno(rs.getInt(13));
				fileDTO.setOname(rs.getString(14));
				fileDTO.setSname(rs.getString(15));
				fileDTO.setDownload(rs.getInt(16));
				fileDTO.setRdate(rs.getString(17));
				fileList.add(fileDTO);						
			}// while 끝
			
			dto.setFiles(fileList);			
			closeAll();
			
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return dto;
	}
	
	public List<ArticleDTO> selectAll(int start) {
		
		List<ArticleDTO> dtoList = new ArrayList<ArticleDTO>();
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_ARTICLE_ALL);
			psmt.setInt(1, start);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				ArticleDTO dto = new ArticleDTO();
				dto.setAno(rs.getInt(1));
				dto.setCate(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setComment_cnt(rs.getInt(5));
				dto.setFile_cnt(rs.getInt(6));
				dto.setHit_cnt(rs.getInt(7));
				dto.setWriter(rs.getString(8));
				dto.setReg_ip(rs.getString(9));
				dto.setWdate(rs.getString(10));
				dto.setNick(rs.getString(11));
				dtoList.add(dto);
			}
			closeAll();			
		}catch (Exception e) {
			logger.error(e.getMessage());
		}		
		return dtoList;
	}
	
	public int selectCountSearch(String searchType, String keyword) {
		
		int total = 0;
		
		StringBuilder sql = new StringBuilder(Sql.SELECT_COUNT_SEARCH);
		
		if(searchType.equals("title")) {
			sql.append(Sql.SEARCH_WHERE_TITLE);
		}else if(searchType.equals("content")) {
			sql.append(Sql.SEARCH_WHERE_CONTENT);
		}else if(searchType.equals("nick")) {
			sql.append(Sql.SEARCH_WHERE_NICK);
		}
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql.toString());
			psmt.setString(1, "%" + keyword + "%");
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				total = rs.getInt(1);
			}
			closeAll();			
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return total;
	}
	
	public List<ArticleDTO> selectArticleSearch(int start, String searchType, String keyword) {
		
		List<ArticleDTO> dtoList = new ArrayList<ArticleDTO>();
		StringBuilder sql = new StringBuilder(Sql.SELECT_ARTICLE_SEARCH);
		
		if(searchType.equals("title")) {
			sql.append(Sql.SEARCH_WHERE_TITLE);
		}else if(searchType.equals("content")) {
			sql.append(Sql.SEARCH_WHERE_CONTENT);			
		}else if(searchType.equals("nick")) {
			sql.append(Sql.SEARCH_WHERE_NICK);			
		}
		sql.append(Sql.SEARCH_ORDER_ANO);
		sql.append(Sql.SEARCH_OFFSET_ROW);
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql.toString());
			psmt.setString(1, "%" + keyword + "%");
			psmt.setInt(2, start);
			
			rs = psmt.executeQuery();
			while(rs.next()) {
				ArticleDTO dto = new ArticleDTO();
				dto.setAno(rs.getInt(1));
				dto.setCate(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setComment_cnt(rs.getInt(5));
				dto.setFile_cnt(rs.getInt(6));
				dto.setHit_cnt(rs.getInt(7));
				dto.setWriter(rs.getString(8));
				dto.setReg_ip(rs.getString(9));
				dto.setWdate(rs.getString(10));
				dto.setNick(rs.getString(11));
				dtoList.add(dto);
			}
			closeAll();			
		}catch (Exception e) {
			logger.error(e.getMessage());
		}		
		return dtoList;
	}
	
	public void update(ArticleDTO dto) {
		
	}
	
	public void delete(int ano) {
		
	}
}