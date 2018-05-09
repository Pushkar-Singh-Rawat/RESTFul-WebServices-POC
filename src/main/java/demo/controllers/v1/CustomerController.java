package demo.controllers.v1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import demo.api.v1.model.CustomerDTO;
import demo.api.v1.model.CustomerDTOList;
import demo.services.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("This is customer controller")
@Controller
@RequestMapping(CustomerController.BASE_URL)
public class CustomerController {

	public final static String BASE_URL="/api/v1/customers";
	private CustomerService customerService;
	public CustomerController(CustomerService customerService) {
		this.customerService=customerService;
	}
	@ApiOperation(notes="these are some of the API notes",value="This will get a list of customers")
	@GetMapping
	public ResponseEntity<CustomerDTOList> getAllCustomers(){
		return new ResponseEntity<CustomerDTOList>(
				new CustomerDTOList(customerService.getAllCustomers())
				, HttpStatus.OK);
	}
	@ApiOperation(notes="these are some of the API notes",value="This will get any customer by id.")
	@GetMapping({"/{Id}"})
	public ResponseEntity<CustomerDTO> getAllCustomersById(@PathVariable String Id){
		return new ResponseEntity<CustomerDTO>(
				customerService.getCustomerByID(Long.valueOf(Id))
				, HttpStatus.OK);
	}
	@ApiOperation(notes="these are some of the API notes",value="This will create a new customer.")
	@PostMapping
	public ResponseEntity<CustomerDTO> createNewCustomer(@RequestBody CustomerDTO customerDTO){
		
		return new ResponseEntity<CustomerDTO>(
				customerService.createNewCustomer(customerDTO)
				,HttpStatus.CREATED
				);
	}
	@ApiOperation(notes="these are some of the API notes",value="This will update any customer by id.")
	@PutMapping({"/{Id}"})
	public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody CustomerDTO customerDTO,@PathVariable Long Id){
		
		return new ResponseEntity<CustomerDTO>(
				customerService.saveCustomerByID(Id, customerDTO)
				,HttpStatus.OK
				);
	}
	@ApiOperation(notes="these are some of the API notes",value="This will delete any customer by id.")
	@DeleteMapping({"/{Id}"})
	public ResponseEntity<Void> deleteCustomerById(@PathVariable Long Id){
		
		customerService.deleteCustomerByID(Id);
		return new ResponseEntity<Void>(
				HttpStatus.OK
				);
	}
}
