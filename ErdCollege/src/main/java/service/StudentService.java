package service;

import java.util.List;

import dao.StudentDAO;
import dto.StudentDTO;

public enum StudentService {
	INSTANCE;
	
	private StudentDAO dao = StudentDAO.getInstance();
	
	//기본CRUD
	public StudentDTO findById(String stdNo) {
		return dao.select(stdNo);
	}
	
	public StudentDTO findByIdAndName(String stdNo, String stdName) {
		return dao.select(stdNo,stdName);
	}
	
	public List<StudentDTO> findAll() {
		return dao.selectAll();
	}
	
	public void register(StudentDTO dto) {
		dao.insert(dto);
	}
	
	public void modify(StudentDTO dto) {
		dao.update(dto);
	}
	
	public void remove(String stdNo) {
		dao.delete(stdNo);
	}
}
