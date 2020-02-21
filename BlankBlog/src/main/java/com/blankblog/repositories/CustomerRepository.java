package com.blankblog.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.blankblog.models.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{

	List<Customer> findByLastName(String lastName);
}
