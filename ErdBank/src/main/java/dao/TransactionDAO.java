package dao;

import java.sql.SQLException;
import java.util.List;

import dto.TransactionDTO;
import util.DBHelper;
import util.Sql;

public class TransactionDAO extends DBHelper{
	private static final TransactionDAO INSTANCE = new TransactionDAO();
	public static TransactionDAO getInstance() {
		return INSTANCE;
	}
	private TransactionDAO() {}
	
	//CRUD
	public TransactionDAO select(int t_no) {
		return null;
	}
	
	public List<TransactionDAO> selectAll(TransactionDTO dto) {
		return null;
	}
	
	public void insertAndUpdate(TransactionDTO dto) {
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			
			psmt = conn.prepareStatement(Sql.INSERT_TRANSACTION);
			psmt.setString(1, dto.getT_a_no());
			psmt.setInt(2, dto.getT_dist());
			psmt.setInt(3, dto.getT_amount());
			psmt.executeUpdate();
			
			psmt1 = conn.prepareStatement(Sql.UPDATE_ACCOUNT_PLUS); //상대방 계좌 +
			psmt1.setInt(1, dto.getT_amount());
			psmt1.setString(2, dto.getT_a_no_to());
			psmt1.executeUpdate();
			
			psmt2 = conn.prepareStatement(Sql.UPDATE_ACCOUNT_MINUS); //내계좌 -
			psmt2.setInt(1, dto.getT_amount());
			psmt2.setString(2, dto.getT_a_no());
			psmt2.executeUpdate();
			
			conn.commit();
			
			closeAll();
			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public void update() {
		
		
	}
	public void delete() {
		
		
	}
	
}
