package demo.converters;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import demo.api.v1.model.CustomerDTO;
import demo.domain.Customer;
import lombok.Synchronized;
@Component
public class CustomerToCustomerDTO implements Converter<Customer,CustomerDTO>{

	@Synchronized
	@Override
	public CustomerDTO convert(Customer customer) {
		if(customer!=null){
			CustomerDTO customerDTO=new CustomerDTO();
			customerDTO.setFirstname(customer.getFirstname());
			customerDTO.setLastname(customer.getLastname());
			/*customerDTO.setId(customer.getId());*/
			return customerDTO;
		}
		return null;
	}

}
