package demo.services;

import java.util.List;

import demo.api.v1.model.CustomerDTO;

public interface CustomerService {

	public List<CustomerDTO> getAllCustomers();
}
