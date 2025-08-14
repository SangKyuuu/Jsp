package service;

import java.util.List;

import dao.CustomerDAO;
import dto.CustomerDTO;

public enum CustomerService {
	INSTANCE;
	
	private CustomerDAO dao = CustomerDAO.getInstance();
	
	public CustomerDTO findById(String c_no) {
		return dao.select(c_no);
	}
	
	public CustomerDTO findByIdAndName(String c_no, String c_name) {
		return dao.select(c_no, c_name);
	}
	
	public List<CustomerDTO> findAll(CustomerDTO dto) {
		return dao.selectAll(dto);
	}
	
	public void register(String c_no) {
		dao.insert(c_no);
	}
	
	public void modify() {
		
	}
	
	public void remove() {
		
		
	}
}
