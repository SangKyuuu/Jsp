package service;

import java.util.List;

import dao.AccountDAO;
import dto.AccountDTO;

public enum AccountService {
	INSTANCE;
	
	private AccountDAO dao = AccountDAO.getInstance();
	
	public AccountDTO findById(String a_no) {
		return dao.select(a_no);
	}
	
	public List<AccountDTO> findAll() {
		return dao.selectAll();
	}
	
	public void register(String a_no) {
		dao.insert(a_no);
	}
	
	public void modify() {
		
	}
	
	public void remove() {
		
		
	}
}
