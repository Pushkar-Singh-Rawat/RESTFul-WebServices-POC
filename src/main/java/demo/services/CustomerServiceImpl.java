package demo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import demo.api.v1.model.CustomerDTO;
import demo.converters.CustomerToCustomerDTO;
import demo.repositories.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	CustomerRepository customerRepository;
	CustomerToCustomerDTO customerToCustomerDTO;

	public CustomerServiceImpl(CustomerRepository customerRepository, CustomerToCustomerDTO customerToCustomerDTO) {
		this.customerRepository = customerRepository;
		this.customerToCustomerDTO = customerToCustomerDTO;
	}

	@Override
	public List<CustomerDTO> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepository
				.findAll()
				.stream()
				.map(customerToCustomerDTO::convert)
				.collect(Collectors.toList());

	}

}
