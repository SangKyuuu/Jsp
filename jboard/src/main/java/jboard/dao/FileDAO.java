package jboard.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jboard.dto.ArticleDTO;
import jboard.dto.FileDTO;
import jboard.util.DBHelper;
import jboard.util.Sql;

public class FileDAO extends DBHelper {
	
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
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	public FileDTO select(String fno) {
		
		FileDTO fileDTO = null;
		
		try {
			conn = getConnection();
			
			psmt = conn.prepareStatement(Sql.SELECT_FILE);
			psmt.setString(1, fno);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				fileDTO = new FileDTO();
				fileDTO.setFno(rs.getInt("FNO"));
				fileDTO.setAno(rs.getInt("ANO"));
				fileDTO.setOname(rs.getString("ONAME"));
				fileDTO.setSname(rs.getString(4));
				fileDTO.setDownload(rs.getInt(5));
				fileDTO.setRdate(rs.getString(6));
			}
			closeAll();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return fileDTO;
	}
	
	public List<FileDTO> selectAll() {
		return null;
	}
	
	public void update(FileDTO dto) {
		
	}
	
	public void updateDownload(String fno) {		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.UPDATE_FILE_DOWNLOAD);
			psmt.setString(1, fno);			
			psmt.executeUpdate();
			closeAll();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}		
	}
	
	public void delete(int fno) {
		
	}
}