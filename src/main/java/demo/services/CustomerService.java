package demo.services;

import java.util.List;

import demo.api.v1.model.CustomerDTO;

public interface CustomerService {

	List<CustomerDTO> getAllCustomers();
	CustomerDTO getCustomerByID(Long Id);
	CustomerDTO createNewCustomer(CustomerDTO customerDTO);
	CustomerDTO saveCustomerByID(Long Id,CustomerDTO customerDTO);
	void deleteCustomerByID(Long Id);
}
