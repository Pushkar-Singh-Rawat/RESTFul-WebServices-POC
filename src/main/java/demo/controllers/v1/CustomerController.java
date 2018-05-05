package demo.controllers.v1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import demo.api.v1.model.CustomerDTO;
import demo.api.v1.model.CustomerDTOList;
import demo.services.CustomerService;

@Controller
@RequestMapping("/api/v1/customers/")
public class CustomerController {

	private CustomerService customerService;
	public CustomerController(CustomerService customerService) {
		this.customerService=customerService;
	}
	@GetMapping
	public ResponseEntity<CustomerDTOList> getAllCustomers(){
		return new ResponseEntity<CustomerDTOList>(
				new CustomerDTOList(customerService.getAllCustomers())
				, HttpStatus.OK);
	}
	
	@GetMapping({"{Id}"})
	public ResponseEntity<CustomerDTO> getAllCustomers(@PathVariable String Id){
		return new ResponseEntity<CustomerDTO>(
				customerService.getCustomerByID(Long.valueOf(Id))
				, HttpStatus.OK);
	}
	
	@PostMapping
	public void createNewCustomer(){
		
	}
}
