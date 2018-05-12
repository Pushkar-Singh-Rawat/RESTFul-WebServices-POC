package demo.controller.v1;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import demo.api.v1.model.CustomerDTO;
import demo.controllers.v1.CustomerController;
import demo.services.CustomerService;

import static org.hamcrest.Matchers.equalTo;
public class CustomerControllerTests {

	@Mock
	CustomerService customerService;
	@InjectMocks
	CustomerController customerController;
	MockMvc mockMvc;
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		mockMvc=MockMvcBuilders.standaloneSetup(customerController).build();
	}
	
	@Test
	public void testCreateNewCustomer() throws Exception{
		CustomerDTO customerDto=new CustomerDTO();
		customerDto.setFirstname("Shyam");
		customerDto.setLastname("S");
		
		CustomerDTO returnDTO=new CustomerDTO();
		returnDTO.setFirstname(customerDto.getFirstname());
		returnDTO.setLastname(customerDto.getLastname());
		returnDTO.setCustomerURL(CustomerController.BASE_URL+"/1");
		
		Mockito.when(customerService.createNewCustomer(customerDto)).thenReturn(returnDTO);
		mockMvc.perform(post(CustomerController.BASE_URL)
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				 .content(restTestHelper.asJsonString(customerDto)))
		.andExpect(status().isCreated())
		.andExpect(jsonPath("$.firstname",equalTo("Shyam")))
		.andExpect(jsonPath("$.customer_url",equalTo(CustomerController.BASE_URL+"/1")));
		
	}
}
