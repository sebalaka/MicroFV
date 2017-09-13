package sda.transformer;

import org.springframework.stereotype.Component;
import sda.dto.Customer;
import sda.entity.CustomerEntity;

/**
 * Created by RENT on 2017-09-13.
 */
@Component
public class CustomerTransformer {

	public CustomerEntity transform (Customer customer){
		CustomerEntity customerEntity = new CustomerEntity();
		customerEntity.setId(customer.getId());
		customerEntity.setName(customer.getName());
		customerEntity.setNIP(customer.getNIP());
		customerEntity.setAddress(customer.getAddress());
		customerEntity.setTelephone(customer.getTelephone());
		customerEntity.setEmail(customer.getEmail());
		return customerEntity;
}

	public Customer transformToCustomer(CustomerEntity customerEntity) {
		Customer customer = new Customer();
		customer.setId(customerEntity.getId());
		customer.setName(customerEntity.getName());
		customer.setNIP(customerEntity.getNIP());
		customer.setAddress(customerEntity.getAddress());
		customer.setTelephone(customerEntity.getTelephone());
		customer.setEmail(customerEntity.getEmail());
		return customer;
	}
}
