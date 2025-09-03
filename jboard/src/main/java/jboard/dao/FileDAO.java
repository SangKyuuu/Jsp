package jboard.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jboard.dto.FileDTO;
import jboard.util.DBHelper;
import jboard.util.Sql;

public class FileDAO extends DBHelper{
	
	private final static FileDAO INSTANCE = new FileDAO();
	public static FileDAO getInstance() {
		return INSTANCE;
	}
	private FileDAO() {}
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void insert(FileDTO dto) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.INSERT_FILE);
			psmt.setInt(1, dto.getAno());
			psmt.setString(2, dto.getOname());
			psmt.setString(3, dto.getSname());
			
			psmt.executeUpdate();
			closeAll();
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	public FileDTO select(int fno) {
		return null;
	}
	
	public List<FileDTO> selectAll() {
		return null;
	}
	
	public void update(FileDTO dto) {
		
	}
	
	public void delete(int fno) {
		
	}
}
