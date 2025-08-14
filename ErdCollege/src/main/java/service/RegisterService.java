package service;

import java.util.List;

import dao.RegisterDAO;
import dto.RegisterDTO;

public enum RegisterService {
	INSTANCE;
	
	private RegisterDAO dao = RegisterDAO.getInstance();
	
	//기본CRUD
	public RegisterDTO findById(String regStdNo, int lecNo) {
		return dao.select(regStdNo, lecNo);
	}
	
	public List<RegisterDTO> findAll() {
		return dao.selectAll();
	}
	
	public void register(RegisterDTO dto) {
		dao.insert(dto);
	}
	
	public void modify(RegisterDTO dto) {
		dao.update(dto);
	}
	
	public void remove(String regStdNo, int lecNo) {
		dao.delete(regStdNo, lecNo);
	}
}
