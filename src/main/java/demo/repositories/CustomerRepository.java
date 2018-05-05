package demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	public Customer findById(Long Id);

}
