package sda.dao;

import org.springframework.data.repository.CrudRepository;
import sda.entity.CustomerEntity;

/**
 * Created by RENT on 2017-09-13.
 */
public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {
	CustomerEntity save(CustomerEntity transform);
}