package com.canvis.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.canvis.models.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{

	List<Customer> findByLastName(String lastName);

}
