package dao;

import java.util.List;

import dto.RegisterDTO;
import util.DBHelper;

public class RegisterDAO extends DBHelper{
	private static final RegisterDAO INSTANCE = new RegisterDAO();
	public static RegisterDAO getInstance () {
		return INSTANCE;
	}
	private RegisterDAO() {}
	
	//기본CRUD
	public RegisterDTO select(String regStdNo, int lecNo) {
		return null;
	}
	
	public List<RegisterDTO> selectAll() {
		return null;
	}
	
	public void insert(RegisterDTO dto) {
		try {
			conn = getConnection();
			
			String sql ="INSERT INTO REGISTER(REGSTDNO, REGLECNO) VALUES(?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getRegStdNo());
			psmt.setInt(2, dto.getRegLecNo());
			
			psmt.executeUpdate();
			
			closeAll();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(RegisterDTO dto) {
		
	}
	
	public void delete(String regStdNo, int lecNo) {
		
	}
}
