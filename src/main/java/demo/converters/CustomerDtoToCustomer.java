package demo.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import demo.api.v1.model.CustomerDTO;
import demo.domain.Customer;
import lombok.Synchronized;

@Component
public class CustomerDtoToCustomer implements Converter<CustomerDTO,Customer> {

	@Override
	@Synchronized
	public Customer convert(CustomerDTO customerDTO) {
		if(customerDTO!=null){
			Customer customer=new Customer();
			customer.setFirstname(customerDTO.getFirstname());
			customer.setLastname(customerDTO.getLastname());
			customer.setId(customerDTO.getId());
			return customer;
		}
		return null;
	}

}
