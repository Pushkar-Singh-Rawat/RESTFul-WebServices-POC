package demo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import demo.api.v1.model.CustomerDTO;
import demo.converters.CustomerDtoToCustomer;
import demo.converters.CustomerToCustomerDTO;
import demo.domain.Customer;
import demo.repositories.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	private final CustomerRepository customerRepository;
	private final CustomerToCustomerDTO customerToCustomerDTO;
	private final CustomerDtoToCustomer customerDtoToCustomer;

	public CustomerServiceImpl(CustomerRepository customerRepository, CustomerToCustomerDTO customerToCustomerDTO,
			CustomerDtoToCustomer customerDtoToCustomer) {
		this.customerRepository = customerRepository;
		this.customerToCustomerDTO = customerToCustomerDTO;
		this.customerDtoToCustomer = customerDtoToCustomer;
	}

	@Override
	public List<CustomerDTO> getAllCustomers() {
		return customerRepository.findAll().stream().map(customer -> {
			CustomerDTO customerDTO = customerToCustomerDTO.convert(customer);
			customerDTO.setCustomerURL("/api/v1/customers/" + customer.getId());
			return customerDTO;
		}).collect(Collectors.toList());

	}

	@Override
	public CustomerDTO getCustomerByID(Long Id) {

		Customer customer = customerRepository.findOne(Id);
		if (customer == null) {
			throw new RuntimeException();
		} else {
			CustomerDTO customerDTO = customerToCustomerDTO.convert(customer);
			customerDTO.setCustomerURL("/api/v1/customers/" + customer.getId());
			return customerDTO;
		}
	}

	@Override
	public CustomerDTO createNewCustomer(CustomerDTO customerDTO) {
		Customer customer = customerDtoToCustomer.convert(customerDTO);
		return saveAndReturnDTO(customer);
	}

	public CustomerDTO saveAndReturnDTO(Customer customer) {

		Customer savedCustomerDTO = customerRepository.save(customer);
		CustomerDTO returnDTO = customerToCustomerDTO.convert(savedCustomerDTO);
		returnDTO.setCustomerURL("/api/v1/customer/" + savedCustomerDTO.getId());
		return returnDTO;

	}

	@Override
	public CustomerDTO saveCustomerByID(Long Id, CustomerDTO customerDTO) {
		Customer customer = customerDtoToCustomer.convert(customerDTO);
		customer.setId(Id);
		return saveAndReturnDTO(customer);
	}


}
