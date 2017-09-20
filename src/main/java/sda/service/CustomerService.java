package sda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sda.dao.CustomerRepository;
import sda.dto.Customer;
import sda.entity.CustomerEntity;
import sda.transformer.CustomerTransformer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RENT on 2017-09-13.
 */
@Service
public class CustomerService {

	private CustomerRepository customerRepository;
	private CustomerTransformer customerTransformer;

	@Autowired
	public CustomerService(CustomerRepository customerRepository, CustomerTransformer customerTransformer) {
		this.customerRepository = customerRepository;
		this.customerTransformer = customerTransformer;
	}

	public Long add(Customer customer){
		if(customer.getName().isEmpty()){
			return null;
		} else {
			CustomerEntity customerEntity = customerRepository.save(customerTransformer.transform(customer));
			return customerEntity.getId();
		}
	}

	public void remove(Long id){
		customerRepository.delete(id);
	}

	public List<Customer> getAll() {
		Iterable<CustomerEntity> all = customerRepository.findAll();
		List<Customer> result = new ArrayList<>();
		for(CustomerEntity customerEntity : all){
			result.add(customerTransformer.transformToCustomer(customerEntity));
		}
		return result;
	}
}
