package DAO;

import java.util.List;

import DTO.User2DTO;
import util.DBHelper;

public class User2DAO extends DBHelper{
	private static final User2DAO INSTANCE = new User2DAO();
	private final String DBCP = "jdbc/studydb";
	
	public User2DAO getInstance() {
		return INSTANCE;
	}
	
	private User2DAO() {}
	
	public List<User2DAO> selectAllUser(User2DTO dto){
		
		return null;
	}
}
