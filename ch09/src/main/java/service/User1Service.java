package service;

import java.util.List;

import dao.User1DAO;
import dto.User1DTO;

/*
 * Service
 * - Controller의 부가적인 비즈니스 처리를 담당
 * - Controller의 요청을 받아 DAO를 호출, Controller와 DAO의 중간 매개 컴포넌트
 * */
public class User1Service {
	
	//싱글톤
	private final static User1Service INSTANCE = new User1Service();
	public static User1Service getInstance() {
		return INSTANCE;
	}
	private User1Service() {}
	
	//DAO연결
	private User1DAO dao = User1DAO.getInstance();
	
	
	//DAO 메서드 호출 - Service에 맞게 네이밍
	public void register(User1DTO dto) {
		dao.insertUser1(dto);
	}
	
	public User1DTO findById(String user_id) {
		return dao.selectUser1(user_id);
	}
	
	public List<User1DTO> findAll() {
		return dao.selectAllUser1();
	}
	
	public void modify(User1DTO dto) {
		dao.updateUser1(dto);
	}
	
	public void delete(String user_id) {
		dao.deleteUser1(user_id);
	}
}
